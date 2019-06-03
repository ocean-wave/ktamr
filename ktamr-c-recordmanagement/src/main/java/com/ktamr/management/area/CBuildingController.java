package com.ktamr.management.area;

import com.ktamr.common.core.domain.BaseController;
import com.ktamr.domain.HaBuilding;
import com.ktamr.service.HaBuildingService;
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
@RequestMapping("/cbuilding")
public class CBuildingController extends BaseController{

    @Resource
    private HaBuildingService haBuildingService;

    @RequestMapping("/JumpBuildingAdd")
    public String jumpBuildingAdd(Integer areaId,Model model){
        model.addAttribute("areaId",areaId);
        return "area/building_add";
    }

    @RequestMapping("/JumpBuildingUpdate")
    public String jumpBuildingUpdate(Integer buildingId,Model model){
        HaBuilding haBuilding = haBuildingService.updateByIdHaBuilding(buildingId);
        model.addAttribute("haBuilding",haBuilding);
        model.addAttribute("buildingId",buildingId);
        return "area/building_update";
    }

    @RequestMapping("/JumpBuildingDel")
    public String jumpBuildingDel(Integer buildingId,Model model){
        HaBuilding haBuilding = haBuildingService.updateByIdHaBuilding(buildingId);
        model.addAttribute("haBuilding",haBuilding);
        model.addAttribute("buildingId",buildingId);
        return "area/building_del";
    }

    @RequestMapping("/QueryAllBuildingC")
    @ResponseBody
    public Object queryAllBuildingC(HaBuilding haBuilding){
        startPage();
        List<HaBuilding> haBuildings = haBuildingService.HaBuildingListC(haBuilding);
        Map<String, Object> map = getDataTable(haBuildings);
        return map;
    }

    @RequestMapping("/UpdateHaBuilding")
    @ResponseBody
    public Object updateHaBuilding(HaBuilding haBuilding){
        Integer haBuildingC = haBuildingService.updateHaBuildingC(haBuilding);
        if(haBuildingC==1){
            return "true";
        }
        return "false";
    }

    @RequestMapping("/DelHaBuilding")
    @ResponseBody
    public Object delHaBuilding(HaBuilding haBuilding){
        Integer haBuildingC = haBuildingService.deleteHaBuildingC(haBuilding);
        if(haBuildingC==1){
            return "true";
        }
        return "false";
    }

    @RequestMapping("/AddHaBuilding")
    @ResponseBody
    public Object addHaBuilding(HaBuilding haBuilding){
        Integer haBuildingC = haBuildingService.addHaBuildingC(haBuilding);
        if(haBuildingC==1){
            return "true";
        }
        return "false";
    }
}
