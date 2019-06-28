package com.ktamr.web.controller.handwork;

import com.ktamr.common.config.Global;
import com.ktamr.common.core.domain.BaseController;
import com.ktamr.common.utils.file.FileUploadUtils;
import com.ktamr.domain.HaArea;
import com.ktamr.service.HaAreaService;
import com.ktamr.service.HaMeterService;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

@Controller
@RequestMapping("/handwork")
public class MeterTableTransController extends BaseController {
    private  String pxePath = "area";

    @Autowired
    private HaMeterService haMeterService;

    @Autowired
    private HaAreaService haAreaService;


    @GetMapping("/tableTrans")
    public String deviceTrans(ModelMap mmap){

        return pxePath+"/meterTableTrans";
    }

    @GetMapping("/meterTableDerived")
    @ResponseBody
    public String meterTableDerived(@RequestParam(value = "areaId",required = false) Integer areaId){
        List<HaArea> list = haAreaService.selectHaAreaIdAndName(new HaArea(areaId));
        String path =  Global.getExportPath();
        String path2 = "";
        ZipOutputStream zos = null;
        if(list.size()>0){
            String areaName = list.get(0).getHaName();
            path += areaName+"表册\\";
            path2 += path + areaName+"表册.zip";
            try {
                FileUploadUtils.getMkdirs(path);
                List<File> files = getForFile();
                zos = new ZipOutputStream(new FileOutputStream(new File(path2)));
                for (File f :files){
                    InputStream in = new FileInputStream(f);
                    ZipEntry en = new ZipEntry(f.getName());
                    en.setSize(f.length());
                    zos.putNextEntry(en);
                    int len =0;
                    byte[] buffer = new byte[1024];
                    while(-1!=(len = in.read(buffer))) {
                        zos.write(buffer, 0, len);
                    }
                    in.close();
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        try {
            zos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "/";
    }

    private List<File> getForFile(){
        List<File> list = new ArrayList<>();
        File file = null;
        for (int i = 0;i<10;i++){
            file = new File(i+".cvs");
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            list.add(file);
        }
        return list;
    }
}
