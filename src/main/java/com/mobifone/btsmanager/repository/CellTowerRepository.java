package com.mobifone.btsmanager.repository;

import com.mobifone.btsmanager.entity.CellTower;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CellTowerRepository extends JpaRepository<CellTower, Integer> {
    @Query("SELECT c FROM CellTower c WHERE c.mcc = 452 AND c.net = 2 AND c.lat BETWEEN 10.3 AND 11.2 AND c.lon BETWEEN 106.3 AND 107.1 ORDER BY c.id")
    List<CellTower> findMobifoneInHCM();

//    @Query("""
//              SELECT c FROM CellTower c
//              WHERE (:radioType IS NULL OR c.radio = :radioType)
//                AND (:status = -1 OR c.status = :status)
//                AND (:districtId = -1 OR c.district.id = :districtId)
//            """)
//    List<CellTower> findAll(int status, int districtId, String radioType, Pageable pageable);

    @Query("""
              SELECT c FROM CellTower c
              WHERE (:radioType IS NULL OR :radioType = "" OR c.radio = :radioType)
              ORDER BY c.id
            """)
    List<CellTower> findAll(int status, int districtId, String radioType, Pageable pageable);

}
