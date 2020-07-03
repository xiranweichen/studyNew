package com.study.shangguigu.basic.duoxiancheng.thread;

/**
 * @description: 创建一个窗口，卖票，总数为100张
 * @date: 2020/2/6 20:34
 * @author: lizhenhong
 */
public class WindowTest{
    public static void main(String[] args) {
        Window window1 = new Window();
        Window window2 = new Window();
        Window window3 = new Window();
        window1.setName("1号窗口");
        window2.setName("2号窗口");
        window3.setName("3号窗口");
        window1.start();
        window2.start();
        window3.start();
    }
}

class Window extends Thread{
    //这种写法存在一票多卖(即线程安全问题)，后面讲线程安全的时候再解决
    private static int ticket = 100;
    //解决前面的线程安全问题
    private static Object obj = new Object();
    @Override
    public void run() {
        while (true) {
            synchronized (obj) {
                if (ticket > 0) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "还有余票：" + ticket + "张");
                    ticket--;
                } else {
                    System.out.println("没票了，下次再来吧");
                    break;
                }
            }
        }
    }
}
