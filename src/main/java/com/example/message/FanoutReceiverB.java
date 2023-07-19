package com.example.message;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@SuppressWarnings("all")
//消息队的监听器
@RabbitListener(queues = "fanoutQueueB")
@Slf4j
public class FanoutReceiverB {

    @RabbitHandler
    public void process(String message){
        log.error("扇形B接受到消息"+message);
    }
}
