package com.mobifone.btsmanager.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Data
@Getter
@Setter
@RequiredArgsConstructor
public class CellTower {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String radio;
    private String name;
    private Integer mcc;
    private Integer mnc;
    private Integer net;
    private Integer area;
    //cellID
    private Integer cell;
    private Integer unit;
    private Integer range;
    private Integer samples;
    private double lat;
    private double lon;
    private Integer changeable;
    private Integer created;
    private Integer updated;
    private Integer averageSignal;
    private String type;
    private Long userCreated;
    private Long userUpdated;
    private Long regionId;
    private Integer status;
}
