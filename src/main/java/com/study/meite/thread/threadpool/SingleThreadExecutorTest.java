package com.study.meite.thread.threadpool;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author lizhenhong
 * @Description: SingleThreadExecutor： 单线程的线程池，用的不多
 * @date 2020/6/27 15:43
 */
public class SingleThreadExecutorTest {

    @Test
    public void test() {
        ExecutorService service = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i++) {
            final int data = i;
            service.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + "-: " + data);
                }
            });
        }
        service.shutdown();
    }
}
