package com.ktamr.web;

import com.ktamr.service.ZhuYeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
public class xxxController {

    @Resource
    private ZhuYeService zhuYeService;
    /**
     * 打开首页
     * @return
     */
    @RequestMapping("/openMainHtml")
    public String openMainHtml(Model model){
        Integer areaCount = zhuYeService.areaCount();
        Integer meterCount = zhuYeService.meterCount();
        Integer notOkCount = zhuYeService.notOkCount();
        Integer notConnectedCount = zhuYeService.notConnectedCount();
        Integer userCount = zhuYeService.userCount();
        Integer ccentorCount = zhuYeService.ccentorCount();
        Integer centorCount = zhuYeService.centorCount();
        Integer collectorCount = zhuYeService.collectorCount();
        model.addAttribute("areaCount",areaCount);
        model.addAttribute("meterCount",meterCount);
        model.addAttribute("notOkCount",notOkCount);
        model.addAttribute("notConnectedCount",notConnectedCount);
        model.addAttribute("userCount",userCount);
        model.addAttribute("ccentorCount",ccentorCount);
        model.addAttribute("centorCount",centorCount);
        model.addAttribute("collectorCount",collectorCount);

        //开始整统计图
        Integer[] meterStateCount = new Integer[16];
        String t_stateNameList="";
        return "main";
    }
}
