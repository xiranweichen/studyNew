package com.study.shangguigu.basic.duoxiancheng.runnable;

/**
 * @description: 创建一个窗口，卖票，总数为100张(实现Runnable接口的方式)
 * @date: 2020/2/7 15:16
 * @author: lizhenhong
 */
public class WindowForRunnable {
    
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
//    Object obj = new Object();
    @Override
    public void run() {
//        Object obj = new Object();  //放到这里时不行的，不能使多个线程公用一个锁
        while (true) {
//            synchronized (obj){
            synchronized (this){
                if (ticket > 0) {
                    try {
                        Thread.sleep(100);  //线程执行到这里时睡眠100毫秒
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + ": 还有余票 ：" + ticket + "张");
                    ticket--;
                }else {
                    System.out.println("当前无票，请下次再来！");  
                    break;
                }
            }
        }
    }
}
