package com.ktamr.web.controller.area;

import com.ktamr.common.core.domain.AjaxResult;
import com.ktamr.common.exception.BusinessException;
import com.ktamr.common.utils.poi.ExceStr;
import com.ktamr.common.utils.poi.ExcelUtil;
import com.ktamr.common.utils.poi.ExcelUtilTwo;
import com.ktamr.domain.HaBuilding;
import com.ktamr.domain.HaRgn;
import com.ktamr.service.HaBuildingService;
import com.ktamr.web.basecontroller.BaseController;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/area/building")
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

    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HaBuilding haBuilding,ExcelUtilTwo excelUtilTwo)
    {
        List<HaBuilding> list = haBuildingService.selectAllBuildingAndCount(haBuilding);
        return excelUtilTwo.init(list,"房间表数据");
    }
}
