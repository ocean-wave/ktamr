package com.ktamr.service;

import com.ktamr.domain.HaCollector;

import java.util.List;

public interface HaCollectorService {
    public List<HaCollector> selectCollector(HaCollector haCollector);

    List<HaCollector> HaCollectorList(HaCollector haCollector);

    List<HaCollector> queryHaCollector(Integer centorId);

    Integer addHaCollector(HaCollector haCollector);

    Integer updateHaCollector(HaCollector haCollector);

    Integer deleteHaCollector(HaCollector haCollector);
}
