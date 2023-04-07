package com.waper.jobhunting.controller;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @ClassName Rec
 * @Description TODO
 * @Author wangpeng
 * @Date 2022/11/15 17:07
 */
public class Rec {
    private final static String QUEUE_NAME = "hello";

    public  static  void connection () {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("192.168.170.130");
        try {
            // 连接
            Connection connection = factory.newConnection();
            // 管道
            Channel channel = connection.createChannel();
            // 队列声明
            channel.queueDeclare(QUEUE_NAME, false, false,false, null);

            System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

            DeliverCallback deliverCallback = (consumerTag , delivery) ->{
                String message1 = new String(delivery.getBody(), "UTF-8");
                System.out.println("[x]Recvied :" + message1);
            };
            channel.basicConsume(QUEUE_NAME, true, deliverCallback, consumerTag -> { });

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (TimeoutException e) {
            throw new RuntimeException(e);
        }



    }

    public static void main(String[] args) {

        connection();
    }


}
