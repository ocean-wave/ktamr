package com.ktamr.service;

import com.ktamr.domain.HaOperator;

import java.util.List;

public interface HaOperatorService {
    public HaOperator selectOperatorByUid(String uid);

    public String selectOperatorRgnByName(String operatorName);

    public String selectOperatorAreaByName(String operatorName);

    public List<HaOperator> selectOperatorCompany(String operatorName);

    List<HaOperator> HaOperatorList(HaOperator haOperator);

    HaOperator updateByIdHaOperator(String operatorCode);

    HaOperator selUpperRgnType(String operatorCode);

    Integer selectHaOperatorCount(HaOperator haOperator);

    Integer addHaOperator(HaOperator haOperator);

    Integer updateHaOperator(HaOperator haOperator);

    Integer deleteHaOperator(HaOperator haOperator);

    /**
     * 修改密码时验证原密码
     * @param haOperator
     * @return
     */
    String CheckPwd(HaOperator haOperator);

    /**
     * 修改密码操作
     * @param haOperator
     * @return
     */
    Integer ChangePWD(HaOperator haOperator);

    //修改传值
    HaOperator HaOperatorGetByID(HaOperator haOperator);
}
