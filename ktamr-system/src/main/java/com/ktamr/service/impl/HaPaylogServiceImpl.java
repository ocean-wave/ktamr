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
     * @return
     */
    @Override
    public List<HaPaylog> selectHaPaylogList(HaPaylog haPaylog) {
        List<HaPaylog> haPaylogList = haPaylogMapper.selectHaPaylogList(haPaylog);
        if(haPaylogList!=null){
            return  haPaylogList;
        }

        return null;
    }



    /**
     * 月报表的查询
     * @param haPaylog
     * @return
     */
    @Override
    public List<HaPaylog> selectMonthReportList(HaPaylog haPaylog) {
        List<HaPaylog> haPaylogList = haPaylogMapper.selectMonthReportList(haPaylog);
        if(haPaylogList!=null){
            return haPaylogList;
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
