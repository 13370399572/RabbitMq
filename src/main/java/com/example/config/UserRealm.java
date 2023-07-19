package com.example.config;

import com.example.controller.exception.BaseException;
import com.example.entity.User;
import com.example.mapper.UserMapper;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;

import java.util.Objects;

//重新授权领域
public class UserRealm  extends AuthorizingRealm {

    private final UserMapper userMapper;

    public UserRealm (UserMapper userMapper){
        this.userMapper = userMapper;
    }

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行了=>授权doGetAuthorizationInfo");
        return null;
    }

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        UsernamePasswordToken userToken =(UsernamePasswordToken) authenticationToken;
        User user= userMapper.queryByName(userToken.getUsername());
        System.out.println("执行了=>认证doGetAuthenticationInfo");
        Subject currentSubject  = SecurityUtils.getSubject();
        Session session = currentSubject.getSession();
        //将登录的用户放进session中
        session.setAttribute("loginUser",user);
        if (Objects.isNull(user)){
            throw new BaseException("用户不存在");
        }
        if (!userToken.getPassword().equals(user.getPassword())){
            throw new  BaseException("用户密码不对");
        }
        return  new SimpleAuthenticationInfo(user,user.getPassword(),"");
    }
}
