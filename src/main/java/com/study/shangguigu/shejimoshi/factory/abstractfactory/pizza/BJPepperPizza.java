package com.study.shangguigu.shejimoshi.factory.abstractfactory.pizza;

/**
 * @description:
 * @date: 2020/6/8 19:30
 * @author: lizhenhong
 */
public class BJPepperPizza extends Pizza {
    @Override
    public void prepare() {
        setName("北京胡椒pizza");
        System.out.println(" 北京胡椒pizza准备原料");
    }
}
