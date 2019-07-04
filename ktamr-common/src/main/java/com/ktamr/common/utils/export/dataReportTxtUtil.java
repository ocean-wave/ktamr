package com.ktamr.common.utils.export;

import com.ktamr.common.core.domain.AjaxResult;
import com.ktamr.common.utils.DateUtils;
import com.ktamr.common.utils.export.ExportStr;
import com.ktamr.common.utils.export.ExportTxtUtil;

import java.io.IOException;
import java.util.List;

public class dataReportTxtUtil {


    public static AjaxResult exportToTxt(String showListType, List<?> listMeterinfo,String[] name){
        if("sys_rass".equals(showListType) || "sys_scsy".equals(showListType) || "sys_scjdz".equals(showListType) || "sys_tzss".equals(showListType)){
            String fileName ="";
            String[] label = new String[]{};
            String segmentationStr = "|";
            if("sys_rass".equals(showListType)){
                fileName = "ra-table"+ DateUtils.dateTimeNow()+".txt";
            }else if("sys_scsy".equals(showListType)){
                label = new String[]{"户号","钢印号","本期抄表日","本期读数"};
                segmentationStr = ",";
                fileName = "scsy-table"+ DateUtils.dateTimeNow()+".txt";
            }else if("sys_scjdz".equals(showListType)){
                segmentationStr = "  ";
                fileName = DateUtils.getDateTwo()+".txt";
            }else if("sys_tzss".equals(showListType)){
                fileName = "tz-table"+ DateUtils.dateTimeNow()+".txt";
            }
            ExportTxtUtil exportTextUtil = new ExportTxtUtil();
            exportTextUtil.setLabel(label);
            exportTextUtil.setSegmentationStr(segmentationStr);
            try {
                exportTextUtil.writeToTxt(fileName,listMeterinfo,name);
                return AjaxResult.success(fileName);
            } catch (IOException e){
                e.printStackTrace();
                return AjaxResult.error(e.getMessage());
            }
        }
        return AjaxResult.error("无返回");
    }
}
