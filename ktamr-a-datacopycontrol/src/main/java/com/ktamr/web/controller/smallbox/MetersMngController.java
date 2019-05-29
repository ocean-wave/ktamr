package com.ktamr.web.controller.smallbox;

import com.ktamr.domain.HavMeterinfo;
import com.ktamr.common.core.domain.BaseController;
import com.ktamr.service.HavMeterinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/smallbox/meter")
public class MetersMngController extends BaseController {
    private String path = "meter";

    @Autowired
    private HavMeterinfoService havMeterinfoService;

    @GetMapping("/metersMng")
    public String metersMng(@RequestParam( value = "cmdName", required = false) String cmdName,
                            @RequestParam( value = "ids", required = false) String ids, ModelMap mmap){
        mmap.put("cmdName",cmdName );
        mmap.put("ids",ids);
        return path+"/metersMng";
    }
    @GetMapping("/metersReadResultList")
    public String metersReadResultList(@RequestParam( value = "cmdids", required = false) String cmdids,
                                       @RequestParam( value = "cmdName", required = false) String cmdName,
                                       @RequestParam( value = "ids", required = false) String ids,ModelMap mmap){
        mmap.put("cmdids",cmdids );
        mmap.put("cmdName",cmdName);
        mmap.put("ids",ids);
        return path+"/metersReadResultList";
    }
    @PostMapping("/metersReadResultListJson")
    @ResponseBody
    public Map<String,Object> metersReadResultLists(HavMeterinfo haMeter){
        startPage();
        List<HavMeterinfo> listMeter = havMeterinfoService.selectReadResult(haMeter);
        return getDataTable(listMeter);
    }
}
