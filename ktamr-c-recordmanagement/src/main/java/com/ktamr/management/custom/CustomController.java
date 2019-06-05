package com.ktamr.management.custom;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.ktamr.common.core.domain.BaseController;
import com.ktamr.domain.HaArea;
import com.ktamr.domain.HaBuilding;
import com.ktamr.domain.HaCustom;
import com.ktamr.domain.HaRoom;
import com.ktamr.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/custom")
public class CustomController extends BaseController {

    @Resource
    private HaCustomService haCustomService;

    @Resource
    private HaAreaService haAreaService;

    @Resource
    private HaBuildingService haBuildingService;

    @Resource
    private HaRoomService haRoomService;

    @RequestMapping("/cust_list")
    public String cust_list() {
        return "custom/cust_list";
    }

    @RequestMapping("/JumpCustAdd")
    public String jumpcustadd(Integer areaId,Integer buildingId,Model model) {
        List<HaArea> haArea = haAreaService.queryAllHaAreaC();
        List<HaBuilding> haBuilding = haBuildingService.queryHaBuildingC(areaId);
        List<HaRoom> haRoom = haRoomService.queryRoomC(buildingId);
        model.addAttribute("haArea",haArea);
        model.addAttribute("haBuilding",haBuilding);
        model.addAttribute("haRoom",haRoom);
        return "custom/cust_add";
    }

    @RequestMapping("/JumpCustUpdate")
    public String jumpcustupdate(Integer areaId, Integer buildingId, Integer custid, HaCustom haCustom, Model model) {
        haCustom.setCustId(custid);
        List<HaArea> haArea = haAreaService.queryAllHaAreaC();
        List<HaBuilding> haBuilding = haBuildingService.queryHaBuildingC(areaId);
        List<HaRoom> haRoom = haRoomService.queryRoomC(buildingId);
        HaCustom custom = haCustomService.updateByIdHaCustom(haCustom);
        model.addAttribute("haArea",haArea);
        model.addAttribute("haBuilding",haBuilding);
        model.addAttribute("haRoom",haRoom);
        model.addAttribute("custom",custom);
        model.addAttribute("custId",custid);
        return "custom/cust_update";
    }

    @RequestMapping("/JumpCustDel")
    public String cust_del(HaCustom haCustom,Model model,Integer custids){
        haCustom.setCustId(custids);
        HaCustom custom = haCustomService.updateByIdHaCustom(haCustom);
        model.addAttribute("custom",custom);
        model.addAttribute("custId",custids);
        return "custom/cust_del";
    }

    @RequestMapping("/custListJson")
    @ResponseBody
    public Object custlistjson(HaCustom haCustom) {
        startPage();
        List<HaCustom> haCustomsList = haCustomService.HaCustomList(haCustom);
        Map<String, Object> map = getDataTable(haCustomsList);
        return map;
    }

    @RequestMapping(value = "/QueryHaAreaJson",produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String queryHaAreaJson(){
        List<HaArea> haAreas = haAreaService.queryAllHaAreaC();
        if(haAreas!=null){
            return JSON.toJSONString(haAreas);
        }
        return null;
    }

    @RequestMapping(value = "/QueryHaBuildingJson",produces = "text/plain;charset=utf-8")
    @ResponseBody
    public Object queryHaBuildingJson(Integer areaId){

        return JSON.toJSONString(haBuildingService.queryHaBuildingC(areaId));
    }

    @RequestMapping(value = "/QueryRoomJson",produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String queryRoomJson(Integer buildingId){
        List<HaRoom> haRoomList = haRoomService.queryRoomC(buildingId);
        if(haRoomList!=null){
            return JSON.toJSONString(haRoomList);
        }
        return null;
    }

    @RequestMapping("/AddHaCustom")
    @ResponseBody
    public Object addHaCustom(HaCustom haCustom,Integer areaId,Integer buildingId,Integer roomId){
        haCustom.setBalance(0);
        HaArea haArea = new HaArea();
        haArea.setAreaId(areaId);
        HaBuilding haBuilding = new HaBuilding();
        haBuilding.setBuildingId(buildingId);
        HaRoom haRoom = new HaRoom();
        haRoom.setRoomId(roomId);
        haCustom.setHaArea(haArea);
        haCustom.setHaBuilding(haBuilding);
        haCustom.setHaRoom(haRoom);
        haCustom.setCreateTime(new Date());
        haCustom.setModifyTime(new Date());
        Integer custom = haCustomService.addHaCustom(haCustom);
        if(custom==1){
            return "true";
        }
        return "false";
    }

    @RequestMapping("/DeleteHaCustom")
    @ResponseBody
    public String deleteHaCustom(HaCustom haCustom){
        Integer custom = haCustomService.deleteHaCustom(haCustom);
        if(custom==1){
            return "true";
        }
        return "false";
    }

    @RequestMapping("/updateHaCustom")
    @ResponseBody
    public Object updateHaCustom(HaCustom haCustom){
        Integer custom = haCustomService.updateHaCustom(haCustom);
        if(custom==1){
            return "true";
        }
        return "false";
    }

    @RequestMapping("/showOtherInformation")
    @ResponseBody
    public Object showOtherInformation(Integer custId,HaCustom haCustom){
        haCustom.setCustId(custId);
        List<HaCustom> haCustoms = haCustomService.ByIdHaCustom(custId);
        return haCustoms;
    }

}
