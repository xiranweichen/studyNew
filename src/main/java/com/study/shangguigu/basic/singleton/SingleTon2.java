package com.study.shangguigu.basic.singleton;

/**
 * @author: lizhenhong
 * @description: 单例涉及模式-懒汉式实现
 * @date: 2020/2/1 19:29
 */
public class SingleTon2 {
    public static void main(String[] args) {
        Order order1 = Order.getInstance();
        Order order2 = Order.getInstance();
        System.out.println(order1);
        System.out.println(order2);
    }
}

class Order {
    //1. 私有化类构造器
    private Order() {
    }
    //2. 声明当前类的静态变量实例(这里没有初始化）
    private static Order order = null;  //这里是null
    //3. 声明共有静态的返回当前类对象的方法
    public static Order getInstance() {
        if (order == null) {
            order = new Order();
        }
        return order;
    }
}
