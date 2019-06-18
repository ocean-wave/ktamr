package com.ktamr.account.pay;


import com.ktamr.common.core.domain.AjaxResult;
import com.ktamr.common.core.domain.BaseController;
import com.ktamr.common.utils.export.ExportExcelUtil;
import com.ktamr.domain.HaBillrecords;
import com.ktamr.domain.HaCustom;
import com.ktamr.service.HaBillrecordsService;
import com.ktamr.service.HaCustomService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Controller
public class HaCustomController extends BaseController {

    @Resource
    private HaCustomService haCustomService;
    @Resource
    private HaBillrecordsService haBillrecordsService;


    /**
     * 打开用户账户页面
     *
     * @return
     */
    @RequestMapping("pay/cust_balance_list.html")
    public String showCust_balance_list() {
        return "pay/cust_balance_list.html";
    }

    /**
     * 查询用户账户列表
     *
     * @param haCustom
     * @return
     */
    @RequestMapping("/pay/yhzh/queryHaCustomList")
    @ResponseBody
    public Object queryHaCustomList(HaCustom haCustom) {
        startPage();
        //通过方法返回一波
        List<HaCustom> haCustomList = haCustomService.queryHaCustomListB(haCustom);
        Map<String, Object> map = getDataTable(haCustomList);//获取用户账户列表记录
        if (map != null) {
            return map;
        }
        return null;
    }

    /**
     * 收费记录导出
     *
     * @param haCustom
     * @param exportExcelUtil
     * @return
     */
    @PostMapping("/pay/yhzh/export")
    @ResponseBody
    public AjaxResult ybbexport(HaCustom haCustom, ExportExcelUtil exportExcelUtil) {
        //这里保证查询的是全部的数据
        List<HaCustom> haCustomList = haCustomService.queryHaCustomListB(haCustom);
        if (haCustomList != null) {
            return exportExcelUtil.init(haCustomList, "月报表数据");
        }
        return null;
    }

    /**
     * 此方法用于查询用户账户中的预存费用,并打开费用查询页面
     *
     * @param haCustom
     * @return
     */
    @RequestMapping("/opencust_bill_operation")
    public String testYuCunFeiYong(HaCustom haCustom, Model model) {
        HaCustom yuCunFeiYong = haCustomService.selectYuCunFeiYongB(haCustom);
        if (yuCunFeiYong != null) {
            model.addAttribute("HaCustomYuCunHuaFei", yuCunFeiYong);//存放数据
            return "pay/cust_bill_operation.html";
        }
        return null;
    }

    /**
     * 预存费用的实现
     *
     * @return 根据返回值 返回Layer输出的东东
     */
    @RequestMapping("/cust_bill_operation_do")
    @ResponseBody
    public String cust_bill_operation_do(HaCustom haCustom, HaBillrecords haBillrecords) {
        if (haBillrecords.getOptType().equals("恢复收费")) {
            String s = haBillrecordsService.selectShiFou(haBillrecords);
            if (s.equals("true")) {
                return "超过可恢复收费";
            }
        }
        //先更新一波
        Integer updateYuCunFeiYong = haCustomService.updateYuCunFeiYongB(haCustom);
        //再添加一波
        Integer insertHaBillrecords = haBillrecordsService.insertHaBillrecords(haBillrecords);
        //如果两数返回值是1+1=2的情况下就返回true即返回成功
        if (updateYuCunFeiYong + insertHaBillrecords == 2) {
            return "true";
        }
        return "操作失败";
    }

    /**
     * 打开用户账户列表 并存值
     *
     * @param haCustom
     * @param model
     * @return
     */
    @RequestMapping("/cust_bill_list2")
    public String cust_bill_list2(HaCustom haCustom, Model model) {

        HaCustom yuCunFeiYong = haCustomService.selectYuCunFeiYongB(haCustom);
        if (yuCunFeiYong != null) {
            model.addAttribute("HaCustomYuCunHuaFei", yuCunFeiYong);//存放数据
            return "pay/cust_bill_list2.html";
        }
        return null;
    }


}
