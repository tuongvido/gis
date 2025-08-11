package com.mobifone.btsmanager.repository;

import com.mobifone.btsmanager.entity.CellTower;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CellTowerRepository extends JpaRepository<CellTower, Integer> {

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
            """)
    List<CellTower> findAll(int status, int districtId, String radioType, Pageable pageable);

}
