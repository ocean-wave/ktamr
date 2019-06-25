package com.ktamr.service.impl;

import com.ktamr.domain.HaMeter;
import com.ktamr.domain.HaMonfreeze;
import com.ktamr.mapper.HaMonFreezeMapper;
import com.ktamr.service.HaMonFreezeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class HaMonFreezeServiceImpl implements HaMonFreezeService {

    @Autowired
    private HaMonFreezeMapper haMonFreezeMapper;

    @Override
    public Integer insertMonFreeze(HaMeter haMeter) {
        return haMonFreezeMapper.insertMonFreeze(haMeter);
    }

    @Override
    public Integer insertMonFreezeTwo(String importTime) {
        return haMonFreezeMapper.insertMonFreezeTwo(importTime);
    }

    @Override
    public Integer updateMonFreeze(HaMeter haMeter) {
        return haMonFreezeMapper.updateMonFreeze(haMeter);
    }

    @Override
    public Integer updateMonFreezeTwo(String importTime) {
        return haMonFreezeMapper.updateMonFreezeTwo(importTime);
    }

    @Override
    public Integer delHaMonFreeze(Integer meterId) {
        return haMonFreezeMapper.delHaMonFreeze(meterId);
    }

    @Override
    public Integer selectMonFreezeMeterIdCount(HaMeter haMeter) {
        return haMonFreezeMapper.selectMonFreezeMeterIdCount(haMeter);
    }

    @Override
    public List<HaMonfreeze> selectAllMonfreeze(Map<String, Object> parms) {
        return haMonFreezeMapper.selectAllMonfreeze(parms);
    }
}
