package com.study.shangguigu.basic.duoxiancheng.thread;

/**
 * @description: 继承Thread类练习，
 *              创建两个线程，其中一个线程遍历100以内的偶数，另一个线程遍历100以内的奇数
 * @date: 2020/2/5 9:13
 * @author: lizhenhong
 */
public class ThreadExercise {
    public static void main(String[] args) {
//        ThreadForOuShu ouShu = new ThreadForOuShu();
//        ouShu.start();
//        ThreadForJiShu jiShu = new ThreadForJiShu();
//        jiShu.start();
        /*用匿名对象的方式*/
        new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    if (i % 2 == 0) {
                        System.out.println("遍历偶数的线程：遍历结果：" + i);
                    }
                }
            }
        }.start();
        new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    if (i % 2 != 0) {
                        System.out.println("遍历奇数的线程：遍历结果是：" + i);
                    }
                }
            }
        }.start();
    }
}

class ThreadForOuShu extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println("遍历偶数的线程：遍历结果：" + i);
            }
        }
    }
}

class ThreadForJiShu extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 != 0) {
                System.out.println("遍历奇数的线程：遍历结果是：" + i);
            }
        }
    }
}
