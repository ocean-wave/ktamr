package com.ktamr.management.meter;

import com.ktamr.domain.HaMeter;
import com.ktamr.service.HaMeterService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/meter")
public class MeterController {

    @Resource
    private HaMeterService haMeterService;

    @RequestMapping("/queryHaMeter")
    @ResponseBody
    public Object queryHaMeter(Integer areaId,Integer collectorid){
        List<HaMeter> haMeters = haMeterService.queryHaMeter(areaId,collectorid);
        return haMeters;
    }
}
