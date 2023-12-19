package com.waper.goodsservice.controller;

import com.waper.common.config.DelayedExchangeConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 监听延迟队列
 */
@Component
public class DelayedMessageConsumer {

    @RabbitListener(queues = DelayedExchangeConfig.QUEUE_NAME)
    public void receiveDelayedMessage(String message) {
        System.out.println("Received delayed message: " + message);
    }

}
