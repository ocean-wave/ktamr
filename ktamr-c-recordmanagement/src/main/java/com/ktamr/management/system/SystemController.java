package com.ktamr.management.system;

import com.ktamr.common.core.domain.BaseController;
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
public class SystemController extends BaseController {

    @Resource
    private HaConfigService haConfigService;

    @RequestMapping("/config_list")
    public String config_list(){
        return "system/config_list";
    }

    @RequestMapping("/ConfigListJson")
    @ResponseBody
    public Object configlistjson(HaConfig haConfig){
        startPage();
        List<HaConfig> haConfigs = haConfigService.queryHaConfig(haConfig);
        Map<String, Object> map = getDataTable(haConfigs);
        return map;
    }

    public Object checkOpLevel(String key,String uid){
        boolean isOK = false;
        if(key=="系统参数" && uid =="ha"){
            isOK = true;
        }else if(key!="系统参数"){
            isOK = false;
        }
        return isOK;
    }

    public Object opConfigTable(){
        return null;
    }

    @RequestMapping("/OpNumbers")
    @ResponseBody
    public String OpNumbers(Integer OpNumber){
        if(OpNumber==1){
            opConfigTable();
        }else if(OpNumber==2){

        }else if(OpNumber==3){

        }
        return "false";
    }

}
