package com.mobifone.btsmanager.controller;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mobifone.btsmanager.dto.RegionDto;
import com.mobifone.btsmanager.entity.Region;
import com.mobifone.btsmanager.repository.RegionRepository;
import lombok.AllArgsConstructor;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.GeometryFactory;

import org.locationtech.jts.geom.LinearRing;
import org.locationtech.jts.geom.MultiPolygon;
import org.locationtech.jts.geom.Polygon;
import org.locationtech.jts.io.WKTWriter;
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
import java.util.Set;
import java.util.stream.Collectors;


@RestController
@RequestMapping("api/region")
@AllArgsConstructor
public class RegionController {
    private final RegionRepository regionRepository;
    private final GeometryFactory geometryFactory = new GeometryFactory();
    @PostMapping
    public void createRegion() throws Exception {
        String filePath = "D:\\\\download\\\\gadm41_VNM_2.json";
        importHCMRegions(filePath);
    }
    public void importHCMRegions(String filePath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode root = objectMapper.readTree(new File(filePath));
        
        JsonNode features = root.get("features");
       
        for (JsonNode feature : features) {
            String province = feature.at("/properties/NAME_1").asText();
            System.out.println(province);
            if (!province.equalsIgnoreCase("HồChíMinh")) continue;

            String name = feature.at("/properties/NAME_2").asText();
            System.out.println("name: " + name);
            String type = feature.at("/properties/ENGTYPE_2").asText();
            JsonNode coordinates = feature.at("/geometry/coordinates");

            String geoJson = objectMapper.writeValueAsString(feature.get("geometry"));
            Region region = new Region();
            GeoJSON geoJSON = GeoJSONFactory.create(geoJson);
            GeoJSONReader reader = new GeoJSONReader();
           Geometry jtsGeometry = reader.read((geoJSON));
            if (jtsGeometry instanceof MultiPolygon) {
                MultiPolygon mp = (MultiPolygon) jtsGeometry;
                // sử dụng mp để lưu vào PostGIS
                region.setGeom(mp);
            }
            
            region.setName(name);
            region.setProvince(province);
          

            regionRepository.save(region);
        }

        System.out.println("✅ Import xong các quận HCM.");
    }
    
    @GetMapping
    public List<RegionDto> getAllRegions() {
        return regionRepository.findAll().stream().map(region -> {
            RegionDto dto = new RegionDto();
            dto.setId(region.getId());
            dto.setName(region.getName());
            dto.setProvince(region.getProvince());
            return dto;
        }).collect(Collectors.toList());
    }

}
