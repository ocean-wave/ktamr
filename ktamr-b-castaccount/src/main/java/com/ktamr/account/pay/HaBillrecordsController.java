package com.ktamr.account.pay;


import com.ktamr.common.core.domain.AjaxResult;
import com.ktamr.common.core.domain.BaseController;
import com.ktamr.common.utils.export.ExcelUtilTwo;
import com.ktamr.domain.HaBillrecords;
import com.ktamr.domain.HaMonthbtime;
import com.ktamr.common.utils.DateUtils;
import com.ktamr.service.HaBillrecordsService;
import com.ktamr.service.HaMonthbtimeService;
import com.ktamr.util.Tool;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.*;

@Controller
public class HaBillrecordsController extends BaseController {

    @Resource
    private HaBillrecordsService haBillrecordsService;

    @Resource
    private HaMonthbtimeService haMonthbtimeService;


    /**
     * 打开收费记录查询页面
     *
     * @return
     */
    @RequestMapping("pay/cust_recharge_list.html")
    public String showCust_recharge_list() {
        return "pay/cust_recharge_list.html";
    }

    /**
     * 对其收费记录查询Json数据
     *
     * @param haBillrecords
     * @return
     */
    @RequestMapping("/pay/sfjl/showBillRecordsList")
    @ResponseBody
    public Object showBillRecordsList(HaBillrecords haBillrecords) {
        startPage();
        List<HaBillrecords> haAreaList = haBillrecordsService.ChaXunHaBillrecordsList(haBillrecords);
        Map<String, Object> map = getDataTable(haAreaList);//获取收费记录查询
        if (map != null) {
            return map;
        }
        return null;
    }

    /**
     * 收费记录导出
     *
     * @param haBillrecords
     * @param excelUtilTwo
     * @return
     */
    @PostMapping("/pay/sfjl/export")
    @ResponseBody
    public AjaxResult ybbexport(HaBillrecords haBillrecords, ExcelUtilTwo excelUtilTwo) {
        //这里保证查询的是全部的数据
        List<HaBillrecords> haAreaList = haBillrecordsService.ChaXunHaBillrecordsList(haBillrecords);
        if (haAreaList != null) {
            return excelUtilTwo.init(haAreaList, "月报表数据");
        }
        return null;
    }

    /**
     * 查询用户账单列表
     *
     * @param haBillrecords
     * @return ajax
     */
    @RequestMapping("/selectYongHuZhangDan")
    @ResponseBody
    public Object queryHaCustomList(HaBillrecords haBillrecords, String startDate, String endDate
    ) {
        if (startDate != null && startDate != "" && endDate != null && endDate != "") {
            Date start = Tool.RiQiZhuanHua(startDate);
            Date end = Tool.RiQiZhuanHua(endDate);
            haBillrecords.setKaiShi(start);
            haBillrecords.setJieShu(end);
        }
        startPage();
        List<HaBillrecords> haBillrecordsList = haBillrecordsService.selectYongHuZhangDan(haBillrecords);
        Map<String, Object> map = getDataTable(haBillrecordsList);
        if (map != null) {
            return map;
        }
        return null;
    }

    /**
     * 打开导入余额页面
     *
     * @return
     */
    @RequestMapping("/cust_balance_import")
    public String cust_balance_import() {
        return "pay/cust_balance_import.html";
    }


    /**
     * 填充结算周期下拉框
     *
     * @param haMonthbtime
     * @return
     */
    @RequestMapping("/load_monthBTime")
    @ResponseBody
    public List<String> load_monthBTime(HaMonthbtime haMonthbtime) {
        List<HaMonthbtime> haMonthbtimeList = haMonthbtimeService.BselectTime(haMonthbtime);//获取开始结束时间
        if (haMonthbtimeList != null) {
            List<String> list = new ArrayList<String>();//创建集合对象；
            for (int i = 0; i < haMonthbtimeList.size(); i++) {
                //对其进行赋值
                String std = DateUtils.parseDateToStr("yyyy-MM-dd HH:mm:ss", haMonthbtimeList.get(i).getStartTime()) + '~' + DateUtils.parseDateToStr("yyyy-MM-dd HH:mm:ss", haMonthbtimeList.get(i).getEndTime()) + ';';
                list.add(std);
            }
            return list;
        }

        return null;
    }
}
