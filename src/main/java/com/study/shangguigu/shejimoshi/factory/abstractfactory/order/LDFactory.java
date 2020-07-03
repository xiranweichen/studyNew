package com.study.shangguigu.shejimoshi.factory.abstractfactory.order;

import shangguigu.shejimoshi.factory.abstractfactory.pizza.LDCheesePizza;
import shangguigu.shejimoshi.factory.abstractfactory.pizza.LDPepperPizza;
import shangguigu.shejimoshi.factory.abstractfactory.pizza.Pizza;

/**
 * @description: 伦敦工厂类(工厂子类)
 * @date: 2020/6/8 20:22
 * @author: lizhenhong
 */
public class LDFactory implements AbsFactory {
    @Override
    public Pizza createPizza(String orderType) {
        System.out.println("使用的是抽象工厂模式-LD");
        Pizza pizza = null;
        if (orderType.equals("cheese")) {
            pizza = new LDCheesePizza();
        } else if (orderType.equals("pepper")) {
            pizza = new LDPepperPizza();
        }
        return pizza;
    }
}
