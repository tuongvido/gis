package com.mobifone.btsmanager.controller;

import com.mobifone.btsmanager.entity.BaseStation;
import com.mobifone.btsmanager.services.IBaseStationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/base-station")
@RequiredArgsConstructor
public class BaseStationController {
    private IBaseStationService baseStationService;

    @PostMapping("/create")
    public ResponseEntity<BaseStation> create(@RequestBody BaseStation baseStation) {
        return ResponseEntity.ok(baseStationService.insertBaseStation(baseStation));
    }
}
