package com.waper.common.componet;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author wangpeng
 * @ClassName MessageReceiver
 * @description TODO
 * @date 2023/12/20 14:23
 */
@Component
public class MessageReceiver {
    @RabbitListener(queues = "delayed.queue")
    public void receiveMessage(String message) {
        // 处理接收到的消息
        System.out.println("Received message: " + message);
    }


}
