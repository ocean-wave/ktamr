package com.ktamr.mapper;

import com.ktamr.domain.HaErrrecord;
import com.ktamr.domain.HaMeterAddr;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 抄表出错记录表Mapper层
 */
public interface HaErrrecordMapper {

    /**
     * 查询ha_errRecord表并且向左连接四表
     * @param cmdId 条件id
     * @return 返回泛型集合HaErrrecord类
     */
    public List<HaErrrecord> selecErrrecordLeftJoinFour(@Param("cmdId") Integer cmdId);
}
