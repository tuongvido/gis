package com.mobifone.btsmanager.controller;

import com.mobifone.btsmanager.dto.SearchTowerDto;
import com.fasterxml.jackson.databind.util.BeanUtil;
import com.mobifone.btsmanager.entity.CellTower;
import com.mobifone.btsmanager.entity.Region;
import com.mobifone.btsmanager.repository.RegionRepository;
import com.mobifone.btsmanager.response.ApiResponse;
import com.mobifone.btsmanager.response.CellTowerResponse;
import com.mobifone.btsmanager.services.ICellTowerService;
import com.mobifone.btsmanager.services.IRegionService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/towers")
@CrossOrigin(origins = "http://localhost:3000")
public class CellTowerController {

    private  ICellTowerService service;
    private  IRegionService regionService;

    public CellTowerController(ICellTowerService service, IRegionService regionService) {
        this.regionService = regionService;
        this.service = service;
    }

    @GetMapping
    public List<CellTowerResponse> getAll() {
        List<CellTower> entities = service.getMobifoneCellTowerAtHCM();
        List<CellTowerResponse> responses = new ArrayList<>();
        Map<Long, String> mapRegion = regionService.getAllRegion().stream().collect(Collectors.toMap(Region::getId, Region::getName));
        for (int i = 0; i < entities.size(); i++) {
            CellTower entity = entities.get(i);
            CellTowerResponse dto = new CellTowerResponse();
            BeanUtils.copyProperties(entity, dto);

            dto.setNameDistrict(mapRegion.get(entity.getRegionId()));
            responses.add(dto);
        }

        return responses;
    }

    @PostMapping("/search")
    public List<CellTower> search(@RequestBody SearchTowerDto searchTowerDto) {
        return service.search(searchTowerDto);
    }

    @GetMapping("/{id}")
    public CellTower getById(@PathVariable int id) {
        return service.getTower(id);
    }

    @PostMapping
    public CellTower create(@RequestBody CellTower tower) {
        return service.saveTower(tower);
    }

    @PutMapping("/{id}")
    public CellTower update(@RequestBody CellTower tower) {
        return service.saveTower(tower);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<?>> delete(@PathVariable int id) {
        service.deleteTower(id);
        return ResponseEntity.ok(ApiResponse.success());
    }

}
