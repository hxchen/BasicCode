package com.a3fun.load_balancing.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author haixiangchen
 */
@RestController
public class HomeController {

    @Value("${server.port}")
    String port;

    @RequestMapping(value = "/")
    public String home(){
        return "hello, my port is :"+ port;
    }
}
