package com.ktamr.management.devicesImport;

import com.ktamr.common.core.domain.BaseController;
import com.ktamr.common.utils.file.ImportService;
import com.ktamr.domain.HaCentor;
import com.ktamr.domain.HatDevicesimport;
import com.ktamr.service.HaCentorService;
import com.ktamr.service.HatDevicesimportService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/devicesImport")
public class HatDevicesimportController extends BaseController {

    @Resource
    private HatDevicesimportService hatDevicesimportService;

    @Resource
    private ImportService importService;

    @Resource
    private HaCentorService haCentorService;

    @RequestMapping("/device_upload_todo")
    @ResponseBody
    public Object device_upload_todo(@RequestParam("userInfo") MultipartFile file, HatDevicesimport hatDevicesimport) throws Exception {
        if (file.isEmpty()) {
            return "false";
        }
        String fileName = file.getOriginalFilename();//获取文件夹名字
        if (fileName.indexOf("xls") < 0) {
            return "上传文件类型不符合要求，请确定是 (.xls/.xlsx)后缀的Excel 文件";
        }
        InputStream inputStream = file.getInputStream();
        List<List<Object>> list = importService.getBankListByExcel(inputStream, file.getOriginalFilename());//读取excel中的数据
        inputStream.close();
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = sdf.format(date);
        Date importTime = sdf.parse(time);

        for (int i = 0; i < list.size(); i++) {
            List<Object> lo = list.get(i);
            String deviceId = lo.get(0).toString();//拿到设备地址
            String deviceName = lo.get(1).toString();//设备名称
            String description = lo.get(2).toString(); //连接说明
            String areaName = lo.get(3).toString(); //所属小区名称
            hatDevicesimport.setDeviceId(deviceId);
            hatDevicesimport.setDeviceName(deviceName);
            hatDevicesimport.setDescription(description);
            hatDevicesimport.setAreaName(areaName);
            hatDevicesimport.setImportTime(importTime);
            try {
                if(lo.get(4)!=null){
                    SimpleDateFormat sdf2 = new SimpleDateFormat("dd-MMM-yyyy");
                    Object setupTime = sdf2.parse(lo.get(4).toString());//安装时间
                    hatDevicesimport.setSetupTime((Date) setupTime);
                }
                if(lo.get(5)!=null){
                    String tel = lo.get(5).toString();//电话号码
                    hatDevicesimport.setTel(tel);
                }
                if(lo.get(6)!=null){
                    String remark = lo.get(6).toString();//备注
                    hatDevicesimport.setReMark(remark);
                }
            } catch (Exception e) {
                System.out.println("空值");
                hatDevicesimport.setTel("");
                hatDevicesimport.setReMark("");
                hatDevicesimport.setSetupTime(null);
            }
            try {
                hatDevicesimportService.addHatDevicesimport(hatDevicesimport);
                hatDevicesimport = new HatDevicesimport();
                hatDevicesimport.setImportTime(importTime);
                hatDevicesimportService.belongAreaCheck(hatDevicesimport);
                hatDevicesimportService.joinSayCheck(hatDevicesimport);
                hatDevicesimportService.centorNameCheck(hatDevicesimport);
                hatDevicesimportService.centorAddrCheck1(hatDevicesimport);
                hatDevicesimportService.centorAddrCheck2(hatDevicesimport);
                hatDevicesimportService.centorAddrCheck3(hatDevicesimport);
                hatDevicesimportService.centorAddrCheck4(hatDevicesimport);
                hatDevicesimportService.centorAddrCheck5(hatDevicesimport);
                hatDevicesimportService.centorAddrCheck6(hatDevicesimport);
                hatDevicesimportService.checkAddOrUpdate(hatDevicesimport);
                hatDevicesimportService.completeDefaultValues(hatDevicesimport);
            } catch (Exception e) {
                System.out.println("对不起，操作不成功！！！错误信息是" + e.getMessage());
                e.printStackTrace();
                return "false";
            }
        }
        Calendar ca = Calendar.getInstance();//之所以要转成Calendar对象，是因为Date的getXXX()方法废弃了。。。
        ca.setTime(importTime);
        return ca.get(Calendar.YEAR) + "-" + (ca.get(Calendar.MONTH) + 1) + "-" + ca.get(Calendar.DATE)
                + " " + ca.get(Calendar.HOUR_OF_DAY) + ":" + ca.get(Calendar.MINUTE) + ":" + ca.get(Calendar.SECOND);
    }

    @RequestMapping("/device_upload_list")
    public String device_upload_list(HatDevicesimport hatDevicesimport,String fileName,Model model) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String importTime = sdf.format(hatDevicesimport.getImportTime());
        Integer allCount = hatDevicesimportService.queryAllHatDevicesimportCount(hatDevicesimport); //总条目
        Integer addsCount = hatDevicesimportService.addsCount(hatDevicesimport); //新增数
        Integer updsCount = hatDevicesimportService.updsCount(hatDevicesimport); //修改数
        Integer errors = addsCount - updsCount; //错误数
        String msg = "总条目:" + allCount + ", 新增数:" + addsCount + ", 修改数:" + updsCount + ", 出错数:" + errors;
        model.addAttribute("fileName", fileName);
        model.addAttribute("importTime", importTime);
        model.addAttribute("allCount", allCount);
        model.addAttribute("addsCount", addsCount);
        model.addAttribute("updsCount", updsCount);
        model.addAttribute("errors", errors);
        model.addAttribute("msg", msg);
        return "devices/device_upload_list";
    }

    @RequestMapping("/EquipmentFilesList")
    @ResponseBody
    public Object equipmentFilesList(HatDevicesimport hatDevicesimport) throws ParseException {
        startPage();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = sdf.format(hatDevicesimport.getImportTime());
        sdf.parse(time);
        List<HatDevicesimport> devicesimports = hatDevicesimportService.HatDevicesimportList(hatDevicesimport);
        Map<String, Object> map = getDataTable(devicesimports);
        if (map != null) {
            return map;
        }
        return null;
    }

    @RequestMapping("/device_upload_do")
    @ResponseBody
    public Object device_upload_do(HatDevicesimport hatDevicesimport,HaCentor haCentor,@RequestParam("op") String op){
        if(op.equals("sure")){
            try {
                hatDevicesimportService.addCentorsAndHandDevices(hatDevicesimport);
                hatDevicesimportService.updateHatDevicesimport(haCentor,hatDevicesimport);
                hatDevicesimportService.deleteHatDevicesimport(hatDevicesimport);
            } catch (Exception e) {
                e.printStackTrace();
                return "执行不成功，异常信息是"+e.getMessage();
            }
            return "true";
        }else {
            try {
                hatDevicesimportService.deleteHatDevicesimport(hatDevicesimport);
            } catch (Exception e) {
                e.printStackTrace();
                return "执行不成功，异常信息是"+e.getMessage();
            }
            return "取消导入";
        }
    }
}
