package com.study.tencent.thread;

/**
 * @author lizhenhong
 * @Description: 指令重排
 * @date 2020/6/6 10:34
 */
public class VolatileReOrderSample {

    private static int x = 0, y = 0;
    private static int a=0, b = 0;

    public static void main(String[] args) {
        int i = 0;
        for (; ; ) {
            i++;
            x=0;
            y = 0;
            a = 0;
            b = 0;
//            Thread t1 = new Thread(new Runnable() {
//                @Override
//                public void run() {
//
//                }
//            })
        }
    }

}
