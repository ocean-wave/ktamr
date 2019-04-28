package com.ktamr.mapper;

import com.ktamr.domain.HaBuilding;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AllBuildingMapper {

    List<HaBuilding> queryAllBuilding(@Param("page") Integer page,
                                      @Param("rowNum") Integer rowNum);

    Integer allBuildingCount(HaBuilding haBuilding);

    List<HaBuilding> queryHaBuildingCondition(@Param("areaId") Integer areaId);

}
