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

                if(state.contains("建档") ) {
                    meterStateCount[0]=total;
                }else if(state.contains("失联")){
                    meterStateCount[2]=total;
                }else if(state.contains("光通道干扰")){
                    meterStateCount[4]=total;
                }else if(state.contains("强光干扰")){
                    meterStateCount[5]=total;
                }else if(state.contains("气泡干扰")){
                    meterStateCount[6]=total;
                }else if(state.contains("通讯故障")){
                    meterStateCount[7]=total;
                }else if(state.contains("表具故障")){
                    meterStateCount[8]=total;
                }else if(state.contains("关阀")){
                    meterStateCount[12]=total;
                }else if(state.contains("开阀故障")){
                    meterStateCount[13]=total;
                }else if(state.contains("关阀故障")){
                    meterStateCount[14]=total;
                }

                if(total>0){
                    t_stateNameList = t_stateNameList +"'"+ state +"',";
                }


        }

        //状态按照固定的顺序排序
        if(t_stateNameList.length()>0){
            String[] stateNameArray = stateNameList.split(",");
             stateNameList = "";
            for (int i=0;i<stateNameArray.length;i++){
                if(t_stateNameList.indexOf(stateNameArray[i])>0){
                    stateNameList = stateNameList + stateNameArray[i] +",";
                }
            }
            if(stateNameList!=null){
                //上面在vb中把最后一个多余的逗号给去掉，在java中不需要
//                stateNameList =  stateNameList.substring(0,stateNameList.lastIndexOf(',')-1);

                stateNameList =  stateNameList.replace("'", "");

            }
        }
        //集中器状态统计
        List<zhuYe> meterStateCountJiZhongQi = zhuYeService.meterStateCountJiZhongQi();
        Integer[] centorStateCount = new Integer[3];
        for (int i=0;i<meterStateCountJiZhongQi.size();i++){
            Integer total = meterStateCountJiZhongQi.get(i).getTotal();//获取总数
            String state = meterStateCountJiZhongQi.get(i).getState();//获取状态
            switch (state){
                case "联机":
                    centorStateCount[0] = total;
                    break;
                case "断开":
                    centorStateCount[1] = total;
                    break;
                case "建档":
                    centorStateCount[2] = total;
                    break;
            }

        }

        //采集器统计
        Integer meterStateCountCaiJiQi1 = zhuYeService.meterStateCountCaiJiQi1();
        Integer meterStateCountCaiJiQi2 = zhuYeService.meterStateCountCaiJiQi2();
        Integer collectorConnCount=meterStateCountCaiJiQi1;
        Integer collectorDisConnCount=meterStateCountCaiJiQi2;
        Integer meterCount = zhuYeService.meterCount();
//        model.addAttribute("meterStateCount",meterStateCount);
        Map<String ,Object> map=new HashMap<>();
        map.put("meterStateCount",meterStateCount);
        map.put("stateNameList",stateNameList);
        map.put("centorStateCount",centorStateCount);
        map.put("collectorConnCount",collectorConnCount);
        map.put("collectorDisConnCount",collectorDisConnCount);
        map.put("meterCount",meterCount);
        if(map!=null){
            return map;
        }
        return null;
    }
}
