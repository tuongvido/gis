package com.mobifone.btsmanager.services;

import com.mobifone.btsmanager.entity.BaseStation;
import com.mobifone.btsmanager.entity.CellTower;

import java.util.List;

public interface IBaseStationService {
    public int saveAll(List<CellTower> cellTowers);
}
