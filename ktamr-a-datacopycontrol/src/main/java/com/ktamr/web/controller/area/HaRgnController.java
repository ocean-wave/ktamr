package com.ktamr.web.controller.area;

import com.ktamr.common.core.domain.AjaxResult;
import com.ktamr.common.utils.export.ExportExcelUtil;
import com.ktamr.common.utils.sql.SqlCondition;
import com.ktamr.domain.HaRgn;
import com.ktamr.common.core.domain.BaseController;
import com.ktamr.service.HaRngService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/area/rgn")
public class HaRgnController extends BaseController {
    private  String pxePath = "area";

    @Autowired
    private HaRngService haRngService;

    @GetMapping()
    public String areasOpManage(){
        return pxePath+"/areasOpManage";
    }

    @PostMapping("/areasOpManageJson")
    @ResponseBody
    public Map<String,Object> areasOpManageJson(HaRgn params){
        startPage();
        params.getParams().put("getRightCondition", SqlCondition.getRightCondition("n.id","rgn","and"));
        List<HaRgn> listHaRng = haRngService.selectAllRngAndCount(params);
        Map<String,String> map2 = new HashMap<String,String>();
        Map<Integer,String> mi = new HashMap<Integer, String>();
        mi.put(0,"haAreaCount");
        mi.put(1,"haCentorCount");
        mi.put(2,"haCollectorCount");
                mi.put(3,"haMeterCount");
        Map<Integer,Integer> mm = getValuesByKey(listHaRng,mi);
        map2.put("cb","总计:");
        map2.put("haAreaCount",mm.get(0).toString());
        map2.put("haCentorCount",mm.get(1).toString());
        map2.put("haCollectorCount",mm.get(2).toString());
        map2.put("haMeterCount",mm.get(3).toString());
        Map<String,Object> m =getDataTable(listHaRng);
        m.put("userdata",map2);
        return m;
    }

    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HaRgn params, ExportExcelUtil exportExcelUtil)
    {
        params.getParams().put("getRightCondition", SqlCondition.getRightCondition("n.id","rgn","and"));
        List<HaRgn> list = haRngService.selectAllRngAndCount(params);
        return exportExcelUtil.init(list, "大区表数据");
    }
}
