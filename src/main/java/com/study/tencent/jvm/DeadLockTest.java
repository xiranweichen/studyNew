package com.study.tencent.jvm;

/**
 * @author lizhenhong
 * @Description: 死锁程序
 * @date 2020/5/24 21:21
 */
public class DeadLockTest {

    private static Object lock1 = new Object();
    private static Object lock2 = new Object();

    public static void main(String[] args) {
        new Thread(() -> {
            synchronized (lock1) {
                System.out.println("thread1 开始");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock2) {
                    System.out.println("thread1 停止");
                }
            }
        }).start();

        new Thread(()->{
            synchronized (lock2) {
                try {
                    System.out.println("thread2 开始");
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock1) {
                    System.out.println("thread2 停止");
                }
            }
        }).start();
    }

}
