package com.a3fun.rocketmq.controller;

import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.apache.rocketmq.spring.support.RocketMQHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author haixiangchen
 */
@RestController
public class ProducerController {
    @Resource
    RocketMQTemplate rocketMQTemplate;

    String TOPIC = "test-topic";

    /**
     * 同步发送测试
     *
     * @param msg
     * @return
     */
    @GetMapping("/send")
    public String send(String msg) {
        rocketMQTemplate.convertAndSend(TOPIC, msg);
        System.out.printf("send %s to test-topic", msg);

        SendResult sendResult = rocketMQTemplate.syncSend("test-topic", msg);
        System.out.printf("syncSend1 to topic %s sendResult=%s %n", TOPIC, sendResult);
        return "success";
    }

    /**
     * 异步发送测试
     *
     * @param msg
     * @return
     */
    @GetMapping("/async_send")
    public String asyncSend(String msg) {
        rocketMQTemplate.asyncSend(TOPIC, msg, new SendCallback() {
            @Override
            public void onSuccess(SendResult var1) {
                System.out.printf("async onSucess SendResult=%s %n", var1);
            }

            @Override
            public void onException(Throwable var1) {
                System.out.printf("async onException Throwable=%s %n", var1);
            }

        });
        System.out.println("async send success");
        return "success";
    }

    @GetMapping("/send_transactional")
    public void transactionalRocketMQTemplate() {
        String[] tags = new String[]{"TagA", "TagB", "TagC", "TagD", "TagE"};
        for (int i = 0; i < 10; i++) {
            try {

                Message msg = MessageBuilder.withPayload("rocketMQTemplate transactional message " + i).setHeader(RocketMQHeaders.TRANSACTION_ID, "KEY_" + i).build();
                SendResult sendResult = rocketMQTemplate.sendMessageInTransaction(TOPIC + ":" + tags[i % tags.length], msg, null);
                System.out.printf("------rocketMQTemplate send Transactional msg body = %s , sendResult=%s %n", msg.getPayload(), sendResult.getSendStatus());

                Thread.sleep(10);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
