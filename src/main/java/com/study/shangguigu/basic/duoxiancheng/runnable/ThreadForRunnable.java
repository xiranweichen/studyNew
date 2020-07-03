package com.study.shangguigu.basic.duoxiancheng.runnable;

/**
 * @description: 用实现Runnable接口的方式实现多线程
 * @date: 2020/2/6 21:28
 * @author: lizhenhong
 */
public class ThreadForRunnable {
    public static void main(String[] args) {
        //3. 创建实现类的对象
        MThread mThread = new MThread();
        //4. 将此对象作为参数传入到Thread类参数为Runnable的构造方法中，创建Thread类的对象
        Thread thread = new Thread(mThread);
        //5. 调用Thread对象的start()方法
        thread.start();
        
        //再创建一个线程，还是遍历一百以内的偶数
        Thread thread2 = new Thread(mThread);
        thread2.setName("线程2");
        thread2.start();
    }
}

//1. 创建一个实现Runnable的类
class MThread implements Runnable{

    //2. 实现Runnable中的run()方法
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ": " + i);
            }
        }
    }
}