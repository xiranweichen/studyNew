package com.study.meite.thread.threadpool;

import org.junit.Test;

import java.util.concurrent.*;

/**
 * @description: Callable方式创建可返回结果的线程池
 * @date: 2020/6/29 19:25
 * @author: lizhenhong
 */
public class CallableThreadPool {

    /**
     * future模式：
     *  A、B两个线程，如果A需要B的结果，A不需要等到B执行完成后才能拿到结果，
     *  使用Futhre模式可以拿到一个未来的Futrure，等B有了结果再取真是的结果，类似于Ajax，做异步加载
     */
//    看到day008，第五节
    @Test
    public void test() throws ExecutionException, InterruptedException {
        ExecutorService service = Executors.newCachedThreadPool();
        Future<String> result = service.submit(new TaskFuture());
        Thread.sleep(2000);
        System.out.println("1. 主线程开始执行");
        String s = result.get();
        Thread.sleep(2000);
        System.out.println("2. Callable返回的结果：" + s);
//        new ThreadPoolExecutor(1,
//                2, 
//                3, 
//                TimeUnit.MILLISECONDS,
//                new LinkedBlockingQueue<>(3),
//                new ThreadFactory() {
//                    @Override
//                    public Thread newThread(Runnable r) {
//                        return null;
//                    }
//                },
//                new ThreadPoolExecutor.AbortPolicy()
//        );
        new LinkedBlockingQueue<>(3);
    }
    
}

class TaskFuture implements Callable<String> {

    @Override
    public String call() throws Exception {
        System.out.println("3. 执行任务开始-正在执行任务，需要等待五秒时间");
        Thread.sleep(5000);
        System.out.println("4. 执行任务结束，需要等待五秒时间");
        return "lizhenhong";
    }
}
