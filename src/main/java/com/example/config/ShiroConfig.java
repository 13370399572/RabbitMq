package com.example.config;

import com.example.mapper.UserMapper;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

    @Autowired
    private UserMapper userMapper;
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("getDefaultWebSecurityManager")DefaultWebSecurityManager defaultWebSecurityManager){
        ShiroFilterFactoryBean bean =new ShiroFilterFactoryBean();
        //设置安全管理器
        bean.setSecurityManager(defaultWebSecurityManager);
        //添加shiro的内置过滤器
        /*
         * anon:无需认证就可以访问
         * authc:必须认证了才能访问
         * user:必须拥有 记住我 功能才能访问
         * perms:  拥有对某个资源的权限才能访问
         * role ：拥有某个角色权限才能访问
         * */
        Map<String,String> filterMap = new HashMap<>();
        filterMap.put("/user/add","anon");
        filterMap.put("/user/update","authc");
        //设置访问不了时跳转到登录页面
        bean.setLoginUrl("/toLogin");
        bean.setFilterChainDefinitionMap(filterMap);
        return bean;
    }
    //DefaultWebSecurityManager  第二步  关联第一步
    @Bean
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //关联userRealm
        securityManager.setRealm(userRealm);
        return securityManager;
    }




    // 创建realm对象，需要自定义类 第一步
    @Bean
    public UserRealm userRealm(){
        return new UserRealm(userMapper);
    }
}

