package com.ktamr.service.impl;

import com.ktamr.domain.HaArea;
import com.ktamr.mapper.AllSmallAreaMapper;
import com.ktamr.service.AllSmallAreaService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AllSmallAreaServiceImpl implements AllSmallAreaService {

    @Resource
    private AllSmallAreaMapper allSmallAreaMapper;

    @Override
    public List<HaArea> queryAllSmallArea(HaArea haArea, Integer page, Integer rowNum) {
        return allSmallAreaMapper.queryAllSmallArea(haArea,page,rowNum);
    }

    @Override
    public List<HaArea> queryAllSmallArea2(String areaNo) {
        return allSmallAreaMapper.queryAllSmallArea2(areaNo);
    }

    @Override
    public Integer smallAreaCount(HaArea haArea) {
        return allSmallAreaMapper.smallAreaCount(haArea);
    }
}
