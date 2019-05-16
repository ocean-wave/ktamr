package com.ktamr.web.controller.dataselect;

import com.ktamr.domain.HaMeter;
import com.ktamr.service.HaMeterService;
import com.ktamr.web.basecontroller.BaseController;
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
public class NotokController extends BaseController {
    private  String pxePath = "meter";

    @Autowired
    private HaMeterService haMeterService;

    @GetMapping("/notok")
    public String notok(){
        return pxePath+"/metersNotokReport";
    }

    @PostMapping("/notokListJson")
    @ResponseBody
    public Map<String,Object> freezeListJson(HaMeter parms){
        startPage();
        List<HaMeter> listHaMeter = haMeterService.selectNotok(parms);
        return getDataTable(listHaMeter);
    }
}
