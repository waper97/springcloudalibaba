package com.waper.common.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 延迟交换机配置类
 * @author wangpeng
 * @ClassName DelayedExchangeConfig
 * @description TODO
 * @date 2023/12/19 16:44
 */
@Configuration
public class DelayedExchangeConfig {

    public static final String EXCHANGE_NAME = "myDelayedExchange";
    public static final String QUEUE_NAME = "delayed.queue";
    public static final String ROUTING_KEY = "delayed.routing.key";


    @Bean
    public CustomExchange delayedExchange() {
        return new CustomExchange(EXCHANGE_NAME,
                "x-delayed-message", // 消息类型
                true, // 是否持久化
                false); // 是否自动删除
    }

    @Bean
    public Queue delayedQueue() {
        return QueueBuilder.durable(QUEUE_NAME)
                .withArgument("x-delayed-type", "direct")
                .build();
    }

    @Bean
    public Binding delayedBinding(Queue delayedQueue, CustomExchange delayedExchange) {
        return BindingBuilder.bind(delayedQueue()).to(delayedExchange()).with(ROUTING_KEY).noargs();
    }


}
