package com.study.shangguigu.basic.duoxiancheng.sisuo;

/**
 * @description: 线程的死锁（写代码不要这么写！）
 * @date: 2020/2/8 20:57
 * @author: lizhenhong
 */
public class SiSuoTest {
    public static void main(String[] args) {
        StringBuffer s1 = new StringBuffer();
        StringBuffer s2 = new StringBuffer();

//        new Thread() {
//            @Override
//            public void run() {
//                synchronized (s1) {
//                    s1.append("a");
//                    s2.append("1");
//                    synchronized (s2) {
//
//                    }
//                }
//            }
//        }.start();
    }
}
