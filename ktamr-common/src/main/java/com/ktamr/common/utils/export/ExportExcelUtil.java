package com.ktamr.common.utils.export;

import com.ktamr.common.exception.BusinessException;
import com.ktamr.common.core.domain.AjaxResult;
import com.ktamr.common.utils.DateUtils;
import com.ktamr.common.utils.StringUtils;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.List;

/**
 * 导出Excel工具类
 * @author ktamr
 */
public class ExportExcelUtil {

    private static final Logger log = LoggerFactory.getLogger(ExportExcelUtil.class);

    private String[] excelLabel;
    private Integer[] excelWidth;
    private String[] excelName;
    private String[] excelDataFormat;
    private String[] excelAlign;
    private CellStyle[] cellStyles;

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
        getCellStyle();
        createExcelField();
        createExcelData();
        return wbWrite();
    }

    private void createExcelField(){
        row = sheet.createRow(0);
        cell = null;
        for(int i = 0;i<excelLabel.length;i++){
            cell = row.createCell(i);
            sheet.setColumnWidth(i,excelWidth[i]*35);
            cell.setCellValue(excelLabel[i]);
        }
    }

    private void createExcelData(){
        double sheetNo = Math.ceil(this.list.size());
        Object value = null;
        int dataFormatIndex=0;
        for (int index = 0; index < sheetNo; index++)
        {
            // 产生一行
            row = sheet.createRow(index+1);
            Object vo = (Object) list.get(index);

            for(int i = 0;i<excelName.length;i++){
                cell = row.createCell(i);
                try {
                    String[] sc = excelName[i].split("[.]");
                    value = getTargetValue(vo, sc);
                    if(value instanceof Date){
                        if (excelDataFormat != null && excelDataFormat.length > 0) {
                            cell.setCellValue(DateUtils.parseDateToStr(excelDataFormat[dataFormatIndex], (Date) value));
                            dataFormatIndex++;
                            if (dataFormatIndex == excelDataFormat.length) {
                                dataFormatIndex = 0;
                            }
                        }else {
                            cell.setCellValue(DateUtils.dateTimeTwo((Date) value));
                        }
                    }else if(value instanceof Double) {
                        cell.setCellValue(String.valueOf(Long.valueOf(new java.text.DecimalFormat("0").format(value))));
                    }else{
                        cell.setCellStyle(cellStyles[i]);
                        cell.setCellType(CellType.STRING);
                        cell.setCellValue(StringUtils.isNull(value)?"":value.toString());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void getCellStyle(){
        cellStyles = new CellStyle[excelName.length];
        for(int i = 0;i<excelName.length;i++) {
            CellStyle style =  wb.createCellStyle();
            switch (excelAlign[i]) {
                case "left":
                    style.setAlignment(HorizontalAlignment.LEFT);
                    break;
                case "right":
                    style.setAlignment(HorizontalAlignment.RIGHT);
                    break;
                case "center":
                    style.setAlignment(HorizontalAlignment.CENTER);
                    break;
            }
            cellStyles[i] = style;
        }
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

    public String[] getExcelAlign() {
        return excelAlign;
    }

    public void setExcelAlign(String[] excelAlign) {
        this.excelAlign = excelAlign;
    }

    public String[] getExcelDataFormat() {
        return excelDataFormat;
    }

    public void setExcelDataFormat(String[] excelDataFormat) {
        this.excelDataFormat = excelDataFormat;
    }

    public Integer[] getExcelWidth() {
        return excelWidth;
    }

    public void setExcelWidth(Integer[] excelWidth) {
        this.excelWidth = excelWidth;
    }

    public String[] getExcelLabel() {
        return excelLabel;
    }

    public void setExcelLabel(String[] excelLabel) {
        this.excelLabel = excelLabel;
    }

    public String[] getExcelName() {
        return excelName;
    }

    public void setExcelName(String[] excelName) {
        this.excelName = excelName;
    }
}
