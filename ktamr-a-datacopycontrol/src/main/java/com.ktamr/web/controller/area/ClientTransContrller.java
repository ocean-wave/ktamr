package com.ktamr.web.controller.area;

import com.ktamr.service.HaMeterService;
import com.ktamr.service.PmKt3NbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/clientTrans")
public class ClientTransContrller {

    @Autowired
    private HaMeterService haMeterService;

    @Autowired
    private PmKt3NbService pmKt3NbService;

    @GetMapping("/rowDataGet")
    @ResponseBody
    public Map<String,Object> getCmdAjax(@RequestParam( value = "dataList", required = false) String dataList,
                                         @RequestParam( value = "meterId", required = false) String meterId,
                                         @RequestParam( value = "id", required = false) String id){

        Map<String,Object> m = new HashMap<String, Object>();
        if(dataList == "readSingleMeter"){
            m = haMeterService.selectMeterById(Integer.parseInt(meterId));
        }else if(dataList == "pmRecord"){
            m = pmKt3NbService.selectPmKt3NbById(Integer.parseInt(id));
        }
        return m;
    }
}
