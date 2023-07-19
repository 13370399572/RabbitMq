package com.example.controller.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {
    @RequestMapping("/")
    public String toIndex(Model model){
        model.addAttribute("msg","hello,shiro");
        return "/page/index";
    }

    @RequestMapping("/user/add")
    public String add(){
        return "/page/user/add";
    }

    @RequestMapping("/user/update")
    public String update(){
        return "/page/user/update";
    }

    @RequestMapping("/toLogin")
    public String toLogin(){
        return "/page/login";
    }
    @RequestMapping("/login")
    public String login(String username,String password,Model model) {
        //获取当前的用户
        Subject subject = SecurityUtils.getSubject();
        //封装用户的登录数据
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        try {
            subject.login(token);//执行登录的方法，如果没有异常就可以了
            return "index";
        } catch (UnknownAccountException e) {//用户名不存在
            model.addAttribute("msg", "用户名错误");
            return "login";
        } catch (IncorrectCredentialsException e) {//密码不存在
            model.addAttribute("msg", "密码错误");
            return "login";
        }
    }

}
