package com.bjpowernode.util.shiro;

import com.bjpowernode.model.entity.User;
import com.bjpowernode.service.IUserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

public class AuthRealm extends AuthorizingRealm {
    private final IUserService userService;

    public AuthRealm(IUserService userService) {
        this.userService = userService;
    }

    /**
     * 权限校验
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();

        authorizationInfo.addStringPermission("auth_list");
        authorizationInfo.addStringPermission("user_list");

        return authorizationInfo;
    }

    /**
     * 登录鉴定
     *
     * @param authenticationToken 登录令牌包含登录时输入的用户名和密码信息
     * @return 登录校验结果
     * @throws AuthenticationException 登录校验失败
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        // 登录令牌在此处只用做获取用户名和密码
        UsernamePasswordToken loginToken = (UsernamePasswordToken) authenticationToken;
        User user = userService.get(loginToken.getUsername());

        // 只有用户存在才有必要继续验证密码
        if (user != null) {
            return new SimpleAuthenticationInfo(user, user.getUserPwd(), getName());
        }
        return null;
    }
}
