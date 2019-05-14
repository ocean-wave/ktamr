package com.ktamr.service;

import com.ktamr.common.parameter.ParameterInfo;
import com.ktamr.domain.HaMeter;
import com.ktamr.domain.HaRecords;

import java.util.List;
import java.util.Map;

public interface HaRecordsService {

    public List<Map<String,Object>> selectRecordsAndErrrecord(ParameterInfo parm);

    public List<Map<String,Object>> selectAllDayfreeze(ParameterInfo parms);

    public List<Map<String,Object>> selectAllMonfreeze(ParameterInfo parms);

    public Integer insertRecords(HaMeter haMeter);

    /**
     * 查询两表
     * @param cmdId cmdId
     * @return 返回泛型对象集合
     */
    public List<HaRecords> selectRecordsAndErrrecordTow(Integer cmdId);

    /**
     * 查询历史抄收数据HaRecords表信息
     * @param params 对象参数
     * @return 返回泛型对象集合
     */
    public List<HaRecords> selectDosageHistory(HaRecords params);

}
