package com.example.rebbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//主题交换机配置
@Configuration
public class TopicConfig {
    //定义建
    public final static String KEY_A="*.orange.*";

    public final static String KET_B="*.*.rabbit";

    public final static String KEY_C="lazy.#";

    @Bean
    public Queue topicQueueA(){
        return new Queue("topicQueueA",true);
    }
    @Bean
    public Queue topicQueueB(){
        return new Queue("topicQueueB",true);
    }
    @Bean
    public Queue topicQueueC(){
        return new Queue("topicQueueC",true);
    }

    @Bean
    public TopicExchange topicExchange(){
        return  new TopicExchange("topicExchange");
    }
    @Bean
    public Binding topicBingingA(){
        return BindingBuilder.bind(topicQueueA()).to(topicExchange()).with(KEY_A);
    }
    @Bean
    public Binding topicBingingB(){
        return BindingBuilder.bind(topicQueueB()).to(topicExchange()).with(KET_B);
    }

    @Bean
    public Binding topicBingingC(){
        return BindingBuilder.bind(topicQueueC()).to(topicExchange()).with(KEY_C);
    }


}
