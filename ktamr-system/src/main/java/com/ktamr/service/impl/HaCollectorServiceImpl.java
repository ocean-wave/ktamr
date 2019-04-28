package com.ktamr.service.impl;

import com.ktamr.domain.HaCollector;
import com.ktamr.mapper.HaCollectorMapper;
import com.ktamr.service.HaCollectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HaCollectorServiceImpl implements HaCollectorService {

    @Autowired
    private HaCollectorMapper haCollectorMapper;

    @Override
    public List<HaCollector> selectCollector(HaCollector haCollector) {
        return haCollectorMapper.selectCollector(haCollector);
    }

    public List<HaCollector> HaCollectorList(HaCollector haCollector) {
        return haCollectorMapper.HaCollectorList(haCollector);
    }

    @Override
    public List<HaCollector> queryHaCollector(Integer centorId) {
        return haCollectorMapper.queryHaCollector(centorId);
    }

    public Integer addHaCollector(HaCollector haCollector) {
        return haCollectorMapper.addHaCollector(haCollector);
    }

    public Integer updateHaCollector(HaCollector haCollector) {
        return haCollectorMapper.updateHaCollector(haCollector);
    }

    public Integer deleteHaCollector(HaCollector haCollector) {
        return haCollectorMapper.deleteHaCollector(haCollector);
    }
}
