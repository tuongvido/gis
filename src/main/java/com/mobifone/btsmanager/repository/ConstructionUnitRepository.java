package com.mobifone.btsmanager.repository;

import com.mobifone.btsmanager.entity.ConstructionUnit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConstructionUnitRepository extends JpaRepository<ConstructionUnit, Long> {
}
