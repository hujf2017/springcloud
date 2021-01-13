package com.atgugui.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * @author Hujf
 * @title: ReceiveMessageListenerController
 * @date 2021/1/13 0013上午 10:12
 * @description: TODO
 */
@Component
@EnableBinding(Sink.class)
public class ReceiveMessageListenerController {

    @Value("${server.port}")
    private String serverPort;

    @StreamListener(Sink.INPUT)
    public void  getMessage(Message<String> message) {

        System.out.print( "我是消费者，收到消息："+message.getPayload()+" "+serverPort);
    }
}
