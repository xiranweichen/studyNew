package com.study.shangguigu.shejimoshi.factory.factorymethod.order;

import com.study.shangguigu.shejimoshi.factory.factorymethod.pizza.Pizza;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @description: 订购pizza
 * @date: 2020/6/8 19:34
 * @author: lizhenhong
 */
public abstract class OrderPizza {

    //定义一个抽象方法，各个工厂子类自己实现
    abstract Pizza createPizza(String orderType);

    //获取订购的pizza种类
    public String getType() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("请输入pizza种类：");
        try {
            String kind = bufferedReader.readLine();
            return kind;
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

    //构造器
    public OrderPizza() {
        Pizza pizza = null;
        String orderType;
        do {
            orderType = getType();
            //抽象方法，由工厂子类完成
            pizza = createPizza(orderType);
            //输出pizza的制作过程
            pizza.prepare();
            pizza.bake();
            pizza.cut();
            pizza.box();
        } while (true);
    }
    
}
