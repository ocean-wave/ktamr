package com.ktamr.config;


import com.ktamr.shiro.realm.OperatorRealm;
import com.ktamr.shiro.web.session.OnlineWebSessionManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.apache.shiro.mgt.SecurityManager;
import javax.servlet.Filter;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 权限配置加载
 *
 * @author ktamr
 */
@Configuration
public class ShiroConfig {

    // Session超时时间，单位为毫秒（默认30分钟）
    @Value("${shiro.session.expireTime}")
    private int expireTime;

    // 登录地址
    @Value("${shiro.operator.loginUrl}")
    private String loginUrl;

    /**
     * 会话管理器
     */
    @Bean
    public OnlineWebSessionManager sessionManager()
    {
        OnlineWebSessionManager manager = new OnlineWebSessionManager();
        // 设置全局session超时时间
        manager.setGlobalSessionTimeout(expireTime * 60 * 1000);

        return manager;
    }

    /**
     * 自定义Realm
     */
    @Bean
    public OperatorRealm operatorRealm()
    {
        OperatorRealm operatorRealm = new OperatorRealm();
        return operatorRealm;
    }

    @Bean
    public SecurityManager securityManager(OperatorRealm operatorRealm)
    {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        // 设置realm.
        securityManager.setRealm(operatorRealm);

        securityManager.setSessionManager(sessionManager());
        return securityManager;
    }

    /**
     * Shiro过滤器配置
     */
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager)
    {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        // Shiro的核心安全接口,这个属性是必须的
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        // 身份认证失败，则跳转到登录页面的配置
        shiroFilterFactoryBean.setLoginUrl(loginUrl);

        // Shiro连接约束配置，即过滤链的定义
        LinkedHashMap<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
        // 对静态资源设置匿名访问
        filterChainDefinitionMap.put("/favicon.ico**", "anon");
        filterChainDefinitionMap.put("/common/**", "anon");
        filterChainDefinitionMap.put("/images/**", "anon");
        filterChainDefinitionMap.put("/ajax/**", "anon");
        filterChainDefinitionMap.put("/plugins/**", "anon");
        filterChainDefinitionMap.put("/system/**", "anon");

        // 退出 logout地址，shiro去清除session
        filterChainDefinitionMap.put("/logout", "logout");
        // 不需要拦截的访问
        filterChainDefinitionMap.put("/login", "anon");
        Map<String, Filter> filters = new LinkedHashMap<>();

        shiroFilterFactoryBean.setFilters(filters);

        // 所有请求需要认证
        filterChainDefinitionMap.put("/**", "user");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);

        return shiroFilterFactoryBean;
    }
}
