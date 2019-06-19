package com.ktamr.web.controller.equipment;


import com.ktamr.common.core.domain.BaseController;
import com.ktamr.common.utils.DateUtils;
import com.ktamr.domain.HaCentor;
import com.ktamr.service.HaCentorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/equipment")
public class NbSurfaceController extends BaseController {

    private  String pxePath = "devices";

    @Autowired
    private HaCentorService haCentorService;

    @GetMapping("/nbSurfaceList")
    public String nbSurfaceList(){
        return pxePath+"/nbSurfaceList";
    }

    @GetMapping("/nbSurfaceMng")
    public String nbSurfaceMng(ModelMap m, @RequestParam( value = "cmdName", required = false) String cmdName
                                         , @RequestParam( value = "ids", required = false) String ids
                                         , @RequestParam( value = "flagStr", required = false) String flagStr ){
        m.put("nowTimeStr", DateUtils.dateTimeTwo());
        m.put("cmdName",cmdName);
        m.put("ids",ids);
        m.put("flagStr",flagStr);
        return pxePath+"/nbSurfaceMng";
    }

    @PostMapping("/nbSurfaceListJson")
    @ResponseBody
    public Map<String,Object> centorcListJson(HaCentor parms){
        startPage();
        List<HaCentor> listHaCentor = haCentorService.selectNbSurfaceCollector(parms);
        return getDataTable(listHaCentor);
    }

}
