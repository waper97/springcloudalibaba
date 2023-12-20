package com.waper.jobhunting.controller;

import com.waper.jobhunting.config.DelayedExchangeConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author wangpeng
 * @ClassName DelayedMessageProducer
 * @description TODO
 * @date 2023/12/19 16:48
 */
@Component
public class DelayedMessageProducer {
    @Autowired
    private RabbitTemplate rabbitTemplate;


    @Scheduled(fixedDelay = 1000)
    public void sendDelayedMessage(String message) {
        rabbitTemplate.convertAndSend(DelayedExchangeConfig.EXCHANGE_NAME,
                DelayedExchangeConfig.ROUTING_KEY,
                message,
                messagePostProcessor -> {
                    messagePostProcessor.getMessageProperties().setDelay(3000); // 设置延迟时间，单位毫秒
                    return messagePostProcessor;
                });
    }




}
