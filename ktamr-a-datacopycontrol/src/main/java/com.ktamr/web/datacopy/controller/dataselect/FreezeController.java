package com.ktamr.web.datacopy.controller.dataselect;

import com.ktamr.common.parameter.ParameterInfo;
import com.ktamr.common.utils.DateUtils;
import com.ktamr.domain.HaDayfreeze;
import com.ktamr.service.HaDayFreezeService;
import com.ktamr.service.HaMeterService;
import com.ktamr.service.HaRecordsService;
import com.ktamr.web.datacopy.basecontroller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/dataselect")
public class FreezeController extends BaseController {
    private  String pxePath = "meter";

    @Autowired
    private HaDayFreezeService haDayFreezeService;

    @GetMapping("/freeze")
    public String freeze(){
        return pxePath+"/metersFreezeReport";
    }

    @PostMapping("/freezeListJson")
    @ResponseBody
    public Map<String,Object> freezeListJson(HaDayfreeze parms){
        startPage();
        List<HaDayfreeze> listHaDayfreeze = haDayFreezeService.selectFreeze(parms);
        return getDataTable(listHaDayfreeze);
    }
}
