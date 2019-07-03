package com.ktamr.account.pay;


import com.ktamr.common.core.domain.AjaxResult;
import com.ktamr.common.core.domain.BaseController;
import com.ktamr.common.utils.export.ExportExcelUtil;
import com.ktamr.common.utils.export.ExportStr;
import com.ktamr.common.utils.export.ExportTxtUtil;
import com.ktamr.common.utils.sql.SqlCondition;
import com.ktamr.domain.HaArea;
import com.ktamr.domain.HaFreeze;
import com.ktamr.domain.HaPaylog;
import com.ktamr.domain.HaPricestandard;
import com.ktamr.service.HaAreaService;
import com.ktamr.service.HaFreezeService;
import com.ktamr.service.HaPaylogService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class HaPaylogController extends BaseController {

    @Resource
    private HaPaylogService haPaylogService;
    @Resource
    private HaAreaService haAreaService;

    @Resource
    private HaFreezeService haFreezeService;

    /**
     * 打开缴费单页面 +查询小区表
     *
     * @return
     */
    @RequestMapping("/pay/bill_list.html")
    public String showBill_list(HaArea haArea, Model model) {
        haArea.setTypeName("id");
        haArea.getParams().put("getRightCondition", SqlCondition.getRightCondition("areaNo","area","where "));
     //   List<HaArea> haAreaList = haAreaService.selectHareaNameList(haArea);
        List<HaArea> haAreaList = haAreaService.AreaByWhere(haArea);
        if (haAreaList != null) {//判断是否有值
            model.addAttribute("areaListName", haAreaList);
            return "pay/bill_list.html";
        }
        return null;
    }

    /**
     * 导出缴费单数据
     *
     * @param haPaylog
     * @param exportExcelUtil
     * @return
     */
    @PostMapping("/pay/export")
    @ResponseBody
    public AjaxResult export(HaPaylog haPaylog, ExportExcelUtil exportExcelUtil) {
        //这里保证查询的是全部的数据
        List<HaPaylog> haPaylogList = haPaylogService.selectHaPaylogList(haPaylog);
        if (haPaylogList != null) {
            return exportExcelUtil.init(haPaylogList, "缴费单数据");
        }
        return null;
    }

    /**
     * 缴费单页面查询+分页
     *
     * @param haPaylog
     * @return
     */
    @RequestMapping(value = "/pay/showHaPaylogList")
    @ResponseBody
    public Object showHaPaylogList(HaPaylog haPaylog, @RequestParam("startTime") Object startTime, @RequestParam("endTime") Object endTime, String hhh
    ) {
        if (hhh != null && hhh != "") {
            boolean b = hhh.contains(",");
            //包含返回true
            List<Integer> xhlist = new ArrayList<>();
            if (b == true) {
                //拆分字符根绝逗号
                String[] split = hhh.split(",");
                //进行循环添加
                for (int i = 0; i < split.length; i++) {
                    xhlist.add(Integer.valueOf(split[i]));
                }
                haPaylog.setIdsList(xhlist);
            } else {
                xhlist.add(Integer.valueOf(hhh));
                haPaylog.setIdsList(xhlist);
            }
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        if (startTime != null && startTime != "" && endTime != null && endTime != "") {
            try {
                Date start = sdf.parse(String.valueOf(startTime));
                Date end = sdf.parse(String.valueOf(endTime));
                HaPricestandard pricestandard = new HaPricestandard();
                pricestandard.setEndTime(end);
                pricestandard.setStartTime(start);
                haPaylog.setHaPricestandard(pricestandard);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        startPage();
        List<HaPaylog> haPaylogList = haPaylogService.selectHaPaylogList(haPaylog);
        Map<String, Object> map = getDataTable(haPaylogList);//获取缴费单页面总记录数
        if (map != null) {
            return map;
        }
        return null;
    }


    /**
     * 打开月报表页面+小区表的查询
     *
     * @param haArea
     * @param model
     * @return
     */
    @RequestMapping("/pay/month_report.html")
    public String showMonth_report(HaArea haArea, Model model) {
        haArea.setTypeName("id");
        haArea.getParams().put("getRightCondition", SqlCondition.getRightCondition("areaNo","area","where "));
        //   List<HaArea> haAreaList = haAreaService.selectHareaNameList(haArea);
        List<HaArea> haAreaList = haAreaService.AreaByWhere(haArea);
        if (haAreaList != null) {//判断是否有值
            model.addAttribute("areaListName", haAreaList);
            return "pay/month_report.html";
        }
        return null;
    }


    /**
     * 导出月报表
     *
     * @param haPaylog
     * @param exportExcelUtil
     * @return
     */
    @PostMapping("/pay/ybb/export")
    @ResponseBody
    public AjaxResult ybbexport(HaPaylog haPaylog, ExportExcelUtil exportExcelUtil) {
        //这里保证查询的是全部的数据
        List<HaPaylog> haPaylogList = haPaylogService.selectMonthReportList(haPaylog);
        if (haPaylogList != null) {
            return exportExcelUtil.init(haPaylogList, "月报表数据");
        }
        return null;
    }

    /**
     * 月报表的查询
     *
     * @param haPaylog
     * @return
     */
    @RequestMapping(value = "/pay/ybb/showMonthReportList")
    @ResponseBody
    public Object showHaMonthReportList(HaPaylog haPaylog) {

        startPage();
        List<HaPaylog> haPaylogList = haPaylogService.selectMonthReportList(haPaylog);

        Map<String, Object> map = getDataTable(haPaylogList);//获取月报表总记录数

        if (map != null) {
            return map;
        }
        return null;
    }

    //点击打印缴费单的事件
    @RequestMapping("/bill_print")
    public String billPrint(HaPaylog haPaylog, HaFreeze haFreeze, Model model) {
        //检测字符串是否包含逗号
        boolean b = haPaylog.getBillId().contains(",");
        //包含返回true
        if (b == true) {
            //拆分字符根绝逗号
            String[] split = haPaylog.getBillId().split(",");
            List<String> xhlist = new ArrayList<>();
            //进行循环添加
            for (int i = 0; i < split.length; i++) {
                xhlist.add(split[i]);
            }
            haPaylog.setBillIdsList(xhlist);
            haPaylog.setBillId(null);
        }
        //查询上面的table
        List<HaPaylog> haPaylogList = haPaylogService.BselectPritJiaoFeiDan1(haPaylog);
        HaFreeze bselectPritJiaoFeiDan2 = null;//全局变量
        //进行循环添加子list
        for (int i = 0; i < haPaylogList.size(); i++) {
            haFreeze.setBillId(haPaylogList.get(i).getBillId());
            bselectPritJiaoFeiDan2 = haFreezeService.BselectPritJiaoFeiDan2(haFreeze);
            //对其进行循环录入
            haPaylogList.get(i).setHaFreeze(bselectPritJiaoFeiDan2);
        }
        if (haPaylogList != null && bselectPritJiaoFeiDan2 != null) {
            model.addAttribute("haPaylogList", haPaylogList);
            model.addAttribute("bselectPritJiaoFeiDan2", bselectPritJiaoFeiDan2);
            Map<String, Object> hh = new HashMap<String, Object>();
            hh.put("haPaylogList", haPaylogList);
            hh.put("bselectPritJiaoFeiDan2", bselectPritJiaoFeiDan2);
            return "pay/bill_print.html";
        }

        return null;
    }

    /**
     * 导出月报表txt文件格式
     *
     * @param haPaylog
     * @param name
     * @return
     */
    @PostMapping("/derived_readinfo_to_txt")
    @ResponseBody
    public AjaxResult exportPhones(HaPaylog haPaylog, @RequestParam(value = "name[]") String[] name) {

        List<HaPaylog> haPaylogList = haPaylogService.selectMonthReportList(haPaylog);
        String fileName = ExportStr.encodingFileTxtname();
        ExportTxtUtil exportTextUtil = new ExportTxtUtil();
        try {
            exportTextUtil.writeToTxt(fileName, haPaylogList, name);
            return AjaxResult.success(fileName);
        } catch (IOException e) {
            e.printStackTrace();
            return AjaxResult.error(e.getMessage());
        }

    }

}
