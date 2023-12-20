package com.waper.common.config;


import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * RabbitMq配置类
 * @author wangpeng
 * @ClassName RabbitMQConfig
 * @description TODO
 * @date 2023/12/20 14:24
 */
@Configuration
public class RabbitMQConfig {
    @Bean
    public Queue myQueue ( ) {
        return new Queue("myQueue");
    }

    @Bean
    public FanoutExchange fanoutExchange () {
        return new FanoutExchange("myExchange");
    }

    @Bean
    public Binding binding (Queue myQueue, FanoutExchange fanoutExchange) {
        return  BindingBuilder.bind(myQueue).to(fanoutExchange);

    }

}
