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
    public List<HaBuilding> HaBuildingListC(HaBuilding haBuilding) {
        return haBuildingMapper.HaBuildingListC(haBuilding);
    }
    @Override
    public List<HaBuilding> queryHaBuildingC(Integer areaId) {
        return haBuildingMapper.queryHaBuildingC(areaId);
    }

    public Integer addHaBuildingC(HaBuilding haBuilding) {
        return haBuildingMapper.addHaBuildingC(haBuilding);
    }

    public Integer updateHaBuildingC(HaBuilding haBuilding) {
        return haBuildingMapper.updateHaBuildingC(haBuilding);
    }

    public Integer deleteHaBuildingC(HaBuilding haBuilding) {
        return haBuildingMapper.deleteHaBuildingC(haBuilding);
    }

    @Override
    public List<HaBuilding> queryAllBuildingC(Integer page, Integer rowNum) {
        return haBuildingMapper.queryAllBuildingC(page,rowNum);
    }

    @Override
    public Integer allBuildingCountC(HaBuilding haBuilding) {
        return haBuildingMapper.allBuildingCountC(haBuilding);
    }

    @Override
    public List<HaBuilding> queryHaBuildingConditionC(Integer areaId) {
        return haBuildingMapper.queryHaBuildingConditionC(areaId);
    }

}
