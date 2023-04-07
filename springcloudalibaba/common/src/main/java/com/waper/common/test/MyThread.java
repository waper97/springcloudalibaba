package com.waper.common.test;

/**
 * @ClassName MyThread
 * @Description TODO
 * @Author wangpeng
 * @Date 2023/1/12 20:16
 */
public class MyThread extends Thread {
    @Override
    public void run() {
       for (int i = 0;i < 100; i++) {
           System.out.println("i = " + i+";"+Thread.currentThread().getName());
       }
    }


}
