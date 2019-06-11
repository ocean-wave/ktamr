package com.ktamr.common.utils.export;

import com.ktamr.common.core.domain.AjaxResult;
import com.ktamr.common.utils.DateUtils;
import com.ktamr.common.utils.StringUtils;
import com.linuxense.javadbf.DBFDataType;
import com.linuxense.javadbf.DBFField;
import com.linuxense.javadbf.DBFWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.nio.charset.Charset;
import java.util.Date;
import java.util.List;

public class ExportDbfUtil {

    private String[] dbfLabel;
    private String[] dbfName;
    private Integer[] dbfWidth;

    private List<?> list;

    private DBFField[] dbfFields;
    private DBFWriter dbfWriter;
    private String fileName;

    public AjaxResult init(List<?> list){
        this.list = list;
        this.createFileds();
        this.createDbfData();
        return this.getWriter();
    }

    private void createDbfData(){
        for(Object obj:this.list){
            Object[] object = new Object[this.dbfName.length];
            for (int i = 0;i<this.dbfName.length;i++){
                String[] sc = this.dbfName[i].split("\\.");
                try {
                    Object value = getTargetValue(obj,sc);
                    if(value instanceof Date) {
                        object[i] = DateUtils.dateTimeTwo((Date)value);
                    }else if(value instanceof Double) {
                        object[i] = String.valueOf(Integer.parseInt(new java.text.DecimalFormat("0").format(value)));
                    }else {
                        object[i] = value!=null?value.toString():"";
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            dbfWriter.addRecord(object);
        }
    }

    private void createFileds(){
        OutputStream out = null;
        this.fileName = ExportStr.encodingFileDbfname();
        try {
            out = new FileOutputStream(ExportStr.getAbsoluteFile(this.fileName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        dbfFields = new DBFField[dbfLabel.length];
        dbfWriter = new DBFWriter(out, Charset.forName("gbk"));
        for(int i = 0;i<dbfLabel.length;i++){
            dbfFields[i] = new DBFField();
            dbfFields[i].setType(DBFDataType.CHARACTER);
            dbfFields[i].setName(dbfLabel[i]);
            dbfFields[i].setLength(dbfWidth[i]);
        }
        dbfWriter.setFields(dbfFields);
    }

    private AjaxResult getWriter(){
        dbfWriter.close();
        return AjaxResult.success(fileName);
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

    public void setDbfLabel(String[] dbfLabel) {
        this.dbfLabel = dbfLabel;
    }

    public void setDbfName(String[] dbfName) {
        this.dbfName = dbfName;
    }

    public void setDbfWidth(Integer[] dbfWidth) {
        this.dbfWidth = dbfWidth;
    }
}
