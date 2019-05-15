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
import java.util.List;

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

    @RequestMapping("/device_data_mng")
    public String device_data_mng(){
        return "devices/device_data_mng";
    }

    @RequestMapping("/device_addr_set")
    public String device_addr_set(){return "devices/device_addr_set";}

    @RequestMapping("/JumpCentorAdd")
    public String jumpCentorAdd(String cmdName,Model model){
        List<HaArea> haArea = haAreaService.queryAllHaAreaC();
        model.addAttribute("haArea",haArea);
        model.addAttribute("cmdName",cmdName);
        return "devices/centor_add";
    }

    @RequestMapping("/deviceDataMngJson")
    @ResponseBody
    public Object deviceDataMngJson(HaCentor haCentor){
        List<HaCentor> listHaCentor = haCentorService.HaCentorList(haCentor);
        return listHaCentor;
    }

    @RequestMapping("/QueryHaCollector")
    @ResponseBody
    public Object queryHaCentor(Integer centorId){
        List<HaCollector> haCollectors = haCollectorService.queryHaCollector(centorId);
        if(haCollectors!=null){
            return haCollectors;
        }
        return null;
    }

    @RequestMapping("/QueryHaMeter")
    @ResponseBody
    public Object queryHaMeter(Integer areaId,Integer collectorId){
        List<HaMeter> haMeters = haMeterService.queryHaMeter(areaId,collectorId);
        if(haMeters!=null){
            return haMeters;
        }
        return null;
    }


}
