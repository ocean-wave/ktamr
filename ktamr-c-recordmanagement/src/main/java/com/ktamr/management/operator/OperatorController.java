package com.ktamr.management.operator;

import com.ktamr.domain.HaOperator;
import com.ktamr.service.HaOperatorService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/operator")
public class OperatorController {

    @Resource
    private HaOperatorService haOperatorService;

    @RequestMapping("/operator_list")
    public String operator_list(){
        return "operator/operator_list";
    }

    @RequestMapping("/JumpOperatorAdd")
    public String jumpoperatoradd(){return "/operator/operator_add";}

    @RequestMapping("/JumpOperatorUpdate")
    public String jumpoperatorupdate(){return "/operator/operator_update";}

    @RequestMapping("/operatorListJson")
    @ResponseBody
    public Object operatorlistjson(HaOperator haOperator, HttpServletRequest request){
        Integer page,pageRows;
        String page1 = request.getParameter("page");//获取需要多少行
        String pageRows1 = request.getParameter("rows");//获取查询的起点位置
        if(page1==null&&pageRows1==null){//为了防止异常给它初始化一波
            page = 100;
            pageRows = 100;
        }else {//如果有那就获取一波
            page = Integer.parseInt(page1); // 取得当前页数
            pageRows = Integer.parseInt(pageRows1); // 取得每页显示行数
        }
        int page2=page;//重新定义变量接收
        --page2;
        List<HaOperator> haOperatorsList = haOperatorService.HaOperatorList(haOperator,pageRows,page2);
        Integer haOperatorCount = haOperatorService.selectHaOperatorCount(haOperator);
        Map<String ,Object> map=new HashMap<String, Object>();
        map.put("page",page);//设置初始的页码 就是第几页
        map.put("rowNum",pageRows);//一页显示几条数据
        map.put("records",haOperatorCount);//总记录数
        map.put("total",(haOperatorCount-1)/pageRows+1);//总页数的计算
        map.put("rows",haOperatorsList);//存放集合
        return map;
    }

    @RequestMapping("/AddHaOperator")
    @ResponseBody
    public Object addHaOperator(HaOperator haOperator){
        Integer haOperators = haOperatorService.addHaOperator(haOperator);
        if(haOperators!=null){
            return "true";
        }
        return "false";
    }

    @RequestMapping("/DeleteHaOperator")
    @ResponseBody
    public Object deleteHaOperator(HaOperator haOperator){
        Integer haOperators = haOperatorService.deleteHaOperator(haOperator);
        if(haOperators!=null){
            return "";
        }
            return "false";
    }
}
