package com.mobifone.btsmanager.controller;

import com.mobifone.btsmanager.entity.CellTower;
import com.mobifone.btsmanager.services.ICellTowerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/towers")
public class CellTowerController {

    private final ICellTowerService service;

    public CellTowerController(ICellTowerService service) {
        this.service = service;
    }

    @GetMapping
    public List<CellTower> getAll() {
        return service.getAllTowers();
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
