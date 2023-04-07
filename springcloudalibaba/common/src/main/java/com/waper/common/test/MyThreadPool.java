package com.waper.common.test;

import java.util.concurrent.*;

/**
 * @ClassName MyThreadPool
 * @Description TODO
 * @Author wangpeng
 * @Date 2023/1/12 22:05
 */
public class MyThreadPool {
    /***
     *
     *
     *
     *
     */
     static int count = 0;
    public static void myThreadPool () {

        ThreadPoolExecutor executor = new ThreadPoolExecutor(10,
                100,
                1000,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(10),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy()
                );
        Myrunnable myrunnable1 = new Myrunnable();

        for (int i = 0; i <= 100; i++) {
            executor.execute(myrunnable1);
            count++;

        }
        System.out.println("循环次数："+count);
    }

    public static void main(String[] args) {
        myThreadPool();
    }
}
