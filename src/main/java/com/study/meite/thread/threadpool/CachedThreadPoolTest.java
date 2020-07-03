package com.study.meite.thread.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author lizhenhong
 * @Description: ExecutorService 线程池
 * @date 2020/6/27 14:41
 */
public class CachedThreadPoolTest {

    public static void main(String[] args) {
        //可缓存的线程池，这个线程池时无限大小的
        ExecutorService service = Executors.newCachedThreadPool();
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
        //停掉线程池
        service.shutdown();
    }

}
