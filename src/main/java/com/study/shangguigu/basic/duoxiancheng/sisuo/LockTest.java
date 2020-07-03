package com.study.shangguigu.basic.duoxiancheng.sisuo;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @description: 用lock锁解决线程安全问题
 * @date: 2020/2/9 8:58
 * @author: lizhenhong
 */ 
public class LockTest {
    public static void main(String[] args) {
        Window w = new Window();
        Thread thread1 = new Thread(w);
        Thread thread3 = new Thread(w);
        Thread thread2 = new Thread(w);
        thread1.setName("窗口一");
        thread2.setName("窗口二");
        thread3.setName("窗口三");
        thread1.start();
        thread2.start();
        thread3.start();
    }
}

class Window implements Runnable{
    private int ticket = 100;
    //1. 实例化ReentrantLock对象
    private ReentrantLock lock = new ReentrantLock();
    @Override
    public void run() {
        while (true) {
            try {
                //2. 调用锁定方法lock()
                lock.lock();
                if (ticket > 0) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "票号为：" + ticket);
                    ticket--;
                } else {
                    System.out.println(Thread.currentThread().getName() + "-没票了");
                    break;
                }
            } finally {
                //3. 调用解锁方法
                lock.unlock();
            }
        }
    }
}
