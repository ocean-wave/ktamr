package com.ktamr.service;

import com.ktamr.domain.HaBuilding;

import java.util.List;

public interface HaBuildingService {

    public List<HaBuilding> selectAllBuildingAndCount(HaBuilding parms);

    List<HaBuilding> HaBuildingList(HaBuilding haBuilding);

    List<HaBuilding> queryHaBuilding(Integer areaId);

    Integer addHaBuilding(HaBuilding haBuilding);

    Integer updateHaBuilding(HaBuilding haBuilding);

    Integer deleteHaBuilding(HaBuilding haBuilding);

}
