package com.mobifone.btsmanager.services.impl;

import com.mobifone.btsmanager.entity.CellTower;
import com.mobifone.btsmanager.repository.CellTowerRepository;
import com.mobifone.btsmanager.services.ICellTowerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CellTowerServiceImplement implements ICellTowerService {

    private final CellTowerRepository cellTowerRepository;

    public CellTowerServiceImplement(CellTowerRepository cellTowerRepository) {
        this.cellTowerRepository = cellTowerRepository;
    }

    @Override
    public List<CellTower> getAllTowers() {
        return cellTowerRepository.findAll();
    }

    @Override
    public CellTower getTower(int id) {
        return cellTowerRepository.findById(id).orElse(null);
    }

    @Override
    public CellTower saveTower(CellTower tower) {
        return cellTowerRepository.save(tower);
    }

    @Override
    public void deleteTower(int id) {
        cellTowerRepository.deleteById(id);
    }
}
