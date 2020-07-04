package com.study.shangguigu.shejimoshi.factory.abstractfactory.order;


import com.study.shangguigu.shejimoshi.factory.abstractfactory.pizza.Pizza;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @description: 模拟用户订购pizza
 * @date: 2020/6/8 20:24
 * @author: lizhenhong
 */
public class OrderPizza {

    AbsFactory absFactory;

    public OrderPizza(AbsFactory factory) {
        setAbsFactory(factory);
    }

    //设置工厂
    private void setAbsFactory(AbsFactory absFactory) {
        Pizza pizza = null;
        String orderType;
        this.absFactory = absFactory;
        do {
            orderType = getType();
            //这里的absFactory极可能是北京的工厂子类，也可能是伦敦的工厂子类
            pizza = absFactory.createPizza(orderType);
            if (pizza != null) {
                pizza.prepare();
                pizza.bake();
                pizza.cut();
                pizza.bake();
            } else {
                System.out.println("订购失败");
                break;
            } 
        } while (true);
    }

    //获取客户希望订购的pizza种类
    private String getType() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("请输入pizza的种类");
        String kind = "";
        try {
            kind = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return kind;
    }
}
