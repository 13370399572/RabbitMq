package com.example.controller;


import com.example.entity.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    private UserController(UserService userService){
        this.userService=userService;
    }

    @RequestMapping("/list")
    public List<User> List(){
       return  userService.queryUserList();
    }

}
