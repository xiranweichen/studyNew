package com.study.tencent.thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @description:
 * @date: 2020/6/5 18:41
 * @author: lizhenhong
 */
public class AtomicIntergerTest {

    static AtomicInteger atomicInteger = new AtomicInteger(1);  //括号里面表示从几开始操作

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    atomicInteger.incrementAndGet();
                }
            }).start();
        }
        //防止上面的线程没有跑完就输出，让他睡眠一秒
        Thread.sleep(1000);
        System.out.println("=====>从1开始自加10次的数值：" + atomicInteger.get()); //=====>自加10次的数值：11
        /**
         * 
         */
    }
    
}
