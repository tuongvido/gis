package com.mobifone.btsmanager.controller;

import com.mobifone.btsmanager.entity.CellTower;
import com.mobifone.btsmanager.services.IBaseStationService;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/base-station")
public class BaseStationController {
    private final IBaseStationService baseStationService;

    public BaseStationController(IBaseStationService baseStationService) {
        this.baseStationService = baseStationService;
    }

    @PostMapping
    public void importFromCsv() {
        try {
            String filePath = "D:\\download\\data.csv";
            Reader reader = Files.newBufferedReader(Paths.get(filePath), StandardCharsets.UTF_8);
            CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(1).build();
            List<CellTower> batch = new ArrayList<>();
            String[] line;

            while ((line = csvReader.readNext()) != null) {
                CellTower tower = new CellTower();
                tower.setRadio(line[0]);
                tower.setMcc(Integer.parseInt(line[1]));
                tower.setNet(Integer.parseInt(line[2]));
                tower.setArea(Integer.parseInt(line[3]));
                tower.setCell(Integer.parseInt(line[4]));
                tower.setUnit(Integer.parseInt(line[5]));
                tower.setLon(Double.parseDouble(fixCoordinate(line[6])));
                tower.setLat(Double.parseDouble(line[7]));
                tower.setRange(Integer.parseInt(line[8]));
                tower.setSamples(Integer.parseInt(line[9]));
                tower.setChangeable(Integer.parseInt(line[10]));
                tower.setAverageSignal(Integer.parseInt(line[13]));

                batch.add(tower);

                if (batch.size() == 1000) {
                    baseStationService.saveAll(batch);
                    batch.clear();
                }
            }

            if (!batch.isEmpty()) {
                baseStationService.saveAll(batch);
            }
            System.out.println("✅ Import completed successfully.");
        }  catch (IOException e) {
            throw new RuntimeException(e);
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        }
    }
    private static String fixCoordinate(String raw) {

        String cleaned = raw.replace(".", "");
        return cleaned.substring(0, 3) + "." + cleaned.substring(3);
    }

}
