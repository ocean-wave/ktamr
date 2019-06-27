package com.ktamr.common.utils.imports;

import com.ktamr.common.core.domain.AjaxResult;
import com.ktamr.common.exception.BusinessException;
import com.ktamr.common.utils.DateUtils;
import com.ktamr.common.utils.DecimalUtils;
import com.ktamr.common.utils.StringUtils;
import com.ktamr.common.utils.export.ExportStr;
import org.apache.poi.hssf.usermodel.HSSFCell;
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
    private String dateString;
    private Integer topCellCount;
    private String[] nonEmptyCell;


   public List<Map<String,Object>> init(InputStream in,String dateString,String[] nonEmptyCell)throws Exception{
       list = new ArrayList<>();
       this.dateString = dateString;
       this.nonEmptyCell = nonEmptyCell;
       this.in = in;
       this.getBankList();
       return list;
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
           for (int j = 1;j<sheet.getLastRowNum()+1;j++){
               topCellCount = getTopCellCount(sheet.getRow(0));
               row = sheet.getRow(j);

               if(null == row){
                   continue;
               }
               Map<String,Object> map = new HashMap<>();

               for (int k = 0;k<topCellCount;k++){
                   cell = row.getCell(k);

                   if(null != cell){
                       Object value = getCellValue(cell);
                       map.put(String.valueOf(k+1),value);
                       if(j>1 && list.size() > 0){
                           Map<String,Object> m = list.get(0);
                           Object value2 = m.get(String.valueOf(k+1));
                           if(null!=value && (value instanceof Date || value2 instanceof Date) && (!(value2 instanceof Date) || !(value instanceof Date)))
                               throw new Exception("第"+(j+1)+"行第"+(k+1)+"列与其他行的类型不一致,请检查");
                           else if(null!=value && (value instanceof Integer || value2 instanceof Integer)  && (!(value2 instanceof Integer) || !(value instanceof Integer)))
                               throw new Exception("第"+(j+1)+"行第"+(k+1)+"列与其他行的类型不一致,请检查");
                       }
                   }else{
                       map.put(String.valueOf(k+1),null);
                   }
                   if(k==topCellCount-1){
                       map.put(String.valueOf(k+2),dateString);
                   }
               }
               if(!getNonEmptyCell(map)){
                   list.add(map);
               }
           }
       }
   }

   private int getTopCellCount(Row row){
       int count = 0;
       Cell cell = null;
       for(int i = 0;i<row.getLastCellNum();i++){
           cell = row.getCell(i);
           if(null!=cell && cell.getRichStringCellValue().getString() != ""){
               count++;
           }
       }
       return count;
   }

   public boolean getNonEmptyCell(Map<String,Object> map){
       if(null!=nonEmptyCell){
           for (int q=0;q<nonEmptyCell.length;q++){
               if(null != map.get(nonEmptyCell[q]) && "" != map.get(nonEmptyCell[q])){
                   return false;
               }
           }
       }else {
           for (int q=1;q<=map.size();q++){
               if(null != map.get(String.valueOf(q)) && "" != map.get(String.valueOf(q)) && q!=map.size()){
                   return false;
               }
           }
       }
       return true;
   }


   public  Workbook getWorkbook(InputStream inStr) throws Exception {
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
    public  Object getCellValue(Cell cell) {
        Object value = null;
        switch (cell.getCellTypeEnum()){
            case STRING:
                value = cell.getRichStringCellValue().getString();
                break;
            case NUMERIC:
                if ("General".equals(cell.getCellStyle().getDataFormatString())) {
                    value = Integer.parseInt(DecimalUtils.decimal(cell.getNumericCellValue()));
                } else if ("m/d/yy".equals(cell.getCellStyle().getDataFormatString())) {
                    value = cell.getDateCellValue();
                } else if("m/d/yy h:mm".equals(cell.getCellStyle().getDataFormatString())){
                    value = cell.getDateCellValue();
                }else {
                    value = Double.valueOf(DecimalUtils.decimalTwo(cell.getNumericCellValue()));
                }
                break;
            case BOOLEAN:
                value = cell.getBooleanCellValue();
                break;
            case BLANK:
                value = null;
                break;
        }
        return value;
    }
}
