package com.keji.common.config;

import com.keji.pojo.authority.UserInfo;
import com.keji.service.authority.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author dcy
 * @date 2019/9/10 14:06
 * @description
 */
public class UserRealm extends AuthenticatingRealm {

    @Autowired
    private UserService userService;

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
            UsernamePasswordToken token  = (UsernamePasswordToken) authenticationToken;
        UserInfo userInfo = userService.findUserByUserName(token.getUsername());
        if(userInfo==null || userInfo.getStatus() == 0){
            return null;
        }
        Object principal = userInfo.getUserName();
        //2)credentials：密码
        Object credentials = userInfo.getPassword();
        String realmName = getName();
        ByteSource credentialsSalt = ByteSource.Util.bytes(principal);//使用当前账号作为盐值
        SimpleAuthenticationInfo info = null;
        info = new SimpleAuthenticationInfo(userInfo, credentials, credentialsSalt, realmName);
        return info;
    }
}
