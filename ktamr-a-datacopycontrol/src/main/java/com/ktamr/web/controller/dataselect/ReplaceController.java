package com.ktamr.web.controller.dataselect;

import com.ktamr.domain.HaReplacerecords;
import com.ktamr.common.core.domain.BaseController;
import com.ktamr.service.HaReplaceRecordsService;
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
