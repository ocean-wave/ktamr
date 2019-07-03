package com.ktamr.management.system;

import com.ktamr.common.core.domain.BaseController;
import com.ktamr.domain.HaConfig;
import com.ktamr.service.HaConfigService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
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

    public Boolean checkOpLevel(String key,String uid){
        boolean isOK = false;
        if(key.equals("系统参数") && uid.equals("ha")){
            isOK = true;
        }else if(!key.equals("系统参数")){
            isOK = false;
        }
        return isOK;
    }

    @RequestMapping("/OpNumbers")
    @ResponseBody
    public String OpNumbers(Integer OpNumber, HttpServletRequest request, HttpSession session){
        if(OpNumber==1){
                String jGoper = request.getParameter("oper");
                String jGid = request.getParameter("id");
                String pos = request.getParameter("pos");
                String s = request.getParameter("s");
                String k = request.getParameter("k");
                String kname = request.getParameter("kname");
                String v = request.getParameter("v");
                String operatorCode = (String)session.getAttribute("operatorCode");
                String re = "true";
                if(jGoper.equals("add")){
                    if(pos.equals("") || s.equals("") || k.equals("")){
                        re="不能为空!";
                    }else {
                        HaConfig haConfig = new HaConfig();
                        haConfig.setK(k);
                        haConfig.setPos(Double.parseDouble(pos));
                        haConfig.setS(s);
                        haConfig.setKname(kname);
                        haConfig.setV(v);
                        haConfig.setLastTime(new Date());
                        haConfig.setUid(operatorCode);
                        Integer addHaConfig = haConfigService.addHaConfig(haConfig);
                        if(addHaConfig==1){
                            return "true";
                        }
                        return "false";
                    }
                }else if(jGoper.equals("edit")){
                    if(!checkOpLevel(s,operatorCode)){
                        re="无权限!";
                    }else{
                        HaConfig haConfig = new HaConfig();
                        haConfig.setPos(Double.parseDouble(pos));
                        haConfig.setK(k);
                        haConfig.setS(s);
                        haConfig.setKname(kname);
                        haConfig.setV(v);
                        haConfig.setLastTime(new Date());
                        haConfig.setUid(operatorCode);
                        Integer updateHaConfig = haConfigService.updateHaConfig(haConfig);
                        if(updateHaConfig==1){
                            return "true";
                        }
                        return "false";
                    }
                }else if(jGoper.equals("del")){
                        HaConfig haConfig = new HaConfig();
                        haConfig.setPos(Double.parseDouble(jGid));
                        Integer config = haConfigService.deleteHaConfig(haConfig);
                        if(config==1){
                            return "true";
                        }
                        return "false";
                }
                return null;
        }else if(OpNumber==2){

        }else if(OpNumber==3){

        }
        return "false";
    }

}
