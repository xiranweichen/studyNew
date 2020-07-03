package com.study.shangguigu.shejimoshi.factory.simplefactory;

import org.junit.Test;

/**
 * @author lizhenhong
 * @Description: 使用简单工厂模式
 * @date 2020/6/20 16:36
 */
public class PizzaStore {

    @Test
    public void testSimpleFactory() {
        new OrderPizza(new SimpleFactory());
        System.out.println("====>退出程序");
    }

}
