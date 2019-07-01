package com.ktamr.web.controller.equipment;


import com.ktamr.common.core.domain.AjaxResult;
import com.ktamr.common.utils.export.ExportExcelUtil;
import com.ktamr.common.utils.sql.SqlCondition;
import com.ktamr.domain.HaCentor;
import com.ktamr.common.core.domain.BaseController;
import com.ktamr.domain.HaRgn;
import com.ktamr.service.HaCentorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/equipment/collector")
public class CentorcController extends BaseController {

    private  String pxePath = "devices";

    @Autowired
    private HaCentorService haCentorService;

    @GetMapping("/centorc")
    public String centorc(){
        return pxePath+"/centorcList";
    }

    @PostMapping("/centorcListJson")
    @ResponseBody
    public Map<String,Object> centorcListJson(HaCentor params){
        startPage();
        params.getParams().put("getRightCondition", SqlCondition.getRightCondition("c.centorno","area","and"));
        List<HaCentor> listHaCentor = haCentorService.selectAllCentorcAndCount(params);
        Map<String,String> map2 = new HashMap<String,String>();
        Map<Integer,String> mi = new HashMap<Integer, String>();
        mi.put(0,"zbs");
        mi.put(1,"meters");
        mi.put(2,"jdbs");
        mi.put(3,"wfhbs");
        Map<Integer,Integer> map = getValuesByKey(listHaCentor,mi);
        map2.put("cb","总计:");
        map2.put("resultParams.zbs",map.get(0).toString());
        map2.put("resultParams.meters",map.get(1).toString());
        map2.put("resultParams.jdbs",map.get(2).toString());
        map2.put("resultParams.wfhbs",map.get(3).toString());
        Map<String,Object> m =getDataTable(listHaCentor);
        m.put("userdata",map2);
        return m;
    }

    @PostMapping("/centorcByQueryIdListJson")
    @ResponseBody
    public Map<String,Object> centorzByCollectoridListJson(HaCentor params){
        startPage();
        params.getParams().put("getRightCondition", SqlCondition.getRightCondition("c.centorno","area","and"));
        List<HaCentor> listHaCentor = haCentorService.selectAllCentorzQueryIdAndCount(params);
        Map<String,String> map2 = new HashMap<String,String>();
        Map<Integer,String> mi = new HashMap<Integer, String>();
        mi.put(0,"lfNumber");
        mi.put(1,"thNumber");
        mi.put(2,"sNumber");
        Map<Integer,Integer> ms = getValuesByKey(listHaCentor,mi);
        map2.put("cb","总计:");
        map2.put("haMeter.lfNumber",ms.get(0).toString());
        map2.put("haMeter.thNumber",ms.get(1).toString());
        map2.put("haMeter.sNumber",ms.get(2).toString());
        Map<String,Object> m =getDataTable(listHaCentor);
        m.put("userdata",map2);
        return m;
    }

    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HaCentor params, ExportExcelUtil exportExcelUtil)
    {
        params.getParams().put("getRightCondition", SqlCondition.getRightCondition("c.centorno","area","and"));
        List<HaCentor> list = null;
        if(params.getParams().get("exportType").equals("1")){
            list =  haCentorService.selectAllCentorcAndCount(params);
        }else if(params.getParams().get("exportType").equals("2")){
            list =  haCentorService.selectAllCentorzQueryIdAndCount(params);
        }
        return exportExcelUtil.init(list, "");
    }

}

