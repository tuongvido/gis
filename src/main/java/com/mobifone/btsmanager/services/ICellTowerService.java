package com.mobifone.btsmanager.services;

import com.mobifone.btsmanager.entity.BaseStation;
import com.mobifone.btsmanager.entity.CellTower;

import java.util.List;

public interface ICellTowerService {

    public List<CellTower> getAllTowers() ;



    public CellTower getTower(int id) ;



    public CellTower saveTower(CellTower tower) ;



    public void deleteTower(int id) ;
}
