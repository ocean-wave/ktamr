package com.ktamr.service;

import com.ktamr.domain.HaPaylog;

import java.util.List;

/**
 * HaPaylogMapper映射HaPaylog
 */
public interface HaPaylogService {
    /**
     * 缴费单查询
     * @param haPaylog
     * @return
     */
    public List<HaPaylog>  selectHaPaylogList(HaPaylog haPaylog);


    /**
     * 月报表的查询
     * @param haPaylog
     * @param page
     * @param rowNum
     * @return
     */
    public List<HaPaylog>  selectMonthReportList(HaPaylog haPaylog);




    /**
     * 点击打印缴费单时进行查询1
     * @param haPaylog
     * @return
     */
    public List<HaPaylog> BselectPritJiaoFeiDan1(HaPaylog haPaylog);
}
