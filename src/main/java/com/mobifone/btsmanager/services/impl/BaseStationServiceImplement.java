package com.mobifone.btsmanager.services.impl;

import com.mobifone.btsmanager.entity.CellTower;
import com.mobifone.btsmanager.repository.CellTowerRepository;
import com.mobifone.btsmanager.services.IBaseStationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BaseStationServiceImplement implements IBaseStationService {
    private CellTowerRepository cellTowerRepository;

    public BaseStationServiceImplement(CellTowerRepository cellTowerRepository) {
        this.cellTowerRepository = cellTowerRepository;
    }

    @Override
    public int saveAll(List<CellTower> cellTowers) {
        cellTowerRepository.saveAll(cellTowers);
        return 0;
    }
}
