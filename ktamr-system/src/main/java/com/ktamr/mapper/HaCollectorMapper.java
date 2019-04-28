package com.ktamr.mapper;

import com.ktamr.domain.HaCollector;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HaCollectorMapper {
    public List<HaCollector> selectCollector(HaCollector haCollector);

    List<HaCollector> HaCollectorList(HaCollector haCollector);

    List<HaCollector> queryHaCollector(@Param("centorId") Integer centorId);

    Integer addHaCollector(HaCollector haCollector);

    Integer updateHaCollector(HaCollector haCollector);

    Integer deleteHaCollector(HaCollector haCollector);
}
