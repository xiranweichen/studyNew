package com.study.shangguigu.shejimoshi.factory.abstractfactory.order;

import shangguigu.shejimoshi.factory.abstractfactory.pizza.Pizza;

/**
 * @description: 一个抽象工厂模式的抽象层
 * @date: 2020/6/8 20:19
 * @author: lizhenhong
 */
public interface AbsFactory {

    //让下面的工厂子类来具体实现这个方法
    public Pizza createPizza(String orderType);
    
}
