package com.ktamr.service;

import com.ktamr.domain.HaConfig;

import java.util.List;

/**
 * 小可爱提交
 */
public interface HaConfigService {


    List<HaConfig> queryHaConfig(HaConfig haConfig);

    Integer haConfigCount(HaConfig haConfig);

    Integer addHaConfig(HaConfig haConfig);

    Integer deleteHaConfig(HaConfig haConfig);

    Integer updateHaConfig(HaConfig haConfig);
}
