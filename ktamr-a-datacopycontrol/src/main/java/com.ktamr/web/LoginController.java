package com.ktamr.web;

import com.ktamr.domain.HaOperator;
import com.ktamr.service.HaOperatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    private HaOperatorService haOperatorService;

    @RequestMapping("/")
    public String index(){
        return "login";
    }

    @RequestMapping("/login")
    @ResponseBody
    public String login(@RequestParam( value = "uid") String uid,
                        @RequestParam( value = "pwd") String pwd
                        , ModelMap mmap, HttpSession session){
        HaOperator haOperator = haOperatorService.selectOperatorByUid(uid);
        if(haOperator.getOperatorPwd().trim().equals(pwd.trim())){
            String rgnid = haOperatorService.selectOperatorRgnByName(haOperator.getOperatorName());
            String areano = haOperatorService.selectOperatorAreaByName(haOperator.getOperatorName());
            session.setAttribute("operatorRgnType",haOperator.getOperatorRgnType());
            session.setAttribute("rgnStr",rgnid);
            session.setAttribute("areaNo",areano);
            session.setAttribute("operatorName",haOperator.getOperatorName());
            session.setAttribute("operatorCompanyId",haOperator.getOperatorCompany());
            session.setAttribute("operatorCode",haOperator.getOperatorCode());
            Integer operatorLevelCode = -1;
            switch (haOperator.getOperatorLevel()){
                case "admin":
                    operatorLevelCode = 0;
                    break;
                case "normal":
                    operatorLevelCode = 1;
                    break;
                case "readMan":
                    operatorLevelCode = 2;
                    break;
                case "viewMan":
                    operatorLevelCode = 3;
                    break;
            }
            session.setAttribute("operatorLevelCode",operatorLevelCode);
            session.setAttribute("operatorLevel",haOperator.getOperatorLevel());
            return "true";
        }
        return "false";
    }
}
