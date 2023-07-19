package com.example.message;


import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@SuppressWarnings("all")
//队列directQueueB的监听器
@RabbitListener(queues = "directQueueB")
@Slf4j
public class DirectReceiverB {

    @RabbitHandler
    public void process(String message){
       log.info("B接到消息"+message);
    }
}
