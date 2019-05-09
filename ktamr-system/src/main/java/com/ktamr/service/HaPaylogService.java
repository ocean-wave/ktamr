package com.ktamr.service;

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
    public List<HaPaylog>  selectHaPaylogList(HaPaylog haPaylog, Integer page,
                                              Integer rowNum);
    /**
     * 缴费单查询的总记录数
     * @param haPaylog
     * @return
     */
    public Integer selectHaPaylogListCount(HaPaylog haPaylog);

    /**
     * 月报表的查询
     * @param haPaylog
     * @param page
     * @param rowNum
     * @return
     */
    public List<HaPaylog>  selectMonthReportList(HaPaylog haPaylog, Integer page,
                                                 Integer rowNum);

    /**
     * 月报表查询的总记录数
     * @param haPaylog
     * @return
     */
    public Integer selectMonthReportListCount(HaPaylog haPaylog);


    /**
     * 点击打印缴费单时进行查询1
     * @param haPaylog
     * @return
     */
    public List<HaPaylog> BselectPritJiaoFeiDan1(HaPaylog haPaylog);
}
