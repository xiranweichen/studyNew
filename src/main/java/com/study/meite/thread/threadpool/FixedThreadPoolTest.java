package com.study.meite.thread.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author lizhenhong
 * @Description: FixedThreadPool, 可固定长度线程池
 * @date 2020/6/27 15:16
 */
public class FixedThreadPoolTest {

    public static void main(String[] args) {
        //括号里面的3，指的是线程池中最多有三个线程同时被创建
        ExecutorService service = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 10; i++) {
            final int data = i;
            //execute方法表示执行线程
            service.execute(new Runnable() {
                @Override
                public void run() {
                    //业务逻辑
                    System.out.println(Thread.currentThread().getName() + "-: " + data);
                }
            });
        }
        service.shutdown();
    }

}
