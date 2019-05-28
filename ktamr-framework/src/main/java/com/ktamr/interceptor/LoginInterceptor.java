package com.ktamr.interceptor;

import com.ktamr.domain.HaOperator;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor  implements HandlerInterceptor {

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 检查每个到来的请求对应的session域中是否有登录标识
        Object obj = request.getSession().getAttribute("haOperator");
        if (null == obj || !(obj instanceof HaOperator)) {
            // 未登录，重定向到登录页
            response.sendRedirect("/");
            return false;
        }
        HaOperator haOperator = (HaOperator) obj;
        System.out.println("当前用户已登录，登录的用户名为： " + haOperator.getOperatorCode());
        return true;
    }
}