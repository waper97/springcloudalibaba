package com.bpm.server.util;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.support.atomic.RedisAtomicLong;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName NumberUtil
 * @Description 流水号工具类
 * @Author wangpeng
 * @Date 2022/4/28 9:36
 */
@RestController
@RequestMapping("/test")
public class NumberUtil {
    final public static String FORMAT_CODE = "00000";
    // 工艺路线
    final public static String PROCESS_ROUTE_PREFIX = "";
    @Autowired
    private StringRedisTemplate redisTemplate;


    /**
     * 获取流水号
     * @return
     */
    public static String getSerialNumber () {
        LocalDateTime localDateTime =  LocalDateTime.now();
        String pattern = "yyyyMMddHHmmss";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        String format = formatter.format(localDateTime);
        return format;
    }

    /**
     * 自动生成每日递增编号
     * @param titleText (编码头部默认字符 如：PO20220101001 则为PO)
     * @return 生成编码
     */
    @GetMapping("/test")
    public  String contextLoads(String titleText) {
        if (StringUtils.isEmpty(titleText)) {
            throw  new NullPointerException("titleText不能为空!");
        }
//        titleText = "test";
        RedisAtomicLong entityIdCounter = new RedisAtomicLong(titleText,redisTemplate.getConnectionFactory());
        Long counter = entityIdCounter.incrementAndGet();
        DecimalFormat format = new DecimalFormat("000");
        entityIdCounter.expire(1, TimeUnit.DAYS);

        return titleText + new SimpleDateFormat("yyyyMMdd").format(new Date()) + format.format(counter);
    }


    public static void main(String[] args) {

    }
}
