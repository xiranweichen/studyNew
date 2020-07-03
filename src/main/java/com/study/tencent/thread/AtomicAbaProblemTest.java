package com.study.tencent.thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @description: Atomic的Aba问题
 * @date: 2020/6/5 18:49
 * @author: lizhenhong
 */
public class AtomicAbaProblemTest {

    static AtomicInteger atomicInteger = new AtomicInteger(1);  //括号里面表示从几开始操作

    public static void main(String[] args) {
        int a = atomicInteger.get();
        System.out.println("初始值是：" + a);
        Thread main = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("操作线程" + Thread.currentThread().getName() + "-修改前操作数值是: " + atomicInteger.incrementAndGet());
                //然后让当前线程休眠一下
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //然后看一下是否修改成功
                boolean isCasSuccess = atomicInteger.compareAndSet(a, 2);
                if (isCasSuccess) {
                    System.out.println("操作线程" + Thread.currentThread().getName() + "-Cas修改后操作数值是: " + atomicInteger.incrementAndGet());
                }else{
                    System.out.println("CAS修改失败");
                }
                //做一个辅助的干扰线程
            }
        },"主线程");
//        Thread other = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                atomicInteger.incrementAndGet();
//                
//            }
//        })
    }
    
}
