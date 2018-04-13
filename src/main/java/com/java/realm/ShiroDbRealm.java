package com.java.realm;

import com.java.domain.User;
import com.java.service.impl.userServiceImpl;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author answer
 *         2018/4/12
 */
public class ShiroDbRealm extends AuthorizingRealm {
    @Autowired
    private userServiceImpl userService;

    public userServiceImpl getUserService() {
        return userService;
    }

    public void setUserService(userServiceImpl userService) {
        this.userService = userService;
    }

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        User user = (User) principalCollection.getPrimaryPrincipal();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        User user1=userService.findByUsername(user.getName());
        String role=user1.getRole();
        info.addRole(role);
        return info;
    }

    //验证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String username = (String) authenticationToken.getPrincipal();

        User user=userService.findByUsername(username);
        if(user==null){
            return null;
        }
        String password=user.getPassword();
        return  new SimpleAuthenticationInfo(user, password, this.getName());

    }
}
