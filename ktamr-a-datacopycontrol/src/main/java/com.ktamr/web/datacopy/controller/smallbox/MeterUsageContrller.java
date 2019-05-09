package com.ktamr.web.datacopy.controller.smallbox;

import com.ktamr.common.parameter.ParameterInfo;
import com.ktamr.service.HaMeterService;
import com.ktamr.service.HaRecordsService;
import com.ktamr.web.datacopy.basecontroller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/smallbox/meterUsage")
public class MeterUsageContrller extends BaseController {
    private String path = "meter";

    @Autowired
    private HaMeterService haMeterService;

    @Autowired
    private HaRecordsService haRecordsService;

    @GetMapping("/meterUsage")
    public String metersMng(@RequestParam(value = "meterid", required = false) String meterid,ModelMap mmap) {
        Map<String,Object> m = haMeterService.selectMeterAndBuildingById(Integer.parseInt(meterid.trim()));
        mmap.put("meterid", meterid);
        mmap.put("meter",m);
        return path + "/meterUsage";
    }

    @PostMapping("/meterUsageList")
    @ResponseBody
    public Map<String,Object> meterUsageList(ParameterInfo parms) {
        startPage();
        String dataType = parms.getDataType();
        Map<String,Object> m = new HashMap<String,Object>();
        if(dataType.equals("last") || dataType.equals("all")){
            List<Map<String,Object>> listHaRecords = haRecordsService.selectRecordsAndErrrecord(parms);
            m = getDataTable(listHaRecords);
        }
        if(dataType.equals("dayFreeze")){
            List<Map<String,Object>> listHaRecords = haRecordsService.selectAllDayfreeze(parms);
            m = getDataTable(listHaRecords);
        }else if(dataType.equals("monFreeze")){
            List<Map<String,Object>> listHaRecords = haRecordsService.selectAllMonfreeze(parms);
            m = getDataTable(listHaRecords);
        }
        return m;
    }
}