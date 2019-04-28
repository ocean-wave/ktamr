package com.ktamr.service.impl;

import com.ktamr.domain.HaMeter;
import com.ktamr.mapper.HaMonFreezeMapper;
import com.ktamr.service.HaMonFreezeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HaMonFreezeServiceImpl implements HaMonFreezeService {

    @Autowired
    private HaMonFreezeMapper haMonFreezeMapper;

    @Override
    public Integer selectMonFreezeMeterIdCount(HaMeter haMeter) {
        return haMonFreezeMapper.selectMonFreezeMeterIdCount(haMeter);
    }

    @Override
    public Integer updateMonFreeze(HaMeter haMeter) {
        return haMonFreezeMapper.updateMonFreeze(haMeter);
    }

    @Override
    public Integer insertMonFreeze(HaMeter haMeter) {
        return haMonFreezeMapper.insertMonFreeze(haMeter);
    }
}