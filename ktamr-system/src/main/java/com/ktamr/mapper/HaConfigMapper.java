package com.ktamr.mapper;

import com.ktamr.domain.HaConfig;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HaConfigMapper {

    List<HaConfig> queryHaConfig(@Param("haConfig") HaConfig haConfig, @Param("page") Integer page,
                                 @Param("rowNum") Integer rowNum);

    Integer haConfigCount(HaConfig haConfig);
}
