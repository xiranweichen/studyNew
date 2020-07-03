package com.study.shangguigu.shejimoshi.factory.simplefactory;

/**
 * @author lizhenhong
 * @Description:
 * @date 2020/6/20 16:21
 */
public class OrderPizza {

    //定义一个简单工厂对象
    SimpleFactory factory;
    //定义一个pizza对象
    Pizza pizza = null;

    //写一个调用setFactory的构造器
    public OrderPizza(SimpleFactory simpleFactory) {
        setFactory(simpleFactory);
    }

    public void setFactory(SimpleFactory factory) {
        String orderType = "";
        //设置简单工厂对象
        this.factory = factory;
            orderType = getType("greek");
            pizza = factory.getcreatPizza(orderType);
            if (pizza != null) {
                System.out.println("====>" + orderType + "-pizza-订购成功");
                pizza.prepare();
                pizza.bake();
                pizza.cut();
                pizza.box();
            }else {
                System.out.println("订购失败");
            }
    }

    //获取订购的pizza种类
    public String getType(String orderType) {
        return orderType;
    }


}
