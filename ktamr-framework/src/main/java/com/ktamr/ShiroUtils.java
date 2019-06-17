package com.ktamr;

import com.ktamr.domain.HaOperator;
import com.ktamr.common.utils.StringUtils;
import com.ktamr.common.utils.bean.BeanUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.subject.Subject;

/**
 * shiro 工具类
 * 
 * @author ktamr
 */
public class ShiroUtils
{
    public static Subject getSubject()
    {
        return SecurityUtils.getSubject();
    }

    public static Session getSession()
    {
        return SecurityUtils.getSubject().getSession();
    }

    public static void logout()
    {
        getSubject().logout();
    }

    public static HaOperator getHaOperator()
    {
        HaOperator haOperator = null;
        Object obj = getSubject().getPrincipal();
        if (StringUtils.isNotNull(obj))
        {
            haOperator = new HaOperator();
            BeanUtils.copyBeanProp(haOperator, obj);
        }
        return haOperator;
    }

    public static void setHaOperator(HaOperator user)
    {
        Subject subject = getSubject();
        PrincipalCollection principalCollection = subject.getPrincipals();
        String realmName = principalCollection.getRealmNames().iterator().next();
        PrincipalCollection newPrincipalCollection = new SimplePrincipalCollection(user, realmName);
        // 重新加载Principal
        subject.runAs(newPrincipalCollection);
    }

    public static String getOperatorName()
    {
        return getHaOperator().getOperatorName();
    }

    public static String getOperatorCode()
    {
        return getHaOperator().getOperatorCode();
    }

    public static String getRgnAndAreaId()
    {
        return getHaOperator().getRgnAndAreaId();
    }

    public static String getOperatorPwd()
    {
        return getHaOperator().getOperatorPwd();
    }

    public static String getIp()
    {
        return getSubject().getSession().getHost();
    }

    public static String getSessionId()
    {
        return String.valueOf(getSubject().getSession().getId());
    }

    /**
     * 生成随机盐
     */
    public static String randomSalt()
    {
        // 一个Byte占两个字节，此处生成的3字节，字符串长度为6
        SecureRandomNumberGenerator secureRandom = new SecureRandomNumberGenerator();
        String hex = secureRandom.nextBytes(3).toHex();
        return hex;
    }
}