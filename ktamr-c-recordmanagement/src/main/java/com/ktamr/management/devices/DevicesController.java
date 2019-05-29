package com.ktamr.management.devices;

import com.ktamr.domain.HaArea;
import com.ktamr.domain.HaCentor;
import com.ktamr.domain.HaCollector;
import com.ktamr.domain.HaMeter;
import com.ktamr.service.HaAreaService;
import com.ktamr.service.HaCentorService;
import com.ktamr.service.HaCollectorService;
import com.ktamr.service.HaMeterService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/devices")
public class DevicesController {

    @Resource
    private HaCentorService haCentorService;

    @Resource
    private HaCollectorService haCollectorService;

    @Resource
    private HaMeterService haMeterService;

    @Resource
    private HaAreaService haAreaService;

    //跳转到设备档案页面
    @RequestMapping("/device_data_mng")
    public String device_data_mng() {
        return "devices/device_data_mng";
    }

    @RequestMapping("/device_addr_set")
    public String device_addr_set() {
        return "devices/device_addr_set";
    }

    //跳转新增集中器，集采器，手抄器页面
    @RequestMapping("/JumpCentorAdd")
    public String jumpCentorAdd(String cmdName, Model model) {
        List<HaArea> haArea = haAreaService.queryAllHaAreaC();
        model.addAttribute("haArea", haArea);
        model.addAttribute("cmdName", cmdName);
        return "devices/centor_add";
    }

    //跳转新增采集器
    @RequestMapping("/JumpCollectorAdd")
    public String jumpCollectorAdd(String cmdName, Integer deviceId, Model model) {
        HaCentor haCentors = haCentorService.queryAddr(deviceId);
        model.addAttribute("cmdName", cmdName);
        model.addAttribute("deviceId", deviceId);
        model.addAttribute("centorAddr", haCentors);
        return "devices/collector_add";
    }

    //跳转修改采集器
    @RequestMapping("/JumpCollectorUpdate")
    public String jumpCollectorUpdate(String cmdName, Integer collectorId, Model model) {
        HaCollector haCollector = haCollectorService.updateByIdHaCollector(collectorId);
        model.addAttribute("cmdName", cmdName);
        model.addAttribute("collectorId", collectorId);
        model.addAttribute("haCollector", haCollector);
        return "devices/collector_update";
    }

    //跳转修改集中器，集采器，手抄器页面
    @RequestMapping("/JumpCentorUpdate")
    public String jumpCentorUpdate(String cmdName, Integer deviceId, Model model) {
        HaCentor uCentor = haCentorService.updateByIdHaCentor(deviceId);
        List<HaArea> haArea = haAreaService.queryAllHaAreaC();
        String uCentorNo4 = uCentor.getCentorNo().substring(uCentor.getCentorNo().length() - 4);
        String uCentorNo5 = uCentor.getCentorNo().substring(uCentor.getCentorNo().length() - 5);
        String uCentorNoFirst5 = uCentor.getCentorNo().substring(0, 5);
        model.addAttribute("haArea", haArea);
        model.addAttribute("cmdName", cmdName);
        model.addAttribute("uCentor", uCentor);
        model.addAttribute("deviceId", deviceId);
        model.addAttribute("uCentorNo4", uCentorNo4);
        model.addAttribute("uCentorNo5", uCentorNo5);
        model.addAttribute("uCentorNoFirst5", uCentorNoFirst5);
        return "devices/centor_update";
    }

    //跳转采集器选择表，端口选择表页面
    @RequestMapping("/JumpLoadAreaMeter")
    public String jumpLoadAreaMeter(String cmdName, Integer deviceId, Integer collectorId, Integer readLineId, Model model) {
        model.addAttribute("cmdName", cmdName);
        model.addAttribute("deviceId", deviceId);
        model.addAttribute("collectorId", collectorId);
        model.addAttribute("readLineId", readLineId);
        return "devices/loadAreaMeter";
    }

    //跳转表选择采集器，表选择端口，表选择线路页面
    @RequestMapping("/JumpLoadCentorCollector")
    public String jumpLoadCentorCollector(String cmdName, String deviceType, Integer meterIds, Model model) {
        model.addAttribute("cmdName", cmdName);
        model.addAttribute("deviceType", deviceType);
        model.addAttribute("meterIds", meterIds);
        return "devices/loadCentorCollector";
    }

    @RequestMapping("/JumpBoundMeter")
    public String jumpBoundMeter(Integer areaId, String cmdName, Integer deviceId, Integer collectorId, Integer readLineId, Model model) {
        List<HaArea> haArea = haAreaService.queryAllHaAreaC();
        HaArea gAreaId = haAreaService.getAreaId(deviceId);
        if (gAreaId == null) {
            gAreaId = new HaArea();
        }
        model.addAttribute("cmdName", cmdName);
        model.addAttribute("deviceId", deviceId);
        model.addAttribute("collectorId", collectorId);
        model.addAttribute("readLineId", readLineId);
        model.addAttribute("haArea", haArea);
        model.addAttribute("areaId", areaId);
        model.addAttribute("gAreaId", gAreaId.getAreaId());
        return "devices/boundMeter";
    }

    @RequestMapping("/deviceDataMngJson")
    @ResponseBody
    public Object deviceDataMngJson(HaCentor haCentor) {
        List<HaCentor> listHaCentor = haCentorService.HaCentorList(haCentor);
        return listHaCentor;
    }

    @RequestMapping("/QueryHaCollector")
    @ResponseBody
    public Object queryHaCentor(Integer centorId) {
        List<HaCollector> haCollectors = haCollectorService.queryHaCollector(centorId);
        if (haCollectors != null) {
            return haCollectors;
        }
        return null;
    }

    @RequestMapping("/QueryHaMeter")
    @ResponseBody
    public Object queryHaMeter(Integer areaId, Integer collectorId, HaMeter haMeter, HttpServletRequest request) {
        Integer page, pageRows;
        String page1 = request.getParameter("page");//获取需要多少行
        String pageRows1 = request.getParameter("rows");//获取查询的起点位置
        if (page1 == null && pageRows1 == null) {//为了防止异常给它初始化一波
            page = 100;
            pageRows = 100;
        } else {//如果有那就获取一波
            page = Integer.parseInt(page1); // 取得当前页数
            pageRows = Integer.parseInt(pageRows1); // 取得每页显示行数
        }
        int page2 = page;//重新定义变量接收
        --page2;
        List<HaMeter> haMeters = haMeterService.queryHaMeter(areaId, collectorId, pageRows, page2);
        Integer haMeterCount = haMeterService.HaMeterCount(haMeter);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("page", page);//设置初始的页码 就是第几页
        map.put("rowNum", pageRows);//一页显示几条数据
        map.put("records", haMeterCount);//总记录数
        map.put("total", (haMeterCount - 1) / pageRows + 1);//总页数的计算
        map.put("rows", haMeters);//存放集合
        return map;
    }

    //采集器选择表，端口选择表 表列表显示
    @RequestMapping("/HaMeterList")
    @ResponseBody
    public Object HaMeterList(HaMeter haMeter, HttpServletRequest request) {
        Integer page, pageRows;
        String page1 = request.getParameter("page");//获取需要多少行
        String pageRows1 = request.getParameter("rows");//获取查询的起点位置
        if (page1 == null && pageRows1 == null) {//为了防止异常给它初始化一波
            page = 100;
            pageRows = 100;
        } else {//如果有那就获取一波
            page = Integer.parseInt(page1); // 取得当前页数
            pageRows = Integer.parseInt(pageRows1); // 取得每页显示行数
        }
        int page2 = page;//重新定义变量接收
        --page2;
        List<HaMeter> haMeters = haMeterService.HaMeterList(haMeter, pageRows, page2);
        Integer haMeterCount = haMeterService.HaMeterCount(haMeter);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("page", page);//设置初始的页码 就是第几页
        map.put("rowNum", pageRows);//一页显示几条数据
        map.put("records", haMeterCount);//总记录数
        map.put("total", (haMeterCount - 1) / pageRows + 1);//总页数的计算
        map.put("rows", haMeters);//存放集合
        return map;
    }

    //表选择采集器，表选择端口，表选择线路页面 采集器列表显示
    @RequestMapping("/HaCollectorList")
    @ResponseBody
    public Object HaCollectorList(HaCollector haCollector, HttpServletRequest request) {
        Integer page, pageRows;
        String page1 = request.getParameter("page");//获取需要多少行
        String pageRows1 = request.getParameter("rows");//获取查询的起点位置
        if (page1 == null && pageRows1 == null) {//为了防止异常给它初始化一波
            page = 100;
            pageRows = 100;
        } else {//如果有那就获取一波
            page = Integer.parseInt(page1); // 取得当前页数
            pageRows = Integer.parseInt(pageRows1); // 取得每页显示行数
        }
        int page2 = page;//重新定义变量接收
        --page2;
        List<HaCollector> haCollectors = haCollectorService.HaCollectorList(haCollector, pageRows, page2);
        Integer haCollectorCount = haCollectorService.HaCollectorCount(haCollector);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("page", page);//设置初始的页码 就是第几页
        map.put("rowNum", pageRows);//一页显示几条数据
        map.put("records", haCollectorCount);//总记录数
        map.put("total", (haCollectorCount - 1) / pageRows + 1);//总页数的计算
        map.put("rows", haCollectors);//存放集合
        return map;
    }

    //添加集中器
    @RequestMapping("/AddCentor")
    @ResponseBody
    public Object addCentor(HaCentor haCentor) {
        haCentor.setState("建档");
        Integer centor = haCentorService.addHaCentor(haCentor);
        if (centor == 1) {
            return "true";
        }
        return "false";
    }

    //添加集采器
    @RequestMapping("/AddCollector")
    @ResponseBody
    public Object addCollector(HaCollector haCollector) {
        if (haCollector.getOconf() == null) {
            haCollector.setOconf(0);
        }
        haCollector.setState("建档");
        Integer collector = haCollectorService.addHaCollector(haCollector);
        if (collector == 1) {
            return "true";
        }
        return "false";
    }

    //修改集采器
    @RequestMapping("/UpdateCollector")
    @ResponseBody
    public Object updateCollector(HaCollector haCollector) {
        if (haCollector.getOconf() == null) {
            haCollector.setOconf(0);
        }
        Integer collector = haCollectorService.updateHaCollector(haCollector);
        if (collector == 1) {
            return "true";
        }
        return "false";
    }

    //修改集中器
    @RequestMapping("/UpdateCentor")
    @ResponseBody
    public Object updateCentor(HaCentor haCentor) {
        Integer centor = haCentorService.updateHaCentor(haCentor);
        if (centor == 1) {
            return "true";
        }
        return "false";
    }

    //删除集中器
    @RequestMapping("/DeleteCentor")
    @ResponseBody
    public Object deleteCentor(String cmdName,Integer deviceId) {
        Integer collectorDelCount = haCollectorService.HaCollectorDelCount(deviceId);
        if(collectorDelCount==0){
            Integer centor = haCentorService.deleteHaCentor(deviceId);
            if (centor == 1) {
                return "true";
            }
        }else {
            if (cmdName.equals("删除集中器")) {
                return "集中器下面存在" + collectorDelCount + "个采集器未删除！";
            } else if (cmdName.equals("删除集采器")) {
                return "集采器下面存在" + collectorDelCount + "个采集器未删除！";
            }
        }
        return "";
    }

    //删除集采器
    @RequestMapping("/DeleteCollector")
    @ResponseBody
    public Object deleteCollector(Integer collectorId) {
        Integer collector = haCollectorService.deleteHaCollector(collectorId);
        if (collector == 1) {
            return "true";
        }
        return "false";
    }

    //采集器选择表 端口选择表 线路选择表关联
    @RequestMapping("/LoadAreaMeterCall")
    @ResponseBody
    public Object loadAreaMeterCall(HaMeter haMeter, HaCentor haCentor, HaCollector haCollector, Integer centorId, Integer collectorId, Integer meterIds, Integer readLineId) {
        if (meterIds > 0) {
            Integer count = 0;
            if (centorId !=null && collectorId !=null) {
                haMeter.setCentorId(centorId);
                haMeter.setCollectorId(collectorId);
                haCentor.setId(centorId);
                haCollector.setCollectorId(collectorId);
                haMeter.setMeterId(meterIds);
                Integer updateHaMeterCollector = haMeterService.updateHaMeterCollector(haMeter, haCentor, haCollector);
                if (updateHaMeterCollector == 1) {
                    Integer haMeterCollectorCount = haMeterService.HaMeterCollectorCount(centorId, collectorId, meterIds);
                    count = haMeterCollectorCount;
                }
                return count;
            } else if (readLineId !=null && readLineId >0) {
                haMeter.setCentorId(readLineId);
                haMeter.setCollectorId(null);
                haCentor.setId(readLineId);
                haMeter.setMeterId(meterIds);
                Integer updateHaMeterReadLine = haMeterService.updateHaMeterReadLine(haMeter, haCentor, readLineId);
                if (updateHaMeterReadLine == 1) {
                    Integer haMeterReadLineCount = haMeterService.HaMeterReadLineCount(readLineId, meterIds);
                    count = haMeterReadLineCount;
                }
                return count;
            } else {
                haMeter.setMeterId(meterIds);
                Integer updateHaMeterNull = haMeterService.updateHaMeterNull(haMeter);
                if(updateHaMeterNull==1){
                    Integer haMeterNullCount = haMeterService.HaMeterNullCount(meterIds);
                    count=haMeterNullCount;
                }
                return count;
            }
        }
        return null;
    }

}
