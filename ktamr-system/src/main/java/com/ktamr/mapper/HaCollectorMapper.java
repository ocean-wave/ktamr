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

    List<HaCollector> HaCollectorList(@Param("haCollector") HaCollector haCollector,@Param("page") Integer page,
                                      @Param("rowNum") Integer rowNum);

    Integer HaCollectorCount(HaCollector haCollector);

    List<HaCollector> queryHaCollector(@Param("centorId") Integer centorId);

    HaCollector updateByIdHaCollector(@Param("collectorId") Integer collectorId);

    Integer addHaCollector(HaCollector haCollector);

    Integer updateHaCollector(HaCollector haCollector);

    Integer deleteHaCollector(@Param("collectorId") Integer collectorId);
}
