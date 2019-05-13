package com.ktamr.web.datacopy.controller.dataselect;

import com.ktamr.common.parameter.ParameterInfo;
import com.ktamr.domain.HaReplacerecords;
import com.ktamr.service.HaMeterService;
import com.ktamr.service.HaRecordsService;
import com.ktamr.service.HaReplaceRecordsService;
import com.ktamr.web.datacopy.basecontroller.BaseController;
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
public class ReplaceController extends BaseController {

    private  String pxePath = "meter";

    @Autowired
    private HaReplaceRecordsService haReplaceRecordsService;

    @GetMapping("/replace")
    public String replace(){
        return pxePath+"/metersReplaceRecords";
    }

    @PostMapping("/replaceListJson")
    @ResponseBody
    public Map<String,Object> replaceListJson(HaReplacerecords parms){
        startPage();
        List<HaReplacerecords> listHaMeter = haReplaceRecordsService.selectReplace(parms);
        return getDataTable(listHaMeter);
    }

}
