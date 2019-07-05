package com.ktamr.mapper;

import com.ktamr.domain.HaCollector;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 采集器表Mapper
 */
public interface HaCollectorMapper {

    /**
     * 根据id查询采集器表信息
     * @param centorId 对象参数
     * @return 返回泛型集合对象
     */
    public List<HaCollector> selectCollectorBycentorId(Integer centorId);

    List<HaCollector> HaCollectorList(@Param("haCollector") HaCollector haCollector);

    Integer HaCollectorCount(HaCollector haCollector);

    Integer HaCollectorDelCount(@Param("centorId") Integer centorId);

    List<HaCollector> queryHaCollector(@Param("centorId") Integer centorId);

    HaCollector updateByIdHaCollector(@Param("collectorId") Integer collectorId);

    Integer addHaCollector(HaCollector haCollector);

    Integer updateHaCollector(HaCollector haCollector);

    Integer deleteHaCollector(@Param("collectorId") Integer collectorId);

    //deviceId不为空查询
    List<HaCollector> collectorByDeviceId(@Param("deviceId") Integer deviceId);

    HaCollector getNconf(@Param("collectorId") Integer collectorId);

    //修改时采集器传值
    List<HaCollector> CollectorByWhere(HaCollector haCollector);

    /**
     * 添加采集器时验证一波
     * @param haCollector
     * @return
     */
    public Integer addingCellValidation2(HaCollector haCollector);

}
