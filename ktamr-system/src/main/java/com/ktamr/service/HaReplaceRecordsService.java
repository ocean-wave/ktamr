package com.ktamr.service;

import com.ktamr.domain.HaReplacerecords;

import java.util.List;

/**
 * 换表记录表Service
 */
public interface HaReplaceRecordsService {

    /**
     * 查询换表记录表信息
     * @param haReplacerecords 对象参数
     * @return 返回泛型对象集合
     */
    public List<HaReplacerecords> selectReplace(HaReplacerecords haReplacerecords);

    //replace meter
    Integer replaceMeter2(HaReplacerecords haReplacerecords);

}
