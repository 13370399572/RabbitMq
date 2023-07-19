package com.example.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/jdbc")
public class JdbcController {


    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/list")
    public List<Map<String ,Object>> userList(){
        String sql = "select * from employee";
        List<Map<String,Object>> maps = jdbcTemplate.queryForList(sql);
        return  maps;
    }

    @GetMapping("/add")
    public String addUser(){
        String sql="INSERT INTO employee(last_name,email,gender,department,birth) VALUES ('韭菜程飞','66666666@qq.com','男','天阳软件部门','2022-06-13')";
        jdbcTemplate.update(sql);
        return "添加成功";
    }

    @GetMapping("/update/{id}")
    public String updateUser(@PathVariable("id") int id){
       String sql = "update employee set last_name=?,email=? where id="+id;
       Object[] objects = new Object[2];
       objects[0] = "鸟人程飞";
       objects[1] = "44444444@chenfei.com";
       jdbcTemplate.update(sql,objects);
       return "修改成功";
    }

    @GetMapping("/delete/{id}")
    public String delUser(@PathVariable("id") int id){
        String sql = "delete from employee where id=?";
        jdbcTemplate.update(sql,id);
        return "删除用户";
    }


}
