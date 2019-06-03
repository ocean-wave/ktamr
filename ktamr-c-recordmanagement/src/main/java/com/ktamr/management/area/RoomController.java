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

    @RequestMapping("/JumpRoomMeterAdd")
    public String JumpRoomMeterAdd(String cmdName, Integer buildingId, Integer roomId, Integer meterId, Model model) {
        List<HaPricestandard> haPricestandardList = haPricestandardService.PriceStandardGenOptionSelected();
        model.addAttribute("haPricestandardList", haPricestandardList);
        model.addAttribute("cmdName", cmdName);
        model.addAttribute("buildingId", buildingId);
        model.addAttribute("roomId", roomId);
        model.addAttribute("meterId", meterId);
        return "area/room_meter_add";
    }

    @RequestMapping("/JumpRoomMeterDel")
    public String JumpRoomMeterDel() {
        return "area/room_meter_del";
    }

    @RequestMapping("/JumpRoomMeterUpdate")
    public String JumpRoomMeterUpdate() {
        return "area/room_meter_update";
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
        Integer addHaMeter = haMeterService.addHaMeter(haMeter);
        if (addHaRoomC == 1 && addHaMeter == 1) {
            return "true";
        }
        return "false";
    }

}
