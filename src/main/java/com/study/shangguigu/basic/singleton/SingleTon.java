package com.study.shangguigu.basic.singleton;

/**
 * @author: lizhenhong
 * @description: 单例涉及模式（饿汉式实现）
 * @date: 2020/1/31 16:44
 */
public class SingleTon {
    public static void main(String[] args) {
        Bank bank1 = Bank.getInstance();
        Bank bank2 = Bank.getInstance();
        System.out.println(bank1);
        System.out.println(bank2);
    }
}
class Bank{
    //1. 私有化类构造器(私有化的目的是避免在本类的外面去调用这个构造器)
    private Bank(){
    }

    //2. 内部创建类的静态对象
    private volatile static Bank instance = new Bank();

    //3. 提供工共的static方法返回类的对象
    public static Bank getInstance() {
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
