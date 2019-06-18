package com.ktamr.management.area;

import com.ktamr.common.core.domain.BaseController;
import com.ktamr.domain.*;
import com.ktamr.service.*;
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
@RequestMapping("/room")
public class RoomController extends BaseController {

    @Resource
    private HaRoomService haRoomService;

    @Resource
    private HaCollectorService haCollectorService;

    @Resource
    private HaCentorService haCentorService;

    @Resource
    private HaPricestandardService haPricestandardService;

    @Resource
    private HaMeterService haMeterService;

    @Resource
    private HaDayFreezeService haDayFreezeService;

    @Resource
    private HaMonFreezeService haMonFreezeService;

    @Resource
    private HavMeterinfoService havMeterinfoService;

    @Resource
    private HaAreaService haAreaService;

    @RequestMapping("/JumpRoomMeterAdd")
    public String JumpRoomMeterAdd(String cmdName, Integer buildingId, Model model) {
        List<HaPricestandard> haPricestandardList = haPricestandardService.PriceStandardGenOptionSelected();
        model.addAttribute("haPricestandardList", haPricestandardList);
        model.addAttribute("cmdName", cmdName);
        model.addAttribute("buildingId", buildingId);
        return "area/room_meter_add";
    }

    @RequestMapping("/JumpRoomMeterDel")
    public String JumpRoomMeterDel(Integer meterId,Integer roomId,Model model) {
        HaRoom haRoom = new HaRoom();
        haRoom.setRoomId(roomId);
        HaRoom room = haRoomService.delByIdHaRoom(haRoom);
        HaMeter haMeter = new HaMeter();
        haMeter.setMeterId(meterId);
        HaMeter meter = haMeterService.delByIdHaMeter(haMeter);
        HaPricestandard haPricestandards = haPricestandardService.queryPName(meter.getPricestandId());
        model.addAttribute("room",room);
        model.addAttribute("meter",meter);
        model.addAttribute("haPricestandards",haPricestandards);
        model.addAttribute("meterId",meterId);
        return "area/room_meter_del";
    }

    @RequestMapping("/JumpRoomMeterUpdate")
    public String JumpRoomMeterUpdate(Integer roomId,Integer meterId,Model model) {
        HaRoom haRoom = new HaRoom();
        haRoom.setRoomId(roomId);
        HaRoom room = haRoomService.delByIdHaRoom(haRoom);
        HaMeter haMeter = new HaMeter();
        haMeter.setMeterId(meterId);
        HaMeter meter = haMeterService.delByIdHaMeter(haMeter);
        HaPricestandard haPricestandards = haPricestandardService.queryPName(meter.getPricestandId());
        List<HaPricestandard> pricestandards = haPricestandardService.queryPriceStandardList();
        HaRoom byHaRoomAreaId = haRoomService.getByHaRoomAreaId(roomId);
        HaRoom byHaRoomBuildingId = haRoomService.getByHaRoomBuildingId(roomId);
        List<HaArea> haArea = haAreaService.queryAllHaAreaC();
        HaCentor centor = haCentorService.updateByDeviceType(meter.getCentorId());
        model.addAttribute("room",room);
        model.addAttribute("meter",meter);
        model.addAttribute("haPricestandards",haPricestandards);
        model.addAttribute("meterId",meterId);
        model.addAttribute("roomId",roomId);
        model.addAttribute("pricestandard",pricestandards);
        model.addAttribute("byHaRoomAreaId",byHaRoomAreaId);
        model.addAttribute("byHaRoomBuildingId",byHaRoomBuildingId);
        model.addAttribute("haArea",haArea);
        model.addAttribute("centor",centor);
        return "area/room_meter_update";
    }

    @RequestMapping("/JumpRoomDel")
    public String JumpRoomDel(Integer roomId,Model model){
        HaRoom haRoom = new HaRoom();
        haRoom.setRoomId(roomId);
        HaRoom room = haRoomService.delByIdHaRoom(haRoom);
        Integer countNum = haMeterService.meterCountNum(roomId);
        model.addAttribute("room",room);
        model.addAttribute("roomId",roomId);
        model.addAttribute("countNum",countNum);
        return "area/room_del";
    }

    @RequestMapping("/QueryAllRoomJson")
    @ResponseBody
    public Object queryAllRoomJson(HaRoom haRoom) {
        startPage();
        List<HaRoom> allRoom = haRoomService.queryAllRoomC(haRoom);
        Map<String, Object> map = getDataTable(allRoom);
        return map;
    }

    @RequestMapping("/LoadDeviceOption")
    @ResponseBody
    public Object loadDeviceOption(String deviceType, Integer deviceId) {
        if (deviceId != null) {
            List<HaCollector> collectorByDeviceId = haCollectorService.collectorByDeviceId(deviceId);
            return collectorByDeviceId;
        } else {
            if (deviceType.equals("centor")) {
                List<HaCentor> centors = haCentorService.deviceTypeCentor();
                return centors;
            } else if (deviceType.equals("ccentor")) {
                List<HaCentor> ccentors = haCentorService.deviceTypeCcentor();
                return ccentors;
            } else if (deviceType.equals("handDevice")) {
                List<HaCentor> handDevice = haCentorService.deviceTypehandDevice();
                return handDevice;
            }
        }
        return null;
    }

    @RequestMapping("/RoomMeterAdd")
    @ResponseBody
    public Object roomMeterAdd(HaRoom haRoom, HaMeter haMeter) {
        Integer addHaRoomC = haRoomService.addHaRoomC(haRoom);
        if (addHaRoomC == 1) {
            HaRoom lastId = haRoomService.getLastId();
            haMeter.setRoomId(lastId.getRoomId());
            Integer addHaMeter = haMeterService.addHaMeter(haMeter);
            return "true";
        }
        return "false";
    }

    @RequestMapping("/RoomMeterDel")
    @ResponseBody
    public Object roomMeterDel(Integer meterId,HaMeter haMeter){
        haMeter.setMeterId(meterId);
        Integer meter = haMeterService.deleteHaMeter(haMeter);
//        Integer dayFreeze = haDayFreezeService.delHaDayFreeze(meterId);
//        Integer monFreeze = haMonFreezeService.delHaMonFreeze(meterId);
        if(meter==1){
            return "true";
        }
        return "false";
    }

    @RequestMapping("/RoomDel")
    @ResponseBody
    public Object roomDel(Integer roomId){
        Integer roomC = haRoomService.deleteHaRoomC(roomId);
        if(roomC==1){
            return "true";
        }
        return "false";
    }

    @RequestMapping("/ChangeForm")
    @ResponseBody
    public Object changeForm(HavMeterinfo havMeterinfo) {
        startPage();
        List<HavMeterinfo> havMeterinfos = havMeterinfoService.changeFormByAreaId(havMeterinfo);
        Map<String, Object> map = getDataTable(havMeterinfos);
        return map;
    }

    @RequestMapping("/DeviceByWhere")
    @ResponseBody
    public Object DeviceByWhere(String deviceType){
        List<HaCentor> haCentors = haCentorService.DeviceByWhere(deviceType);
        return haCentors;
    }

    @RequestMapping("/UpdateRoom")
    @ResponseBody
    public Object updateRoom(String opType,Integer meterId,Integer centorId,Integer collectorId,Integer meterNumber,HaRoom haRoom,HaMeter haMeter){
        Object centorDevNo = null;
        Object mMeterSequences = null;
        Object nconf=null;
        if(opType.equals("updateMeter")){
            Integer haRoomC = haRoomService.updateHaRoomC(haRoom);
            if(centorId==null){
                centorDevNo.equals("X");
                centorId=null;
            }else{
                centorDevNo = haCentorService.centorDevNo(centorId);
                HaCentor centorDevDescription = haCentorService.centorDevDescription(centorId);
                if(centorDevDescription.getDescription().substring(0, 5).equals("KT4EW")){
                    mMeterSequences = haMeterService.mMeterSequence(meterId);
                    if(((HaMeter) mMeterSequences).getMeterSequence()==0){
                        mMeterSequences = haMeterService.mMeterSequence2(centorId,centorId);
                        if(mMeterSequences.equals("") || mMeterSequences.equals(0)){
                            mMeterSequences.equals(1);
                        }else if(((HaMeter) mMeterSequences).getMeterSequence()-0>65535){
                            mMeterSequences=null;
                        }
                    }
                }
            }
            if(collectorId==null || collectorId==-1){
                nconf.equals("X");
                collectorId=null;
            }else{
                nconf = haCollectorService.getNconf(collectorId);
            }
            String addr = centorDevNo.toString()+nconf+meterNumber;
            haMeter.setAddr(addr);
            haMeter.setMeterNumber(meterNumber);
            haMeter.setMeterId(meterId);
            Integer meter = haMeterService.updateHaMeter(haMeter);
            if(haRoomC==1 && meter==1){
                return "true";
            }
            return false;
        }else if(opType.equals("changeMeter")){
            Integer haRoomC = haRoomService.updateHaRoomC(haRoom);
            if(haRoomC==1){
                return "true";
            }
            return false;
        }
        return null;
    }

}
