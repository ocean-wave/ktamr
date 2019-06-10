package com.ktamr.web.controller.thirdpartydata;

import com.ktamr.common.core.domain.AjaxResult;
import com.ktamr.common.core.domain.BaseController;
import com.ktamr.common.utils.ServletUtils;
import com.ktamr.common.utils.export.ExportStr;
import com.ktamr.common.utils.export.ExportTxtUtil;
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

    @PostMapping("/exportToTxt")
    @ResponseBody
    public AjaxResult exportToTxt(HavMeterinfo havMeterinfo,@RequestParam( value = "name[]") String[] name){
        List<HavMeterinfo> listMeterinfo = havMeterinfoService.selectThirdParty(havMeterinfo);
        String fileName = ExportStr.getFileName();
        ExportTxtUtil exportTextUtil = new ExportTxtUtil();
        try {
            exportTextUtil.writeToTxt(fileName,listMeterinfo,name);
            return AjaxResult.success(fileName);
        } catch (IOException e){
            e.printStackTrace();
            return AjaxResult.error(e.getMessage());
        }
    }

    @PostMapping("/exportToDbf")
    @ResponseBody
    public AjaxResult exportToDbf(HavMeterinfo havMeterinfo){
        List<HavMeterinfo> listMeterinfo = havMeterinfoService.selectThirdParty(havMeterinfo);
        String fileName = ExportStr.getFileName();
        ExportTxtUtil exportTextUtil = new ExportTxtUtil();
        try {

            return AjaxResult.success(fileName);
        } catch (Exception e){
            e.printStackTrace();
            return AjaxResult.error(e.getMessage());
        }
    }
}
