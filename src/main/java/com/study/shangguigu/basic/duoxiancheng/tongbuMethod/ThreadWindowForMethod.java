package com.study.shangguigu.basic.duoxiancheng.tongbuMethod;

/**
 * @description: 同步方法解决继承Thread类的方式创建多线程中的线程安全问题
 * @date: 2020/2/8 17:26
 * @author: lizhenhong
 */
public class ThreadWindowForMethod {
    public static void main(String[] args) {
        Window1 window1 = new Window1();
        Window1 window2 = new Window1();
        Window1 window3 = new Window1();
        window1.setName("1号窗口");
        window2.setName("2号窗口");
        window3.setName("3号窗口");
        window1.start();
        window2.start();
        window3.start();
    }
}

class Window1 extends Thread{
    private static int ticket = 100;
    @Override
    public void run() {
        while (true) {
            int sale = sale();
            if (sale==0) {
                System.out.println("没票了");
                break;
            }
        }
    }

    private static synchronized int sale() {
        if (ticket > 0) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "还有余票：" + ticket + "张");
            ticket--;
        }
        return ticket;
    }
}
