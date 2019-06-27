package com.ktamr.web.controller.dataselect;

import com.ktamr.common.constant.Constants;
import com.ktamr.common.utils.ServletUtils;
import com.ktamr.common.utils.sql.SqlCondition;
import com.ktamr.domain.HaDayfreeze;
import com.ktamr.common.core.domain.BaseController;
import com.ktamr.service.HaDayFreezeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/dataselect")
public class FreezeController extends BaseController {
    private  String pxePath = "meter";

    @Autowired
    private HaDayFreezeService haDayFreezeService;

    @GetMapping("/freeze")
    public String freeze(){
        return pxePath+"/metersFreezeReport";
    }

    @PostMapping("/freezeListJson")
    @ResponseBody
    public Map<String,Object> freezeListJson(HaDayfreeze params){
        //startPage();
        params.getParams().put("getRightCondition", SqlCondition.getRightCondition("areano","area","and"));
        List<HaDayfreeze> listHaDayfreeze = haDayFreezeService.selectFreeze(params);
        return getDataTable(listHaDayfreeze);
    }
}
