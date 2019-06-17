package com.ktamr.web;

import com.ktamr.common.utils.ServletUtils;
import com.ktamr.common.utils.StringUtils;
import com.ktamr.common.core.domain.BaseController;
import com.ktamr.service.HaCentorService;
import com.ktamr.service.HaOperatorService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController extends BaseController {

    @Resource
    private HaCentorService haCentorService;

    @GetMapping("/login")
    public String login(HttpServletRequest request, HttpServletResponse response)
    {
        // 如果是Ajax请求，返回Json字符串。
        if (ServletUtils.isAjaxRequest(request))
        {
            return ServletUtils.renderString(response, "{\"code\":\"1\",\"msg\":\"未登录或登录超时。请重新登录\"}");
        }

        return "login";
    }

    /**
     * 登录的方法
     * @param uid
     * @param pwd
     * @param mmap
     * @return
     */
    @PostMapping("/login")
    @ResponseBody
    public String login(@RequestParam( value = "uid") String uid,
                        @RequestParam( value = "pwd") String pwd
                        , ModelMap mmap, HttpSession session){
        UsernamePasswordToken token = new UsernamePasswordToken(uid, pwd);
        Subject subject = SecurityUtils.getSubject();
        try
        {
            subject.login(token);
            //这里获取集中器,集采器,手抄器,DTU 
            Integer centor_count = haCentorService.centor_count(uid);
            Integer collector_count = haCentorService.collector_count(uid);
            Integer pad_count1 = haCentorService.pad_count1(uid);
            Integer pad_count2 = haCentorService.pad_count2(uid);
            Integer DTU_count = haCentorService.DTU_count(uid);
            if(centor_count!=null&&collector_count!=null&&pad_count1!=null&&pad_count2!=null&&DTU_count!=null){
                session.setAttribute("centor_count",centor_count);
                session.setAttribute("collector_count",collector_count);
                session.setAttribute("pad_count1",pad_count1);
                session.setAttribute("pad_count2",pad_count2);
                session.setAttribute("DTU_count",DTU_count);
            }

            return "true";
        }
        catch (AuthenticationException e)
        {
            String msg = "";
            if (StringUtils.isNotEmpty(e.getMessage()))
            {
                msg = e.getMessage();
            }
            return msg;
        }
    }
}
