package com.study.shangguigu.shejimoshi.factory.factorymethod.pizza;

/**
 * @description:
 * @date: 2020/6/8 19:32
 * @author: lizhenhong
 */
public class LDPepperPizza extends Pizza {
    @Override
    public void prepare() {
        setName("伦敦胡椒pizza");
        System.out.println(" 为伦敦胡椒pizza准备原料");
    }
}
