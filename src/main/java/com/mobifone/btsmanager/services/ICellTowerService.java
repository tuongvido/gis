package com.mobifone.btsmanager.services;

import com.mobifone.btsmanager.dto.SearchTowerDto;
import com.mobifone.btsmanager.entity.CellTower;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICellTowerService {

    public List<CellTower> getAllTowers() ;

    public List<CellTower> search(SearchTowerDto searchTowerDto) ;

    public CellTower getTower(int id) ;



    public CellTower saveTower(CellTower tower) ;



    public void deleteTower(int id) ;

    public List<CellTower> getMobifoneCellTowerAtHCM();
}
