package com.study.shangguigu.shejimoshi.factory.abstractfactory.order;


import com.study.shangguigu.shejimoshi.factory.abstractfactory.pizza.BJCheesePizza;
import com.study.shangguigu.shejimoshi.factory.abstractfactory.pizza.BJPepperPizza;
import com.study.shangguigu.shejimoshi.factory.abstractfactory.pizza.Pizza;

/**
 * @description: 北京工厂类(工厂子类)
 * @date: 2020/6/8 20:20
 * @author: lizhenhong
 */
public class BJFactory implements AbsFactory{


    @Override
    public Pizza createPizza(String orderType) {
        System.out.println("使用的是抽象工厂模式-BJ");
        Pizza pizza = null;
        if (orderType.equals("cheese")) {
            pizza = new BJCheesePizza();
        } else if (orderType.equals("pepper")) {
            pizza = new BJPepperPizza();
        }
        return pizza;
    }
}
