package com.ktamr.service.impl;

import com.ktamr.common.parameter.ParameterInfo;
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

    @Override
    public List<Map<String, Object>> selectRecordsAndErrrecord(ParameterInfo parms) {
        return haRecordsMapper.selectRecordsAndErrrecord(parms);
    }

    @Override
    public List<Map<String, Object>> selectAllDayfreeze(ParameterInfo parms) {
        return haRecordsMapper.selectAllDayfreeze(parms);
    }

    @Override
    public List<Map<String, Object>> selectAllMonfreeze(ParameterInfo parms) {
        return haRecordsMapper.selectAllMonfreeze(parms);
    }

    @Override
    public List<Map<String, Object>> selectFreeze(ParameterInfo params) {
        return haRecordsMapper.selectFreeze(params);
    }

    @Override
    public List<Map<String, Object>> selectReplace(ParameterInfo params) {
        return haRecordsMapper.selectReplace(params);
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

    @Override
    public List<HaRecords> selectDosageHistory(ParameterInfo params) {
        return haRecordsMapper.selectDosageHistory(params);
    }

}
