package com.ktamr.web.controller.equipment;


import com.ktamr.domain.HaGprsdtu;
import com.ktamr.service.HaGprsdtuService;
import com.ktamr.web.basecontroller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/equipment")
public class gprsdtuController extends BaseController {

    private  String pxePath = "gprsdtu";

    @Autowired
    private HaGprsdtuService haGprsdtuService;

    @GetMapping("/gprsdtu")
    public String centorc(){
        return pxePath+"/gprsdtuList";
    }

    @PostMapping("/gprsdtuListJson")
    @ResponseBody
    public Map<String,Object> centorcListJson(HaGprsdtu parms){
        startPage();
        List<HaGprsdtu> listHaCentor = haGprsdtuService.selectAllGprsdtuAndCount(parms);
        Map<String,String> map2 = new HashMap<String,String>();
        Map<Integer,String> mi = new HashMap<Integer, String>();
        mi.put(0,"xsjcqsm");
        Map<Integer,Integer> map = getValuesByKey(listHaCentor,mi);
        map2.put("cb","总计:");
        map2.put("resultParams.xsjcqsm",map.get(0).toString());
        Map<String,Object> m =getDataTable(listHaCentor);
        m.put("userdata",map2);
        return m;
    }
}

