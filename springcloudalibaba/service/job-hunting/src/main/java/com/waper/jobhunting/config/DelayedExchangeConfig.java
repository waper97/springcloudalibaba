package com.waper.jobhunting.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;


/**
 * 延迟交换机配置类
 * @author wangpeng
 * @ClassName DelayedExchangeConfig
 * @description TODO
 * @date 2023/12/19 16:44
 */
@Configuration
public class DelayedExchangeConfig {

    public static final String EXCHANGE_NAME = "delayed.exchange";
    public static final String QUEUE_NAME = "delayed.queue";
    public static final String ROUTING_KEY = "delayed.routing.key";


//    @Bean
//    public CustomExchange delayedExchange() {
//        return new CustomExchange(EXCHANGE_NAME,
//                "x-delayed-message", // 消息类型
//                true, // 是否持久化
//                false); // 是否自动删除
//    }


    //自定义交换机 我们在这里定义的是一个延迟交换机
    @Bean("delayedExchange")
    public CustomExchange delayedExchange() {
        Map<String, Object> args = new HashMap<>(16);
        //自定义交换机的类型，指定分发方式
        args.put("x-delayed-type", "direct");
        //此处type指定为延迟交换机
        return new CustomExchange(EXCHANGE_NAME, "x-delayed-message", true, false, args);
    }


    @Bean
    public Queue delayedQueue() {
        return QueueBuilder.durable(QUEUE_NAME)
                .withArgument("x-delayed-type", "direct")
                .build();
    }

    @Bean
    public Binding delayedBinding() {
        return BindingBuilder.bind(delayedQueue()).to(delayedExchange()).with(ROUTING_KEY).noargs();
    }

    @Bean
    public Binding bindingDelayedQueue(@Qualifier("delayedQueue") Queue queue,
                                       @Qualifier("delayedExchange") CustomExchange delayedExchange) {
        return BindingBuilder.bind(queue).to(delayedExchange).with(ROUTING_KEY).noargs();
    }



}
