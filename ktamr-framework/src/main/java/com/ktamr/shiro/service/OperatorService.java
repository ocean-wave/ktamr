package com.ktamr.shiro.service;

import com.ktamr.domain.HaOperator;
import com.ktamr.common.exception.operator.HaOperatorNotPasswordException;
import com.ktamr.common.exception.operator.HaOperatorNullException;
import com.ktamr.service.HaOperatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OperatorService {

    @Autowired
    private HaOperatorService haOperatorService;

    public HaOperator login(String uid, String pwd){
        HaOperator haOperator = null;
        haOperator = haOperatorService.selectOperatorByUid(uid);

        if (haOperator == null)
        {
            throw new HaOperatorNullException();
        }
        if(!(haOperator.getOperatorPwd().trim().equals(pwd.trim()))) {
            throw new HaOperatorNotPasswordException();
        }

        return haOperator;
    }
}
