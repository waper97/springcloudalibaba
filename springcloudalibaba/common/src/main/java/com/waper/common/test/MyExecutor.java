package com.waper.common.test;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName MyExecutor
 * @Description TODO
 * @Author wangpeng
 * @Date 2023/1/12 21:59
 */
public class MyExecutor {

    public static void myExecutor () {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.execute(() ->{
            System.out.println("任务被线程池运行"+Thread.currentThread().getName());
        });
    }

    public static void main(String[] args) {
        myExecutor();
    }
}
