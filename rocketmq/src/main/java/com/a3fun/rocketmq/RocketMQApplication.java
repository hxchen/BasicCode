package com.a3fun.rocketmq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 1. 启动RocketMQServer：nohup sh bin/mqnamesrv &
 * 2. 查看状态：tail -f ~/logs/rocketmqlogs/namesrv.log
 * 3. 启动Broker：nohup sh bin/mqbroker -n localhost:9876 --enable-proxy &
 * 4. 查看Broker：tail -f ~/logs/rocketmqlogs/proxy.log
 * 关闭
 * 3. sh bin/mqshutdown broker
 * 4. sh bin/mqshutdown namesrv
 *
 * @author haixiangchen
 */
@SpringBootApplication
public class RocketMQApplication {
    public static void main(String[] args) {
        SpringApplication.run(RocketMQApplication.class, args);
    }
}
