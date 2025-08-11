package com.mobifone.btsmanager.entity;

import lombok.Getter;

@Getter
public enum RadioType {
    GSM("GSM"),
    LTE("LTE"),
    UMTS("UMTS");

    private final String value;

    RadioType(String value) {
        this.value = value;
    }

    public static RadioType fromValue(String value) {
        for (RadioType type : RadioType.values()) {
            if (type.value.equalsIgnoreCase(value)) {
                return type;
            }
        }
        throw new IllegalArgumentException("Unknown radio type: " + value);
    }
}

