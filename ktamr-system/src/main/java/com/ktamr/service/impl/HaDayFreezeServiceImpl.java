package com.ktamr.service.impl;

import com.ktamr.domain.HaMeter;
import com.ktamr.mapper.HaDayFreezeMapper;
import com.ktamr.service.HaDayFreezeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HaDayFreezeServiceImpl implements HaDayFreezeService {

    @Autowired
    private HaDayFreezeMapper haDayFreezeMapper;

    @Override
    public Integer selectDayFreezeMeterIdCount(HaMeter haMeter) {
        return haDayFreezeMapper.selectDayFreezeMeterIdCount(haMeter);
    }

    @Override
    public Integer updateDayFreeze(HaMeter haMeter) {
        return haDayFreezeMapper.updateDayFreeze(haMeter);
    }

    @Override
    public Integer insertDayFreeze(HaMeter haMeter) {
        return haDayFreezeMapper.insertDayFreeze(haMeter);
    }
}
