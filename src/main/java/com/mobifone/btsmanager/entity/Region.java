package com.mobifone.btsmanager.entity;

import jakarta.persistence.*;


import org.locationtech.jts.geom.MultiPolygon;

@Entity
@Table(name = "region")
public class Region {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String province;

    private String type;

    @Column(columnDefinition = "geometry(MultiPolygon,4326)")
    private MultiPolygon geom;

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getProvince() { return province; }
    public void setProvince(String province) { this.province = province; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public MultiPolygon getGeom() { return geom; }
    public void setGeom(MultiPolygon geom) { this.geom = geom; }
}

