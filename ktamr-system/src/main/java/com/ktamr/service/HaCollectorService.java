package com.ktamr.service;

import com.ktamr.domain.HaCollector;

import java.util.List;

/**
 * 采集器表Service
 */
public interface HaCollectorService {

    /**
     * 根据id查询采集器表信息
     * @param centorId 对象参数
     * @return 返回泛型集合对象
     */
    public List<HaCollector> selectCollectorBycentorId(Integer centorId);

    List<HaCollector> HaCollectorList(HaCollector haCollector);

    Integer HaCollectorCount(HaCollector haCollector);

    Integer HaCollectorDelCount(Integer centorId);

    List<HaCollector> queryHaCollector(Integer centorId);

    HaCollector updateByIdHaCollector(Integer collectorId);

    Integer addHaCollector(HaCollector haCollector);

    Integer updateHaCollector(HaCollector haCollector);

    Integer deleteHaCollector(Integer collectorId);

    //deviceId不为空查询
    List<HaCollector> collectorByDeviceId(Integer deviceId);

    HaCollector getNconf(Integer collectorId);

    //修改时采集器传值
    List<HaCollector> CollectorByWhere(HaCollector haCollector);

    /**
     * 添加采集器时验证一波
     * @param haCollector
     * @return
     */
    public Integer addingCellValidation2(HaCollector haCollector);
}
