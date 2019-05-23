package com.ktamr.common.utils.sql;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ktamr.common.utils.ServletUtils;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class SqlCondition {

    private String groupOp;
    private List<Map<String,String>> rules;


    public static String getMultipleConditions(){
        String sql = "  ";
        ObjectMapper objectMapper = new ObjectMapper();
        String str = ServletUtils.getRequest().getParameter("filters");
        if (str != null) {
            try {
                SqlCondition sqlCondition = objectMapper.readValue(str, SqlCondition.class);
                for (int i = 0;i<sqlCondition.rules.size();i++) {
                        sql = sql + " where ";
                        String field = sqlCondition.rules.get(i).get("field");
                        String op = sqlCondition.rules.get(i).get("op");
                        String data = sqlCondition.rules.get(i).get("data");
                        String[] s = field.split("\\.");
                        field = s.length==0?field:s[s.length-1];
                        if(op.equals("like") || op.equals("not like")){
                            field = " "+field+"::text ";
                            data = " '%"+data+"%' ";
                            sql = sql + (sqlCondition.rules.size()>1 && i >= 1?sqlCondition.groupOp + " "+field+" "+op+data:field+" "+op+data);
                        }else {
                            sql = sql + (sqlCondition.rules.size()>1 && i >= 1?sqlCondition.groupOp + " "+field+" "+op+" '"+data+"'":field+" "+op+" '"+data+"'");
                        }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sql;
    }

    public String getGroupOp() {
        return groupOp;
    }

    public void setGroupOp(String groupOp) {
        this.groupOp = groupOp;
    }

    public List<Map<String, String>> getRules() {
        return rules;
    }

    public void setRules(List<Map<String, String>> rules) {
        this.rules = rules;
    }
}
