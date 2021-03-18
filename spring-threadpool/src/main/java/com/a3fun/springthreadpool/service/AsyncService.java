package com.a3fun.springthreadpool.service;

import org.apache.tomcat.jni.Time;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author haixiangchen
 */
@Service
public class AsyncService {
    Logger logger = LoggerFactory.getLogger(AsyncService.class);

    /**
     * 异步调用测试
     */
    @Async
    public void asyncInvoke() throws InterruptedException {
        logger.info("异步调用开始，先睡5s");
        Thread.sleep(5000);
        logger.info("5s后，我醒了");
    }

    /**
     * 同步调用
     */
    public void syncInvoke() throws InterruptedException {
        logger.info("同步调用开始，先睡5s");
        Thread.sleep(5000);
        logger.info("5s后，我醒了");
    }

}
