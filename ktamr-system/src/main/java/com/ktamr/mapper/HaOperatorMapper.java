package com.ktamr.mapper;

import com.ktamr.domain.HaOperator;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HaOperatorMapper {

    public HaOperator selectOperatorByUid(String uid);

    public String selectOperatorRgnByName(String operatorName);

    public String selectOperatorAreaByName(String operatorName);

    List<HaOperator> HaOperatorList(@Param("haOperator") HaOperator haOperator, @Param("page") Integer page, @Param("rowNum") Integer rowNum);

    Integer selectHaOperatorCount(HaOperator haOperator);

    Integer addHaOperator(HaOperator haOperator);

    Integer updateHaOperator(HaOperator haOperator);

    Integer deleteHaOperator(HaOperator haOperator);
}
