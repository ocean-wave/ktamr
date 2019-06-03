package com.ktamr.common.utils.poi;

import com.ktamr.common.utils.StringUtils;
import com.ktamr.common.utils.file.FileUtils;

import java.io.*;
import java.lang.reflect.Method;
import java.util.List;

public class ExportTextUtil {
    public void writeToTxt(String fileName, List<?> list,String[] name) throws IOException {//设置响应的字符集
        OutputStream out = null;
        PrintWriter pw = null;
        try {
            out = new FileOutputStream(ExceStr.getAbsoluteFile(fileName));
            pw = new PrintWriter(out);
            StringBuffer sb = new StringBuffer();
            for (Object obj : list) {
                for(int i = 0;i<name.length;i++){
                    String[] sc = name[i].split("\\.");
                    try {
                        Object value = getTargetValue(obj,sc);
                        if(i==name.length-1){
                            sb.append(value);
                        }else {
                            sb.append(value + "|");
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
}
