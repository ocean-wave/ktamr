package com.ktamr.service;

import com.ktamr.domain.HaErrrecord;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 接口Service层
 */
public interface HaErrrecordService {

    /**
     * 查询ha_errRecord表并且向左连接四表
     * @param cmdId 条件id
     * @return返回泛型集合HaErrrecord类
     */
    public List<HaErrrecord> selecErrrecordLeftJoinFour(Integer cmdId);
}
