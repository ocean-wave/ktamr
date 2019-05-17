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

    private static final Logger log = LoggerFactory.getLogger(ExcelUtil.class);

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
    public AjaxResult export(HaBuilding haBuilding, ExcelUtilTwo excelUtilTwo)
    {
        List<HaBuilding> list = haBuildingService.selectAllBuildingAndCount(haBuilding);

        Workbook wb = new SXSSFWorkbook(500);
        Sheet sheet = wb.createSheet();
        Row row = sheet.createRow(0);
        Cell cell = null;
        cell = row.createCell(0);
        cell.setCellValue("用户编号");
        cell.setCellValue("用户名称");
        cell.setCellValue("用户地址");
        cell.setCellValue("房间备注");
        cell.setCellValue("表地址");
        cell.setCellValue("用户编号");
        cell.setCellValue("用户编号");
        cell.setCellValue("用户编号");
        OutputStream out = null;
        String filename = ExceStr.encodingFilename("房间表数据");
        try {
            out = new FileOutputStream(ExceStr.getAbsoluteFile(filename));
            wb.write(out);
        } catch (Exception e) {
            log.error("导出Excel异常{}", e.getMessage());
            throw new BusinessException("导出Excel失败，请联系网站管理员！");
        }finally {
            if (wb != null)
            {
                try
                {
                    wb.close();
                }
                catch (IOException e1)
                {
                    e1.printStackTrace();
                }
            }
            if (out != null)
            {
                try
                {
                    out.close();
                }
                catch (IOException e1)
                {
                    e1.printStackTrace();
                }
            }
        }
        return AjaxResult.success(filename);
    }
}
