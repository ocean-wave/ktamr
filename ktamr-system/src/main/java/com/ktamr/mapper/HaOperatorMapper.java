package com.ktamr.mapper;

import com.ktamr.domain.HaOperator;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface HaOperatorMapper {

    public HaOperator selectOperatorByUid(String uid);

    public String selectOperatorRgnByName(String operatorName);

    public String selectOperatorAreaByName(String operatorName);

    public List<HaOperator> selectOperatorCompany(String operatorName);

    List<HaOperator> HaOperatorList(@Param("haOperator") HaOperator haOperator);

    HaOperator updateByIdHaOperator(@Param("operatorCode") String operatorCode);

    HaOperator selUpperRgnType(@Param("operatorCode") String operatorCode);

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
}
