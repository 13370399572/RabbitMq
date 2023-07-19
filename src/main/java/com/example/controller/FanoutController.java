package com.example.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/fanout")
@RestController
public class FanoutController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @RequestMapping("/fanoutSend")
    public String fanoutSend(){
        rabbitTemplate.convertAndSend("fanoutExchange",null,"韭菜阿飞");
        return "YES";
    }
}
