package com.mobifone.btsmanager.services.impl;

import com.mobifone.btsmanager.entity.BaseStation;
import com.mobifone.btsmanager.repository.BaseStationRepository;
import com.mobifone.btsmanager.services.IBaseStationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BaseStationServiceImplement implements IBaseStationService {
    private BaseStationRepository baseStationRepository;

    @Override
    public BaseStation insertBaseStation(BaseStation baseStation) {
        return baseStationRepository.save(baseStation);
    }
}
