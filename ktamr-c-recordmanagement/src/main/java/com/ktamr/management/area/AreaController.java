package com.ktamr.management.area;

//import com.ktamr.system.domain.HaRgn;
//import com.ktamr.system.service.HaRgnService;
//import com.ktamr.system.util.PageUtil;

import com.ktamr.domain.HaArea;
import com.ktamr.domain.HaRgn;
import com.ktamr.service.HaAreaService;
import com.ktamr.service.HaRngService;
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
@RequestMapping("/area")
public class AreaController {

    @Resource
    private HaAreaService haAreaService;

    @Resource
    private HaRngService haRngService;

    @RequestMapping("/area_op_manage")
    public String area_op_manage() {
        return "area/area_op_manage";
    }

    @RequestMapping("/QueryAllHaArea")
    @ResponseBody
    public Object queryAllHaArea() {
        List<HaArea> haAreasList = haAreaService.queryAllHaAreaC();
        return haAreasList;
    }

    @RequestMapping("/JumpAreaAdd")
    public String JumpAreaAdd(Model model) {
        List<HaRgn> haRgn = haRngService.queryAllRngC();
        model.addAttribute("haRgn", haRgn);
        return "area/area_add";
    }

    @RequestMapping("/JumpAreaDelete")
    public String JumpAreaDelete(Integer areaId, Model model) {
        HaArea area = haAreaService.updateByIdHaAreaC(areaId);
        model.addAttribute("area", area);
        model.addAttribute("areaId", areaId);
        return "area/area_del";
    }

    @RequestMapping("/JumpAreaUpdate")
    public String JumpAreaUpdate(Integer areaId, Model model) {
        HaArea area = haAreaService.updateByIdHaAreaC(areaId);
        List<HaRgn> haRgn = haRngService.queryAllRngC();
        model.addAttribute("haRgn", haRgn);
        model.addAttribute("area", area);
        model.addAttribute("areaId", areaId);
        return "area/area_update";
    }

    @RequestMapping("/JumpRoomMeterAdd")
    public String JumpRoomMeterAdd(){
        return "area/room_meter_add";
    }

    @RequestMapping("/JumpRoomMeterDel")
    public String JumpRoomMeterDel(){
        return "area/room_meter_del";
    }

    @RequestMapping("/JumpRoomMeterUpdate")
    public String JumpRoomMeterUpdate(){
        return "area/room_meter_update";
    }

    @RequestMapping("/QueryAllSmallAreaJson")
    @ResponseBody
    public Object queryAllSmallAreaJson(HaArea haArea, HttpServletRequest request) {
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
        List<HaArea> allSmallArea = haAreaService.queryAllSmallArea(haArea, pageRows, page2);
        Integer smallAreaCount = haAreaService.smallAreaCount(haArea);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("page", page);//设置初始的页码 就是第几页
        map.put("rowNum", pageRows);//一页显示几条数据
        map.put("records", smallAreaCount);//总记录数
        map.put("total", (smallAreaCount - 1) / pageRows + 1);//总页数的计算
        map.put("rows", allSmallArea);//存放集合

        int meterCount = 0;
        for (int i = 0; i < allSmallArea.size(); i++) {
            meterCount += allSmallArea.get(i).getHaMeter().getHaMeterCount();
        }
        Map<String, Object> map2 = new HashMap<String, Object>();
        map2.put("cb", "总计:");
        map2.put("haMeter.haMeterCount", meterCount);
        map.put("userdata", map2);
        return map;
    }

    @RequestMapping("/AddArea")
    @ResponseBody
    public Object addArea(HaArea haArea) {
        haArea.setReserved("false");
        haArea.setAuditResult("无稽核");
        haArea.setCreateTime(new Date());
        haArea.setModifyTime(new Date());
        Integer area = haAreaService.addHaAreaC(haArea);
        if (area == 1) {
            return "true";
        }
        return "false";
    }

    @RequestMapping("/DeleteArea")
    @ResponseBody
    public Object deleteArea(Integer areaId, HaArea haArea) {
        haArea.setAreaId(areaId);
        Integer area = haAreaService.deleteHaAreaC(haArea);
        if (area == 1) {
            return "删除成功";
        }
        return "false";
    }

    @RequestMapping("/UpdateArea")
    @ResponseBody
    public Object updateArea(Integer areaId, HaArea haArea) {
        haArea.setAreaId(areaId);
        Integer area = haAreaService.updateHaArea(haArea);
        if (area == 1) {
            return "true";
        }
        return "false";
    }

    @RequestMapping("/RowEditing")
    @ResponseBody
    public String rowEditing(HaArea haArea,char OpNumber) {
        String switchAreaFreezeRead = "false";
        switch (OpNumber) {
            case '1':
                break;
            case '2':
                break;
            case '3':
                if (haArea.getReserved().equals("true")) {
                    haArea.setReserved("Y");
                } else {
                    haArea.setReserved("N");
                }
                Integer queryHaAreaCount = haAreaService.queryHaAreaCountC(haArea);
                if (queryHaAreaCount > 0) {
                    Integer updateHaArea = haAreaService.updateHaArea(haArea);
                    if (updateHaArea > 0) {
                        switchAreaFreezeRead = "true";
                    }
                }
                break;
            default:
        }
        return switchAreaFreezeRead;
    }
}
