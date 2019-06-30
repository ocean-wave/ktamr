package com.ktamr.management.importCustom;

import com.ktamr.common.core.domain.BaseController;
import com.ktamr.common.utils.DateUtils;
import com.ktamr.common.utils.imports.ImportExcelUtil;
import com.ktamr.domain.HaImportcustom;
import com.ktamr.domain.HaMetertype;
import com.ktamr.domain.HaPricestandard;
import com.ktamr.service.HaImportCustomService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/importCustom")
public class HaImportCustomController extends BaseController {

    @Resource
    private HaImportCustomService haImportCustomService;

    @RequestMapping("/upload_users_todo")
    @ResponseBody
    public Object upload_users_todo(@RequestParam("userInfo") MultipartFile file, ImportExcelUtil importExcelUtil, HaImportcustom haImportcustom)throws Exception{
        if (file.isEmpty()) {
            return "false";
        }
        String fileName = file.getOriginalFilename();//获取文件夹名字
        if (fileName.indexOf("xls") < 0) {
            return "上传文件类型不符合要求，请确定是 (.xls/.xlsx)后缀的Excel 文件";
        }
        InputStream inputStream = file.getInputStream();//获取File
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = DateUtils.getTime();
        Date importTime = sdf.parse(dateString);
        String[] nonEmptyCell = new String[]{"2","7","8","9","12","13","15","17","18","19","20"};//如果excel模板有*号的坐标位置
        List<Map<String,Object>> list = importExcelUtil.init(inputStream,dateString,nonEmptyCell);//获取excel里面的信息
        try {
            haImportCustomService.deleteImportCustom(haImportcustom);
            haImportCustomService.addImportCustom(list);
            haImportcustom = new HaImportcustom();
            haImportcustom.setImportTime(sdf.parse(dateString));//重新的设值
            haImportCustomService.checkCustomTemporary(haImportcustom);
            haImportCustomService.collationData(haImportcustom);
            haImportCustomService.customAddrCheck1(haImportcustom);
            haImportCustomService.customAddrCheck2(haImportcustom);
            haImportCustomService.customAddrCheck3(haImportcustom);
            haImportCustomService.customAddrCheck4(haImportcustom);
            haImportCustomService.customAddrCheck5(haImportcustom);
            haImportCustomService.customAddrCheck6(haImportcustom);
            haImportCustomService.customAddrCheck7(haImportcustom);
            haImportCustomService.customAddrCheck8(haImportcustom);
            haImportCustomService.customNoCheck1(haImportcustom);
            haImportCustomService.customNoCheck2(haImportcustom);
            haImportCustomService.customNoCheck3(haImportcustom);
            haImportCustomService.meterNumCheck1(haImportcustom);
            haImportCustomService.meterNumCheck2(haImportcustom);
            haImportCustomService.meterNumCheck3(haImportcustom);
            haImportCustomService.centorCollectorCheck1(haImportcustom);
            haImportCustomService.centorCollectorCheck2(haImportcustom);
            haImportCustomService.centorCollectorCheck3(haImportcustom);
            haImportCustomService.meterTypeCheck1(haImportcustom);
            haImportCustomService.meterTypeCheck2(haImportcustom);
            haImportCustomService.chargeTypeCheck1(haImportcustom);
            haImportCustomService.chargeTypeCheck2(haImportcustom);
            haImportCustomService.serialNumber1(haImportcustom);
            haImportCustomService.serialNumber2(haImportcustom);
            haImportCustomService.serialNumber3(haImportcustom);
            haImportCustomService.serialNumber4(haImportcustom);
            haImportCustomService.checkAddOrUpdate1(haImportcustom);
            haImportCustomService.checkAddOrUpdate2(haImportcustom);
            haImportCustomService.checkAddOrUpdate3(haImportcustom);
            haImportCustomService.checkAddOrUpdate4(haImportcustom);
            HaPricestandard tpriceStandard = haImportCustomService.tpriceStandard();
            HaMetertype tmeterType = haImportCustomService.tmeterType(tpriceStandard.getName());
            haImportCustomService.completeAddDefaultValues(tmeterType.getName(),tpriceStandard.getName(),haImportcustom);
            haImportCustomService.completeAddDefaultValues2(haImportcustom);
        } catch (Exception e) {
            System.out.println("对不起，操作不成功！！！错误信息是" + e.getMessage());
            e.printStackTrace();
            return "false";
        }
        Calendar ca = Calendar.getInstance();//之所以要转成Calendar对象，是因为Date的getXXX()方法废弃了。。。
        ca.setTime(importTime);
        return ca.get(Calendar.YEAR) + "-" + (ca.get(Calendar.MONTH) + 1) + "-" + ca.get(Calendar.DATE)
                + " " + ca.get(Calendar.HOUR_OF_DAY) + ":" + ca.get(Calendar.MINUTE) + ":" + ca.get(Calendar.SECOND);
    }

    @RequestMapping("/upload_users_list")
    public String upload_users_list(HaImportcustom haImportcustom, String fileName, Model model) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String importTime = sdf.format(haImportcustom.getImportTime());
        Integer allCount = haImportCustomService.queryAllHaImportCustomCount(haImportcustom); //总条目
        Integer addsCount = haImportCustomService.addsCount(haImportcustom); //新增数
        Integer updsCount = haImportCustomService.updsCount(haImportcustom); //修改数
        Integer errors = addsCount - updsCount; //错误数
        String msg = "总条目:" + allCount + ", 新增数:" + addsCount + ", 修改数:" + updsCount + ", 出错数:" + errors;
        model.addAttribute("fileName", fileName);
        model.addAttribute("importTime", importTime);
        model.addAttribute("allCount", allCount);
        model.addAttribute("addsCount", addsCount);
        model.addAttribute("updsCount", updsCount);
        model.addAttribute("errors", errors);
        model.addAttribute("msg", msg);
        return "uploads/upload_users_list";
    }

    @RequestMapping("/userTableInformation")
    @ResponseBody
    public Object userTableInformation(HaImportcustom haImportcustom) throws ParseException {
        startPage();
        /*SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = sdf.format(haImportcustom.getImportTime());
        sdf.parse(time);*/
        List<HaImportcustom> haImportcustoms = haImportCustomService.HaImportcustomList(haImportcustom);
        Map<String, Object> map = getDataTable(haImportcustoms);
        if (map != null) {
            return map;
        }
        return null;
    }

    @RequestMapping("/upload_users_do")
    @ResponseBody
    public Object upload_users_do(HaImportcustom haImportcustom, @RequestParam("msg") String msg, @RequestParam("fileName") String fileName, HttpSession session){
        String operatorCode = (String)session.getAttribute("operatorCode");
        if(!msg.equals("cancel")){
            try {
            haImportCustomService.addRoomByExport1(haImportcustom);
            haImportCustomService.addRoomByExport2(haImportcustom);
            haImportCustomService.addCustomByExport1(haImportcustom);
            haImportCustomService.addCustomByExport2(haImportcustom);
            haImportCustomService.updateMeterRoomByExport1(haImportcustom);
            haImportCustomService.updateMeterRoomByExport2(haImportcustom);
            haImportCustomService.addMeterByExport(haImportcustom);
            haImportCustomService.updateMeterByExport1(haImportcustom);
            haImportCustomService.updateMeterByExport2(haImportcustom);
            haImportCustomService.updateCustomByExport1(haImportcustom);
            haImportCustomService.updateCustomByExport2(fileName,operatorCode,msg);
            } catch (Exception e) {
                System.out.println("对不起，操作不成功！！！错误信息是" + e.getMessage());
                e.printStackTrace();
                return "false";
            }
        }
        haImportCustomService.deleteImportCustom(haImportcustom);

        if(!msg.equals("cancel")){
            return "true";
        }else {
            return "取消导入数据";
        }
    }

}
