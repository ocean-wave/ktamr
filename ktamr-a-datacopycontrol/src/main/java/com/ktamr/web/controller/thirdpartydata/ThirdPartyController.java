package com.ktamr.web.controller.thirdpartydata;

import com.ktamr.common.core.domain.AjaxResult;
import com.ktamr.common.core.domain.BaseController;
import com.ktamr.common.utils.DateUtils;
import com.ktamr.common.utils.ServletUtils;
import com.ktamr.common.utils.export.ExportStr;
import com.ktamr.common.utils.export.ExportTextUtil;
import com.ktamr.domain.HavMeterinfo;
import com.ktamr.service.HaOperatorService;
import com.ktamr.service.HavMeterinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/thirdpartydata")
public class ThirdPartyController extends BaseController {
    private  String pxePath = "interface";

    @Autowired
    private HavMeterinfoService havMeterinfoService;

    @Autowired
    private HaOperatorService haOperatorService;

    @GetMapping("/party")
    public String party(ModelMap mmap){
        String id = (String) ServletUtils.getSession().getAttribute("operatorCode");
        mmap.put("operatorCompnayList",haOperatorService.selectOperatorCompany(id));
        return pxePath+"/thirdPartyReport";
    }

    @PostMapping("/thirdPartyReportJson")
    @ResponseBody
    public Map<String, Object> interfaceCmdListJson(HavMeterinfo havMeterinfo){
        startPage();
        List<HavMeterinfo> listMeterinfo = havMeterinfoService.selectThirdParty(havMeterinfo);
        return getDataTable(listMeterinfo);
    }

    @PostMapping("/exportToTXT")
    @ResponseBody
    public AjaxResult exportToTXT(HavMeterinfo havMeterinfo,@RequestParam( value = "name[]") String[] name){
        List<HavMeterinfo> listMeterinfo = havMeterinfoService.selectThirdParty(havMeterinfo);
        String fileName = ExportStr.getFileName();
        ExportTextUtil exportTextUtil = new ExportTextUtil();
        try {
            exportTextUtil.writeToTxt(fileName,listMeterinfo,name);
            return AjaxResult.success(fileName);
        } catch (IOException e){
            e.printStackTrace();
            return AjaxResult.error(e.getMessage());
        }
    }

    private String getFileName(String showListType){
        String fileName = "kt-table"+ DateUtils.dateTimeNow();
        if(showListType.equals("sys_rass")){
            fileName = "融安水司";
        }else if(showListType.equals("sys_tzss")){
            fileName = "泰州水司";
        }else if(showListType.equals("sys_scsy")){
            fileName = "三川邵阳";
        }else if(showListType.equals("sys_scjdz")){
            fileName = "三川景德镇";
        }
        return fileName;
    }
}
