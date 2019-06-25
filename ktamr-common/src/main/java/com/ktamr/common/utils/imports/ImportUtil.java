package com.ktamr.common.utils.imports;

public class ImportUtil {

    public static void fileNameExcel(String fileName) throws Exception{
        String str = fileName.substring(fileName.lastIndexOf("."));
        if(!(".xls".equals(str) || ".xlsl".equals(str))){
            throw new Exception("请上传.xls或.xlsl文件");
        }
    }
}
