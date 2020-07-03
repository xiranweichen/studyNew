package com.study.shangguigu.basic.staticTest;

/**
 * @author: lizhenhong
 * @description: static关键字的应用举例
 * @date: 2020/1/23 21:47
 */

public class StaticTest {

    public static void main(String[] args) {
        Circle c1 = new Circle();
        System.out.println("c1的id是：" + c1.getId() + ", 制造的圆的个数：" + Circle.getTotal());
        Circle c2 = new Circle();
        System.out.println("c2的id是:" + c2.getId() + ", 制造的圆的个数：" + Circle.getTotal());
    }
}

class Circle{
    private double radius;  //半径
    private int id;   //给一个id，每调一次静态属性让id加1
    private static int total;  //记录创建的圆的个数
    private static int init = 1001;  //给一个初始值
    //声明一个构造方法，达到id && total都加1的功能
    public Circle() {
        id = init++;
        total++;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static int getTotal() {
        return total;
    }

    public static void setTotal(int total) {
        Circle.total = total;
    }
}

