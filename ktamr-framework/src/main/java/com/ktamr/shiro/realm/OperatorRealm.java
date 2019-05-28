package com.ktamr.shiro.realm;

import com.ktamr.common.exception.operator.HaOperatorNotPasswordException;
import com.ktamr.common.exception.operator.HaOperatorNullException;
import com.ktamr.common.exception.operator.HaOperatorSystemException;
import com.ktamr.domain.HaOperator;
import com.ktamr.shiro.service.OperatorService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

public class OperatorRealm extends AuthorizingRealm {


    @Autowired
    private OperatorService operatorService;
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken upToken = (UsernamePasswordToken) token;
        String uid = upToken.getUsername();
        String pwd = "";
        if (upToken.getPassword() != null)
        {
            pwd = new String(upToken.getPassword());
        }
        HaOperator haOperator = null;
        try {
            haOperator = operatorService.login(uid,pwd);
        }catch (HaOperatorNullException e){
            throw new UnknownAccountException(e.getMessage(),e);
        }catch (HaOperatorNotPasswordException e){
            throw new UnknownAccountException(e.getMessage(),e);
        }catch (Exception e){
            e.printStackTrace();
            throw new HaOperatorSystemException();
        }
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(haOperator, pwd, getName());
        return info;
    }

}
