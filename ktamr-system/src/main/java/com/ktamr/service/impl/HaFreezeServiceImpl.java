package com.ktamr.service.impl;

import com.ktamr.domain.HaFreeze;
import com.ktamr.mapper.HaFreezeMapper;
import com.ktamr.service.HaFreezeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class HaFreezeServiceImpl implements HaFreezeService {

    @Resource
    private HaFreezeMapper haFreezeMapper;

    /**
     * 点击费用结算所做的步骤1
     * @param haFreeze
     * @return
     */
    @Override
    public Integer insertHaFreeze1(HaFreeze haFreeze) {
        Integer insertHaFreeze1 = haFreezeMapper.insertHaFreeze1(haFreeze);
        if(insertHaFreeze1!=null){
            return insertHaFreeze1;
        }
        return null;
    }

    /**
     * 点击费用结算所做的步骤2
     * @param haFreeze
     * @return
     */
    @Override
    public Integer insertHaFreeze2(HaFreeze haFreeze) {
        Integer insertHaFreeze2 = haFreezeMapper.insertHaFreeze2(haFreeze);
        if(insertHaFreeze2!=null){
            return insertHaFreeze2;
        }
        return null;
    }
}
