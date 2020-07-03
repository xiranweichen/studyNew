package com.study.meite.thread.threadpool;

import org.junit.Test;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author lizhenhong
 * @Description: 自定义线程池
 *
 * @date 2020/6/27 19:13
 */
public class ZidingyiThreadPool {

    @Test
    public void test() {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(1,             //核心线程数：比如设置成1，表示只能同时运行一个线程
                                                        2,             //最大线程数：2，最多只能创建两个线程
                                                           60L,            //存活时间，线程空闲超时时间，
                                                                         TimeUnit.MILLISECONDS,          //空闲时间单位
                                                                         new LinkedBlockingQueue<Runnable>(3));//队列的类型 && 容量
        /**
         * 如果下面执行的线程数 > 线程池最大线程数 + 队列容量 的总和，就会报错
         */
        //任务一现在创建了线程在执行
        executor.execute(new TaskThread("线程一"));
        //任务二存放在队列缓存中
        executor.execute(new TaskThread("线程二"));
        //任务三存放在队列缓存中
        executor.execute(new TaskThread("线程三"));
        //任务四存放在缓存队列中
        executor.execute(new TaskThread("线程四"));
        //任务五
        executor.execute(new TaskThread("线程五"));
        //任务六，这时队列满了，而且任务二三四将队列存满了，
        // 此时外面的线程数在活跃最大线程数和队列容量的总和，所以这里会拒绝执行，
        // 即报错：java.util.concurrent.RejectedExecutionException
//        executor.execute(new TaskThread("线程六"));

    }

}

class TaskThread extends Thread{
    private String threadName;
    public TaskThread(String threadName) {
        this.threadName = threadName;
    }
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "-正在运行的任务名：" + threadName);
    }
}