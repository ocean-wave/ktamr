package com.ktamr.mapper;

import com.ktamr.domain.HaPaylog;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * HaPaylogMapper映射HaPaylog
 */
public interface HaPaylogMapper {
    /**
     * 缴费单查询
     * @param haPaylog
     * @return
     */
    public List<HaPaylog>  selectHaPaylogList(@Param("HaPaylog") HaPaylog haPaylog, @Param("page") Integer page,
                                              @Param("rowNum") Integer rowNum);

    /**
     * 缴费单查询的总记录数
     * @param haPaylog
     * @return
     */
    public Integer selectHaPaylogListCount(@Param("HaPaylog") HaPaylog haPaylog);

    /**
     * 对月报表的查询
     * @param haPaylog
     * @param page
     * @param rowNum
     * @return
     */
    public List<HaPaylog>  selectMonthReportList(@Param("HaPaylog") HaPaylog haPaylog, @Param("page") Integer page,
                                                 @Param("rowNum") Integer rowNum);

    /**
     * 查询月报表查询的总记录数
     * @param haPaylog
     * @return
     */
    public Integer selectMonthReportListCount(@Param("HaPaylog") HaPaylog haPaylog);


}
