package com.ktamr.mapper;


import com.ktamr.domain.HaPricestandard;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HaPricestandardMapper {

    List<HaPricestandard> HaPricestandardList(@Param("haPricestandard") HaPricestandard haPricestandard, @Param("page") Integer page, @Param("rowNum") Integer rowNum);

    Integer selectHaPricestandardCount(HaPricestandard haPricestandard);

    HaPricestandard updateByIdHaPricestandard(@Param("haPricestandard") HaPricestandard haPricestandard);

    Integer addHaPricestandard(HaPricestandard haPricestandard);

    Integer updateHaPricestandard(HaPricestandard haPricestandard);

    Integer deleteHaPricestandard(HaPricestandard haPricestandard);


}