package com.ktamr.web.controller.area;

import com.ktamr.common.core.domain.AjaxResult;
import com.ktamr.common.utils.export.ExportExcelUtil;
import com.ktamr.common.utils.sql.SqlCondition;
import com.ktamr.domain.HaBuilding;
import com.ktamr.common.core.domain.BaseController;
import com.ktamr.service.HaBuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/area/building")
public class HaBuildingContrller extends BaseController {

    @Autowired
    private HaBuildingService haBuildingService;

    @PostMapping("/buildingsOpManageJson")
    @ResponseBody
    public Map<String,Object> buildingsOpManageJson(HaBuilding params){
        startPage();
        params.getParams().put("getRightCondition", SqlCondition.getRightCondition("a.areano","area","and"));
        List<HaBuilding> listHaBuilding = haBuildingService.selectAllBuildingAndCount(params);
        return getDataTable(listHaBuilding);
    }

    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HaBuilding params, ExportExcelUtil exportExcelUtil)
    {
        params.getParams().put("getRightCondition", SqlCondition.getRightCondition("a.areano","area","and"));
        List<HaBuilding> list = haBuildingService.selectAllBuildingAndCount(params);
        return exportExcelUtil.init(list,"房间表数据");
    }
}
