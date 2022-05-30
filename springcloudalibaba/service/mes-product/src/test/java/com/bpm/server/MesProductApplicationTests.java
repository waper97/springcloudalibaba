package com.bpm.server;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.support.atomic.RedisAtomicLong;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@SpringBootTest(classes = MesProductApplicationTests.class )
class MesProductApplicationTests {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Test
    void contextLoads() {
        String titleText = "test";
        RedisAtomicLong entityIdCounter = new RedisAtomicLong(titleText, stringRedisTemplate.getConnectionFactory());
        Long counter = entityIdCounter.incrementAndGet();
        DecimalFormat format=new DecimalFormat("000");
        entityIdCounter.expire(1, TimeUnit.DAYS);

        String str = titleText + new SimpleDateFormat("yyyyMMdd").format(new Date()) + format.format(counter);
        System.out.println(str);

    }



}
