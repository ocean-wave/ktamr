package com.ktamr.web.datacopy.controller.area;

import com.ktamr.domain.HaRgn;
import com.ktamr.service.HaRngService;
import com.ktamr.web.datacopy.basecontroller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/rgn")
public class HaRgnController extends BaseController {
    private  String pxePath = "/area";

    @Autowired
    private HaRngService haRngService;

    @GetMapping()
    public String areasOpManage(){
        return pxePath+"/areasOpManage";
    }

    @PostMapping("/areasOpManageJson")
    @ResponseBody
    public Map<String,Object> areasOpManageJson(HaRgn haRgn){
        startPage();
        List<HaRgn> listHaRng = haRngService.selectAllRngAndCount(haRgn);
        Map<String,String> map2 = new HashMap<String,String>();
        Map<Integer,String> mi = new HashMap<Integer, String>();
        mi.put(0,"haAreaCount");
        mi.put(1,"haCentorCount");
        mi.put(2,"haCollectorCount");
        mi.put(3,"haMeterCount");
        Map<Integer,Integer> mm = getValuesByKey(listHaRng,mi);
        map2.put("cb","总计:");
        map2.put("resultParams.haAreaCount",mm.get(0).toString());
        map2.put("resultParams.haCentorCount",mm.get(1).toString());
        map2.put("resultParams.haCollectorCount",mm.get(2).toString());
        map2.put("resultParams.haMeterCount",mm.get(3).toString());
        Map<String,Object> m =getDataTable(listHaRng);
        m.put("userdata",map2);
        return m;
    }
}
