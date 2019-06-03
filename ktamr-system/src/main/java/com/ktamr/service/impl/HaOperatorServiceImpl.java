package com.ktamr.service.impl;

import com.ktamr.domain.HaOperator;
import com.ktamr.mapper.HaOperatorMapper;
import com.ktamr.service.HaOperatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HaOperatorServiceImpl implements HaOperatorService {

    @Autowired
    private HaOperatorMapper haOperatorMapper;


    @Override
    public HaOperator selectOperatorByUid(String uid) {
        return haOperatorMapper.selectOperatorByUid(uid);
    }

    @Override
    public String selectOperatorRgnByName(String operatorName) {
        return haOperatorMapper.selectOperatorRgnByName(operatorName);
    }

    @Override
    public String selectOperatorAreaByName(String operatorName) {
        return haOperatorMapper.selectOperatorAreaByName(operatorName);
    }

    @Override
    public List<HaOperator> selectOperatorCompany(String operatorName) {
        return haOperatorMapper.selectOperatorCompany(operatorName);
    }

    public List<HaOperator> HaOperatorList(HaOperator haOperator, Integer page,
                                           Integer rowNum) {
        return haOperatorMapper.HaOperatorList(haOperator,page,rowNum);
    }

    @Override
    public HaOperator updateByIdHaOperator(String operatorCode) {
        return haOperatorMapper.updateByIdHaOperator(operatorCode);
    }

    @Override
    public HaOperator selUpperRgnType(String operatorCode) {
        return haOperatorMapper.selUpperRgnType(operatorCode);
    }

    @Override
    public Integer selectHaOperatorCount(HaOperator haOperator) {
        Integer haOperators = haOperatorMapper.selectHaOperatorCount(haOperator);
        if(haOperators!=null){
            return haOperators ;
        }
        return null;
    }

    public Integer addHaOperator(HaOperator haOperator) {
        return haOperatorMapper.addHaOperator(haOperator);
    }

    public Integer updateHaOperator(HaOperator haOperator) {
        return haOperatorMapper.updateHaOperator(haOperator);
    }

    public Integer deleteHaOperator(HaOperator haOperator) {
        return haOperatorMapper.deleteHaOperator(haOperator);
    }

    /**
     * 修改密码时验证原密码
     * @param haOperator
     * @return
     */
    @Override
    public String CheckPwd(HaOperator haOperator) {
        String checkPwd = haOperatorMapper.CheckPwd(haOperator);
        if(checkPwd!=null){
            return checkPwd;
        }
        return null;
    }

    /**
     * 修改密码操作
     * @param haOperator
     * @return
     */
    @Override
    public Integer ChangePWD(HaOperator haOperator) {
        Integer changePWD = haOperatorMapper.ChangePWD(haOperator);
        if(changePWD!=null){
            return changePWD;
        }
        return null;
    }
}
