package com.ktamr.web.controller.dataselect;

import com.ktamr.common.core.domain.AjaxResult;
import com.ktamr.common.utils.export.ExportExcelUtil;
import com.ktamr.common.utils.sql.SqlCondition;
import com.ktamr.domain.HaDayfreeze;
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
@RequestMapping("/dataselect/replace")
public class ReplaceController extends BaseController {

    private  String pxePath = "meter";

    @Autowired
    private HaReplaceRecordsService haReplaceRecordsService;

    @GetMapping("/replaceList")
    public String replaceList(){
        return pxePath+"/metersReplaceRecords";
    }

    @PostMapping("/replaceListJson")
    @ResponseBody
    public Map<String,Object> replaceListJson(HaReplacerecords params){
        startPage();
        params.getParams().put("getRightCondition", SqlCondition.getRightCondition("areano","area","and"));
        List<HaReplacerecords> listHaMeter = haReplaceRecordsService.selectReplace(params);
        return getDataTable(listHaMeter);
    }

    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HaReplacerecords params, ExportExcelUtil exportExcelUtil)
    {
        params.getParams().put("getRightCondition", SqlCondition.getRightCondition("areano","area","and"));
        List<HaReplacerecords> list = haReplaceRecordsService.selectReplace(params);
        return exportExcelUtil.init(list, "");
    }

}
