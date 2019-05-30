package com.ktamr.service;

import com.ktamr.domain.HaOperator;

import java.util.List;

public interface HaOperatorService {
    public HaOperator selectOperatorByUid(String uid);

    public String selectOperatorRgnByName(String operatorName);

    public String selectOperatorAreaByName(String operatorName);

    List<HaOperator> HaOperatorList(HaOperator haOperator, Integer page,
                                    Integer rowNum);

    HaOperator updateByIdHaOperator(String operatorCode);

    HaOperator selUpperRgnType(String operatorCode);

    Integer selectHaOperatorCount(HaOperator haOperator);

    Integer addHaOperator(HaOperator haOperator);

    Integer updateHaOperator(HaOperator haOperator);

    Integer deleteHaOperator(HaOperator haOperator);
}
