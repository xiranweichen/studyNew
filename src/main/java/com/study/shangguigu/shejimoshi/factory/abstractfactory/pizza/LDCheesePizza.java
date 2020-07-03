package com.study.shangguigu.shejimoshi.factory.abstractfactory.pizza;

/**
 * @description:
 * @date: 2020/6/8 19:33
 * @author: lizhenhong
 */
public class LDCheesePizza extends Pizza {
    @Override
    public void prepare() {
        setName("伦敦奶酪pizza");
        System.out.println(" 为伦敦奶酪pizza准备原料");
    }
}
