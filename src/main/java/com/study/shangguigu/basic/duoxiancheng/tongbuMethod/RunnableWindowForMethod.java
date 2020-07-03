package com.study.shangguigu.basic.duoxiancheng.tongbuMethod;

/**
 * @description: 用同步方法的方式来解决实现Runnable接口出现的线程安全问题
 * @date: 2020/2/8 17:05
 * @author: lizhenhong
 */
public class RunnableWindowForMethod {

    public static void main(String[] args) {
        Window window1 = new Window();

        Thread thread1 = new Thread(window1);
        Thread thread2 = new Thread(window1);
        Thread thread3 = new Thread(window1);

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
    @Override
    public void run() {
        while (true) {
            int ticket = sale();
            if (ticket==0) {
                System.out.println("余票张数为零");
                break;
            }
        }
    }

    private synchronized int sale() {  //这里的同步监视器时默认的this关键字
        if (ticket > 0) {
            try {
                Thread.sleep(10);  //线程执行到这里时睡眠10毫秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ": 还有余票 ：" + ticket + "张");
            ticket--;
        }
        return ticket;
    }
}
