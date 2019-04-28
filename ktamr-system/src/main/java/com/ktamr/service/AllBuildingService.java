package com.ktamr.service;

import com.ktamr.domain.HaBuilding;

import java.util.List;

public interface AllBuildingService {

    List<HaBuilding> queryAllBuilding(Integer page, Integer rowNum);

    Integer allBuildingCount(HaBuilding haBuilding);

    List<HaBuilding> queryHaBuildingCondition(Integer areaId);

}
