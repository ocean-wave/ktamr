package com.ktamr.mapper;

import com.ktamr.domain.HaArea;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AllSmallAreaMapper {

    List<HaArea> queryAllSmallArea(@Param("haArea") HaArea haArea, @Param("page") Integer page,
                                   @Param("rowNum") Integer rowNum);

    List<HaArea> queryAllSmallArea2(@Param("areaNo") String areaNo);

    Integer smallAreaCount(HaArea haArea);

}
