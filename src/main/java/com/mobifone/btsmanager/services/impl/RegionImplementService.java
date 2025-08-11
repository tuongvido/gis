package com.mobifone.btsmanager.services.impl;

import com.mobifone.btsmanager.entity.CellTower;
import com.mobifone.btsmanager.entity.Region;
import com.mobifone.btsmanager.repository.RegionRepository;
import com.mobifone.btsmanager.services.ICellTowerService;
import com.mobifone.btsmanager.services.IRegionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RegionImplementService implements IRegionService {
    
    private final RegionRepository regionRepository;

    @Override
    public List<Region> getAllRegion() {
        return regionRepository.findAll();
    }
}
