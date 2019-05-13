package com.ktamr.web.datacopy.controller.dataselect;

import com.ktamr.common.utils.DateUtils;
import com.ktamr.domain.HaMeter;
import com.ktamr.domain.HaRecords;
import com.ktamr.service.HaMeterService;
import com.ktamr.service.HaRecordsService;
import com.ktamr.web.datacopy.basecontroller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/dataselect")
public class DosageController extends BaseController {

    private  String pxePath = "meter";

    @Autowired
    private HaMeterService haMeterService;

    @Autowired
    private HaRecordsService haRecordsService;

    @GetMapping("/dosage")
    public String dosage(ModelMap mmap){
        mmap.put("sTitle","读数清单, 当前日期:"+ DateUtils.getDate());
        return pxePath+"/metersUsageReport";
    }

    @PostMapping("/dosageRecentlyListJson")
    @ResponseBody
    public Map<String,Object> dosageRecentlyListJson(HaMeter parms){
        startPage();
        List<HaMeter> listHaMeter = haMeterService.selectDosageRecently(parms);
        return getDataTable(listHaMeter);
    }

    @PostMapping("/dosageHistoryListJson")
    @ResponseBody
    public Map<String,Object> dosageHistoryListJson(HaRecords parms){
        startPage();
        long startdate = System.currentTimeMillis();
        if(parms.getParams() != null && parms.getParams().get("startDate") != null && parms.getParams().get("startDate") != "") {
            parms.getParams().put("startDate", DateUtils.dateTime("yyyy-MM-dd HH:mm:ss", parms.getParams().get("startDate").toString()));
            parms.getParams().put("endDate", DateUtils.dateTime("yyyy-MM-dd HH:mm:ss", parms.getParams().get("endDate").toString()));
        }
        List<HaRecords> listHaMeter = haRecordsService.selectDosageHistory(parms);
        long enddate = System.currentTimeMillis();
        System.out.println((startdate-enddate)/1000);
        return getDataTable(listHaMeter);
    }
}

