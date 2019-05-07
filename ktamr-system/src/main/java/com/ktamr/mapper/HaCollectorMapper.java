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

    List<HaCollector> HaCollectorList(HaCollector haCollector);

    List<HaCollector> queryHaCollector(@Param("centorId") Integer centorId);

    Integer addHaCollector(HaCollector haCollector);

    Integer updateHaCollector(HaCollector haCollector);

    Integer deleteHaCollector(HaCollector haCollector);
}
