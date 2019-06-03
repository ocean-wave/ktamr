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
    public List<HaPaylog>  selectHaPaylogList(@Param("HaPaylog") HaPaylog haPaylog);



    /**
     * 对月报表的查询
     * @param haPaylog
     * @return
     */
    public List<HaPaylog>  selectMonthReportList(@Param("HaPaylog") HaPaylog haPaylog);



    /**
     * 点击打印缴费单时进行查询1
     * @param haPaylog
     * @return
     */
    public List<HaPaylog> BselectPritJiaoFeiDan1(@Param("HaPaylog")HaPaylog haPaylog);

}
