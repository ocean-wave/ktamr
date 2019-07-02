package com.ktamr.management.operator;

import com.ktamr.common.core.domain.BaseController;
import com.ktamr.common.utils.sql.SqlCondition;
import com.ktamr.domain.HaArea;
import com.ktamr.domain.HaOperator;
import com.ktamr.domain.HaOperatorRgns;
import com.ktamr.domain.HaRgn;
import com.ktamr.service.HaAreaService;
import com.ktamr.service.HaOperatorRgnsService;
import com.ktamr.service.HaOperatorService;
import com.ktamr.service.HaRngService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.apache.shiro.util.StringUtils.split;

@Controller
@RequestMapping("/operator")
public class OperatorController extends BaseController {

    @Resource
    private HaOperatorService haOperatorService;

    @Resource
    private HaRngService haRngService;

    @Resource
    private HaAreaService haAreaService;

    @Resource
    private HaOperatorRgnsService haOperatorRgnsService;

    @RequestMapping("/operator_list")
    public String operator_list() {
        return "operator/operator_list";
    }

    @RequestMapping("/JumpOperatorAdd")
    public String jumpoperatoradd() {
        return "operator/operator_add";
    }

    @RequestMapping("/JumpOperatorUpdate")
    public String jumpoperatorupdate(HttpSession session, HaOperator haOperator, HaRgn haRgn, HaArea haArea, String operatorCode, Model model) {
        //开始读取会话
        String thisOperatorCode = (String)session.getAttribute("operatorCode");
        HaOperator haOp= (HaOperator)session.getAttribute("haOperator");
        Integer thisOperatorLeveL = haOp.getOperatorLevelCode();
        //String thisOperatorRgnType = (String)session.getAttribute("haOperatorRgnType");
        //结束读取会话

        haOperator = haOperatorService.updateByIdHaOperator(operatorCode);//修改获取haOperator的值
        haOperator.setOperatorCode(operatorCode);
        HaOperator haOperators = haOperatorService.HaOperatorGetByID(haOperator);
        HaOperator selUpperRgnType = haOperatorService.selUpperRgnType(haOperators.getOperatorUpper());
        List<HaOperatorRgns> selRgnCodeStr = haOperatorRgnsService.selRgnCodeStr(operatorCode);

        List<HaRgn> rgn2s = haRngService.rgnByWhere(haRgn);
        //开启判断模式
        HaRgn hg = new HaRgn();
        HaArea ha=new HaArea();
        List<HaRgn> hgList=null;
        List<HaArea> haList=null;
        if(thisOperatorCode.equals(haOperators.getOperatorCode()) && haOperators.getOperatorRgnType().equals("rgn")){
            hg.getParams().put("getUpperRightCondition",SqlCondition.getUpperRightCondition("id","rgn","where ",haOperators.getOperatorUpper(),selUpperRgnType.getOperatorRgnType()));
            hgList=haRngService.rgnByWhere(hg);
        }else if (thisOperatorCode.equals(haOperators.getOperatorCode()) && haOperators.getOperatorRgnType().equals("area")){
            ha.setTypeName("code");
            ha.getParams().put("getUpperRightCondition",SqlCondition.getUpperRightCondition("areaNo","area","where ",haOperators.getOperatorUpper(),selUpperRgnType.getOperatorRgnType()));
            haList= haAreaService.AreaByWhere(ha);
        }else  if(thisOperatorLeveL<=0 && haOperators.getOperatorRgnType().equals("rgn") ){
            hgList= haRngService.rgnByWhere(hg);
        }else if (thisOperatorLeveL<=0 && haOperators.getOperatorRgnType().equals("area") ){
            ha.setTypeName("code");
            haList= haAreaService.AreaByWhere(ha);
        }else if(haOperators.getOperatorRgnType().equals("rgn")){
            hg.getParams().put("getRightCondition",SqlCondition.getRightCondition("id","rgn","where "));
            hgList= haRngService.rgnByWhere(hg);
        }else if(haOperators.getOperatorRgnType().equals("area")){
            ha.setTypeName("code");
            ha.getParams().put("getRightCondition",SqlCondition.getRightCondition("areaNo","area","where "));
            haList= haAreaService.AreaByWhere(ha);
        }

        //结束判断模式
          /*  HaRgn haRgn1213 = new HaRgn();
         List<HaRgn> rgns = haRngService.rgnByWhere(haRgn1213);

        HaRgn haRgn3 = new HaRgn();
        haRgn3.getParams().put("getRightCondition",SqlCondition.getRightCondition("id","rgn",""));
        List<HaRgn> rgn3s = haRngService.rgnByWhere(haRgn3);

        haArea.setTypeName("code");
        haArea.getParams().put("getUpperRightCondition",SqlCondition.getUpperRightCondition("areaNo","area","",haOperator.getOperatorUpper(),selUpperRgnType.getOperatorRgnType()));
        List<HaArea> haArea1s = haAreaService.AreaByWhere(haArea);

        HaArea haArea2 = new HaArea();
        haArea2.setTypeName("code");
        List<HaArea> haArea2s = haAreaService.AreaByWhere(haArea2);

        HaArea haArea3 = new HaArea();
        haArea3.setTypeName("code");
        haArea3.getParams().put("getRightCondition",SqlCondition.getRightCondition("areaNo","area",""));
        List<HaArea> haArea3s = haAreaService.AreaByWhere(haArea3);*/

        List<HaRgn> queryRgnByRgn = haRngService.queryRgnByRgn();
        List<HaArea> queryAreaByArea = haAreaService.queryAreaByArea();
      /*  model.addAttribute("rgns",rgns);
        model.addAttribute("rgn2s",rgn2s);
        model.addAttribute("rgn3s",rgn3s);
        model.addAttribute("haArea1s",haArea1s);
        model.addAttribute("haArea2s",haArea2s);
        model.addAttribute("haArea3s",haArea3s);*/
        model.addAttribute("haOperators",haOperators);
        model.addAttribute("hgList",hgList);
        model.addAttribute("haList",haList);
        model.addAttribute("haOperator", haOperator);
        model.addAttribute("selUpperRgnType", selUpperRgnType);
        model.addAttribute("selRgnCodeStr",selRgnCodeStr);
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
    public Object addHaOperator(HaOperator haOperator,HaOperatorRgns haOperatorRgns) {
        HaOperator operator = haOperatorService.updateByIdHaOperator(haOperator.getOperatorCode());
        if(operator!=null){
            return "false";
        }else {
            haOperator.setOperatorCreatTime(new Date());
            Integer haOperators = haOperatorService.addHaOperator(haOperator);
            String operatorRgn = haOperator.getOperatorRgn();
            if(!operatorRgn.equals("")){
                String[] operatorRgnArray = split(operatorRgn);
                for(int i=0;i<operatorRgnArray.length;i++){
                    String s = operatorRgnArray[i];
                    haOperatorRgns.setOperatorCode(haOperator.getOperatorCode());
                    haOperatorRgns.setRgnCode(s);
                    Integer OperatorRgns = haOperatorRgnsService.addHaOperatorRgns(haOperatorRgns);
                }
            }
            if (haOperators == 1) {
                return "true";
            }
            return "false";
        }
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
    public Object updateHaOperator(HaOperator haOperator,HaOperatorRgns haOperatorRgns) {
        Integer updateHaOperator = haOperatorService.updateHaOperator(haOperator);
        if(haOperator.getOperatorPwd()!=null){
            Integer changePWD = haOperatorService.ChangePWD(haOperator);
        }
        String operatorRgn = haOperator.getOperatorRgn();
        haOperatorRgns.setOperatorCode(haOperator.getOperatorCode());
        haOperatorRgnsService.deleteHaOperatorRgns(haOperatorRgns);
        if(!operatorRgn.equals("")){
            String[] operatorRgnArray = split(operatorRgn);
            for(int i=0;i<operatorRgnArray.length;i++){
                String s = operatorRgnArray[i];
                haOperatorRgns.setOperatorCode(haOperator.getOperatorCode());
                haOperatorRgns.setRgnCode(s);
                Integer OperatorRgns = haOperatorRgnsService.addHaOperatorRgns(haOperatorRgns);
            }
        }
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
