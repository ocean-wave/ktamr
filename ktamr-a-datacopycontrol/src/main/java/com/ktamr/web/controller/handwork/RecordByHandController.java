package com.ktamr.web.controller.handwork;

import com.ktamr.ShiroUtils;
import com.ktamr.common.core.domain.AjaxResult;
import com.ktamr.common.core.domain.BaseController;
import com.ktamr.common.utils.DateUtils;
import com.ktamr.common.utils.export.ExportExcelUtil;
import com.ktamr.common.utils.file.FileUploadUtils;
import com.ktamr.common.utils.imports.ImportExcelUtil;
import com.ktamr.common.utils.imports.ImportUtil;
import com.ktamr.common.utils.sql.SqlCondition;
import com.ktamr.domain.HaCentor;
import com.ktamr.domain.HaMeter;
import com.ktamr.domain.HaRecords;
import com.ktamr.domain.HatMetersRecordImport;
import com.ktamr.service.*;
import com.ktamr.service.HaCmdService;
import com.ktamr.service.HaDayFreezeService;
import com.ktamr.service.HaMeterService;
import com.ktamr.service.HaRecordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/handwork")
public class RecordByHandController extends BaseController {
    private  String pxePath = "area";

    @Autowired
    private HaMeterService haMeterService;

    @Autowired
    private HaCmdService haCmdService;

    @Autowired
    private HaRecordsService haRecordsService;

    @Autowired
    private HaDayFreezeService haDayFreezeService;

    @Autowired
    private HaMonFreezeService haMonFreezeService;

    @Autowired
    private HatMetersRecordImportService hatMetersRecordImportService;


    @GetMapping("/byHand")
    public String deviceTrans(ModelMap mmap){
        mmap.put("nowStr", DateUtils.getTime());
        return pxePath+"/recordByHand";
    }

    @GetMapping("/metersRecordImport")
    public String metersRecordImport(ModelMap mmap){
        return pxePath+"/metersRecordImport";
    }

    @GetMapping("/metersRecordImportList")
    public String metersRecordImportList(ModelMap mmap,@RequestParam("fileName") String fileName
                                                      ,@RequestParam("importTime") String importTime){
        Map<String,Object> map = new HashMap<>();
        map.put("parameterType","importTime");
        map.put("importTime",DateUtils.dateTime("yyyy-MM-dd HH:mm:ss",importTime));
        Integer allrows = hatMetersRecordImportService.selectMetersRecordImportCount(map);
        map.put("parameterType","checkResultAndImportTime");
        Integer imports = hatMetersRecordImportService.selectMetersRecordImportCount(map);

        Integer errors = allrows-imports;
        String msgTitle = "总条目:<b>"+allrows+"</b>, 待导入数:<b><font color='green'>"+imports+"</font></b>, 出错数:<b><font color='red'>"+errors+"</font></b> (说明:点击确定才完成导入)";
        String msg = "总条目:"+allrows+", 待导入数:"+imports+", 出错数:"+errors;
        mmap.put("msgTitle",msgTitle);
        mmap.put("msg",msg);
        mmap .put("fileName",fileName);
        mmap.put("importTime",importTime);
        mmap.put("errors",errors);
        return pxePath+"/metersRecordImportList";
    }

    @PostMapping("/recordByHandJson")
    @ResponseBody
    public Map<String, Object> interfaceCmdListJson(HaMeter params){
        startPage();
        params.getParams().put("getRightCondition", SqlCondition.getRightCondition("a.areano","area","and"));
        List<HaMeter> listMeter = haMeterService.selectRecordByHand(params);
        return getDataTable(listMeter);
    }

    @PostMapping("/metersRecordImportListJson")
    @ResponseBody
    public Map<String, Object> metersRecordImportListJson(@RequestParam("importTime") String importTime){
        startPage();
        List<HatMetersRecordImport> list = hatMetersRecordImportService.selectMetersRecordImportByImportTime(importTime);
        return getDataTable(list);
    }

    @PostMapping("/RowEditing")
    @ResponseBody
    public String RowEditing(HaMeter haMeter){
        haMeter.getParams().put("nowStr",DateUtils.getNowDate());
        haMeter.getParams().put("operatorCode", ShiroUtils.getOperatorCode());
        Integer meterId = haCmdService.insertCmdTwo(haMeter);
        Integer itemId = haRecordsService.insertRecords(haMeter);
        Integer dayCount = haDayFreezeService.selectDayFreezeMeterIdCount(haMeter);
        if(dayCount>0){
            haDayFreezeService.updateDayFreeze(haMeter);
        }else{
            haDayFreezeService.insertDayFreeze(haMeter);
        }
        Integer MonCount = haMonFreezeService.selectMonFreezeMeterIdCount(haMeter);
        if(MonCount > 0){
            haMonFreezeService.updateMonFreeze(haMeter);
        }else{
            haMonFreezeService.insertMonFreeze(haMeter);
        }
        haMeterService.updateMeter(haMeter);
        return "true";
    }

    @RequestMapping("/metersRecordImportTwo")
    @ResponseBody
    public String metersRecordImportTwo(MultipartFile userInfo){
        ImportExcelUtil importExcelUtil = new ImportExcelUtil();
        List<Map<String,Object>> list = new ArrayList<>();
        String dateString = DateUtils.getTime();
        String[] nonEmptyCell = new String[]{"1","3"};
        try {
            ImportUtil.fileNameExcel(userInfo.getOriginalFilename());
            FileUploadUtils.upload(userInfo,userInfo.getOriginalFilename());
            list = importExcelUtil.init(userInfo.getInputStream(),dateString,nonEmptyCell);
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
        if(list.size()>0) {
            try {
                hatMetersRecordImportService.insertMetersRecordImport(list);
            }catch (Exception e){
                e.printStackTrace();
                return "请检查Excel里的值,对应各个值";
            }
        }
        hatMetersRecordImportService.updateMetersRecordImport(dateString);
        hatMetersRecordImportService.updateMetersRecordImportTwo(dateString);
        hatMetersRecordImportService.updateMetersRecordImportThree(dateString);
        return dateString;
    }

    @RequestMapping("/metersRecordImportThree")
    @ResponseBody
    public String metersRecordImportThree(@RequestParam("msg") String msg
                                          ,@RequestParam("fileName") String fileName
                                          ,@RequestParam("importTime") String importTime
                                          ,@RequestParam("op") String op){
        if("sure".equals(op)){
            Map<String,Object> map = new HashMap<>();
            map.put("fileName",fileName);
            map.put("msg",msg);
            map.put("operatorCode",ShiroUtils.getOperatorCode());
            map.put("importTime",importTime);
            try {
                haCmdService.insertCmdTwo2(map);
                haRecordsService.insertRecordsTwo(map);
                haDayFreezeService.updateDayFreezeTwo(importTime);
                haDayFreezeService.insertDayFreezeTwo(importTime);
                haMonFreezeService.updateMonFreezeTwo(importTime);
                haMonFreezeService.insertMonFreezeTwo(importTime);
                haMeterService.updateMeterTwo(importTime);
                hatMetersRecordImportService.deleteMetersRecordImport(importTime);
            }catch (Exception e){
                return "导入失败,请联系管理员";
            }
            return "true";
        }else {
            try {
                hatMetersRecordImportService.deleteMetersRecordImport(importTime);
            }catch (Exception e){
                return "删除失败,请联系管理员";
            }
            return "取消导入";
        }
    }

    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HaMeter params,@RequestParam(value = "importTime",required = false) String importTime, ExportExcelUtil exportExcelUtil)
    {
        List<HaMeter> list = null;
        List<HatMetersRecordImport> list2 = null;
        if(params.getParams().get("exportType").equals("1")){
            params.getParams().put("getRightCondition", SqlCondition.getRightCondition("a.areano","area","and"));
            list =  haMeterService.selectRecordByHand(params);
            return exportExcelUtil.init(list, "");
        }else{
            list2 =  hatMetersRecordImportService.selectMetersRecordImportByImportTime(importTime);
            return exportExcelUtil.init(list2, "");
        }
    }
}
