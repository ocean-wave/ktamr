package com.ktamr.web;

import com.ktamr.common.core.domain.AjaxResult;
import com.ktamr.common.core.domain.BaseController;
import com.ktamr.common.core.domain.BaseEntity;
import com.ktamr.common.utils.ServletUtils;
import com.ktamr.common.utils.StringUtils;
import com.ktamr.domain.HaOperator;
import com.ktamr.service.HaOperatorService;
import com.ktamr.util.ShiroUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;

@Controller
public class LoginController extends BaseController {

    @Autowired
    private HaOperatorService haOperatorService;

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

    @PostMapping("/login")
    @ResponseBody
    public String login(@RequestParam( value = "uid") String uid,
                            @RequestParam( value = "pwd") String pwd
                        , ModelMap mmap){
        UsernamePasswordToken token = new UsernamePasswordToken(uid, pwd);
        Subject subject = SecurityUtils.getSubject();
        try
        {
            subject.login(token);
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
