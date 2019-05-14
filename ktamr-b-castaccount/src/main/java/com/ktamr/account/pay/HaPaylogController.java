package com.ktamr.account.pay;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.ktamr.domain.*;
import com.ktamr.service.HaAreaService;
import com.ktamr.service.HaFreezeService;
import com.ktamr.service.HaPaylogService;
import com.ktamr.util.PageUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class HaPaylogController {

    @Resource
    private HaPaylogService haPaylogService;
    @Resource
    private HaAreaService haAreaService;

    @Resource
    private HaFreezeService haFreezeService;
    /**
     * 打开缴费单页面 +查询小区表
     * @return
     */
    @RequestMapping("/pay/bill_list.html")
    public String showBill_list(HaArea haArea, Model model){
        List<HaArea> haAreaList = haAreaService.selectHareaNameList(haArea);
        if(haAreaList!=null){//判断是否有值
            model.addAttribute("areaListName",haAreaList);
            return "pay/bill_list.html";
        }
        return null;
    }

    /**
     * 缴费单页面查询+分页
     * @param haPaylog
     * @param request
     * @param pageSize
     * @return
     */
    @RequestMapping(value ="/showHaPaylogList")
    @ResponseBody
    public Object showHaPaylogList(HaPaylog haPaylog, HttpServletRequest request, @RequestParam("page") int pageSize
    , @RequestParam("startTime") Object startTime, @RequestParam("endTime")Object endTime, String hhh,PageUtil pageUtil
    ){
    if(hhh!=null&& hhh!=""){
        boolean b = hhh.contains(",");
        //包含返回true
        List<Integer> xhlist=new ArrayList<>();
        if(b==true){
            //拆分字符根绝逗号
            String[] split = hhh.split(",");
            //进行循环添加
            for (int i =0;i<split.length;i++){
                xhlist.add(Integer.valueOf(split[i]));
            }
            haPaylog.setIdsList(xhlist);
        }else {
            xhlist.add(Integer.valueOf(hhh));
            haPaylog.setIdsList(xhlist);
        }
    }
        SimpleDateFormat sdf = new SimpleDateFormat( "yyyy-MM-dd hh:mm:ss" );
        if(startTime!=null&&startTime!="" &&endTime!=null&&endTime!=""){
        try {
                Date start    = sdf.parse( String.valueOf(startTime));
                Date end = sdf.parse( String.valueOf(endTime));
                HaPricestandard pricestandard=new HaPricestandard();
                pricestandard.setEndTime(end);
                pricestandard.setStartTime(start);
                haPaylog.setHaPricestandard(pricestandard);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        }
        String page1 = request.getParameter("page");//获取需要多少行
        String pageRows1 = request.getParameter("rows");//获取查询的起点位置
        Integer[] integers = pageUtil.pageAndPageRow(page1, pageRows1);
        List<HaPaylog> haPaylogList = haPaylogService.selectHaPaylogList(haPaylog, integers[0] ,integers[1]);
        Integer paylogListCount = haPaylogService.selectHaPaylogListCount(haPaylog);
        Map map = pageUtil.map(haPaylogList, paylogListCount);
        if(map!=null){
            return map;
        }
        return null;
    }


    /**
     * 打开月报表页面+小区表的查询
     * @param haArea
     * @param model
     * @return
     */
    @RequestMapping("/pay/month_report.html")
    public String showMonth_report(HaArea haArea,Model model){
        List<HaArea> haAreaList = haAreaService.selectHareaNameList(haArea);
        if(haAreaList!=null){//判断是否有值
            model.addAttribute("areaListName",haAreaList);
            return "pay/month_report.html";
        }
        return null;
    }

    /**
     * 月报表的查询
     * @param haPaylog
     * @param request
     * @return
     */
    @RequestMapping(value ="/showMonthReportList")
    @ResponseBody
    public String showHaMonthReportList(HaPaylog haPaylog, HttpServletRequest request
    , PageUtil pageUtil){
        String page1 = request.getParameter("page");//获取需要多少行
        String pageRows1 = request.getParameter("rows");//获取查询的起点位置
        Integer[] integers = pageUtil.pageAndPageRow(page1, pageRows1);
        List<HaPaylog> haPaylogList = haPaylogService.selectMonthReportList(haPaylog, integers[0] ,integers[1]);
        Integer monthReportListCount = haPaylogService.selectMonthReportListCount(haPaylog);
        Map map = pageUtil.map(haPaylogList, monthReportListCount);
        String s = JSON.toJSONString(map, SerializerFeature.DisableCircularReferenceDetect);
        if(s!=null){
            return s;
        }
        return null;
    }

    //点击打印缴费单的事件
    @RequestMapping("/bill_print")
    public String billPrint(HaPaylog haPaylog, HaFreeze haFreeze,Model model){
        //检测字符串是否包含逗号
        boolean b = haPaylog.getBillId().contains(",");
        //包含返回true
        if(b==true){
            //拆分字符根绝逗号
            String[] split = haPaylog.getBillId().split(",");

            List<String> xhlist=new ArrayList<>();
            //进行循环添加
            for (int i =0;i<split.length;i++){
                xhlist.add(split[i]);
            }
            haPaylog.setBillIdsList(xhlist);
            haPaylog.setBillId(null);

        }
        //查询上面的table
        List<HaPaylog> haPaylogList = haPaylogService.BselectPritJiaoFeiDan1(haPaylog);
        HaFreeze bselectPritJiaoFeiDan2=null;//全局变量
        //进行循环添加子list
        for (int i=0;i<haPaylogList.size();i++){
            haFreeze.setBillId(haPaylogList.get(i).getBillId());
            bselectPritJiaoFeiDan2 = haFreezeService.BselectPritJiaoFeiDan2(haFreeze);

                //对其进行循环录入
            haPaylogList.get(i).setHaFreeze(bselectPritJiaoFeiDan2);
        }

        if(haPaylogList!=null&&bselectPritJiaoFeiDan2!=null){
            model.addAttribute("haPaylogList",haPaylogList);
            model.addAttribute("bselectPritJiaoFeiDan2",bselectPritJiaoFeiDan2);
            Map<String,Object> hh=new HashMap<String,Object>();
            hh.put("haPaylogList",haPaylogList);
            hh.put("bselectPritJiaoFeiDan2",bselectPritJiaoFeiDan2);
            return "pay/bill_print.html";
        }

        return  null;
    }
}
