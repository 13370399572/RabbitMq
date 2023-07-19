package com.example.message;


import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@SuppressWarnings("all")
//队列directQueueA的监听器
@RabbitListener(queues = "directQueueA")
@Slf4j
public class DirectReceiverA {

    @RabbitHandler
    public void process(String message){
       log.info("A接到消息"+message);
    }
}
