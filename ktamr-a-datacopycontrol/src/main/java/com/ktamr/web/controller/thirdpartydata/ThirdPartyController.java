package com.ktamr.web.controller.thirdpartydata;

import com.ktamr.common.core.domain.AjaxResult;
import com.ktamr.common.core.domain.BaseController;
import com.ktamr.common.utils.ServletUtils;
import com.ktamr.common.utils.file.FileUtils;
import com.ktamr.common.utils.poi.ExceStr;
import com.ktamr.common.utils.poi.ExportTextUtil;
import com.ktamr.domain.HaMeter;
import com.ktamr.domain.HaOperator;
import com.ktamr.service.HaMeterService;
import com.ktamr.service.HaOperatorService;
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
    private HaMeterService haMeterService;

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
    public Map<String, Object> interfaceCmdListJson(HaMeter haMeter){
        startPage();
        List<HaMeter> listMeter = haMeterService.selectThirdParty(haMeter);
        return getDataTable(listMeter);
    }


    @PostMapping("/exportToTXT")
    @ResponseBody
    public AjaxResult exportToTXT(HaMeter haMeter,@RequestParam( value = "name[]") String[] name){
        List<HaMeter> listMeter = haMeterService.selectThirdParty(haMeter);
        String fileName = "";
        if(haMeter.getParams().get("showListType").equals("sys_rass")){
            fileName = "融安水司";
        }else if(haMeter.getParams().get("showListType").equals("sys_tzss")){
            fileName = "泰州水司";
        }else if(haMeter.getParams().get("showListType").equals("sys_scsy")){
            fileName = "三川邵阳";
        }else if(haMeter.getParams().get("showListType").equals("sys_scjdz")){
            fileName = "三川景德镇";
        }
        fileName = ExceStr.encodingFileTxTname(fileName);
        ExportTextUtil exportTextUtil = new ExportTextUtil();
        try {
            exportTextUtil.writeToTxt(fileName,listMeter,name);
            return AjaxResult.success(fileName);
        } catch (IOException e){
            e.printStackTrace();
            return AjaxResult.error(e.getMessage());
        }
    }
}
