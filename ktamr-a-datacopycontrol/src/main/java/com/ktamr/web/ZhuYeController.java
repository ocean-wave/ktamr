package com.ktamr.web;

import com.ktamr.common.Checkright;
import com.ktamr.common.core.domain.BaseEntity;
import com.ktamr.domain.*;
import com.ktamr.service.HaAreaService;
import com.ktamr.service.HaMeterService;
import com.ktamr.service.HaRngService;
import com.ktamr.service.ZhuYeService;
import com.ktamr.util.PageUtil;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ZhuYeController {


    //定义一个全局变量
    private String Globalstate=null;

    @Autowired
    private HaAreaService haAreaService;
    @Autowired
    private HaRngService haRngService;
    @Resource
    private ZhuYeService zhuYeService;
    @Resource
    private HaMeterService haMeterService;
    @Resource
    private Checkright ck;

    /**
     * 打开首页
     * @return
     */
    @RequestMapping("/openMainHtml")
    public String openMainHtml(Model model,HttpSession session){
        BaseEntity baseEntity =new zhuYe();

        Integer areaCount = zhuYeService.areaCount(baseEntity);

        Integer meterCount = zhuYeService.meterCount(baseEntity);
        Integer notOkCount = zhuYeService.notOkCount(baseEntity);
        Integer notConnectedCount = zhuYeService.notConnectedCount(baseEntity);

        Integer userCount = zhuYeService.userCount(baseEntity);

        Integer ccentorCount = zhuYeService.ccentorCount(baseEntity);
        Integer centorCount = zhuYeService.centorCount(baseEntity);
        Integer collectorCount = zhuYeService.collectorCount(baseEntity);
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
    public Map<String ,Object> openMainHtml2(zhuYe zhuYe, HttpSession session){
        //开始统计图
        Integer[] meterStateCount = new Integer[15];
        String t_stateNameList="";
        String stateNameList = "建档,无返回,失联,正常,强光干扰,气泡干扰,通讯故障,表具故障,异常,用量异常,开阀,关阀";
        //1、正常表计数'
        BaseEntity baseEntity =new zhuYe();
        //ck.GetRightCondition("areaNo","area","and",session,baseEntity);

        //获得全部状态
        Map<String, Object> map2 = zhuYeService.getMeterStateCount(baseEntity);
        meterStateCount[3]= Integer.parseInt(map2.get("正常").toString());;//2、正常状态计数
        t_stateNameList = t_stateNameList + "'正常'" +",";
        meterStateCount[9]= Integer.parseInt(map2.get("异常").toString());//2、异常状态计数
        t_stateNameList = t_stateNameList + "'异常'" +",";
        meterStateCount[1]= Integer.parseInt(map2.get("无返回").toString());//3、无返回数据计数
        t_stateNameList = t_stateNameList + "'无返回'" +",";
        meterStateCount[10]=Integer.parseInt(map2.get("用量异常").toString());//4、用量异常计数
        t_stateNameList = t_stateNameList + "'用量异常'" +",";
        meterStateCount[11]=Integer.parseInt(map2.get("开阀").toString());//5、开阀状态计数
        t_stateNameList = t_stateNameList + "'开阀'" +",";

        //6、其他状态表计数
        List<zhuYe> zhuYeList = zhuYeService.meterStateCountQiTa(baseEntity);



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
        //ck.GetRightCondition("ce.centorNo","centor","AND",session,baseEntity);
        List<zhuYe> meterStateCountJiZhongQi = zhuYeService.meterStateCountJiZhongQi(baseEntity);
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
        Integer meterStateCountCaiJiQi1 = zhuYeService.meterStateCountCaiJiQi1(baseEntity);
        Integer meterStateCountCaiJiQi2 = zhuYeService.meterStateCountCaiJiQi2(baseEntity);
        Integer collectorConnCount=meterStateCountCaiJiQi1;
        Integer collectorDisConnCount=meterStateCountCaiJiQi2;
        //ck.GetRightCondition("a.areaNo","area","and",session,baseEntity);
        Integer meterCount = zhuYeService.meterCount(baseEntity);
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


    /**
     * 统计图中==》打开根据状态表查询页面
     * @param haArea
     * @return
     */
    @RequestMapping("/meter/meters_state_list")
    public String  centorList(HaArea haArea, Model model){
        Globalstate=haArea.getState();//把从页面来的状态赋给全局变量里
        List<HaRgn> haRgns = haRngService.selectBigNameB();
        if(Globalstate!=null&&haRgns!=null){
            model.addAttribute("haRgnsListName",haRgns);
            return "meter/metersStateList.html";//返回打开的页面
        }
        return null;
    }

    /**
     * 状态表列表之==》小区列表
     * @param haArea
     * @param request
     * @param pageUtil
     * @return
     */
    @RequestMapping("/getAreaMeterState")
    @ResponseBody
    public Map<String ,Object> showList(HaArea haArea, HttpServletRequest request, PageUtil pageUtil,
                                        String aareaid
    ){
        String s1 = aareaid;//获取areaid  小区名字
        if(s1!=null && s1!=""){//判断小区名字如果没有赋值的话就不用查询
            String[] split = s1.split(",");
            List<String> idsList = new ArrayList<String>();
            for(int i=0;i<split.length;i++){
                idsList.add(split[i]);
            }
            haArea.setIdsList2(idsList);

        }
        haArea.setState(Globalstate);//将刚才设置的全局变量赋值一波
        String page1 = request.getParameter("page");//获取需要多少行
        String pageRows1 = request.getParameter("rows");//获取查询的起点位置
        Integer[] integers = pageUtil.pageAndPageRow(page1, pageRows1);
        List<HaArea> haAreaList = haAreaService.AQueryHaAreabystatus(haArea, integers[0], integers[1]);
        Integer queryHaAreabystatusCount = haAreaService.AQueryHaAreabystatusCount(haArea);
        Map map = pageUtil.map(haAreaList, queryHaAreabystatusCount);
        if(map!=null){
            return map;
        }else {
            return null;
        }
    }


    /**
     * 主页统计表==》表列表
     * @param haMeter
     * @param request
     * @param pageUtil
     * @return
     */
    @RequestMapping("/getStateMeter")
    @ResponseBody
    public Map<String ,Object> getStateMeterCount(HaMeter haMeter, HttpServletRequest request, PageUtil pageUtil
    ){

        haMeter.setState(Globalstate);//将刚才设置的全局变量赋值一波
        String page1 = request.getParameter("page");//获取需要多少行
        String pageRows1 = request.getParameter("rows");//获取查询的起点位置
        Integer[] integers = pageUtil.pageAndPageRow(page1, pageRows1);
        List<HaMeter> haMeterList = haMeterService.zhuYegetStateMeter(haMeter, integers[0], integers[1]);
        Integer zhuYegetStateMeterCount = haMeterService.zhuYegetStateMeterCount(haMeter);
        Map map = pageUtil.map(haMeterList, zhuYegetStateMeterCount);
        if(map!=null){
            return map;
        }else {
            return null;
        }
    }
}
