package com.ktamr.mapper;

import com.ktamr.domain.HaMonthbtime;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HaMonthbtimeMapper {
    /**
     * 根据arreaid查询起始结束时间并返回到缴费单页面结算周期下拉框中
     * @param haMonthbtime
     * @return Json数据
     */
    public List<HaMonthbtime> BselectTime(@Param("HaMonthbtime")HaMonthbtime haMonthbtime);
}
