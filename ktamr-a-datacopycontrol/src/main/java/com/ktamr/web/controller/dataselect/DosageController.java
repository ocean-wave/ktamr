package com.ktamr.web.controller.dataselect;

import com.ktamr.common.core.domain.AjaxResult;
import com.ktamr.common.utils.DateUtils;
import com.ktamr.common.core.domain.BaseController;
import com.ktamr.common.utils.export.ExportExcelUtil;
import com.ktamr.common.utils.sql.SqlCondition;
import com.ktamr.domain.HaCentor;
import com.ktamr.domain.HaMeter;
import com.ktamr.domain.HaRecords;
import com.ktamr.service.HaMeterService;
import com.ktamr.service.HaRecordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/dataselect/dosage")
public class DosageController extends BaseController {

    private  String pxePath = "meter";

    @Autowired
    private HaMeterService haMeterService;

    @Autowired
    private HaRecordsService haRecordsService;

    @GetMapping("/dosageRecentlyList")
    public String dosageRecentlyList(ModelMap mmap){
        mmap.put("sTitle","读数清单, 当前日期:"+ DateUtils.getDate());
        return pxePath+"/metersUsageReport";
    }

    @PostMapping("/dosageRecentlyListJson")
    @ResponseBody
    public Map<String,Object> dosageRecentlyListJson(HaMeter params){
        startPage();
        params.getParams().put("getRightCondition", SqlCondition.getRightCondition("mi.areano","area","and"));
        List<HaMeter> listHaMeter = haMeterService.selectDosageRecently(params);
        return getDataTable(listHaMeter);
    }

    @PostMapping("/dosageHistoryListJson")
    @ResponseBody
    public Map<String,Object> dosageHistoryListJson(HaRecords params){
        startPage();
        long startdate = System.currentTimeMillis();
        List<HaRecords> listHaMeter = haRecordsService.selectDosageHistory(params);
        long enddate = System.currentTimeMillis();
        System.out.println((startdate-enddate)/1000);
        return getDataTable(listHaMeter);
    }

    @PostMapping("/dosageHistoryTitle")
    @ResponseBody
    public HaMeter dosageHistoryTitle(@RequestParam(value = "keyWordTwo", required = false) String keyWordTwo){
        HaMeter haMeter = haMeterService.selectMeterAndBuildingByKeyWordTwo(keyWordTwo);
        return haMeter;
    }

    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HaMeter params,HaRecords params2,ExportExcelUtil exportExcelUtil)
    {
        List<HaMeter> list = null;
        List<HaRecords> list2 = null;
        if(params.getParams().get("exportType").equals("1")){
            params.getParams().put("getRightCondition", SqlCondition.getRightCondition("mi.areano","area","and"));
            list =  haMeterService.selectDosageRecently(params);
            return exportExcelUtil.init(list, "");
        }else{
            list2 =  haRecordsService.selectDosageHistory(params2);
            return exportExcelUtil.init(list2, "");
        }
    }
}

