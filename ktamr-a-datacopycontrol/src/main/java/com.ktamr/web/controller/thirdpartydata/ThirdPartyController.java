package com.ktamr.web.controller.thirdpartydata;

import com.ktamr.domain.HaMeter;
import com.ktamr.service.HaMeterService;
import com.ktamr.web.basecontroller.BaseController;
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
@RequestMapping("/thirdpartydata")
public class ThirdPartyController extends BaseController {
    private  String pxePath = "interface";

    @Autowired
    private HaMeterService haMeterService;


    @GetMapping("/party")
    public String party(ModelMap mmap){
        return pxePath+"/thirdPartyReport";
    }

    @PostMapping("/thirdPartyReportJson")
    @ResponseBody
    public Map<String, Object> interfaceCmdListJson(HaMeter haMeter){
        startPage();
        List<HaMeter> listMeter = haMeterService.selectThirdParty(haMeter);
        return getDataTable(listMeter);
    }
}
