package com.ktamr.service.impl;

import com.ktamr.domain.HaMonthbtime;
import com.ktamr.mapper.HaMonthbtimeMapper;
import com.ktamr.service.HaMonthbtimeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class HaMonthbtimeServiceImpl implements HaMonthbtimeService {

    @Resource
    private HaMonthbtimeMapper haMonthbtimeMapper;

    /**
     * 根据arreaid查询起始结束时间并返回到缴费单页面结算周期下拉框中
     * @param haMonthbtime
     * @return  Json数据
     */
    @Override
    public List<HaMonthbtime> BselectTime(HaMonthbtime haMonthbtime) {
        List<HaMonthbtime> haMonthbtimeList = haMonthbtimeMapper.BselectTime(haMonthbtime);
        if(haMonthbtimeList!=null){
            return haMonthbtimeList;
        }
        return null;
    }
}
