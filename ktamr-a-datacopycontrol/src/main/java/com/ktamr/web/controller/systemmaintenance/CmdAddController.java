package com.ktamr.web.controller.systemmaintenance;

import com.ktamr.common.core.domain.AjaxResult;
import com.ktamr.common.utils.export.ExportExcelUtil;
import com.ktamr.common.utils.sql.SqlCondition;
import com.ktamr.domain.HaArea;
import com.ktamr.domain.HaCentor;
import com.ktamr.domain.HaCollector;
import com.ktamr.common.core.domain.BaseController;
import com.ktamr.domain.HaMeter;
import com.ktamr.service.HaAreaService;
import com.ktamr.service.HaCentorService;
import com.ktamr.service.HaCollectorService;
import com.ktamr.service.HaMeterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/systemmaintenance/equipment")
public class CmdAddController extends BaseController {
    private  String pxePath = "datamng";

    @Autowired
    private HaCentorService haCentorService;

    @Autowired
    private HaMeterService haMeterService;

    @Autowired
    private HaCollectorService haCollectorService;

    @Autowired
    private HaAreaService haAreaService;


    @GetMapping("/cmdAdd")
    public String cmdAdd(ModelMap mmap){
        return pxePath+"/cmdAdd";
    }

    @PostMapping("/cmdAddJson")
    @ResponseBody
    public Map<String, Object> cmdAddJson(HaCentor haCentor){
        startPage();
        List<HaCentor> listCentor = haCentorService.selectCentor(haCentor);
        return getDataTable(listCentor);
    }

    @GetMapping("/loadCentorMeter")
    public String loadCentorMeter(@RequestParam( value = "cmdName") String cmdName,
                                  @RequestParam( value = "centorId") Integer centorId,
                                  @RequestParam( value = "devDescription") String devDescription,ModelMap mmap){
        mmap.put("cmdName",cmdName);
        mmap.put("centorId",centorId);
        return pxePath+"/loadCentorMeter";
    }
    @GetMapping("/loadCollector")
    public String loadCollector(@RequestParam( value = "cmdName") String cmdName,
                                @RequestParam( value = "centorId") Integer centorId,
                                @RequestParam( value = "devDescription") String devDescription,ModelMap mmap){
        mmap.put("cmdName",cmdName);
        mmap.put("centorId",centorId);
        return pxePath+"/loadCollector";
    }
    @GetMapping("/readCentorParams")
    public String readCentorParams(@RequestParam( value = "cmdName") String cmdName,
                                @RequestParam( value = "centorId") Integer centorId,
                                @RequestParam( value = "devDescription") String devDescription,ModelMap mmap){
        mmap.put("cmdName",cmdName);
        mmap.put("centorId",centorId);
        return pxePath+"/readCentorParams";
    }
    @GetMapping("/setCentorParams")
    public String setCentorParams(@RequestParam( value = "cmdName") String cmdName,
                                  @RequestParam( value = "centorId") Integer centorId,
                                  @RequestParam( value = "devDescription") String devDescription,ModelMap mmap){
        mmap.put("cmdName",cmdName);
        mmap.put("centorId",centorId);
        mmap.put("devDescription",devDescription);
        return pxePath+"/setCentorParams";
    }
    @GetMapping("/loadArea")
    public String loadArea(@RequestParam( value = "cmdName") String cmdName,
                                  @RequestParam( value = "centorId") Integer centorId,
                                  @RequestParam( value = "devDescription") String devDescription,ModelMap mmap){
        mmap.put("cmdName",cmdName);
        mmap.put("centorId",centorId);
        return pxePath+"/loadArea";
    }
    @GetMapping("/loadKT300Meter")
    public String loadKT300Meter(@RequestParam( value = "cmdName",required = false) String cmdName,
                           @RequestParam( value = "centorId",required = false) Integer centorId,
                           @RequestParam( value = "devDescription",required = false) String devDescription,ModelMap mmap){
        String sql = "SELECT centorid FROM ha_centor WHERE id="+centorId;
        String sql2 = "SELECT centorid FROM ha_centor WHERE position('KT3NB' in description)>0 AND id="+centorId;
        HaCentor haCentor = haCentorService.selectCustomSql(sql);
        String ccentorNo = String.valueOf("00"+haCentor.getCentorId());
        ccentorNo = ccentorNo.substring(ccentorNo.length()-2);
        HaCentor haCentor2 = haCentorService.selectCustomSql(sql2);
        long ccentorAdd = haCentor.getCentorId();
        mmap.put("cmdName",cmdName);
        mmap.put("centorId",centorId);
        mmap.put("devDescription",devDescription);
        mmap.put("ccentorAdd",ccentorAdd);
        mmap.put("ccentorNo",ccentorNo);
        return pxePath+"/loadKT300Meter";
    }

    @GetMapping("/loadCollectorMeter")
    public String loadCollectorMeter(@RequestParam( value = "cmdName") String cmdName,
                                 @RequestParam( value = "centorId") Integer centorId,
                                 @RequestParam( value = "devDescription") String devDescription,ModelMap mmap){
        mmap.put("cmdName",cmdName);
        mmap.put("centorId",centorId);
        return pxePath+"/loadCollectorMeter";
    }

    @GetMapping("/setKT300Params")
    public String setKT300Params(@RequestParam(value = "cmdName",required = false) String cmdName,
                                 @RequestParam(value = "centorId",required = false) Integer centorId,ModelMap mmap){
        mmap.put("cmdName",cmdName);
        mmap.put("centorId",centorId);
        String sql = "SELECT centorid FROM ha_centor WHERE id="+centorId;
        String sql2 = "SELECT centorid FROM ha_centor WHERE position('KT3NB' in description)>0 AND id="+centorId;
        HaCentor haCentor = haCentorService.selectCustomSql(sql);
        String ccentorAdd = String.valueOf("00"+haCentor.getCentorId());
        ccentorAdd = ccentorAdd.substring(ccentorAdd.length()-2);
        HaCentor haCentor2 = haCentorService.selectCustomSql(sql2);
        long KT3NBccentorAdd = haCentor.getCentorId();
        mmap.put("ccentorAdd",ccentorAdd);
        mmap.put("KT3NBccentorAdd",KT3NBccentorAdd);
        return pxePath+"/setKT300Params";
    }

    @GetMapping("/readFreeze")
    public String readFreeze(@RequestParam(value = "cmdName",required = false) String cmdName,
                             @RequestParam(value = "centorId",required = false) String centorId,ModelMap mmap){
        mmap.put("cmdName",cmdName);
        mmap.put("centorId",centorId);
        return pxePath+"/readFreeze";
    }

    @GetMapping("/loadDTU")
    public String loadDTU(@RequestParam(value = "cmdName",required = false) String cmdName,
                             @RequestParam(value = "centorId",required = false) String centorId,ModelMap mmap){
        mmap.put("cmdName",cmdName);
        mmap.put("centorId",centorId);
        return pxePath+"/loadDTU";
    }

    @PostMapping("/loadCentorMeterJson")
    @ResponseBody
    public Map<String, Object> loadCentorMeterJson(@RequestParam( value = "centorId") Integer centorId){
        startPage();
        List<HaMeter> listMeter = haMeterService.selectMeterByCentorId(centorId);
        return getDataTable(listMeter);
    }

    @PostMapping("/loadCollectorJson")
    @ResponseBody
    public Map<String, Object> loadCollectorJson(@RequestParam( value = "centorId") Integer centorId){
        startPage();
        List<HaCollector> listCollector = haCollectorService.selectCollectorBycentorId(centorId);
        return getDataTable(listCollector);
    }

    @PostMapping("/loadAreaJson")
    @ResponseBody
    public Map<String, Object> loadAreaJson(HaArea haArea){
        startPage();
        List<HaArea> listArea = haAreaService.selectHaAreaIdAndName(haArea);
        return getDataTable(listArea);
    }

    @PostMapping("/loadKT300MeterJson")
    @ResponseBody
    public Map<String, Object> loadKT300MeterJson(@RequestParam( value = "centorId") Integer centorId){
        startPage();
        List<HaMeter> listArea = haMeterService.selectMeterByCentorId(centorId);
        return getDataTable(listArea);
    }

    @PostMapping("/loadCollectorMeterJson")
    @ResponseBody
    public Map<String, Object> loadCollectorMeterJson(@RequestParam( value = "collectorId",required = false) Integer collectorId){
        startPage();
        List<HaMeter> listMeter = haMeterService.selectMeterByCollectorId(collectorId);
        return getDataTable(listMeter);
    }

    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HaArea haArea,HaCentor params,@RequestParam( value = "centorId",required = false) Integer centorId,
                             @RequestParam( value = "collectorId",required = false) Integer collectorId, ExportExcelUtil exportExcelUtil)
    {
        List<HaCentor> list = null;
        List<HaCollector> list2 = null;
        List<HaMeter> list3 = null;
        List<HaArea> list4 = null;
        if(params.getParams().get("exportType").equals("1")){
            params.getParams().put("getRightCondition", SqlCondition.getRightCondition("a.areano","area","and"));
            list =  haCentorService.selectCentor(params);
            return exportExcelUtil.init(list, "");
        }else if(params.getParams().get("exportType").equals("2")){
            list3 =  haMeterService.selectMeterByCentorId(centorId);
            return exportExcelUtil.init(list3, "");
        }else if(params.getParams().get("exportType").equals("3")) {
            list2 = haCollectorService.selectCollectorBycentorId(centorId);
            return exportExcelUtil.init(list2, "");
        }else if(params.getParams().get("exportType").equals("4")) {
            list4 = haAreaService.selectHaAreaIdAndName(haArea);
            return exportExcelUtil.init(list4, "");
        }else if(params.getParams().get("exportType").equals("5")) {
            list3 = haMeterService.selectMeterByCentorId(centorId);
            return exportExcelUtil.init(list3, "");
        }else {
            list3 =haMeterService.selectMeterByCollectorId(collectorId);
            return exportExcelUtil.init(list3, "");
        }
    }

}
