package com.ktamr.account.pay;


import com.ktamr.common.core.domain.AjaxResult;
import com.ktamr.common.core.domain.BaseController;
import com.ktamr.common.utils.export.ExportExcelUtil;
import com.ktamr.common.utils.file.ImportService;
import com.ktamr.domain.HaBillrecords;
import com.ktamr.domain.HaCustom;
import com.ktamr.service.HaBillrecordsService;
import com.ktamr.service.HaCustomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

@Controller
public class HaCustomController extends BaseController {

    @Resource
    private HaCustomService haCustomService;
    @Resource
    private HaBillrecordsService haBillrecordsService;
    @Autowired
    private ImportService importService;

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


    /**
     * 用户账户导入余额上传判断
     * @param file
     * @return
     */
    @RequestMapping("/cust_balance_import_todo")
    @ResponseBody
    public String cust_balance_import_todo( @RequestParam("userInfo") MultipartFile file) throws Exception {
        if(file.isEmpty()){
            return "false";
        }
        String fileName = file.getOriginalFilename();//获取文件夹名字
        if(fileName.indexOf("xls")<0){
            return "上传文件类型不符合要求，请确定是 (.xls/.xlsx)后缀的Excel 文件";//
        }
        //List<List<Object>> list = ReadExcel.readExcel(file);
        InputStream inputStream = file.getInputStream();
        List<List<Object>> list = importService.getBankListByExcel(inputStream, file.getOriginalFilename());
        inputStream.close();
        for (int i = 0; i < list.size(); i++) {
            List<Object> lo = list.get(i);

            float a1=Float.parseFloat(lo.get(0).toString());
            int userCode = (int)a1;//获取用户编号
            String userName = lo.get(1).toString();//获取用户名称
            float a2=Float.parseFloat(lo.get(2).toString());
            int meterNumber = (int)a2;//获取表号
            float a3=Float.parseFloat(lo.get(3).toString());
            int balance = (int)a3;//获取余额

            System.out.println("您好，请看，用户编号:"+userCode+",用户名称:"+userName+",表号:"+meterNumber+"，余额:"+balance);






        }


        return null;
    }


}
