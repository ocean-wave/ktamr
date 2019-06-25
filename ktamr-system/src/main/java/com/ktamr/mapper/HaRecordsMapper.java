package com.ktamr.mapper;

import com.ktamr.domain.HaMeter;
import com.ktamr.domain.HaRecords;

import java.util.List;
import java.util.Map;

/**
 * 抄表记录表HaRecordsMapper
 */
public interface HaRecordsMapper {

    public Integer insertRecords(HaMeter haMeter);

    public Integer insertRecordsTwo(Map<String,Object> map);

    /**
     * 查询抄表记录表与抄表出错记录表信息
     * @param parms Map参数
     * @return 返回泛型集合
     */
    public List<HaRecords> selectRecordsAndErrrecord(Map<String,Object> parms);

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
