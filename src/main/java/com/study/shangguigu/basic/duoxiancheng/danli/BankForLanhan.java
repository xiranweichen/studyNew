package com.study.shangguigu.basic.duoxiancheng.danli;

/**
     * @description: 用同步机制解决单例的懒汉式实现中存在的线程不安全问题
 * @date: 2020/2/8 19:26
 * @author: lizhenhong
 */
public class BankForLanhan {
    
}

class Bank{
    public Bank() {
    }

    private static Bank instance = null;

    public static Bank getInstance() {
        //方式一：效率稍差
//        synchronized (Bank.class) {
//            if (instance == null) {
//                instance = new Bank();
//            }
//            return instance;
//        }
        //方式二：效率高一些
        if (instance == null) {
            synchronized (Bank.class) {
                if (instance == null) {
                    instance = new Bank();
                }
            }
        }
        return instance;
    }
}
