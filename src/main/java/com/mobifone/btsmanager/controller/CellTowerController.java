package com.mobifone.btsmanager.controller;

import com.fasterxml.jackson.databind.util.BeanUtil;
import com.mobifone.btsmanager.entity.CellTower;
import com.mobifone.btsmanager.response.CellTowerResponse;
import com.mobifone.btsmanager.services.ICellTowerService;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/towers")
@CrossOrigin(origins = "http://localhost:3000")
public class CellTowerController {

    private final ICellTowerService service;

    public CellTowerController(ICellTowerService service) {
        this.service = service;
    }

    @GetMapping
    public List<CellTowerResponse> getAll() {
        List<CellTower> entities = service.getMobifoneCellTowerAtHCM();
        List<CellTowerResponse> responses = new ArrayList<>();
        String[] statuses = {"ONLINE", "OFFLINE", "MAINTENANCE"};
        for (int i = 0; i < entities.size(); i++) {
            CellTower entity = entities.get(i);
            CellTowerResponse dto = new CellTowerResponse();
            BeanUtils.copyProperties(entity, dto);

            dto.setStatus(statuses[i % statuses.length]);

            responses.add(dto);
        }

        return responses;
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
    public CellTower update(@PathVariable Integer id, @RequestBody CellTower tower) {
        return service.saveTower(tower);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        service.deleteTower(id);
    }
}
