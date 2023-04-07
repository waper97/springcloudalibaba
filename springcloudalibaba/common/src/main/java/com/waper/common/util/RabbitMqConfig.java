//package com.waper.common.util;
//
//import org.springframework.amqp.core.Binding;
//import org.springframework.amqp.core.BindingBuilder;
//import org.springframework.amqp.core.FanoutExchange;
//import org.springframework.amqp.core.Queue;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//
//
///**
// * @ClassName RabbitMqConfig
// * @Description TODO
// * @Author wangpeng
// * @Date 2022/12/27 17:15
// */
//@Configuration
//public class RabbitMqConfig {
//    /**
//     * 声明队列1
//     * @return
//     */
//    @Bean
//    public Queue fanoutQueue1(){
//        return new Queue("fanout.queue1");
//    }
//
//    /**
//     * 声明队列2
//     * @return
//     */
//    @Bean
//    public Queue fanoutQueue2(){
//        return new Queue("fanout.queue2");
//    }
//
//    /**
//     * 声明交换机
//     * @return
//     */
//    @Bean
//    public FanoutExchange fanoutExchange(){
//        return new FanoutExchange("amqp.Exchange");
//    }
//
//    // 把队列1队列2 绑定广播交换机上
//    @Bean
//     public Binding bindingQueue1() {
//        return BindingBuilder.bind(fanoutQueue1()).to(fanoutExchange());
//     }
//
//    @Bean
//    public Binding bindingQueue2() {
//        return BindingBuilder.bind(fanoutQueue2()).to(fanoutExchange());
//    }
//}
