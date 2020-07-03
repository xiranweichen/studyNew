package com.study.shangguigu.basic.duoxiancheng.tongxin;

/**
 * @description: 线程的通信，例如：用两个线程交替打印1-100
 * @date: 2020/2/10 20:34
 * @author: lizhenhong
 */
public class CommunicationTest {
    public static void main(String[] args) {
        Number number = new Number();
        Thread thread1 = new Thread(number);
        Thread thread2 = new Thread(number);
        thread1.setName("线程一");
        thread2.setName("线程二");
        thread1.start();
        thread2.start();
    }
}

class Number implements Runnable{
    private int num = 1;
    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                notify();    //唤醒线程(notifyAll()方法是唤醒当前线程之外的所有线程)
                if (num <= 100) {
                    System.out.println(Thread.currentThread().getName() + ":" + num);
                    num++;
                    try {
                        wait();  //执行wait()方法会释放锁
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("打印完毕");
                    break;
                }
            }
        }
    }
}
