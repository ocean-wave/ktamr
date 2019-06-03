package com.ktamr.management.meter;

import com.ktamr.common.core.domain.BaseController;
import com.ktamr.domain.HaMeter;
import com.ktamr.service.HaMeterService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/meter")
public class MeterController extends BaseController {

    @Resource
    private HaMeterService haMeterService;

    @RequestMapping("/queryHaMeter")
    @ResponseBody
    public Object queryHaMeter(Integer centorId,Integer collectorId){
        startPage();
        List<HaMeter> haMeters = haMeterService.queryHaMeter(centorId,collectorId);
        Map<String, Object> map = getDataTable(haMeters);
        return map;
    }
}
