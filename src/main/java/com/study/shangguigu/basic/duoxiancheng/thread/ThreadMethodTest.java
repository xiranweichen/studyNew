package com.study.shangguigu.basic.duoxiancheng.thread;

/**
 * @description: Thread类的常见方法
 * @date: 2020/2/5 10:03
 * @author: lizhenhong
 */
public class ThreadMethodTest {
    public static void main(String[] args) {
        HelloThread helloThread = new HelloThread("用构造器命名线程名");
//        设置线程名
//        helloThread.setName("初次正式接触多线程，请多指教");
        helloThread.start();
//        设置主线程的线程名(这里很奇怪，不知道为什么，每次测试的时候都是先把主线程的逻辑执行完才执行别的线程)
        Thread.currentThread().setName("主线程");
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 1) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
//            if (i == 20) {
//                try {
//                    helloThread.join();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
        }
//        SecondThread second = new SecondThread();
//        second.setName("临时加的线程");
//        second.start();
    }
}

class HelloThread extends Thread{
    public HelloThread(String threadName) {
        super(threadName);
    }
    @Override
    public void run() {
        Thread.currentThread().setPriority(10);
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                //输出线程名以及i的值
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
            //如果i能被20整除，则当前线程让步给其他线程执行
//            if (i % 20 == 0) {
//                this.yield();
//            }
        }
    }
}

class SecondThread extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 != 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}
