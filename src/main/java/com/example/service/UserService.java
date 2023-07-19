package com.example.service;

import com.example.entity.User;

import java.util.List;


public interface UserService {

    public static final int age=18;

    List<User> queryUserList();

    User queryUserById(Integer id);

    int addUser(User user);

    int updateUser(User user);

    int deleteUserById(Integer id);
}
