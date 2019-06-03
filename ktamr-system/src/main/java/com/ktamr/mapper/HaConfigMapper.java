package com.ktamr.mapper;

import com.ktamr.domain.HaConfig;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HaConfigMapper {

    List<HaConfig> queryHaConfig(@Param("haConfig") HaConfig haConfig);

    Integer haConfigCount(HaConfig haConfig);

    Integer addHaConfig(HaConfig haConfig);

    Integer deleteHaConfig(HaConfig haConfig);

    Integer updateHaConfig(HaConfig haConfig);
}
