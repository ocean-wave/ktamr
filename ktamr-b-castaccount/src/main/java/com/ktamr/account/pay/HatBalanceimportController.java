package com.ktamr.account.pay;

import com.alibaba.fastjson.JSON;
import com.ktamr.common.core.domain.BaseController;
import com.ktamr.common.utils.file.ImportService;
import com.ktamr.domain.HatBalanceimport;
import com.ktamr.service.HatBalanceimportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
public class HatBalanceimportController extends BaseController {

    @Autowired
    private HatBalanceimportService hatBalanceimportService;
    @Autowired
    private ImportService importService;


    /**
     * 用户账户导入余额上传判断
     * @param file
     * @return
     */
    @RequestMapping("/cust_balance_import_todo")
    @ResponseBody
    public Object cust_balance_import_todo(@RequestParam("userInfo") MultipartFile file, HatBalanceimport hatBalanceimport) throws Exception {
        if (file.isEmpty()) {
            return "false";
        }
        String fileName = file.getOriginalFilename();//获取文件夹名字
        if (fileName.indexOf("xls") < 0) {
            return "上传文件类型不符合要求，请确定是 (.xls/.xlsx)后缀的Excel 文件";//
        }

        InputStream inputStream = file.getInputStream();
        List<List<Object>> list = importService.getBankListByExcel(inputStream, file.getOriginalFilename());//读取excel中的数据
        inputStream.close();
        Date date = new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time= sdf.format( date);
        Date importTime=sdf.parse(time);
        for (int i = 0; i < list.size(); i++) {
            List<Object> lo = list.get(i);
            float a1 = Float.parseFloat(lo.get(0).toString());
            int Code = (int) a1;
            String userCode = String.valueOf(Code);//获取用户编号
            String userName = lo.get(1).toString();//获取用户名称
            float a2 = Float.parseFloat(lo.get(2).toString());
            int meterNumber = (int) a2;//获取表号
            float a3 = Float.parseFloat(lo.get(3).toString());
            int balance = (int) a3;//获取余额
            //System.out.println("您好，请看，用户编号:" + userCode + ",用户名称:" + userName + ",表号:" + meterNumber + "，余额:" + balance);
            hatBalanceimport.setUserCode(userCode);
            hatBalanceimport.setUserName(userName);
            hatBalanceimport.setMeterNumber(meterNumber);
            hatBalanceimport.setBalance(balance);
            hatBalanceimport.setImportTime(importTime);
            try {
                Integer integer = hatBalanceimportService.insertHatBalanceimport(hatBalanceimport);
                hatBalanceimport = new HatBalanceimport();//重新new一下
                hatBalanceimport.setImportTime(importTime);//重新的设值
                Integer UserNumberCheck1 = hatBalanceimportService.UserNumberCheck1(hatBalanceimport);
                Integer UserNumberCheck2 = hatBalanceimportService.UserNumberCheck2(hatBalanceimport);
                Integer TableNumberCheck1 = hatBalanceimportService.TableNumberCheck1(hatBalanceimport);
                Integer TableNumberCheck2 = hatBalanceimportService.TableNumberCheck2(hatBalanceimport);
                Integer MatchingUserNumber = hatBalanceimportService.MatchingUserNumber(hatBalanceimport);
                Integer Matchingtablenumber = hatBalanceimportService.Matchingtablenumber(hatBalanceimport);
                Integer CheckBalance = hatBalanceimportService.CheckBalance(hatBalanceimport);
            } catch (Exception e) {
                System.out.println("对不起，操作不成功！！！错误信息是" + e.getMessage());
                e.printStackTrace();
                return "false";
            }
        }
        Calendar ca = Calendar.getInstance();//之所以要转成Calendar对象，是因为Date的getXXX()方法废弃了。。。
        ca.setTime(importTime);
        return ca.get(Calendar.YEAR) + "-" + (ca.get(Calendar.MONTH)+1) + "-" + ca.get(Calendar.DATE)
                + " " + ca.get(Calendar.HOUR_OF_DAY) + ":" + ca.get(Calendar.MINUTE) + ":" + ca.get(Calendar.SECOND);
    }

    /**
     * 打开用户余额确认列表
     * @return
     */
    @RequestMapping("/cust_balance_import_list")
    public String showcust_balance_import_list(HatBalanceimport hatBalanceimport, Model model){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String importTime= sdf.format( hatBalanceimport.getImportTime());

        String fileName = hatBalanceimport.getFileName();
        Integer selectAllrows = hatBalanceimportService.selectAllrows(hatBalanceimport);
        Integer selectImports = hatBalanceimportService.selectImports(hatBalanceimport);
        Integer errors = selectAllrows - selectImports;
        String msgTitle = "总条目:<b>"+selectAllrows+"</b>, 待导入数:<b><font color='green'>"+selectImports+"</font></b>, 出错数:<b><font color='red'>"+errors+"</font></b> (说明:点击确定才完成换表)";
        String msg = "总条目:"+selectAllrows+", 待导入数:"+selectImports+", 出错数:"+errors;
        model.addAttribute("fileName",fileName);
        model.addAttribute("importTime",importTime);
        model.addAttribute("selectAllrows",selectAllrows);
        model.addAttribute("selectImports",selectImports);
        model.addAttribute("errors",errors);
        model.addAttribute("msgTitle",msgTitle);
        model.addAttribute("msg",msg);
        return "pay/cust_balance_import_list.html";
    }

    @RequestMapping("/selectCustBalanceImportDo")
    @ResponseBody
    public Object selectCustBalanceImportDo(HatBalanceimport hatBalanceimport) throws ParseException {
        startPage();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time= sdf.format( hatBalanceimport.getImportTime());
        sdf.parse(time);
        List<HatBalanceimport> hatBalanceimportList = hatBalanceimportService.selectCustBalanceImportList(hatBalanceimport);
        Map<String, Object> map = getDataTable(hatBalanceimportList);
        if (map != null) {
            return map;
        }
        return null;
    }

}