package com.ktamr.common.utils.export;

import com.ktamr.common.utils.DateUtils;
import com.ktamr.common.utils.StringUtils;

import java.io.*;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.List;

public class ExportTxtUtil {

    private String[] label;
    private String segmentationStr;

    public void writeToTxt(String fileName, List<?> list,String[] name) throws IOException {
        OutputStream out = null;
        PrintWriter pw = null;
        try {
            out = new FileOutputStream(ExportStr.getAbsoluteFile(fileName));
            pw = new PrintWriter(out);
            StringBuffer sb = new StringBuffer();
            if(label.length>0){
                for (int i =0;i<label.length;i++){
                    sb.append(label[i]);
                    if(i!=label.length-1){
                        if(segmentationStr!=null){
                            sb.append(segmentationStr);
                        }else {
                            sb.append("|");
                        }
                    }
                }
                sb.append(System.getProperty("line.separator"));
            }
            for (Object obj : list) {
                for(int i = 0;i<name.length;i++){
                    String[] sc = name[i].split("\\.");
                    try {
                        Object value = getTargetValue(obj,sc);
                        if(value instanceof Date) {
                            sb.append(DateUtils.dateTimeTwo((Date)value));
                        }else if(value instanceof Double) {
                            sb.append(Integer.parseInt(new java.text.DecimalFormat("0").format(value) ));
                        }else {
                            sb.append(value);
                        }
                        if(i!=name.length-1){
                            if(segmentationStr!=null){
                                sb.append(segmentationStr);
                            }else {
                                sb.append("|");
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                sb.append(System.getProperty("line.separator"));
            }
            pw.write(sb.toString().toCharArray());
            pw.flush();
        } catch (IOException e1) {

        }finally {
            if (pw != null) {
                pw.close();
            }
            if (out != null) {
                out.close();
            }
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

    public void setSegmentationStr(String segmentationStr) {
        this.segmentationStr = segmentationStr;
    }

    public void setLabel(String[] label) {
        this.label = label;
    }
}
