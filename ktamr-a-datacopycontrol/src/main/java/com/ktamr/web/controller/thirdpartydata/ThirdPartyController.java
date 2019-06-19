package com.ktamr.web.controller.thirdpartydata;

import com.ktamr.common.core.domain.AjaxResult;
import com.ktamr.common.core.domain.BaseController;
import com.ktamr.common.utils.ServletUtils;
import com.ktamr.common.utils.export.*;
import com.ktamr.domain.HavMeterinfo;
import com.ktamr.service.HaOperatorService;
import com.ktamr.service.HavMeterinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/thirdpartydata")
public class ThirdPartyController extends BaseController {
    private  String pxePath = "interface";

    @Autowired
    private HavMeterinfoService havMeterinfoService;

    @Autowired
    private HaOperatorService haOperatorService;

    @GetMapping("/party")
    public String party(ModelMap mmap){
        String id = (String) ServletUtils.getSession().getAttribute("operatorCode");
        mmap.put("operatorCompnayList",haOperatorService.selectOperatorCompany(id));
        return pxePath+"/thirdPartyReport";
    }

    @GetMapping("/usersUpload")
    public String usersUpload(){
        return pxePath+"/usersUpload";
    }

    @GetMapping("/dataUpload")
    public String dataUpload(){
        return pxePath+"/interfaceDataUpload";
    }

    @PostMapping("/thirdPartyReportJson")
    @ResponseBody
    public Map<String, Object> interfaceCmdListJson(HavMeterinfo havMeterinfo){
        startPage();
        List<HavMeterinfo> listMeterinfo = havMeterinfoService.selectThirdParty(havMeterinfo);
        return getDataTable(listMeterinfo);
    }

    @PostMapping("/exportToTxt")
    @ResponseBody
    public AjaxResult exportToTxt(HavMeterinfo havMeterinfo,@RequestParam( value = "name[]") String[] name){
        List<HavMeterinfo> listMeterinfo = havMeterinfoService.selectThirdParty(havMeterinfo);
        String fileName = ExportStr.encodingFileTxtname();
        ExportTxtUtil exportTextUtil = new ExportTxtUtil();
        try {
            exportTextUtil.writeToTxt(fileName,listMeterinfo,name);
            return AjaxResult.success(fileName);
        } catch (IOException e){
            e.printStackTrace();
            return AjaxResult.error(e.getMessage());
        }
    }

    @PostMapping("/exportToDbf")
    @ResponseBody
    public AjaxResult exportToDbf(HavMeterinfo havMeterinfo,@RequestParam( value = "name[]") String[] name){
        List<HavMeterinfo> listMeterinfo = havMeterinfoService.selectThirdParty(havMeterinfo);
        String showListType = havMeterinfo.getParams().get("showListType").toString();
        String[] dbfLabel = new String[]{};
        Integer[] dbfWidth = new Integer[]{};
        String[] format = new String[]{};
        if("sys_zjss".equals(showListType)){
            dbfLabel = new String[]{"USERNO","METERNO","DIZHI","READNUM","READDATE"};
            dbfWidth = new Integer[]{20,20,20,20,8};
            format = new String[]{"CHARACTER","CHARACTER","CHARACTER","CHARACTER","DATE"};
        }else if("sys_gdsg".equals(showListType)){
            dbfLabel = new String[]{"A","B","C","D","E","F","G","H","I","J","K","L","N","M","O","P","Q","R"};
            dbfWidth = new Integer[]{10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,8,10};
            format = new String[]{"CHARACTER","CHARACTER","CHARACTER","CHARACTER","CHARACTER","CHARACTER","CHARACTER","CHARACTER","CHARACTER","CHARACTER","CHARACTER","CHARACTER","CHARACTER","CHARACTER","CHARACTER","CHARACTER","DATE","CHARACTER"};
        }else if("sys_jlhd".equals(showListType)){
            dbfLabel = new String[]{"USERID","CURDATA","READDATE","SUCCFLAG"};
            dbfWidth = new Integer[]{10,10,8,10};
            format = new String[]{"CHARACTER","CHARACTER","DATE","CHARACTER"};
        }
        ExportDbfUtil exportDbfUtil = new ExportDbfUtil();
        exportDbfUtil.setDbfLabel(dbfLabel);
        exportDbfUtil.setDbfWidth(dbfWidth);
        exportDbfUtil.setFormar(format);
        exportDbfUtil.setDbfName(name);
        try {
            return exportDbfUtil.init(listMeterinfo);
        } catch (Exception e){
            e.printStackTrace();
            return AjaxResult.error(e.getMessage());
        }
    }

    /**
     * 导出自定义Excel
     * @param havMeterinfo
     * @return
     */
    @PostMapping("/exportCustomExcel")
    @ResponseBody
    public AjaxResult exportCustomExcel(HavMeterinfo havMeterinfo)
    {
        List<HavMeterinfo> list = havMeterinfoService.selectThirdParty(havMeterinfo);
        ExportGdsgExcel exportGdsgExcel = new ExportGdsgExcel();
        String[] excelLabel = new String[]{"","序号","小区","楼栋","单元","门牌","用户名","铅封号","用户编码","设备编码","口径","流量","压力","瞬时流量","阀门状态","表具状态","电压","温度","上传时间","表具时间"};
        Integer[] excelWidth = new Integer[]{0,100,100,80,150,150,150,150,150,150,150,150,150,150,150,150,150,150,150,150};
        String[] excelName = new String[]{"","","areaName","haBuilding.name","haRoom.name","defaultOne","userName","defaultOne","userNo","centorNo","defaultOne","defaultOne","defaultOne","defaultOne","defaultOne","state","defaultOne","defaultOne","thRTime","defaultOne"};
        exportGdsgExcel.setExcelLabel(excelLabel);
        exportGdsgExcel.setExcelWidth(excelWidth);
        exportGdsgExcel.setExcelName(excelName);
        return exportGdsgExcel.init(list,"");
    }

    /**
     * 导出页面表格Excel
     * @param havMeterinfo
     * @param exportExcelUtil
     * @return
     */
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HavMeterinfo havMeterinfo, ExportExcelUtil exportExcelUtil)
    {
        List<HavMeterinfo> list = havMeterinfoService.selectThirdParty(havMeterinfo);
        return exportExcelUtil.init(list, "");
    }
}
