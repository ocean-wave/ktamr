package com.ktamr.service.impl;

import com.ktamr.domain.HatBalanceimport;
import com.ktamr.mapper.HatBalanceimportMapper;
import com.ktamr.service.HatBalanceimportService;

import javax.annotation.Resource;

public class HatBalanceimportServiceImpl  implements HatBalanceimportService {

    @Resource
    HatBalanceimportMapper hatBalanceimportMapper;


    /**
     * 添加状态为待校验
     * @param hatBalanceimport
     * @return
     */
    @Override
    public Integer insertHatBalanceimport(HatBalanceimport hatBalanceimport) {
        Integer insertHatBalanceimport = hatBalanceimportMapper.insertHatBalanceimport(hatBalanceimport);
        if(insertHatBalanceimport!=null){
            return insertHatBalanceimport;
        }
        return null;
    }
}
