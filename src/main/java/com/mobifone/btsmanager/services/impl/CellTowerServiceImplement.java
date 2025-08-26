package com.mobifone.btsmanager.services.impl;

import com.mobifone.btsmanager.dto.SearchTowerDto;
import com.mobifone.btsmanager.entity.CellTower;
import com.mobifone.btsmanager.repository.CellTowerRepository;
import com.mobifone.btsmanager.services.ICellTowerService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class CellTowerServiceImplement implements ICellTowerService {

    private final CellTowerRepository cellTowerRepository;


    public CellTowerServiceImplement(CellTowerRepository cellTowerRepository) {
        this.cellTowerRepository = cellTowerRepository;
    }

    @Override
    public List<CellTower> getAllTowers() {
        Pageable limit = PageRequest.of(0, 100); // lấy 10 phần tử đầu tiên
        return cellTowerRepository.findAll(limit).getContent();
    }

    @Override
    public List<CellTower> search(SearchTowerDto searchTowerDto) {
        Pageable pageable = Objects.isNull(searchTowerDto.getPageDto()) ? Pageable.unpaged() :
                PageRequest.of(searchTowerDto.getPageDto().getPageNumber(), searchTowerDto.getPageDto().getPageSize());
        return cellTowerRepository.findAll(searchTowerDto.getCell(), searchTowerDto.getStatus(), searchTowerDto.getDistrictId(),
                searchTowerDto.getRadioType(), searchTowerDto.getConstructionUnitId(), pageable);
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

    @Override
    public List<CellTower> getMobifoneCellTowerAtHCM() {
        return cellTowerRepository.findMobifoneInHCM();
    }
}
