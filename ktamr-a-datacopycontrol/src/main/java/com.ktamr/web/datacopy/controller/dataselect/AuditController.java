package com.ktamr.web.datacopy.controller.dataselect;

import com.ktamr.common.utils.DateUtils;
import com.ktamr.domain.HaArea;
import com.ktamr.service.HaAreaService;
import com.ktamr.service.HaAuditService;
import com.ktamr.service.HaMeterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.util.List;

@Controller
@RequestMapping("/dataselect")
public class AuditController {
    private  String pxePath = "/meter";

    @Autowired
    private HaAreaService haAreaService;

    @Autowired
    private HaAuditService haAuditService;

    @GetMapping("/audit")
    public String audit(@RequestParam( value = "startDate",required = false) String startDate,
                        @RequestParam( value = "endDate",required = false) String endDate,HaArea params, ModelMap mmap){
        if(startDate == null || endDate == null || params.getAreaId() == null){
            params.getParams().put("startDate",DateUtils.getDateMonth());
            params.getParams().put("endDate",DateUtils.getDateMonth());
            mmap.put("daterange",DateUtils.getDateMonth()+"~"+DateUtils.getDateMonth());
            mmap.put("areaid",0);
        }else {
            params.getParams().put("startDate",startDate);
            params.getParams().put("endDate",endDate);
            mmap.put("startDate",startDate);
            mmap.put("endDate",endDate);
            mmap.put("daterange",startDate+"~"+endDate);
            mmap.put("areaid",params.getAreaId());
        }
        List<HaArea> listArea = haAreaService.selectHaAreaIdAndName(params);
        List<String> listStr = haAuditService.selectAudit(params);
        String[] str;
        String[] strDate;
        String xAxisData = "[]";
        String branchMeterData = "[]";
        String TotalMeterData = "[]";
        if(listStr.size() > 0) {
            xAxisData = "[";
            branchMeterData = "[";
            TotalMeterData = "[";
            for (int i = 0; i < listStr.size(); i++) {
                str = listStr.get(i).split(",");
                strDate = str[0].split("-");
                if (Integer.parseInt(strDate[2]) < 15) {
                    if (i != 0) {
                        xAxisData += ",";
                    }
                    xAxisData += "'"+strDate[0] + "-" + strDate[1] + "上旬'";
                }
                if (Integer.parseInt(strDate[2]) > 15 && Integer.parseInt(strDate[2]) < 25) {
                    xAxisData += "," + "'"+strDate[0] + "-" + strDate[1] + "中旬'";
                }
                if (Integer.parseInt(strDate[2]) > 25) {
                    xAxisData += "," + "'"+strDate[0] + "-" + strDate[1] + "下旬'";
                }
                branchMeterData += "'"+str[1]+"'";
                if( i != (listStr.size()-1)){
                    branchMeterData += ",";
                }
                TotalMeterData += "'"+str[2]+"'";
                if( i != (listStr.size()-1)){
                    TotalMeterData += ",";
                }
            }
            xAxisData += "]";
            branchMeterData += "]";
            TotalMeterData += "]";
        }
        mmap.put("xAxisData",xAxisData);
        mmap.put("branchMeterData",branchMeterData);
        mmap.put("TotalMeterData",TotalMeterData);
        mmap.put("sTitle","总分表稽核累计用量统计：");
        mmap.put("listArea",listArea);
        try {
            mmap.put("mnDate",DateUtils.getMonthDiff(params.getParams().get("startDate").toString(),params.getParams().get("endDate").toString())+1);
        }catch (ParseException e){
            e.getMessage();
        }
        return pxePath+"/metersAuditReport";
    }
}
