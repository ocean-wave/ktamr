package com.ktamr.service.impl;

import com.ktamr.domain.HaBuilding;
import com.ktamr.mapper.HaBuildingMapper;
import com.ktamr.service.HaBuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HaBuildingServiceImpl implements HaBuildingService {

    @Autowired
    private HaBuildingMapper haBuildingMapper;


    @Override
    public List<HaBuilding> selectAllBuildingAndCount(HaBuilding parms) {
        return haBuildingMapper.selectAllBuildingAndCount(parms);
    }
    public List<HaBuilding> HaBuildingList(HaBuilding haBuilding) {
        return haBuildingMapper.HaBuildingList(haBuilding);
    }
    @Override
    public List<HaBuilding> queryHaBuilding(Integer areaId) {
        return haBuildingMapper.queryHaBuilding(areaId);
    }

    public Integer addHaBuilding(HaBuilding haBuilding) {
        return haBuildingMapper.addHaBuilding(haBuilding);
    }

    public Integer updateHaBuilding(HaBuilding haBuilding) {
        return haBuildingMapper.updateHaBuilding(haBuilding);
    }

    public Integer deleteHaBuilding(HaBuilding haBuilding) {
        return haBuildingMapper.deleteHaBuilding(haBuilding);
    }

}
