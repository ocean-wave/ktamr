package com.ktamr.mapper;

import com.ktamr.common.parameter.ParameterInfo;
import com.ktamr.domain.HaMeter;
import com.ktamr.domain.HaRecords;

import java.util.List;
import java.util.Map;

/**
 * 抄表记录表HaRecordsMapper
 */
public interface HaRecordsMapper {

    public List<Map<String,Object>> selectRecordsAndErrrecord(ParameterInfo parms);

    public List<Map<String,Object>> selectAllDayfreeze(ParameterInfo parms);

    public List<Map<String,Object>> selectAllMonfreeze(ParameterInfo parms);

    public List<Map<String,Object>> selectReplace(ParameterInfo params);

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
