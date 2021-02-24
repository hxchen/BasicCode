package com.a3fun.springthreadpool.service;

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
    public void asyncInvoke(){
        logger.info("start async invoke");
    }

    /**
     * 同步调用
     */
    public void syncInvoke() {
        logger.info("start sync invoke");
    }

}
