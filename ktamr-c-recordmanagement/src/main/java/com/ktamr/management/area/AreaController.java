package com.ktamr.management.area;

//import com.ktamr.system.domain.HaRgn;
//import com.ktamr.system.service.HaRgnService;
//import com.ktamr.system.util.PageUtil;

import com.ktamr.common.core.domain.BaseController;
import com.ktamr.common.utils.sql.SqlCondition;
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
public class AreaController extends BaseController {

    @Resource
    private HaAreaService haAreaService;

    @Resource
    private HaRngService haRngService;

    @RequestMapping("/area_op_manage")
    public String area_op_manage(String appPage,Model model) {
        appPage = "management";
        model.addAttribute("appPage",appPage);
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

    @RequestMapping("/QueryAllSmallAreaJson")
    @ResponseBody
    public Object queryAllSmallAreaJson(HaArea haArea) {
        startPage();
        haArea.getParams().put("getRightCondition", SqlCondition.getRightCondition("a.areano","area","and"));
        List<HaArea> allSmallArea = haAreaService.queryAllSmallArea(haArea);
        Map<String, Object> map = getDataTable(allSmallArea);
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
        }else if (area==0){
            return  "有重复";
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

    /**
     * 添加时验证小区编号，小区名字，小区测名
     * @param haArea
     * @return
     */
    @RequestMapping("/addingCellValidation")
    @ResponseBody
    public String addingCellValidation(HaArea haArea){
        Integer addingCellValidation = haAreaService.addingCellValidation(haArea);
        if(addingCellValidation==1){
            return "True";
        }
        return "false";
    }
}
