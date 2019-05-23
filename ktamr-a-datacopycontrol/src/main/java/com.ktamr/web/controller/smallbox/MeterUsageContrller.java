package com.ktamr.web.controller.smallbox;

import com.ktamr.common.core.domain.AjaxResult;
import com.ktamr.common.utils.poi.ExcelUtilTwo;
import com.ktamr.common.utils.sql.SqlCondition;
import com.ktamr.domain.*;
import com.ktamr.service.HaDayFreezeService;
import com.ktamr.service.HaMeterService;
import com.ktamr.service.HaMonFreezeService;
import com.ktamr.service.HaRecordsService;
import com.ktamr.web.basecontroller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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

    @Autowired
    private HaDayFreezeService haDayFreezeService;

    @Autowired
    private HaMonFreezeService haMonFreezeService;

    @GetMapping("/meterUsage")
    public String metersMng(@RequestParam(value = "meterId", required = false) Integer meterId,ModelMap mmap) {
        HaMeter m = haMeterService.selectMeterAndBuildingById(meterId);
        mmap.put("meterId", meterId);
        mmap.put("meter",m);
        return path + "/meterUsage";
    }

    @PostMapping("/meterUsageList")
    @ResponseBody
    public Map<String,Object> meterUsageList(@RequestParam(value = "dataType", required = false) String dataType,
                                             @RequestParam(value = "meterId", required = false) Integer meterId,
                                             @RequestParam(value = "startDate", required = false) String startDate,
                                             @RequestParam(value = "endDate", required = false) String endDate) {
        startPage();
        Map<String,Object> m = new HashMap<String,Object>();
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("meterId",meterId);
        params.put("startDate",startDate);
        params.put("endDate",endDate);
        params.put("multipleConditions", SqlCondition.getMultipleConditions());
        if(dataType.equals("last") || dataType.equals("all")){
            params.put("dataType",dataType);
            List<HaRecords> listHaRecords = haRecordsService.selectRecordsAndErrrecord(params);
            m = getDataTable(listHaRecords);
        }
        if(dataType.equals("dayFreeze")){
            List<HaDayfreeze> listHaRecords = haDayFreezeService.selectAllDayfreeze(params);
            m = getDataTable(listHaRecords);
        }else if(dataType.equals("monFreeze")){
            List<HaMonfreeze> listHaRecords = haMonFreezeService.selectAllMonfreeze(params);
            m = getDataTable(listHaRecords);
        }
        return m;
    }

    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HaBuilding haBuilding,@RequestParam(value = "dataType", required = false) String dataType,
                            @RequestParam(value = "meterId", required = false) Integer meterId,
                             ExcelUtilTwo excelUtilTwo)
    {
        List<?> list = new ArrayList<>();
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("meterId",meterId);
        if(dataType.equals("last") || dataType.equals("all")){
            params.put("dataType",dataType);
            list = haRecordsService.selectRecordsAndErrrecord(params);
        }
        if(dataType.equals("dayFreeze")){
            list = haDayFreezeService.selectAllDayfreeze(params);
        }else if(dataType.equals("monFreeze")){
            list = haMonFreezeService.selectAllMonfreeze(params);
        }
        return excelUtilTwo.init(list,"单表记录数据");
    }
}