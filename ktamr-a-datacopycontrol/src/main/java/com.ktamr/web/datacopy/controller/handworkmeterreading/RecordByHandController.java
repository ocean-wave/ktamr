package com.ktamr.web.datacopy.controller.handworkmeterreading;

import com.ktamr.common.utils.DateUtils;
import com.ktamr.domain.HaMeter;
import com.ktamr.service.*;
import com.ktamr.web.datacopy.basecontroller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/handworkmeterreading")
public class RecordByHandController extends BaseController {
    private  String pxePath = "area";

    @Autowired
    private HaMeterService haMeterService;

    @Autowired
    private HaCmdService haCmdService;

    @Autowired
    private HaRecordsService haRecordsService;

    @Autowired
    private HaDayFreezeService haDayFreezeService;

    @Autowired
    private HaMonFreezeService haMonFreezeService;


    @GetMapping("/byHand")
    public String deviceTrans(ModelMap mmap){
        mmap.put("nowStr", DateUtils.getTime());
        return pxePath+"/recordByHand";
    }

    @PostMapping("/recordByHandJson")
    @ResponseBody
    public Map<String, Object> interfaceCmdListJson(HaMeter haMeter){
        startPage();
        List<HaMeter> listMeter = haMeterService.selectRecordByHand(haMeter);
        return getDataTable(listMeter);
    }

    @PostMapping("/RowEditing")
    @ResponseBody
    public String RowEditing(HaMeter haMeter){
        haMeter.getParams().put("nowStr",DateUtils.getNowDate());
        Integer meterId = haCmdService.insertCmdTwo(haMeter);
        Integer itemId = haRecordsService.insertRecords(haMeter);
        Integer dayCount = haDayFreezeService.selectDayFreezeMeterIdCount(haMeter);
        if(dayCount>0){
            haDayFreezeService.updateDayFreeze(haMeter);
        }else{
            haDayFreezeService.insertDayFreeze(haMeter);
        }
        Integer MonCount = haMonFreezeService.selectMonFreezeMeterIdCount(haMeter);
        if(MonCount > 0){
            haMonFreezeService.updateMonFreeze(haMeter);
        }else{
            haMonFreezeService.insertMonFreeze(haMeter);
        }
        haMeterService.updateMeter(haMeter);
        return "true";
    }

    @GetMapping("/metersRecordImport")
    public String metersRecordImport(ModelMap mmap){
        return pxePath+"/metersRecordImport";
    }
}
