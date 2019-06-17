package com.ktamr.common.utils.export;

import com.ktamr.common.core.domain.AjaxResult;
import com.ktamr.common.exception.BusinessException;
import com.ktamr.common.utils.DateUtils;
import com.ktamr.common.utils.StringUtils;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.List;

public class ExportCustomExcel {
    private static final Logger log = LoggerFactory.getLogger(ExcelUtilTwo.class);

    private String[] excelLabel;
    private Integer[] excelWidth;
    private String[] excelName;

    private List<?> list;
    private String sheetName;
    private Workbook wb;
    private Sheet sheet;
    private Row row;
    private Cell cell;

    public AjaxResult init(List<?> list, String sheetName){
        wb = new SXSSFWorkbook(500);
        sheet = wb.createSheet();
        this.list = list;
        this.sheetName = sheetName;
        createTitle();
        createExcelField();
        createExcelData();
        return wbWrite();
    }

    private void createTitle(){
        for(int i =0;i<2;i++) {
            row = sheet.createRow(i);
            cell = null;
            for (int j = 0;j<excelLabel.length+1;j++){
                cell = row.createCell(j);
                sheet.setColumnWidth(i,excelWidth[i]*35);
                row.setHeight((short)500);

                CellStyle style =  wb.createCellStyle();
                Font font = wb.createFont();
                style.setAlignment(HorizontalAlignment.CENTER);
                style.setVerticalAlignment(VerticalAlignment.CENTER);
                if(j!=0){
                    cell.setCellValue("");
                }else if(i==0) {
                    font.setBold(true);
                    font.setFontHeight((short) 300);
                    style.setFont(font);
                    cell.setCellValue("韶关市曲江区供水管理处实时数据已抄到统计");
                }else if(i==1){
                    cell.setCellValue("实时数据已抄到统计(导出时间:"+DateUtils.getTime()+")");
                }
                cell.setCellStyle(style);
            }
        }
        CellRangeAddress region = new CellRangeAddress(0, 0, 0, 19);
        sheet.addMergedRegion(region);
        CellRangeAddress region2 = new CellRangeAddress(1, 1, 0, 19);
        sheet.addMergedRegion(region2);
    }

    private void createExcelField(){
        row = sheet.createRow(2);
        cell = null;
        getBeginColumn(row);
        for(int i = 1;i<=excelLabel.length-1;i++){
            cell = row.createCell(i);
            sheet.setColumnWidth(i,excelWidth[i]*35);
            cell.setCellValue(excelLabel[i]);
        }
    }

    private void createExcelData(){
        double sheetNo = Math.ceil(this.list.size());
        Object value = null;
        int dataFormatIndex=0;
        for (int index = 2; index < sheetNo; index++)
        {
            // 产生一行
            row = sheet.createRow(index+1);
            getBeginColumn(row);
            Object vo = (Object) list.get(index);

            for(int i = 1;i<=excelName.length-1;i++){
                cell = row.createCell(i);
                if(i==1){
                    cell.setCellType(CellType.STRING);
                    cell.setCellValue(String.valueOf(index-1));
                    continue;
                }
                try {
                    String[] sc = excelName[i].split("[.]");
                    value = getTargetValue(vo, sc);
                    if(value instanceof Date){
                        cell.setCellValue(DateUtils.dateTimeTwo((Date) value));
                    }else if(value instanceof Double) {
                        cell.setCellValue(String.valueOf(Integer.parseInt(new java.text.DecimalFormat("0").format(value))));
                    }else{
                        cell.setCellType(CellType.STRING);
                        cell.setCellValue(StringUtils.isNull(value)?"":value.toString());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void getBeginColumn(Row row){
        cell = row.createCell(0);
        sheet.setColumnWidth(0,1500);
        cell.setCellValue(" ");
    }

    private Object getTargetValue(Object o, String[] sc)  throws Exception {
        if(sc.length > 0) {
            for (String s : sc) {
                if(o != null) {
                    o = getValue(o, s);
                }
            }
        }else {
            if(o!=null) {
                o = getValue(o, sc[0]);
            }
        }
        return o;
    }

    private Object getValue(Object o, String name) throws Exception
    {
        if (StringUtils.isNotEmpty(name))
        {
            Class<?> clazz = o.getClass();
            String methodName = "get" + name.substring(0, 1).toUpperCase() + name.substring(1);
            Method method = clazz.getMethod(methodName);
            o = method.invoke(o);
        }
        return o;
    }

    private AjaxResult wbWrite(){
        OutputStream out = null;
        String filename = ExportStr.encodingFileExcelname();
        try {
            out = new FileOutputStream(ExportStr.getAbsoluteFile(filename));
            wb.write(out);
            return AjaxResult.success(filename);
        } catch (Exception e) {
            log.error("导出Excel异常{}", e.getMessage());
            throw new BusinessException("导出Excel失败，请联系网站管理员！");
        }finally {
            if (wb != null)
            {
                try
                {
                    wb.close();
                }
                catch (IOException e1)
                {
                    e1.printStackTrace();
                }
            }
            if (out != null)
            {
                try
                {
                    out.close();
                }
                catch (IOException e1)
                {
                    e1.printStackTrace();
                }
            }
        }
    }
    public void setExcelWidth(Integer[] excelWidth) {
        this.excelWidth = excelWidth;
    }

    public void setExcelLabel(String[] excelLabel) {
        this.excelLabel = excelLabel;
    }

    public void setExcelName(String[] excelName) {
        this.excelName = excelName;
    }
}
