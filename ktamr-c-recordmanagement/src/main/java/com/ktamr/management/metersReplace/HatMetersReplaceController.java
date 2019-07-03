package com.ktamr.management.metersReplace;

import com.ktamr.common.core.domain.BaseController;
import com.ktamr.common.utils.DateUtils;
import com.ktamr.common.utils.imports.ImportExcelUtil;
import com.ktamr.domain.HatMetersreplace;
import com.ktamr.service.HatMetersReplaceService;
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
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/metersReplace")
public class HatMetersReplaceController extends BaseController {

    @Resource
    private HatMetersReplaceService hatMetersReplaceService;

    @RequestMapping("/meters_replace")
    public String meter_replace(){
        return "area/meters_replace";
    }

    @RequestMapping("/meters_replace_todo")
    @ResponseBody
    public Object device_upload_todo(@RequestParam("userInfo") MultipartFile file, ImportExcelUtil importExcelUtil, HatMetersreplace hatMetersreplace) throws Exception {
        if (file.isEmpty()) {
            return "false";
        }
        String fileName = file.getOriginalFilename();//获取文件夹名字
        if (fileName.indexOf("xls") < 0) {
            return "上传文件类型不符合要求，请确定是 (.xls/.xlsx)后缀的Excel 文件";
        }
        InputStream inputStream = file.getInputStream();//获取File
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = DateUtils.getTime();
        Date importTime = sdf.parse(dateString);
        String[] nonEmptyCell = new String[]{"3","5","6","7","8"};//如果excel模板有*号的坐标位置
        List<Map<String,Object>> list2 = importExcelUtil.init(inputStream,dateString,nonEmptyCell);//获取excel里面的信息
        try {
            hatMetersReplaceService.addHatMetersReplace(list2);
            hatMetersreplace = new HatMetersreplace();
            hatMetersreplace.setImportTime(sdf.parse(dateString));//重新的设值
            hatMetersReplaceService.exportCustomNoCheck1(hatMetersreplace);
            hatMetersReplaceService.exportCustomNoCheck2(hatMetersreplace);
            hatMetersReplaceService.exportArchivesMeterNumCheck1(hatMetersreplace);
            hatMetersReplaceService.exportArchivesMeterNumCheck2(hatMetersreplace);
            hatMetersReplaceService.exportArchivesMeterNumCheck3(hatMetersreplace);
            hatMetersReplaceService.exportArchivesMeterNumCheck4(hatMetersreplace);
            hatMetersReplaceService.exportArchivesMeterNumCheck5(hatMetersreplace);
            hatMetersReplaceService.matchCustomNo(hatMetersreplace);
            hatMetersReplaceService.matchOldMeterNo(hatMetersreplace);
            hatMetersReplaceService.makeUpDefaultNum(hatMetersreplace);
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

    @RequestMapping("/meters_replace_list")
    public String meters_replace_list(HatMetersreplace hatMetersreplace, String fileName, Model model) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String importTime = sdf.format(hatMetersreplace.getImportTime());
        Integer allrows = hatMetersReplaceService.allrows(hatMetersreplace); //总条目
        Integer replaces = hatMetersReplaceService.replaces(hatMetersreplace); //待换数
        Integer errors = allrows - replaces; //错误数
        String msg = "总条目:" + allrows + ", 待换数:" + replaces + ", 出错数:" + errors;
        model.addAttribute("fileName", fileName);
        model.addAttribute("importTime", importTime);
        model.addAttribute("allrows", allrows);
        model.addAttribute("replaces", replaces);
        model.addAttribute("errors", errors);
        model.addAttribute("msg", msg);
        return "area/meters_replace_list";
    }

    @RequestMapping("/ImportReplacementList")
    @ResponseBody
    public Object importReplacementList(HatMetersreplace hatMetersreplace) throws ParseException {
        startPage();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = sdf.format(hatMetersreplace.getImportTime());
        sdf.parse(time);
        List<HatMetersreplace> hatMetersreplaces = hatMetersReplaceService.HatMetersReplaceList(hatMetersreplace);
        Map<String, Object> map = getDataTable(hatMetersreplaces);
        if (map != null) {
            return map;
        }
        return null;
    }

    @RequestMapping("/meters_replace_do")
    @ResponseBody
    public Object device_upload_do(HatMetersreplace hatMetersreplace, @RequestParam("msg") String msg, @RequestParam("fileName") String fileName, HttpSession session,@RequestParam("op") String op){
        String operatorCode = (String)session.getAttribute("operatorCode");
        if(op.equals("sure")){
            try {
                hatMetersReplaceService.addBatchChangeMeter(fileName,operatorCode,msg);
                hatMetersReplaceService.addOldMeterLastMeterRead(hatMetersreplace);
                hatMetersReplaceService.addOldMeterLastDayFrozen1(hatMetersreplace);
                hatMetersReplaceService.addOldMeterLastDayFrozen2(hatMetersreplace);
                hatMetersReplaceService.addOldMeterLastDayFrozen3(hatMetersreplace);
                hatMetersReplaceService.addOldMeterLastMonthFrozen1(hatMetersreplace);
                hatMetersReplaceService.addOldMeterLastMonthFrozen2(hatMetersreplace);
                hatMetersReplaceService.addOldMeterLastMonthFrozen3(hatMetersreplace);
                hatMetersReplaceService.changeMeter(hatMetersreplace);
                hatMetersReplaceService.addChangeMeterNote(hatMetersreplace);
                hatMetersReplaceService.finishChangeMeter(hatMetersreplace);
                hatMetersReplaceService.deleteHatMetersReplace(hatMetersreplace);
            } catch (Exception e) {
                e.printStackTrace();
                return "执行不成功，异常信息是"+e.getMessage();
            }
            return "true";
        }else {
            try {
                hatMetersReplaceService.deleteHatMetersReplace(hatMetersreplace);
            } catch (Exception e) {
                e.printStackTrace();
                return "执行不成功，异常信息是"+e.getMessage();
            }
            return "取消导入";
        }
    }


}
