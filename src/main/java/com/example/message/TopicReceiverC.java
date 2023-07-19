package com.example.message;


import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@SuppressWarnings("all")
@RabbitListener(queues="topicQueueC")
@Slf4j
public class TopicReceiverC {

    @RabbitHandler
    public void process(String message){
        log.info("主题C收到消息"+message);
    }
}
