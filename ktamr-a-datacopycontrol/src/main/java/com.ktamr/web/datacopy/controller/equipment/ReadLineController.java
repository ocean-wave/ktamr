package com.ktamr.web.datacopy.controller.equipment;


import com.ktamr.common.parameter.ParameterInfo;
import com.ktamr.domain.HaCentor;
import com.ktamr.service.HaCentorService;
import com.ktamr.web.datacopy.basecontroller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/equipment")
public class ReadLineController extends BaseController {

    private  String pxePath = "devices";

    @Autowired
    private HaCentorService haCentorService;

    @GetMapping("/readLine")
    public String centorc(){
        return pxePath+"/readLineList";
    }

    @PostMapping("/readLineList1")
    @ResponseBody
    public Map<String,Object> centorcListJson(HaCentor parms){
        startPage();
        List<HaCentor> listHaCentor = haCentorService.selectAllCentorHandAndCount(parms);
        Map<String,String> map2 = new HashMap<String,String>();
        Map<Integer,String> mi = new HashMap<Integer, String>();
        mi.put(0,"zbs");
        mi.put(1,"meters");
        mi.put(2,"jdbs");
        Map<Integer,Integer> map = getValuesByKey(listHaCentor,mi);
        map2.put("cb","总计:");
        map2.put("resultParams.zbs",map.get(0).toString());
        map2.put("resultParams.meters",map.get(1).toString());
        map2.put("resultParams.jdbs",map.get(2).toString());
        Map<String,Object> m =getDataTable(listHaCentor);
        m.put("userdata",map2);
        return m;
    }

    @PostMapping("/centorHandByQueryIdListJson")
    @ResponseBody
    public Map<String,Object> centorHandByQueryIdListJson(HaCentor parms){
        startPage();
        List<HaCentor> listHaCentor = new ArrayList<>();
        if(parms.getCentorId() != 0){
            listHaCentor = haCentorService.selectAllCentorzQueryIdAndCount(parms);
        }
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
}

