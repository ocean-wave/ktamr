package com.ktamr.web.controller;

import com.ktamr.common.config.Global;
import com.ktamr.ShiroUtils;
import com.ktamr.domain.HaOperator;
import com.ktamr.domain.HaOperatorRgns;
import com.ktamr.service.HaOperatorRgnsService;
import com.ktamr.service.HaOperatorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class indexContrller {

    @Resource
    private HaOperatorService haOperatorService;
    @Resource
    private HaOperatorRgnsService haOperatorRgnsService;

    /**
     * 打开主页
     * @param mmap
     * @param session
     * @param haOperatorRgns
     * @return
     */
    @RequestMapping("/index")
    public String index(ModelMap mmap, HttpSession session, HaOperatorRgns haOperatorRgns){
        session.setAttribute("webVersion", Global.getWebVersion());
        session.setAttribute("version", Global.getVersion());
        session.setAttribute("haOperator", ShiroUtils.getHaOperator());
        session.setAttribute("operatorCode", ShiroUtils.getOperatorCode());
        HaOperator haOperator = (HaOperator)session.getAttribute("haOperator");
        session.setAttribute("haOperatorCompanyId",haOperator.getOperatorCompanyId());
        session.setAttribute("haOperatorRgnType",haOperator.getOperatorRgnType());//登录时候获取并存放haOperatorRgnType

        //获取用户授权区域字符串 begin
        String operatorCode = (String)session.getAttribute("operatorCode");//第一个参数
        String operatorRgnType = haOperator.getOperatorRgnType();
        if(operatorRgnType!=null){
            operatorRgnType=operatorRgnType.trim();//第二个参数
        }
       if(!operatorRgnType.equals("rgn") && !operatorRgnType.equals("area")){
            session.setAttribute("rgnStr", "");
            session.setAttribute("leftRgnStr", "");
            return "index";
        }
        haOperatorRgns.setOperatorCode(operatorCode);
        List<HaOperatorRgns> sql1 = haOperatorRgnsService.sql1(haOperatorRgns);
        String rgnStr = "";
        String leftRgnStr = "";
        if(sql1!=null){

            for (int i=0;i<sql1.size();i++){
                rgnStr=rgnStr+sql1.get(i).getRgnCode()+",";
            }

            rgnStr= rgnStr.substring(0,rgnStr.lastIndexOf(","));
        }
        if (operatorRgnType.equals("area")){
            List<HaOperatorRgns> sql2 = haOperatorRgnsService.sql2(haOperatorRgns);
            for (int i=0;i<sql2.size();i++){
                leftRgnStr=leftRgnStr+sql2.get(i).getRgnCode()+",";
            }
            leftRgnStr= leftRgnStr.substring(0,leftRgnStr.lastIndexOf(","));
        }
        //获取用户授权区域字符串 end
        session.setAttribute("rgnStr", rgnStr);
        session.setAttribute("leftRgnStr", leftRgnStr);
        return "index";
    }

    /**
     * 打开修改密码界面
     * @return
     */
    @RequestMapping("/operator/operator_pwd_change")
    public  String openPasswordChange(){
        return "operator/operatorPwdChange";
    }

    /**
     * 对其修改密码进行操作
     * @return
     */
    @RequestMapping("/operator_pwd_change_do")
    @ResponseBody
    public String operator_pwd_change_do(@RequestParam( value = "new_pwd") String new_pwd, HaOperator haOperator){
        String s = haOperatorService.CheckPwd(haOperator);//获取当前账户的密码
        if(s.equals(haOperator.getOperatorPwd())){
             if(new_pwd!=null){
                 haOperator.setOperatorPwd(new_pwd);
             }
            Integer changePWD = haOperatorService.ChangePWD(haOperator);//进行修改，返回受影响的行数
            if(changePWD!=null && changePWD>0){
                return "";//返回空代表操作成功
            }

        }
        return "原密码错误";
    }
}
