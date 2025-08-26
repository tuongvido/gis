package com.mobifone.btsmanager.dto;

import com.mobifone.btsmanager.entity.RadioType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SearchTowerDto {

    private String cell;
    private Integer status;
    private Integer districtId;
    private String radioType;
    private Integer constructionUnitId;
    private PageDto pageDto;

}
