package com.ktamr.web.controller.area;

import com.ktamr.common.core.domain.AjaxResult;
import com.ktamr.common.utils.poi.ExcelUtil;
import com.ktamr.domain.HaArea;
import com.ktamr.service.HaAreaService;
import com.ktamr.web.basecontroller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/area")
public class HaAreaContrller extends BaseController{
    private  String pxePath = "area";

    @Autowired
    private HaAreaService haAreaService;

    @PostMapping("/areasOpManageJson")
    @ResponseBody
    public Map<String,Object> areasOpManageJson(HaArea parms){
        startPage();
        List<HaArea> listHaArea = haAreaService.selectAllAreaAndCount(parms);
        Map<String,String> map2 = new HashMap<String,String>();
        Map<Integer,String> mi = new HashMap<Integer, String>();
        mi.put(0,"zBs");
        mi.put(1,"zDs");
        mi.put(2,"bqyl");
        mi.put(3,"blbs");
        Map<Integer,Integer> ms = getValuesByKey(listHaArea,mi);
        map2.put("cb","总计:");
        map2.put("resultParams.zBs",ms.get(0).toString());
        map2.put("resultParams.zDs",ms.get(1).toString());
        map2.put("resultParams.bqyl",ms.get(2).toString());
        map2.put("resultParams.blbs",ms.get(3).toString());
        Map<String,Object> m = getDataTable(listHaArea);
        m.put("userdata",map2);
        return m;
    }

    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HaArea haArea)
    {
        List<HaArea> list = haAreaService.selectAllAreaAndCount(haArea);
        ExcelUtil<HaArea> util = new ExcelUtil<HaArea>(HaArea.class);
        return util.exportExcel(list, "小区表抄控");
    }
}
