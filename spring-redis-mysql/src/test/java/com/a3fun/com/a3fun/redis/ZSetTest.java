package com.a3fun.com.a3fun.redis;

import com.a3fun.springredismysql.utils.RedisUtil;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class ZSetTest {

    Random random = new Random();
    @Test
    public void TestZSet() {
        String key = "pay_rankings";
        Map<String, Double> map = new HashMap<>();
        for (int i = 10000; i < 10100; i++){
            map.put(String.valueOf(i), getScore());
        }
        RedisUtil.getJedis().zadd(key, map);
    }
    private Double getScore(){
        int score = random.nextInt(Integer.MAX_VALUE);
        long time = System.currentTimeMillis();
        long left = 10000000000000L - time;
        double decimalPart = left * Math.pow(10, -13);
        double ret = score + decimalPart;
        System.out.println("生成分数：" + score + ", 时间戳：" + time + ", left:" + left + ", decimal:" + decimalPart + "最终结果：" + ret);
        return ret;
    }

}
