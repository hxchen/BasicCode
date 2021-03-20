package com.a3fun.rocketmq.listener;

import org.apache.rocketmq.spring.annotation.RocketMQTransactionListener;
import org.apache.rocketmq.spring.core.RocketMQLocalTransactionListener;
import org.apache.rocketmq.spring.core.RocketMQLocalTransactionState;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author haixiangchen
 */
@Component
@RocketMQTransactionListener
public class SyncProducerListener implements RocketMQLocalTransactionListener {

    private ConcurrentHashMap<String, Object> localTrans = new ConcurrentHashMap<>();

    @Override
    public RocketMQLocalTransactionState executeLocalTransaction(Message message, Object o) {
        try {
            System.out.printf("执行本地事务 msg:%s, Object:%s", message, o);
            localTrans.put(message.getHeaders().getId() + "", message.getPayload());
            return RocketMQLocalTransactionState.COMMIT;
        } catch (Exception e) {
            e.printStackTrace();
            System.err.printf("【执行本地业务异常】 exception message:%s", e.getMessage());
            return RocketMQLocalTransactionState.ROLLBACK;
        }
    }

    @Override
    public RocketMQLocalTransactionState checkLocalTransaction(Message message) {
        System.out.printf("【执行检查任务】");
        return RocketMQLocalTransactionState.UNKNOWN;
    }
}
