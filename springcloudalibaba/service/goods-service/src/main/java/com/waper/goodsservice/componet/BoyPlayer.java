package com.waper.goodsservice.componet;

import com.rabbitmq.client.Channel;
import com.waper.dataanalysisapi.entity.Hero;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @ClassName BoyPlayer
 * @Description TODO
 * @Author wangpeng
 * @Date 2023/2/16 16:44
 */
@Component
public class BoyPlayer {

    @RabbitListener(queues = "hero-queue")
    public void receviceMessage (Hero hero, Channel channel, Message message) {
        System.out.println("BoyPlayerchannel通道编号为:"+channel.getChannelNumber());
        System.out.println("BoyPlay收到消息：" + new String(message.getBody()));

    }
}
