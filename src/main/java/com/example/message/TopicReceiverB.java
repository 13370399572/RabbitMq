package com.example.message;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@SuppressWarnings("all")
@RabbitListener(queues="topicQueueB")
@Slf4j
public class TopicReceiverB {

    @RabbitHandler
    public void process(String message){
        log.info("主题B收到消息"+message);
    }
}
