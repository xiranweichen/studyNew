package com.study.meite.thread.threadpool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author lizhenhong
 * @Description: ScheduledThreadPool, 可创建定时任务
 * @date 2020/6/27 15:26
 */
public class ScheduledThreadPoolTest {

    public static void main(String[] args) {
        ScheduledExecutorService service = Executors.newScheduledThreadPool(3);
        for (int i = 0; i < 10; i++) {
            final int data = i;
            //execute方法表示执行线程
//            service.execute(new Runnable() {
//                @Override
//                public void run() {
//                    //业务逻辑
//                    System.out.println(Thread.currentThread().getName() + "-: " + data);
//                }
//            });

            //如果想做成定时任务的：
            //下面的意思时等待三秒执行run()方法中的逻辑
            service.schedule(new Runnable() {
                @Override
                public void run() {
                    //业务逻辑
                    System.out.println(Thread.currentThread().getName() + "-: " + data);
                }
            }, 3, TimeUnit.SECONDS);
        }
        service.shutdown();
    }

}
