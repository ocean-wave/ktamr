package com.ktamr.service;

import com.ktamr.domain.HaPricestandard;

import java.util.List;

public interface HaPricestandardService {

    List<HaPricestandard> HaPricestandardList(HaPricestandard haPricestandard);

    Integer selectHaPricestandardCount(HaPricestandard haPricestandard);

    HaPricestandard updateByIdHaPricestandard(HaPricestandard haPricestandard);

    Integer addHaPricestandard(HaPricestandard haPricestandard);

    Integer updateHaPricestandard(HaPricestandard haPricestandard);

    Integer deleteHaPricestandard(HaPricestandard haPricestandard);

    //收费类型下拉框
    List<HaPricestandard> PriceStandardGenOptionSelected();

    HaPricestandard queryPName(Integer pricestandardId);

    List<HaPricestandard> queryPriceStandardList();

    public Integer addingCellValidation(HaPricestandard haPricestandard);
}
