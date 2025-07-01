package com.mobifone.btsmanager.repository;

import com.mobifone.btsmanager.entity.CellTower;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CellTowerRepository extends JpaRepository<CellTower, Integer> {
    List<CellTower> findByMccAndMncAndNet(int mcc, int mnc, String net);
}
