package com.study.shangguigu.basic.duoxiancheng.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @description: 用线程池的方式创建多线程
 * @date: 2020/2/15 16:42
 * @author: lizhenhong
 */
public class ThreadPoolTest {
    public static void main(String[] args) {
        //1. 提供指定线程数量的线程池
        ExecutorService service = Executors.newFixedThreadPool(10);
        //设置线程池的属性
        ThreadPoolExecutor executor = (ThreadPoolExecutor) service;
        executor.setCorePoolSize(15);   //线程池的大小
        //2. 执行指定的线程的操作，这里需要提供实现Runnable或者Callable接口的实现类的对象
        service.execute(new NumberThread());
//        service.submit(Callable call);  //适用于实现Callable接口的方式，可以用一个类型接收返回值
        //3. 关闭连接池
        service.shutdown();
    }
}
class NumberThread implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i%2==0) {
                System.out.println(Thread.currentThread().getName() + " : " + i);
            }
        }
    }
}
