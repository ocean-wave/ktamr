package com.ktamr.common.utils.sql;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ktamr.common.utils.ServletUtils;
import com.ktamr.common.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * sql工具类 数据范围过滤
 *
 * @author ktamr
 */
public class SqlCondition {

    protected final Logger logger = LoggerFactory.getLogger(SqlCondition.class);

    private String groupOp;
    private List<Map<String,String>> rules;


    public static String getMultipleConditions(){
        String sql = "  ";
        ObjectMapper objectMapper = new ObjectMapper();
        String str = ServletUtils.getRequest().getParameter("filters");
        if (!StringUtils.isEmpty(str)) {
            try {
                SqlCondition sqlCondition = objectMapper.readValue(str, SqlCondition.class);
                sql = sql + " where ";
                for (int i = 0;i<sqlCondition.rules.size();i++) {
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

    public static String getRightCondition(String fieldName,String noType,String condition){
        String haOperatorRgnType = (String) ServletUtils.getSession().getAttribute("haOperatorRgnType");
        String rgnStr = (String) ServletUtils.getSession().getAttribute("rgnStr");
        String leftRgnStr = (String) ServletUtils.getSession().getAttribute("leftRgnStr");
        String sql = "";
        if("rgn".equals(haOperatorRgnType)){
            sql = condition+" position(LEFT(" + fieldName +",1) in '"+rgnStr+"')>0 ";
        }else if("area".equals(haOperatorRgnType)){
            if("rgn".equals(noType)){
                sql= condition+" position(LEFT(" + fieldName + ",1) in '"+leftRgnStr+"') >0 ";
            }else {
                sql = condition + " position(LEFT(" + fieldName + ",5) in '" + rgnStr + "')>0 ";
            }
        }
        return sql;
    }

    public static String getUpperRightCondition(String fieldName,String noType,String condition,String upper_operator_code,String upper_rgn_type){
        String sql = "";
        if(upper_rgn_type.equals("rgn") && !upper_operator_code.equals("")){
            sql = condition+"LEFT(" + fieldName +",1) in (SELECT rgn_code FROM ha_operator_rgns WHERE operator_code='"+upper_operator_code+"')";
        }else if(upper_rgn_type.equals("area") && !upper_operator_code.equals("")){
            if(noType.equals("rgn")){
                sql = condition+"LEFT(" + fieldName +",1) in (SELECT Left(rgn_code, 1) FROM ha_operator_rgns WHERE operator_code='"+upper_operator_code+"' GROUP BY Left(rgn_code, 1))";
            }else {
                sql = condition+"LEFT(" + fieldName +",5) in (SELECT rgn_code FROM ha_operator_rgns WHERE operator_code='"+ upper_operator_code +"')";
            }
        }
        return sql;
    }

    public static String getRightCondition(){
        String operatorCode = (String) ServletUtils.getSession().getAttribute("operatorCode");
        String haOperatorRgnType = (String) ServletUtils.getSession().getAttribute("haOperatorRgnType");
        String sql = "";
        if(!"all".equals(haOperatorRgnType)){
            sql = " and o.operator_code='"+operatorCode+"'";
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
