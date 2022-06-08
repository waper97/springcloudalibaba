package com.bpm.server.util;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.support.atomic.RedisAtomicLong;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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

    /**
     * 自动生成每日递增编号
     * @param titleText (编码头部默认字符 如：PO20220101001 则为PO)
     * @return 生成编码
     */
    @GetMapping("/testList")
    public  String getContextLoads(String titleText, String zeroText) {
        RedisAtomicLong entityIdCounter = new RedisAtomicLong(titleText, redisTemplate.getConnectionFactory());
        Long counter = entityIdCounter.incrementAndGet();
        DecimalFormat format=new DecimalFormat(zeroText);
        entityIdCounter.expire(1, TimeUnit.DAYS);

        return titleText + new SimpleDateFormat("yyyyMMdd").format(new Date()) + format.format(counter);
    }
    /**
     * 自动生成每日递增编号
     * @param titleText (编码头部默认字符 如：PO20220101001 则为PO)
     * @return 生成编码
     */
    @GetMapping("/testListTwo")
    public  String getContextLoadsTwo(String titleText, String zeroText) {
        RedisAtomicLong entityIdCounter = new RedisAtomicLong(titleText, redisTemplate.getConnectionFactory());
        Long counter = entityIdCounter.incrementAndGet();
        DecimalFormat format=new DecimalFormat(zeroText);
        entityIdCounter.expire(1, TimeUnit.DAYS);

        return titleText + new SimpleDateFormat("yyyyMM").format(new Date()) + format.format(counter);
    }

    /**
     * 自动生成每日递增编号
     * @param titleText (编码头部默认字符 如：PO20220101001 则为PO)
     * @return 生成编码
     */
    @GetMapping("/testListThree")
    public  String getContextLoadsThree(String titleText, String zeroText) {
        RedisAtomicLong entityIdCounter = new RedisAtomicLong(titleText, redisTemplate.getConnectionFactory());
        Long counter = entityIdCounter.incrementAndGet();
        DecimalFormat format=new DecimalFormat(zeroText);
        entityIdCounter.expire(1, TimeUnit.DAYS);

        return titleText + format.format(counter);
    }

    /**
     * 字符串自增 0001 0002 0003
     * @param str 目标字符串
     * @param length 开始截取长度
     * @return 得到的字符串
     */
    public static String addOrderNum(String str,Integer length) {
        //取出最后四位数字
        String numStr = str.substring(length);
        //如果最后四位不是数字，抛NumberFormatException异常
        if (!org.springframework.util.StringUtils.isEmpty(numStr)) {
            //取出字符串的长度
            int n = numStr.length();
            //将该数字加一
            int num = Integer.parseInt(numStr) + 1;
            String added = String.valueOf(num);
            n = Math.min(n, added.length());
            //拼接字符串
            return str.subSequence(0, str.length() - n) + added;
        } else {
            throw new NumberFormatException();
        }
    }

    /**
     * 获取当前月所有日期 eg: 5月的1到30号
     * @return
     */
    public   static List<LocalDateTime> getMonthAllDate () {

        List<LocalDateTime> monthALLDate = new ArrayList<>();
        // 获取当月的总天数
        int currentMonthLength = LocalDate.now().lengthOfMonth();
        LocalDateTime nowTime = LocalDateTime.now();


        for (int i = 1; i <= currentMonthLength; i ++) {
            LocalDate now = LocalDate.now().withDayOfMonth(i);

            monthALLDate.add(now.atTime(LocalTime.from(nowTime)));
        }
        monthALLDate.forEach(System.out::println);
        return monthALLDate;
    }


    public static void main(String[] args) {

    }
}
