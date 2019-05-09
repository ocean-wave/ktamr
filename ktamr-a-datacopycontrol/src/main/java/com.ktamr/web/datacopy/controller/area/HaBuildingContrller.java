package com.ktamr.web.datacopy.controller.area;

import com.ktamr.domain.HaBuilding;
import com.ktamr.service.HaBuildingService;
import com.ktamr.web.datacopy.basecontroller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/building")
public class HaBuildingContrller extends BaseController {
    private  String pxePath = "area";

    @Autowired
    private HaBuildingService haBuildingService;

    @PostMapping("/buildingsOpManageJson")
    @ResponseBody
    public Map<String,Object> buildingsOpManageJson(HaBuilding parms){
        startPage();
        List<HaBuilding> listHaBuilding = haBuildingService.selectAllBuildingAndCount(parms);
        return getDataTable(listHaBuilding);
    }
}
