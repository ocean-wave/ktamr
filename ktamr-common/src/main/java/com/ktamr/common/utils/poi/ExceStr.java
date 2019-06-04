package com.ktamr.common.utils.poi;

import com.ktamr.common.config.Global;
import com.ktamr.common.utils.DateUtils;

import java.io.File;
import java.util.UUID;

/**
 * Excel String类
 *
 * @author ktamr
 */
public class ExceStr {

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
