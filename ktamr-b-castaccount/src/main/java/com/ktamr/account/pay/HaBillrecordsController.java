package com.ktamr.account.pay;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.ktamr.common.core.domain.AjaxResult;
import com.ktamr.common.utils.poi.ExcelUtilTwo;
import com.ktamr.domain.HaBillrecords;
import com.ktamr.domain.HaMonthbtime;
import com.ktamr.common.utils.DateUtils;
import com.ktamr.service.HaBillrecordsService;
import com.ktamr.service.HaMonthbtimeService;
import com.ktamr.util.PageUtil;
import com.ktamr.util.Tool;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Controller
public class HaBillrecordsController {

    @Resource
    private HaBillrecordsService haBillrecordsService;

    @Resource
    private HaMonthbtimeService haMonthbtimeService;


    /**
     * 打开收费记录查询页面
     * @return
     */
    @RequestMapping("pay/cust_recharge_list.html")
    public String showCust_recharge_list(){
        return "pay/cust_recharge_list.html";
    }

    /**
     * 对其收费记录查询Json数据
     * @param haBillrecords
     * @return
     */
    @RequestMapping("/pay/sfjl/showBillRecordsList")
    @ResponseBody
    public  Object  showBillRecordsList(HaBillrecords haBillrecords, HttpServletRequest request, PageUtil pageUtil
    ){
        String page1 = request.getParameter("page");//获取需要多少行
        String pageRows1 = request.getParameter("rows");//获取查询的起点位置
        Integer[] integers = pageUtil.pageAndPageRow(page1, pageRows1);
        List<HaBillrecords> haAreaList =haBillrecordsService.queryHaBillrecordsList(haBillrecords,integers[0] ,integers[1] );
        Integer selectHaAreaCount = haBillrecordsService.ChaXunHaBillrecordsCount(haBillrecords);
        Map map = pageUtil.map(haAreaList, selectHaAreaCount);
       if(map!=null){
           return map;
       }
        return null;
    }

    /**
     * 收费记录导出
     * @param haBillrecords
     * @param excelUtilTwo
     * @return
     */
    @PostMapping("/pay/sfjl/export")
    @ResponseBody
    public AjaxResult ybbexport(HaBillrecords haBillrecords, ExcelUtilTwo excelUtilTwo)
    {
        //这里保证查询的是全部的数据
        List<HaBillrecords> haAreaList =haBillrecordsService.queryHaBillrecordsList(haBillrecords,9999999,0 );
        if (haAreaList!=null){
            return excelUtilTwo.init(haAreaList, "月报表数据");
        }
        return null;
    }
    /**
     * 查询用户账单列表
     * @param haBillrecords
     * @param request
     * @param pageUtil
     * @return ajax
     */
    @RequestMapping("/selectYongHuZhangDan")
    @ResponseBody
     public String queryHaCustomList(HaBillrecords haBillrecords , HttpServletRequest request, PageUtil pageUtil
    , String startDate, String endDate

    ) {
        if(startDate!=null&&startDate!="" &&endDate!=null&&endDate!=""){
            Date start = Tool.RiQiZhuanHua(startDate);
            Date end = Tool.RiQiZhuanHua(endDate);
            haBillrecords.setKaiShi(start);
            haBillrecords.setJieShu(end);
        }
         //接收一波
        String page1 = request.getParameter("page");//获取需要多少行
        String pageRows1 = request.getParameter("rows");//获取查询的起点位置
        //通过方法返回一波
        Integer[] integers = pageUtil.pageAndPageRow(page1, pageRows1);
        List<HaBillrecords> haBillrecordsList = haBillrecordsService.selectYongHuZhangDan(haBillrecords, integers[0], integers[1]);

        Integer selectYongHuZhangDanCount = haBillrecordsService.selectYongHuZhangDanCount(haBillrecords);
        Map map = pageUtil.map(haBillrecordsList, selectYongHuZhangDanCount);
        String s = JSON.toJSONString(map, SerializerFeature.DisableCircularReferenceDetect);
        if (s != null) {
            return s;
        }
        return null;
    }

    /**
     * 打开导入余额页面
     * @param haBillrecords
     * @return
     */
    @RequestMapping("/cust_balance_import")
    public String cust_balance_import(HaBillrecords haBillrecords){
        return "pay/cust_balance_import.html";
    }


    /**
     * 填充结算周期下拉框
     * @param haMonthbtime
     * @return
     */
    @RequestMapping("/load_monthBTime")
    @ResponseBody
    public List<String> load_monthBTime(HaMonthbtime haMonthbtime){
        List<HaMonthbtime> haMonthbtimeList = haMonthbtimeService.BselectTime(haMonthbtime);//获取开始结束时间
        if(haMonthbtimeList!=null){
            List<String> list = new ArrayList<String>();//创建集合对象；

            for (int i=0;i<haMonthbtimeList.size();i++){
                //对其进行赋值

                String std= DateUtils.parseDateToStr("yyyy-MM-dd HH:mm:ss",haMonthbtimeList.get(i).getStartTime())+'~'+DateUtils.parseDateToStr("yyyy-MM-dd HH:mm:ss",haMonthbtimeList.get(i).getEndTime())+';';
                list.add(std);
            }
            return list;
        }

        return  null;
    }
}
