package com.example.message;


import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@SuppressWarnings("all")
//队列directQueueC的监听器
@RabbitListener(queues = "directQueueC")
@Slf4j
public class DirectReceiverC {

    @RabbitHandler
    public void process(String message){
       log.info("A接到消息"+message);
    }
}
