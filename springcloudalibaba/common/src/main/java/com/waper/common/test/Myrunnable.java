package com.waper.common.test;

import java.lang.reflect.Member;

/**
 * @ClassName Myrunnable
 * @Description TODO
 * @Author wangpeng
 * @Date 2023/1/12 20:24
 */
public class Myrunnable implements Runnable{

    final String message ="{\"1\":\"倔强青铜III\",\"2\":\"倔强青铜II\",\"3\":\"倔强青铜I\",\"4\":\"秩序白银III\",\"5\":\"秩序白银II\",\"6\":\"秩序白银I\",\"17\":\"荣耀黄金IV\",\"7\":\"荣耀黄金III\",\"8\":\"荣耀黄金II\",\"9\":\"荣耀黄金I\",\"18\":\"尊贵铂金V\",\"19\":\"尊贵铂金IV\",\"10\":\"尊贵铂金III\",\"11\":\"尊贵铂金II\",\"12\":\"尊贵铂金I\",\"20\":\"永恒钻石V\",\"21\":\"永恒钻石IV\",\"13\":\"永恒钻石III\",\"14\":\"永恒钻石II\",\"15\":\"永恒钻石I\",\"22\":\"至尊星耀V\",\"23\":\"至尊星耀IV\",\"24\":\"至尊星耀III\",\"25\":\"至尊星耀II\",\"26\":\"至尊星耀I\"}";
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"添加了数据");
    }

    public static void main(String[] args) {
        Myrunnable myrunnable = new Myrunnable();
        Thread thread1 = new Thread(myrunnable);
        Thread thread2 = new Thread(myrunnable);
        thread1.start();
        thread2.start();
    }
}
