package com.ktamr.account.pay;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.ktamr.domain.HaArea;
import com.ktamr.domain.HaPaylog;
import com.ktamr.domain.HaPricestandard;
import com.ktamr.service.HaAreaService;
import com.ktamr.service.HaPaylogService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HaPaylogController {

    @Resource
    private HaPaylogService haPaylogService;
    @Resource
    private HaAreaService haAreaService;

    /**
     * 打开缴费单页面 +查询小区表
     * @return
     */
    @RequestMapping("/com/ktamr/account/pay/bill_list.html")
    public String showBill_list(HaArea haArea, Model model){
        List<HaArea> haAreaList = haAreaService.selectHareaNameList(haArea);
        if(haAreaList!=null){//判断是否有值
            model.addAttribute("areaListName",haAreaList);
            return "com/ktamr/account/pay/bill_list.html";
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
    public String showHaPaylogList(HaPaylog haPaylog, HttpServletRequest request, @RequestParam("page") int pageSize
    , @RequestParam("startTime") Object startTime, @RequestParam("endTime")Object endTime
    ){

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
        Integer page,pageRows;

        String page1 = request.getParameter("page");//获取需要多少行
        String pageRows1 = request.getParameter("rows");//获取查询的起点位置
        if(page1==null&&pageRows1==null){//为了防止异常给它初始化一波
            page = 100;
            pageRows = 100;
        }else {//如果有那就获取一波
            page = Integer.parseInt(page1); // 取得当前页数
            pageRows = Integer.parseInt(pageRows1); // 取得每页显示行数
        }
        int page2=page;//重新定义变量接收
        --page2;
        List<HaPaylog> haPaylogList = haPaylogService.selectHaPaylogList(haPaylog, pageRows, page2);
        Integer paylogListCount = haPaylogService.selectHaPaylogListCount(haPaylog);

        Map<String ,Object> map=new HashMap<String, Object>();
        map.put("page",page);//设置初始的页码 就是第几页
        map.put("rowNum",pageRows);//一页显示几条数据
        map.put("records",paylogListCount);//总记录数
        map.put("total",(paylogListCount-1)/pageRows+1);//总页数的计算
        map.put("rows",haPaylogList);//存放集合

        String s = JSON.toJSONString(map, SerializerFeature.DisableCircularReferenceDetect);

        if(s!=null){
            return s;
        }
        return null;
    }


    /**
     * 打开月报表页面+小区表的查询
     * @param haArea
     * @param model
     * @return
     */
    @RequestMapping("/com/ktamr/account/pay/month_report.html")
    public String showMonth_report(HaArea haArea,Model model){
        List<HaArea> haAreaList = haAreaService.selectHareaNameList(haArea);
        if(haAreaList!=null){//判断是否有值
            model.addAttribute("areaListName",haAreaList);
            return "com/ktamr/account/pay/month_report.html";
        }
        return null;
    }

    /**
     * 月报表的查询
     * @param haPaylog
     * @param request
     * @param pageSize
     * @return
     */
    @RequestMapping(value ="/showMonthReportList")
    @ResponseBody
    public String showHaMonthReportList(HaPaylog haPaylog, HttpServletRequest request, @RequestParam("page") int pageSize

    ){

        Integer page,pageRows;

        String page1 = request.getParameter("page");//获取需要多少行
        String pageRows1 = request.getParameter("rows");//获取查询的起点位置
        if(page1==null&&pageRows1==null){//为了防止异常给它初始化一波
            page = 100;
            pageRows = 100;
        }else {//如果有那就获取一波
            page = Integer.parseInt(page1); // 取得当前页数
            pageRows = Integer.parseInt(pageRows1); // 取得每页显示行数
        }
        int page2=page;//重新定义变量接收
        --page2;
//        List<HaPaylog> haPaylogList = haPaylogService.selectHaPaylogList(haPaylog, pageRows, page2);
//        Integer paylogListCount = haPaylogService.selectHaPaylogListCount(haPaylog);
        List<HaPaylog> haPaylogList = haPaylogService.selectMonthReportList(haPaylog, pageRows, page2);
        Integer monthReportListCount = haPaylogService.selectMonthReportListCount(haPaylog);
        Map<String ,Object> map=new HashMap<String, Object>();
        map.put("page",page);//设置初始的页码 就是第几页
        map.put("rowNum",pageRows);//一页显示几条数据
        map.put("records",monthReportListCount);//总记录数
        map.put("total",(monthReportListCount-1)/pageRows+1);//总页数的计算
        map.put("rows",haPaylogList);//存放集合

        String s = JSON.toJSONString(map, SerializerFeature.DisableCircularReferenceDetect);

        if(s!=null){
            return s;
        }
        return null;
    }
}
