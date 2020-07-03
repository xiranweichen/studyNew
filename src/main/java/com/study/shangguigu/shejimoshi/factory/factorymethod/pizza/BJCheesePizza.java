package com.study.shangguigu.shejimoshi.factory.factorymethod.pizza;

/**
 * @description: 北京奶酪pizza
 * @date: 2020/6/8 19:25
 * @author: lizhenhong
 */
public class BJCheesePizza extends Pizza {
    @Override
    public void prepare() {
        setName("北京奶酪pizza");
        System.out.println("给北京的奶酪pizza准备原料");
    }
}
