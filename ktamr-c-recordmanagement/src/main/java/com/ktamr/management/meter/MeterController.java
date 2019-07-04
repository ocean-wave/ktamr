package com.ktamr.management.meter;

import com.ktamr.common.core.domain.BaseController;
import com.ktamr.common.utils.DateUtils;
import com.ktamr.domain.HaMeter;
import com.ktamr.domain.HavMeterinfo;
import com.ktamr.service.HaMeterService;
import com.ktamr.service.HavMeterinfoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/meter")
public class MeterController extends BaseController {

    @Resource
    private HaMeterService haMeterService;

    @Resource
    private HavMeterinfoService havMeterinfoService;

    @RequestMapping("/meter_replace")
    public String meter_replace(HaMeter haMeter, Integer meterid, Model model, HttpSession session){
        String operatorCode = (String)session.getAttribute("operatorCode");
        haMeter.setMeterId(meterid);
        HaMeter meter = haMeterService.delByIdHaMeter(haMeter);
        HavMeterinfo userAddr = havMeterinfoService.userAddr(meterid);
        model.addAttribute("meter",meter);
        model.addAttribute("meterid",meterid);
        model.addAttribute("userAddr",userAddr);
        model.addAttribute("operatorCode",operatorCode);
        model.addAttribute("nowDate", DateUtils.getNowDate());
        return "area/meter_replace";
    }

    @RequestMapping("/queryHaMeter")
    @ResponseBody
    public Object queryHaMeter(Integer centorId,Integer collectorId){
        startPage();
        List<HaMeter> haMeters = haMeterService.queryHaMeter(centorId,collectorId);
        Map<String, Object> map = getDataTable(haMeters);
        return map;
    }
}
