package com.ktamr.management.meter;

import com.ktamr.common.core.domain.BaseController;
import com.ktamr.common.utils.DateUtils;
import com.ktamr.domain.*;
import com.ktamr.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/meter")
public class MeterController extends BaseController {

    @Resource
    private HaMeterService haMeterService;

    @Resource
    private HavMeterinfoService havMeterinfoService;

    @Resource
    private HaCmdService haCmdService;

    @Resource
    private HaRecordsService haRecordsService;

    @Resource
    private HaDayFreezeService haDayFreezeService;

    @Resource
    private HaMonFreezeService haMonFreezeService;

    @Resource
    private HaReplaceRecordsService haReplaceRecordsService;

    @RequestMapping("/meter_replace")
    public String meter_replace(HaMeter haMeter, Integer meterid, Model model, HttpSession session){
        String operatorCode = (String)session.getAttribute("operatorCode");
        haMeter.setMeterId(meterid);
        HaMeter meter = haMeterService.delByIdHaMeter(haMeter);
        HavMeterinfo userAddr = havMeterinfoService.userAddr(meterid);
        model.addAttribute("meter",meter);
        model.addAttribute("meterid",meterid);
        model.addAttribute("userAddr",userAddr);
        model.addAttribute("operatorCode",operatorCode);
        model.addAttribute("nowDate", DateUtils.getNowDate());
        return "area/meter_replace";
    }

    @RequestMapping("/queryHaMeter")
    @ResponseBody
    public Object queryHaMeter(Integer centorId,Integer collectorId){
        startPage();
        List<HaMeter> haMeters = haMeterService.queryHaMeter(centorId,collectorId);
        Map<String, Object> map = getDataTable(haMeters);
        return map;
    }

    @RequestMapping("/meter_replace_do")
    @ResponseBody
    public Object meterReplaceDo(HaMeter haMeter, HaCmd haCmd, HaRecords haRecords,HatMetersreplace hatMetersreplace,Integer meterId, HaDayfreeze haDayfreeze,HaMonfreeze haMonfreeze,HaReplacerecords haReplacerecords){
        haMeter.setMeterId(meterId);
        HaMeter meter = haMeterService.delByIdHaMeter(haMeter);
        if(meter!=null){

            Integer addHaCmd = haCmdService.addHaCmd(haCmd);
            Integer addHaRecords = haRecordsService.addHaRecords(haRecords);

            HaDayfreeze fdayDataCount = haDayFreezeService.fdayDataCount(haDayfreeze);
            if(fdayDataCount!=null){
                Integer fdayDataCount2 = haDayFreezeService.fdayDataCount2(haDayfreeze);
            }else {
                Integer fdayDataCount3 = haDayFreezeService.fdayDataCount3(haDayfreeze);
            }

            HaMonfreeze fmonDataCount = haMonFreezeService.fmonDataCount(haMonfreeze);
            if(fmonDataCount!=null){
                Integer fmonDataCount2 = haMonFreezeService.fmonDataCount2(haMonfreeze);
            }else {
                Integer fmonDataCount3 = haMonFreezeService.fmonDataCount3(haMonfreeze);
            }

            Integer replaceMeter = haMeterService.replaceMeter(haMeter);
            Integer replaceMeter2 = haReplaceRecordsService.replaceMeter2(haReplacerecords);
            Integer replaceMeter3 = haMeterService.replaceMeter3(haMeter);
        }else {
            return "原表资料不存在！";
        }
        return null;
    }
}
