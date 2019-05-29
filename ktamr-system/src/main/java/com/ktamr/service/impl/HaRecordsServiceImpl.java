package com.ktamr.service.impl;

import com.ktamr.domain.HaMeter;
import com.ktamr.domain.HaRecords;
import com.ktamr.mapper.HaRecordsMapper;
import com.ktamr.service.HaRecordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class HaRecordsServiceImpl implements HaRecordsService {

    @Autowired
    private HaRecordsMapper haRecordsMapper;

    /**
     * 查询抄表记录表与抄表出错记录表信息
     * @param parms Map参数
     * @return 返回泛型集合
     */
    @Override
    public List<HaRecords> selectRecordsAndErrrecord(Map<String,Object> parms) {
        return haRecordsMapper.selectRecordsAndErrrecord(parms);
    }

    @Override
    public Integer insertRecords(HaMeter haMeter) {
        return haRecordsMapper.insertRecords(haMeter);
    }

    /**
     * 查询两表
     * @param cmdId cmdId
     * @return 返回泛型对象集合
     */
    @Override
    public List<HaRecords> selectRecordsAndErrrecordTow(Integer cmdId) {
        return haRecordsMapper.selectRecordsAndErrrecordTow(cmdId);
    }

    /**
     * 查询历史抄收数据HaRecords表信息
     * @param params 对象参数
     * @return 返回泛型对象集合
     */
    @Override
    public List<HaRecords> selectDosageHistory(HaRecords params) {
        return haRecordsMapper.selectDosageHistory(params);
    }

}
