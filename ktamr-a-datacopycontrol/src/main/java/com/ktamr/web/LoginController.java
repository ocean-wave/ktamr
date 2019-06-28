package com.ktamr.web;

import com.ktamr.common.utils.ServletUtils;
import com.ktamr.common.utils.StringUtils;
import com.ktamr.common.core.domain.BaseController;
import com.ktamr.service.HaCentorService;
import com.ktamr.service.HaOperatorRgnsService;
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
import java.util.HashMap;
import java.util.Map;

@Controller
public class LoginController extends BaseController {

    @Resource
    private HaCentorService haCentorService;

    private String publicUid=null;
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
                        , ModelMap mmap ){
        publicUid=uid;
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

    @PostMapping("/loginGetSession")
    @ResponseBody
    public Map<String,Object> loginGetSession(HttpSession session){
        Map<String,Object> map=new HashMap<>();
        try {
            //这里获取集中器,集采器,手抄器,DTU
            Integer centor_count = haCentorService.centor_count(publicUid);
            Integer collector_count = haCentorService.collector_count(publicUid);
            Integer pad_count1 = haCentorService.pad_count1(publicUid);
            Integer pad_count2 = haCentorService.pad_count2(publicUid);
            Integer DTU_count = haCentorService.DTU_count(publicUid);

            if(centor_count!=null&&collector_count!=null&&pad_count1!=null&&pad_count2!=null&&DTU_count!=null){
                map.put("centor_count",centor_count);
                map.put("collector_count",collector_count);
                map.put("pad_count1",pad_count1);
                map.put("pad_count2",pad_count2);
                map.put("DTU_count",DTU_count);
            }
            return map;
        } catch (Exception e) {
            e.printStackTrace();

        }
        return null;
    }
}
