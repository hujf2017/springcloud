package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.service.IMessageProvider;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;

/**
 * @author Hujf
 * @title: IMessageProviderImpl
 * @date 2021/1/11 0011下午 3:24
 * @description: TODO
 */
@EnableBinding(Source.class)
public class MessageProviderImpl  implements IMessageProvider {

    @Resource
    private MessageChannel output;
    @Override
    public String send() {
        String s ="第一个 Stream消息";
        output.send(MessageBuilder.withPayload(s).build());
        return s;
    }
}
