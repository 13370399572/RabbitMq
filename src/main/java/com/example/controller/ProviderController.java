package com.example.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//提供者发送消息
@RestController
@RequestMapping("/direct")
public class ProviderController {

    @Autowired
    private RabbitTemplate template;

    @RequestMapping ("/test")
    public String test(){
       // template.convertAndSend("directExchange",routingKey,"hello world");
        return "yes";
    }

    @GetMapping ("/directSent/{rotingKey}")
    public String directSend(@PathVariable("rotingKey") String routingKey){
        template.convertAndSend("directExchange",routingKey,"hello world");
        return "yes";
    }
}
