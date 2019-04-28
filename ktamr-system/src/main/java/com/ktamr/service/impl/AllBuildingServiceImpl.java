package com.ktamr.service.impl;

import com.ktamr.domain.HaBuilding;
import com.ktamr.mapper.AllBuildingMapper;
import com.ktamr.service.AllBuildingService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AllBuildingServiceImpl implements AllBuildingService {

    @Resource
    private AllBuildingMapper allBuildingMapper;

    @Override
    public List<HaBuilding> queryAllBuilding(Integer page, Integer rowNum) {
        return allBuildingMapper.queryAllBuilding(page,rowNum);
    }

    @Override
    public Integer allBuildingCount(HaBuilding haBuilding) {
        return allBuildingMapper.allBuildingCount(haBuilding);
    }

    @Override
    public List<HaBuilding> queryHaBuildingCondition(Integer areaId) {
        return allBuildingMapper.queryHaBuildingCondition(areaId);
    }
}
