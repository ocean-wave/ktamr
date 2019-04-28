package com.ktamr.service.impl;

import com.ktamr.domain.HaConfig;
import com.ktamr.mapper.HaConfigMapper;
import com.ktamr.service.HaConfigService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class HaConfigServiceImpl implements HaConfigService {

    @Resource
    private HaConfigMapper haConfigMapper;

    @Override
    public List<HaConfig> queryHaConfig(HaConfig haConfig, Integer page, Integer rowNum) {
        return haConfigMapper.queryHaConfig(haConfig,page,rowNum);
    }

    @Override
    public Integer haConfigCount(HaConfig haConfig) {
        return haConfigMapper.haConfigCount(haConfig);
    }
}