package com.study.shangguigu.basic.duoxiancheng.thread;

/**
 * @description: 多线程的方式遍历100以内的所有偶数
 * @date: 2020/2/4 21:01
 * @author: lizhenhong
 */
public class ThreadTest{

    public static void main(String[] args) {
        //3. 创建新的Thread类的子类的对象
        MyThread thread = new MyThread();
        //4. 调用此对象的start()方法
        thread.start();
        //重新new一个MyTherad对象，用新的对象调start()方法
        MyThread myThread = new MyThread();
        myThread.start();
    }
    

}

//1. 创建一个继承Thread类的子类
class MyThread extends Thread{
    //2. 重写run()方法
    @Override
    public void run() {
        //将创建的线程要做的事写到run方法里面
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
            }
        }
    }
}
