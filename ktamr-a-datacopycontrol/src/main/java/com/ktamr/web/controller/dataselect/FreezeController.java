package com.ktamr.web.controller.dataselect;

import com.ktamr.common.constant.Constants;
import com.ktamr.common.core.domain.AjaxResult;
import com.ktamr.common.utils.ServletUtils;
import com.ktamr.common.utils.export.ExportExcelUtil;
import com.ktamr.common.utils.sql.SqlCondition;
import com.ktamr.domain.HaDayfreeze;
import com.ktamr.common.core.domain.BaseController;
import com.ktamr.domain.HaRgn;
import com.ktamr.domain.HavMeterinfo;
import com.ktamr.service.HaDayFreezeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/dataselect/freeze")
public class FreezeController extends BaseController {
    private  String pxePath = "meter";

    @Autowired
    private HaDayFreezeService haDayFreezeService;

    @GetMapping("/freezeList")
    public String freezeList(){
        return pxePath+"/metersFreezeReport";
    }

    @PostMapping("/freezeListJson")
    @ResponseBody
    public Map<String,Object> freezeListJson(HaDayfreeze params){
        startPage();
        params.getParams().put("getRightCondition", SqlCondition.getRightCondition("areano","area","and"));
        List<HaDayfreeze> listHaDayfreeze = haDayFreezeService.selectFreeze(params);
        List<HaDayfreeze> listHaDayfreeze2=listHaDayfreeze.stream().sorted(Comparator.comparing(HaDayfreeze::getFday).thenComparing(HaDayfreeze::getUserDs)).collect(Collectors.toList());
        return getDataTable(listHaDayfreeze,listHaDayfreeze2);
    }

    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HaDayfreeze params, ExportExcelUtil exportExcelUtil)
    {
        params.getParams().put("getRightCondition", SqlCondition.getRightCondition("areano","area","and"));
        List<HaDayfreeze> list = haDayFreezeService.selectFreeze(params);
        return exportExcelUtil.init(list, "");
    }
}
