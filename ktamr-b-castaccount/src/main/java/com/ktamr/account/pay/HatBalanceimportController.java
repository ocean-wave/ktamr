package com.ktamr.account.pay;

import com.alibaba.fastjson.JSON;
import com.ktamr.common.core.domain.BaseController;
import com.ktamr.common.utils.DateUtils;
import com.ktamr.common.utils.file.ImportService;
import com.ktamr.common.utils.imports.ImportExcelUtil;
import com.ktamr.domain.HaCmd;
import com.ktamr.domain.HatBalanceimport;
import com.ktamr.service.HaCmdService;
import com.ktamr.service.HaCustomService;
import com.ktamr.service.HatBalanceimportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class HatBalanceimportController extends BaseController {

    @Autowired
    private HatBalanceimportService hatBalanceimportService;
    @Autowired
    private ImportService importService;
    @Autowired
    private HaCmdService haCmdService;


    /**
     * 用户账户导入余额上传判断
     *
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
        //Map<Integer, Object> map = importService.getBankListByExcel(inputStream, file.getOriginalFilename());//读取excel中的数据
        //List list = importService.getBankListByExcel(inputStream, file.getOriginalFilename());
        //inputStream.close();
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String dateString = DateUtils.getTime();
        Date importTime = sdf.parse(dateString);
        ImportExcelUtil importExcelUtil = new ImportExcelUtil();
        List<Map<String,Object>> list2 = new ArrayList<>();

        String[] nonEmptyCell = new String[]{"1","3"};
        list2 = importExcelUtil.init(inputStream,dateString,nonEmptyCell);
        //List<Object> lo = list.get(i);

            try {
                Integer integer = hatBalanceimportService.insertHatBalanceimport(list2);
                hatBalanceimport = new HatBalanceimport();//重新new一下
                hatBalanceimport.setImportTime(sdf.parse(dateString));//重新的设值
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

        Calendar ca = Calendar.getInstance();//之所以要转成Calendar对象，是因为Date的getXXX()方法废弃了。。。
        ca.setTime(importTime);
        return ca.get(Calendar.YEAR) + "-" + (ca.get(Calendar.MONTH) + 1) + "-" + ca.get(Calendar.DATE)
                + " " + ca.get(Calendar.HOUR_OF_DAY) + ":" + ca.get(Calendar.MINUTE) + ":" + ca.get(Calendar.SECOND);
    }

    /**
     * 打开用户余额确认列表
     *
     * @return
     */
    @RequestMapping("/cust_balance_import_list")
    public String showcust_balance_import_list(HatBalanceimport hatBalanceimport, Model model) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String importTime = sdf.format(hatBalanceimport.getImportTime());

        String fileName = hatBalanceimport.getFileName();
        Integer selectAllrows = hatBalanceimportService.selectAllrows(hatBalanceimport);
        Integer selectImports = hatBalanceimportService.selectImports(hatBalanceimport);
        Integer errors = selectAllrows - selectImports;
        String msgTitle = "总条目:<b>" + selectAllrows + "</b>, 待导入数:<b><font color='green'>" + selectImports + "</font></b>, 出错数:<b><font color='red'>" + errors + "</font></b> (说明:点击确定才完成换表)";
        String msg = "总条目:" + selectAllrows + ", 待导入数:" + selectImports + ", 出错数:" + errors;
        model.addAttribute("fileName", fileName);
        model.addAttribute("importTime", importTime);
        model.addAttribute("selectAllrows", selectAllrows);
        model.addAttribute("selectImports", selectImports);
        model.addAttribute("errors", errors);
        model.addAttribute("msgTitle", msgTitle);
        model.addAttribute("msg", msg);
        return "pay/cust_balance_import_list.html";
    }

    /**
     * 查询用户余额确认列表
     *
     * @param hatBalanceimport
     * @return
     * @throws ParseException
     */
    @RequestMapping("/selectCustBalanceImportDo")
    @ResponseBody
    public Object selectCustBalanceImportDo(HatBalanceimport hatBalanceimport) throws ParseException {
        startPage();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = sdf.format(hatBalanceimport.getImportTime());
        sdf.parse(time);
        List<HatBalanceimport> hatBalanceimportList = hatBalanceimportService.selectCustBalanceImportList(hatBalanceimport);
        Map<String, Object> map = getDataTable(hatBalanceimportList);
        if (map != null) {
            return map;
        }
        return null;
    }

    /**
     * 批量导入
     * @param hatBalanceimport
     * @param msg
     * @param op
     * @return
     */
    @RequestMapping("/cust_balance_import_do")
    @ResponseBody
    public String cust_balance_import_do(HatBalanceimport hatBalanceimport, HaCmd haCmd, @RequestParam("msg") String msg,
                                         @RequestParam("op") String op, HttpSession session
                                         ) {
        if (op.equals("sure") ) {
            Object attribute = session.getAttribute("operatorCode");
            haCmd.setParms(hatBalanceimport.getFileName());
            haCmd.setUid(String.valueOf(attribute));
            haCmd.setProcessing(msg);
            try {
                //插入一条批量导入余额的命令
                Integer insertCommand = haCmdService.insertCommand(haCmd);
                //修改用户余额
                Integer integermodifyUserBalance = hatBalanceimportService.modifyUserBalance(hatBalanceimport);
                //执行完清理零时表
                Integer cleanupTemporaryTables = hatBalanceimportService.cleanupTemporaryTables(hatBalanceimport);
            } catch (Exception e) {
                e.printStackTrace();
                return "执行不成功，异常信息是"+e.getMessage();
            }
            return "true";
        } else {
            try {
                Integer cleanupTemporaryTables = hatBalanceimportService.cleanupTemporaryTables(hatBalanceimport);
            } catch (Exception e) {
                e.printStackTrace();
                return "执行不成功，异常信息是"+e.getMessage();
            }
            return "取消导入";
        }

    }

}
