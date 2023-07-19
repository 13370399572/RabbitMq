package com.example.rebbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


//直连队列的配置
@Configuration
public class DirectConfig {

    //true 表示持久化
    @Bean
    public Queue directQueueA(){
         return new Queue("directQueueA",true);
    }

    @Bean
    public Queue directQueueB(){
        return new Queue("directQueueB",true);
    }

    @Bean
    public Queue directQueueC(){
        return new Queue("directQueueC",true);
    }

    //创建直连交换机
    @Bean
    public DirectExchange directExchange(){
        return new DirectExchange("directExchange");
    }
    //将交换机和队列绑定 路由建为AA
    @Bean
    public Binding  binginA(){
      return BindingBuilder.bind(directQueueA()).to(directExchange()).with("AA");
    }

    @Bean
    public Binding  binginB(){
        return BindingBuilder.bind(directQueueB()).to(directExchange()).with("BB");
    }

    @Bean
    public Binding  binginC(){
        return BindingBuilder.bind(directQueueC()).to(directExchange()).with("CC");
    }
}
