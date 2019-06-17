package com.ktamr.service.impl;

import com.ktamr.domain.HaCollector;
import com.ktamr.mapper.HaCollectorMapper;
import com.ktamr.service.HaCollectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 采集器表实现类
 */
@Service
public class HaCollectorServiceImpl implements HaCollectorService {

    /**
     * 注入HaCollectorMapper
     */
    @Autowired
    private HaCollectorMapper haCollectorMapper;

    /**
     * 根据id查询采集器表信息
     * @param centorId 对象参数
     * @return 返回泛型集合对象
     */
    @Override
    public List<HaCollector> selectCollectorBycentorId(Integer centorId) {
        return haCollectorMapper.selectCollectorBycentorId(centorId);
    }

    public List<HaCollector> HaCollectorList(HaCollector haCollector) {
        return haCollectorMapper.HaCollectorList(haCollector);
    }

    @Override
    public Integer HaCollectorCount(HaCollector haCollector) {
        return haCollectorMapper.HaCollectorCount(haCollector);
    }

    @Override
    public Integer HaCollectorDelCount(Integer centorId) {
        return haCollectorMapper.HaCollectorDelCount(centorId);
    }

    @Override
    public List<HaCollector> queryHaCollector(Integer centorId) {
        return haCollectorMapper.queryHaCollector(centorId);
    }

    @Override
    public HaCollector updateByIdHaCollector(Integer collectorId) {
        return haCollectorMapper.updateByIdHaCollector(collectorId);
    }

    public Integer addHaCollector(HaCollector haCollector) {
        return haCollectorMapper.addHaCollector(haCollector);
    }

    public Integer updateHaCollector(HaCollector haCollector) {
        return haCollectorMapper.updateHaCollector(haCollector);
    }

    public Integer deleteHaCollector(Integer collectorId) {
        return haCollectorMapper.deleteHaCollector(collectorId);
    }

    @Override
    public List<HaCollector> collectorByDeviceId(Integer deviceId) {
        return haCollectorMapper.collectorByDeviceId(deviceId);
    }

    @Override
    public HaCollector getNconf(Integer collectorId) {
        return haCollectorMapper.getNconf(collectorId);
    }
}
