package com.bpm.mes.stock.server.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.support.atomic.RedisAtomicLong;
import org.springframework.util.StringUtils;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author gl
 * 2021-07-29
 */
public class NumAddUtil {

    /**
     * 字符串自增 0001 0002 0003
     * @param str
     * @return
     */
    public static String addNum(String str) {
        //取出最后四位数字
        String numStr = str.substring(str.length() - 4);
        //如果最后四位不是数字，抛NumberFormatException异常
        if (!StringUtils.isEmpty(numStr)) {
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
     * 字符串自增 0001 0002 0003
     * @param str 目标字符串
     * @param length 开始截取长度
     * @return 得到的字符串
     */
    public static String addOrderNum(String str,Integer length) {
        //取出最后四位数字
        String numStr = str.substring(length);
        //如果最后四位不是数字，抛NumberFormatException异常
        if (!StringUtils.isEmpty(numStr)) {
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

    @Autowired
    private StringRedisTemplate redisTemplate;
    /**
     * 自动生成每日递增编号
     * @param titleText (编码头部默认字符 如：PO20220101001 则为PO)
     * @return 生成编码
     */
    public  String contextLoads(String titleText,String zeroText) {

        RedisAtomicLong entityIdCounter = new RedisAtomicLong(titleText, redisTemplate.getConnectionFactory());
        Long counter = entityIdCounter.incrementAndGet();
        DecimalFormat format=new DecimalFormat(zeroText);
        entityIdCounter.expire(1, TimeUnit.DAYS);

        return titleText + new SimpleDateFormat("yyyyMMdd").format(new Date()) + format.format(counter);
    }
}
