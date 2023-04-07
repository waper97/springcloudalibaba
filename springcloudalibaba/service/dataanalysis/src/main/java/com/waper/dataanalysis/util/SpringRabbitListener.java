package com.waper.dataanalysis.util;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @ClassName SpringRabbitListener
 * @Description TODO
 * @Author wangpeng
 * @Date 2022/12/27 14:47
 */
@Component
public class SpringRabbitListener {

    @RabbitListener(queues = "simple.queue")
    public void listenSimpleQueueMessage (String message) {
        System.out.println("接收到的消息"+message);
    }
}
