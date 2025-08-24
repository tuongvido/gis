package com.mobifone.btsmanager.entity;

import jakarta.persistence.*;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
@Table
@Entity
@RequiredArgsConstructor

public class TowerUserAccess {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long cellTowerId;
    private String sessionId;
    private LocalDateTime accessTime;
    private LocalDateTime releaseTime;
    private Long dataVolume;
}
