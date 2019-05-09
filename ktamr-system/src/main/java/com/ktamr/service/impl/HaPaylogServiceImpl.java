package com.ktamr.service.impl;

import com.ktamr.domain.HaPaylog;
import com.ktamr.mapper.HaPaylogMapper;
import com.ktamr.service.HaPaylogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 缴费单
 */
@Service
public class HaPaylogServiceImpl implements HaPaylogService {

    @Resource
    private HaPaylogMapper haPaylogMapper;

    /**
     * 缴费单查询列表
     * @param haPaylog
     * @param page
     * @param rowNum
     * @return
     */
    @Override
    public List<HaPaylog> selectHaPaylogList(HaPaylog haPaylog, Integer page, Integer rowNum) {
        List<HaPaylog> haPaylogList = haPaylogMapper.selectHaPaylogList(haPaylog, page, rowNum);
        if(haPaylogList!=null){
            return  haPaylogList;
        }

        return null;
    }

    /**
     * 缴费单查询总记录数
     * @param haPaylog
     * @return
     */
    @Override
    public Integer selectHaPaylogListCount(HaPaylog haPaylog) {
        Integer paylogListCount = haPaylogMapper.selectHaPaylogListCount(haPaylog);
        if(paylogListCount!=null){
            return paylogListCount;
        }
        return null;
    }

    /**
     * 月报表的查询
     * @param haPaylog
     * @param page
     * @param rowNum
     * @return
     */
    @Override
    public List<HaPaylog> selectMonthReportList(HaPaylog haPaylog, Integer page, Integer rowNum) {
        List<HaPaylog> haPaylogList = haPaylogMapper.selectMonthReportList(haPaylog, page, rowNum);
        if(haPaylogList!=null){
            return haPaylogList;
        }
        return null;
    }

    /**
     * 月报表总记录数的查询
     * @param haPaylog
     * @return
     */
    @Override
    public Integer selectMonthReportListCount(HaPaylog haPaylog) {
        Integer reportListCount = haPaylogMapper.selectMonthReportListCount(haPaylog);
        if(reportListCount!=null){
            return reportListCount;
        }
        return null;
    }

    /**
     * 点击打印缴费单时进行查询1
     * @param haPaylog
     * @return
     */
    @Override
    public List<HaPaylog> BselectPritJiaoFeiDan1(HaPaylog haPaylog) {
        List<HaPaylog> haPaylogs = haPaylogMapper.BselectPritJiaoFeiDan1(haPaylog);
        if(haPaylogs!=null){
            return haPaylogs;
        }
        return null;
    }


}
