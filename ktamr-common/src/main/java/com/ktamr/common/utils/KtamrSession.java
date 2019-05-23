package com.ktamr.common.utils;

import java.util.HashMap;
import java.util.Map;

public class KtamrSession {

    public static Map<String,Object> getKtamrSession(){
        Map<String,Object> params = new HashMap<>();
        params.put("haOperator", ServletUtils.getSession().getAttribute("haOperator"));
        params.put("rgnStr", ServletUtils.getSession().getAttribute("rgnStr"));
        params.put("areaNo", ServletUtils.getSession().getAttribute("areaNo"));
        return params;
    }

    public static Map<String,Object> getKtamrSession(Map<String,Object> params){
        params.put("haOperator", ServletUtils.getSession().getAttribute("haOperator"));
        params.put("rgnStr", ServletUtils.getSession().getAttribute("rgnStr"));
        params.put("areaNo", ServletUtils.getSession().getAttribute("areaNo"));
        return params;
    }
}
