package com.ktamr.common.utils.imports;

import com.ktamr.common.core.domain.AjaxResult;
import com.ktamr.common.exception.BusinessException;
import com.ktamr.common.utils.DateUtils;
import com.ktamr.common.utils.DecimalUtils;
import com.ktamr.common.utils.StringUtils;
import com.ktamr.common.utils.export.ExportStr;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 导入Excel工具类
 * @author ktamr
 */
public class ImportExcelUtil {

    private List<Map<String,Object>> list;
    private InputStream in;

   public void init(InputStream in)throws Exception{
       list = new ArrayList<>();
       this.in = in;
       this.getBankList();
   }

   private void getBankList()throws Exception{
       Workbook work = getWorkbook(in);
       if(null == work){
           throw new Exception("创建工作博为空");
       }

       Sheet sheet = null;
       Row row = null;
       Cell cell = null;

       for (int i = 0;i<work.getNumberOfSheets();i++){
           sheet = work.getSheetAt(i);

           if(null == sheet){
               continue;
           }

           for (int j = 0;i<sheet.getLastRowNum();j++){
               row = sheet.getRow(j);

               if(null == row){
                   continue;
               }
               Map<String,Object> map = new HashMap<>();

               for (int k = 0;k<row.getLastCellNum();k++){
                   cell = row.getCell(k);

                   if(null != cell){
                       map.put(String.valueOf(k+1),getCellValue(cell));
                   }else{
                       map.put(String.valueOf(k+1),"");
                   }
               }
           }
       }
   }

    public static Workbook getWorkbook(InputStream inStr) throws Exception {
        Workbook wb = null;
        wb = WorkbookFactory.create(inStr);
        return wb;
    }

    /**
     * 描述：对表格中数值进行格式化
     *
     * @param cell
     * @return
     */
    public static Object getCellValue(Cell cell) {
        Object value = null;
        System.out.println(cell.getCellStyle().getDataFormatString());
        switch (cell.getCellTypeEnum()){
            case STRING:
                value = cell.getRichStringCellValue().getString();
            case NUMERIC:
                if ("General".equals(cell.getCellStyle().getDataFormatString())) {
                    value = DecimalUtils.decimal(cell.getNumericCellValue());
                } else if ("m/d/yy".equals(cell.getCellStyle().getDataFormatString())) {
                    value = DateUtils.dateTime(cell.getDateCellValue());
                } else if("m/d/yy h:mm".equals(cell.getCellStyle().getDataFormatString())){
                    value = DateUtils.dateTimeTwo(cell.getDateCellValue());
                }else {
                    value = DecimalUtils.decimalTwo(cell.getNumericCellValue());
                }
            case BOOLEAN:
                value = cell.getBooleanCellValue();
            case BLANK:
                value = "";
        }
        return value;
    }
}
