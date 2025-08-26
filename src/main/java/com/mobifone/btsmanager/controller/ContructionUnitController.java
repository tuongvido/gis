package com.mobifone.btsmanager.controller;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mobifone.btsmanager.dto.ConstructionUnitDto;
import com.mobifone.btsmanager.dto.RegionDto;
import com.mobifone.btsmanager.entity.Region;
import com.mobifone.btsmanager.repository.ConstructionUnitRepository;
import com.mobifone.btsmanager.repository.RegionRepository;
import lombok.AllArgsConstructor;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.MultiPolygon;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wololo.geojson.GeoJSON;
import org.wololo.geojson.GeoJSONFactory;
import org.wololo.jts2geojson.GeoJSONReader;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("api/constructionUnit")
@AllArgsConstructor
public class ContructionUnitController {

    private ConstructionUnitRepository constructionUnitRepository;

    @GetMapping
    public List<ConstructionUnitDto> getAllRegions() {
        return constructionUnitRepository.findAll().stream().map(constructionUnit -> {
            ConstructionUnitDto dto = new ConstructionUnitDto();
            dto.setId(constructionUnit.getId());
            dto.setName(constructionUnit.getName());
            dto.setAddress(constructionUnit.getAddress());
            dto.setPhone(constructionUnit.getPhone());
            dto.setContactPerson(constructionUnit.getContactPerson());
            return dto;
        }).collect(Collectors.toList());
    }

}
