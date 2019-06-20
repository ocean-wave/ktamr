package com.ktamr.web.controller;

import com.ktamr.common.config.Global;
import com.ktamr.ShiroUtils;
import com.ktamr.domain.HaOperator;
import com.ktamr.service.HaOperatorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
public class indexContrller {

    @Resource
    private HaOperatorService haOperatorService;

    @RequestMapping("/index")
    public String index(ModelMap mmap, HttpSession session){
        session.setAttribute("webVersion", Global.getWebVersion());
        session.setAttribute("version", Global.getVersion());
        session.setAttribute("haOperator", ShiroUtils.getHaOperator());
        session.setAttribute("operatorCode", ShiroUtils.getOperatorCode());
        session.setAttribute("rgnAndAreaId", ShiroUtils.getRgnAndAreaId());
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
