package com.example.rebbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//扇形交换器连接队列的配置
@Configuration
public class FanoutConfig {


    //创建队列
    @Bean
    public Queue fanoutQueueA(){
       return new Queue ("fanoutQueueA",true);
    }

    @Bean
    public Queue fanoutQueueB(){
        return new Queue ("fanoutQueueB",true);
    }

    @Bean
    public Queue fanoutQueueC(){
        return new Queue ("fanoutQueueC",true);
    }

    //创建交换机
    @Bean
    public FanoutExchange fanoutExchange(){
       return new  FanoutExchange("fanoutExchange");
    }

    @Bean
    public Binding fanoutBingingA(){
        return BindingBuilder.bind(fanoutQueueA()).to(fanoutExchange());
    }

    @Bean
    public Binding fanoutBingingB(){
        return BindingBuilder.bind(fanoutQueueB()).to(fanoutExchange());
    }

    @Bean
    public Binding fanoutBingingC(){
        return BindingBuilder.bind(fanoutQueueC()).to(fanoutExchange());
    }

}
