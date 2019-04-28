package com.ktamr.service;

import com.ktamr.domain.HaConfig;

import java.util.List;

public interface HaConfigService {

    List<HaConfig> queryHaConfig(HaConfig haConfig, Integer page,
                                 Integer rowNum);

    Integer haConfigCount(HaConfig haConfig);
}
