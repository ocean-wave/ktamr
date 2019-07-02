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

    public static String encodingFileExcelname()
    {
        return UUID.randomUUID().toString() + "_"+ "kt-table"+ DateUtils.dateTimeNow()+".xlsx";
    }
    public static String encodingFileExcelnameTwo()
    {
        return "kt-table"+ DateUtils.dateTimeNow()+".xlsx";
    }

    public static String encodingFileTxtname()
    {
        return UUID.randomUUID().toString() + "_"+ "kt-table"+ DateUtils.dateTimeNow()+".txt";
    }

    public static String encodingFileDbfname()
    {
        return UUID.randomUUID().toString() + "_"+ "kt-table"+ DateUtils.dateTimeNow()+".dbf";
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
