package com.study.shangguigu.shejimoshi.factory.simplefactory;

/**
 * @author lizhenhong
 * @Description: 简单工厂类
 * @date 2020/6/20 14:44
 */
public class SimpleFactory {

    public Pizza getcreatPizza(String orderType) {
        Pizza pizza;
        System.out.println("===>这里是简单工厂模式");
        switch (orderType) {
            case "greek":
                pizza = new Pizza();
                pizza.setName("greek pizza");
                break;
            case "cheese":
                pizza = new Pizza();
                pizza.setName("cheese");
                break;
            case "pepper":
                pizza = new Pizza();
                pizza.setName("pepper");
                break;
            default:
                pizza = null;
        }
        return pizza;
    }

}
