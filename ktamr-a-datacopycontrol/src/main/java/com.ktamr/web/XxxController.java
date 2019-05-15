package com.ktamr.web;

import com.ktamr.service.ZhuYeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

import static org.springframework.util.StringUtils.split;

@Controller
public class XxxController {

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

        //开始统计图

        Integer[] meterStateCount = new Integer[16];
        String t_stateNameList="";
        String stateNameList = "'建档','无返回','失联','正常','光通道干扰',' 强光干扰','气泡干扰','通讯故障','表具故障','异常','用量异常','开阀','关阀',' 开阀故障','关阀故障'";
        //1、正常表计数'
        meterStateCount[3] = 3;
        t_stateNameList = t_stateNameList + "'正常'" +",";
        //2、异常状态计数
        meterStateCount[9] = 9;
        t_stateNameList = t_stateNameList + "'异常'" +",";
        //3、无返回数据计数
        meterStateCount[1] = 1;
        t_stateNameList = t_stateNameList + "'无返回'" +",";
        //4、用量异常计数
        meterStateCount[10] = 10;
        t_stateNameList = t_stateNameList + "'用量异常'" +",";
        //5、开阀状态计数
        meterStateCount[11] = 11;
        t_stateNameList = t_stateNameList + "'开阀'" +",";
        //6、其他状态表计数
        meterStateCount[0] = 1000;
        t_stateNameList = t_stateNameList + "'通讯故障'" +",";
        //状态按照固定的顺序排序
        if(t_stateNameList.length()>0){
            String[] strings = split(stateNameList, ",");
        }

        return "main";
    }
}
