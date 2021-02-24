package com.a3fun.springthreadpool.controller;

import com.a3fun.springthreadpool.service.AsyncService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author haixiangchen
 */
@RestController
public class UserController {
    Logger logger = LoggerFactory.getLogger(AsyncService.class);
    @Resource
    AsyncService asyncService;
    /**
     * 测试
     * @return
     */
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello(){
        logger.info("async invoke from main");
        asyncService.asyncInvoke();
        return "hello";
    }

    /**
     * 测试2
     * @return
     */
    @RequestMapping(value = "/hello2", method = RequestMethod.GET)
    public String hello2(){
        logger.info("exe in main");
        asyncService.syncInvoke();
        return "hello";
    }
}
