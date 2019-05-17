package com.ktamr.web;

import com.ktamr.domain.zhuYe;
import com.ktamr.service.ZhuYeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.util.StringUtils.split;
@Controller
public class ZhuYeController {

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
        return "main";
    }

    /**
     * 主页下方的统计图,无刷新请求
     * @return
     */
    @RequestMapping("/openMainHtml2")
    @ResponseBody
    public Map<String ,Object> openMainHtml2(){
        //开始统计图
        Integer[] meterStateCount = new Integer[15];
        meterStateCount[2] = 2;
        meterStateCount[4] = 4;
        meterStateCount[5] = 5;
        meterStateCount[6] = 6;
        meterStateCount[7] = 7;
        meterStateCount[8] = 8;
        meterStateCount[12] = 12;
        meterStateCount[13] = 13;
        meterStateCount[14] = 14;


        String t_stateNameList="";
        String stateNameList = "建档,无返回,失联,正常,强光干扰,气泡干扰,通讯故障,表具故障,异常,用量异常,开阀,关阀";
        //1、正常表计数'
        meterStateCount[3] = zhuYeService.meterStateCount03();
        t_stateNameList = t_stateNameList + "'正常'" +",";
        //2、异常状态计数
        meterStateCount[9] = zhuYeService.meterStateCount09();
        t_stateNameList = t_stateNameList + "'异常'" +",";
        //3、无返回数据计数
        meterStateCount[1] = zhuYeService.meterStateCount01();
        t_stateNameList = t_stateNameList + "'无返回'" +",";
        //4、用量异常计数
        meterStateCount[10] = zhuYeService.meterStateCount10();
        t_stateNameList = t_stateNameList + "'用量异常'" +",";
        //5、开阀状态计数
        meterStateCount[11] = zhuYeService.meterStateCount11();
        t_stateNameList = t_stateNameList + "'开阀'" +",";
        //6、其他状态表计数
        List<zhuYe> zhuYeList = zhuYeService.meterStateCountQiTa();



        //进行循环
        for (int i =0;i<zhuYeList.size();i++){
            //获取状态，总数
            String state = zhuYeList.get(i).getState();//状态
            Integer total = zhuYeList.get(i).getTotal();//总数
//            switch (state){
//                case state.contains("建档") :
//
//                    break;
//            }
        }
        t_stateNameList = t_stateNameList + "'通讯故障'" +",";
        //状态按照固定的顺序排序
        if(t_stateNameList.length()>0){
            String[] strings = split(stateNameList, ",");
        }
        //集中器状态统计
        Integer[] centorStateCount = new Integer[3];
        centorStateCount[0]=001;
        centorStateCount[1]=002;
        centorStateCount[2]=003;
        //采集器统计
        Integer collectorConnCount=111;
        Integer collectorDisConnCount=222;
//        model.addAttribute("meterStateCount",meterStateCount);
        Map<String ,Object> map=new HashMap<>();
        map.put("meterStateCount",meterStateCount);
        map.put("stateNameList",stateNameList);
        map.put("centorStateCount",centorStateCount);
        map.put("collectorConnCount",collectorConnCount);
        map.put("collectorDisConnCount",collectorDisConnCount);
        map.put("collectorDisConnCount",collectorDisConnCount);
        if(map!=null){
            return map;
        }
        return null;
    }
}
