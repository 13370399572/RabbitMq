package com.example.controller;


import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/topic")
public class TopicCotroller {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @RequestMapping("/topicSend/{routingKey}")
    public String topicSend(@PathVariable("routingKey") String routingKey){
        rabbitTemplate.convertAndSend("topicExchange",routingKey,"韭菜程飞");
        return "YES";
    }
}
