package com.mobifone.btsmanager.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
@Table
@Entity

@RequiredArgsConstructor
@Data
public class ConstructionUnit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;
    private String contactPerson;
    private String phone;
    private LocalDateTime createdAt;
}
