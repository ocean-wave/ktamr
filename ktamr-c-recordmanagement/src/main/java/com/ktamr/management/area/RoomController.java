package com.ktamr.management.area;

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
public class RoomController {

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
    public Object queryAllRoomJson(HaRoom haRoom, HttpServletRequest request) {
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

        List<HaRoom> allRoom = haRoomService.queryAllRoomC(haRoom, pageRows, page2);
        Integer roomCount = haRoomService.allRoomCountC(haRoom);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("page", page);//设置初始的页码 就是第几页
        map.put("rowNum", pageRows);//一页显示几条数据
        map.put("records", roomCount);//总记录数
        map.put("total", (roomCount - 1) / pageRows + 1);//总页数的计算
        map.put("rows", allRoom);//存放集合
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
