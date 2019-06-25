package com.ktamr.common;


import com.ktamr.common.core.domain.BaseEntity;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.lang.reflect.Field;

@Service
public class Checkright {

    /**
     * 查询编号类型：noType rgn/area/centor 分别为1位数字/5位数字/10位数字'
     * @param fieldName
     * @param noType
     * @param condition SQL语句附加连接词
     */
    public void GetRightCondition(String fieldName, String noType, String condition, HttpSession session,BaseEntity baseEntity){

        String haOperatorRgnType = (String)session.getAttribute("haOperatorRgnType");
        String rgnStr = (String)session.getAttribute("rgnStr");
        String leftRgnStr = (String)session.getAttribute("leftRgnStr");
        baseEntity.setFieldName(fieldName);
        baseEntity.setNoType(noType);
        baseEntity.setCondition(condition);
        baseEntity.setOperator_rgn_type(haOperatorRgnType);
        baseEntity.setRgnStr(rgnStr);
        baseEntity.setLeftRgnStr(leftRgnStr);
    }

}
