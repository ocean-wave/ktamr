package com.ktamr.management.system;

import com.ktamr.domain.HaConfig;
import com.ktamr.service.HaConfigService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/system")
public class SystemController {

    @Resource
    private HaConfigService haConfigService;

    @RequestMapping("/config_list")
    public String config_list(){
        return "system/config_list";
    }

    @RequestMapping("/ConfigListJson")
    @ResponseBody
    public Object configlistjson(HaConfig haConfig, HttpServletRequest request){
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
        List<HaConfig> haConfigs = haConfigService.queryHaConfig(haConfig,pageRows,page2);
        Integer configCount = haConfigService.haConfigCount(haConfig);
        Map<String ,Object> map=new HashMap<String, Object>();
        map.put("page",page);//设置初始的页码 就是第几页
        map.put("rowNum",pageRows);//一页显示几条数据
        map.put("records",configCount);//总记录数
        map.put("total",(configCount-1)/pageRows+1);//总页数的计算
        map.put("rows",haConfigs);//存放集合
        return map;
    }
}
