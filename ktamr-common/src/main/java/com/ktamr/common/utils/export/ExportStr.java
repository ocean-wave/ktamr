package com.ktamr.common.utils.export;

import com.ktamr.common.config.Global;
import com.ktamr.common.utils.DateUtils;

import java.io.File;
import java.util.UUID;

/**
 * 导出 String类
 *
 * @author ktamr
 */
public class ExportStr {

    /**
     * 编码文件名
     */
    public static String encodingFilename(String filename)
    {
        filename = UUID.randomUUID().toString() + "_" + filename + ".xlsx";
        return filename;
    }

    public static String encodingFileTxTname(String filename)
    {
        filename = UUID.randomUUID().toString() + "_" + filename+".txt";
        return filename;
    }

    public static String getFileName()
    {
        return UUID.randomUUID().toString() + "_" + "kt-table"+ DateUtils.dateTimeNow()+".txt";
    }

    private String getFileName(String showListType){
        String fileName = "kt-table"+ DateUtils.dateTimeNow();
        if(showListType.equals("sys_rass")){
            fileName = "融安水司";
        }else if(showListType.equals("sys_tzss")){
            fileName = "泰州水司";
        }else if(showListType.equals("sys_scsy")){
            fileName = "三川邵阳";
        }else if(showListType.equals("sys_scjdz")){
            fileName = "三川景德镇";
        }
        return fileName;
    }

    /**
     * 获取下载路径
     *
     * @param filename 文件名称
     */
    public static String getAbsoluteFile(String filename)
    {
        String downloadPath = Global.getDownloadPath() + filename;
        File desc = new File(downloadPath);
        if (!desc.getParentFile().exists())
        {
            desc.getParentFile().mkdirs();
        }
        return downloadPath;
    }
}
