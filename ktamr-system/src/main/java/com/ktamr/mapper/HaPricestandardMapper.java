package com.ktamr.mapper;


import com.ktamr.domain.HaPricestandard;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HaPricestandardMapper {

    List<HaPricestandard> HaPricestandardList(@Param("haPricestandard") HaPricestandard haPricestandard);

    Integer selectHaPricestandardCount(HaPricestandard haPricestandard);

    HaPricestandard updateByIdHaPricestandard(@Param("haPricestandard") HaPricestandard haPricestandard);

    Integer addHaPricestandard(HaPricestandard haPricestandard);

    Integer updateHaPricestandard(HaPricestandard haPricestandard);

    Integer deleteHaPricestandard(HaPricestandard haPricestandard);

    //收费类型下拉框
    List<HaPricestandard> PriceStandardGenOptionSelected();

    HaPricestandard queryPName(@Param("pricestandardId") Integer pricestandardId);

    List<HaPricestandard> queryPriceStandardList();

    public Integer addingCellValidation(HaPricestandard haPricestandard);

}
