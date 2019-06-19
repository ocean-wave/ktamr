package com.ktamr.account.pay;

import com.ktamr.common.utils.file.ImportService;
import com.ktamr.domain.HatBalanceimport;
import com.ktamr.service.HatBalanceimportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

@Controller
public class HatBalanceimportController {

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
    public String cust_balance_import_todo(@RequestParam("userInfo") MultipartFile file, HatBalanceimport hatBalanceimport) throws Exception {
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
            int Code = (int)a1;
            String userCode = String.valueOf(Code);//获取用户编号
            String userName = lo.get(1).toString();//获取用户名称
            float a2=Float.parseFloat(lo.get(2).toString());
            int meterNumber = (int)a2;//获取表号
            float a3=Float.parseFloat(lo.get(3).toString());
            int balance = (int)a3;//获取余额
            System.out.println("您好，请看，用户编号:"+userCode+",用户名称:"+userName+",表号:"+meterNumber+"，余额:"+balance);
            hatBalanceimport.setUserCode(userCode);
            hatBalanceimport.setUserName(userName);
            hatBalanceimport.setMeterNumber(meterNumber);
            hatBalanceimport.setBalance(balance);
            Date importTime=new Date();
            hatBalanceimport.setImportTime(importTime);
            try {
                Integer integer = hatBalanceimportService.insertHatBalanceimport(hatBalanceimport);
            } catch (Exception e) {
                System.out.println("对不起，添加不成功！！！" +e.getMessage());
                e.printStackTrace();
                return "false";
            }


        }


        return null;
    }
}
