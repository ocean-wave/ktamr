package com.ktamr.web.datacopy.controller.systemmaintenance;

import com.ktamr.domain.HaArea;
import com.ktamr.domain.HaCentor;
import com.ktamr.domain.HaCollector;
import com.ktamr.domain.HaMeter;
import com.ktamr.service.HaAreaService;
import com.ktamr.service.HaCentorService;
import com.ktamr.service.HaCollectorService;
import com.ktamr.service.HaMeterService;
import com.ktamr.web.datacopy.basecontroller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/systemmaintenance")
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
    public String loadKT300Meter(@RequestParam( value = "cmdName") String cmdName,
                           @RequestParam( value = "centorId") Integer centorId,
                           @RequestParam( value = "devDescription") String devDescription,
                           @RequestParam( value = "ccentorAdd") String ccentorAdd,ModelMap mmap){
        mmap.put("cmdName",cmdName);
        mmap.put("centorId",centorId);
        mmap.put("devDescription",devDescription);
        mmap.put("ccentorAdd",ccentorAdd);
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

}
