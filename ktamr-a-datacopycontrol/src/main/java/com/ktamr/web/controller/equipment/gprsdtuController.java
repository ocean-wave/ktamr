package com.ktamr.web.controller.equipment;


import com.ktamr.common.core.domain.AjaxResult;
import com.ktamr.common.utils.export.ExportExcelUtil;
import com.ktamr.common.utils.sql.SqlCondition;
import com.ktamr.domain.HaCentor;
import com.ktamr.domain.HaGprsdtu;
import com.ktamr.common.core.domain.BaseController;
import com.ktamr.service.HaGprsdtuService;
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
@RequestMapping("/equipment/dtu")
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
    public Map<String,Object> centorcListJson(HaGprsdtu params){
        startPage();
        params.getParams().put("getRightCondition", SqlCondition.getRightCondition("a.areano","area","and"));
        List<HaGprsdtu> listHaCentor = haGprsdtuService.selectAllGprsdtuAndCount(params);
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

    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HaGprsdtu params, ExportExcelUtil exportExcelUtil)
    {
        params.getParams().put("getRightCondition", SqlCondition.getRightCondition("a.areano","area","and"));
        List<HaGprsdtu> list = haGprsdtuService.selectAllGprsdtuAndCount(params);
        return exportExcelUtil.init(list, "");
    }
}

