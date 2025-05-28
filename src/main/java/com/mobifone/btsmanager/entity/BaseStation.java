package com.mobifone.btsmanager.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "base_station")
public class BaseStation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "station_code", nullable = false, unique = true)
    private String code;

    @Column(name = "station_name")
    private String name;

    @Column(name = "latitude", nullable = false)
    private Double latitude;

    @Column(name = "longitude", nullable = false)
    private Double longitude;

    @Column(name = "location")
    private String location;

    @Column(name = "province")
    private String province;

    @Column(name = "district")
    private String district;

    @Column(name = "tech_type")
    private String techType; // 2G, 3G, 4G, 5G

    @Column(name = "status")
    private String status; // Active, Maintenance, Offline, Overloaded

    @Column(name = "antenna_azimuth")
    private Float antennaAzimuth;

    @Column(name = "coverage_radius")
    private Float coverageRadius; // in meters

    @Column(name = "installation_date")
    private LocalDate installationDate;

    @Column(name = "last_maintenance_date")
    private LocalDate lastMaintenanceDate;

    @Column(name = "equipment_vendor")
    private String equipmentVendor;

    @Column(name = "notes", columnDefinition = "TEXT")
    private String notes;

}
