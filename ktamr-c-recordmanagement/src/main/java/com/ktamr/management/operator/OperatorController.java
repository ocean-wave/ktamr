package com.ktamr.management.operator;

import com.ktamr.common.core.domain.BaseController;
import com.ktamr.domain.HaArea;
import com.ktamr.domain.HaOperator;
import com.ktamr.domain.HaRgn;
import com.ktamr.service.HaAreaService;
import com.ktamr.service.HaOperatorService;
import com.ktamr.service.HaRngService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/operator")
public class OperatorController extends BaseController {

    @Resource
    private HaOperatorService haOperatorService;

    @Resource
    private HaRngService haRngService;

    @Resource
    private HaAreaService haAreaService;

    @RequestMapping("/operator_list")
    public String operator_list() {
        return "operator/operator_list";
    }

    @RequestMapping("/JumpOperatorAdd")
    public String jumpoperatoradd() {
        return "operator/operator_add";
    }

    @RequestMapping("/JumpOperatorUpdate")
    public String jumpoperatorupdate(String operatorCode, Model model) {
        HaOperator haOperator = haOperatorService.updateByIdHaOperator(operatorCode);
        HaOperator selUpperRgnType = haOperatorService.selUpperRgnType(haOperator.getOperatorCode());
        List<HaRgn> queryRgnByRgn = haRngService.queryRgnByRgn();
        List<HaArea> queryAreaByArea = haAreaService.queryAreaByArea();
        model.addAttribute("haOperator", haOperator);
        model.addAttribute("selUpperRgnType", selUpperRgnType);
        model.addAttribute("queryRgnByRgn", queryRgnByRgn);
        model.addAttribute("queryAreaByArea", queryAreaByArea);
        model.addAttribute("operatorCode", operatorCode);
        return "operator/operator_update";
    }

    @RequestMapping("/operatorListJson")
    @ResponseBody
    public Object operatorlistjson(HaOperator haOperator) {
        startPage();
        List<HaOperator> haOperatorsList = haOperatorService.HaOperatorList(haOperator);
        Map<String, Object> map = getDataTable(haOperatorsList);
        return map;
    }

    @RequestMapping("/AddHaOperator")
    @ResponseBody
    public Object addHaOperator(HaOperator haOperator) {
        haOperator.setOperatorCreatTime(new Date());
        Integer haOperators = haOperatorService.addHaOperator(haOperator);
        if (haOperators == 1) {
            return "true";
        }
        return "false";
    }

    @RequestMapping("/DeleteHaOperator")
    @ResponseBody
    public Object deleteHaOperator(HaOperator haOperator) {
        Integer haOperators = haOperatorService.deleteHaOperator(haOperator);
        if (haOperators != null) {
            return "";
        }
        return "false";
    }

    @RequestMapping("/UpdateHaOperator")
    @ResponseBody
    public Object updateHaOperator(HaOperator haOperator) {
        Integer updateHaOperator = haOperatorService.updateHaOperator(haOperator);
        if (updateHaOperator == 1) {
            return "true";
        }
        return "false";
    }

    //根据区域类型选择所属区域
    @RequestMapping("/LoadSelectOption")
    @ResponseBody
    public Object LoadSelectOption(String selectType, String op) {
        if (selectType.equals("rgn") && op.equals("add")) {
            List<HaRgn> queryRgnByRgn = haRngService.queryRgnByRgn();
            return queryRgnByRgn;
        } else if (selectType.equals("area") && op.equals("add")) {
            List<HaArea> queryAreaByArea = haAreaService.queryAreaByArea();
            return queryAreaByArea;
        }
        return null;
    }
}
