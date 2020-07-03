package com.study.shangguigu.shejimoshi.factory.abstractfactory.order;

/**
 * @description: 调用订购的方法
 * @date: 2020/6/8 20:32
 * @author: lizhenhong
 */
public class PizzaStore {

    public static void main(String[] args) {
//        new OrderPizza(new BJFactory());
        new OrderPizza(new LDFactory());
    }
    
}
