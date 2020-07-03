package com.study.shangguigu.basic.abstractTest;

/**
 * @author: lizhenhong
 * @description: 声明抽象类Employee
 * @date: 2020/2/2 16:13
 */
public abstract class Employee {   //这里的class必须用abstract修饰

    private String name;
    private int age;
    private double salary;

    public Employee() {
    }

    public Employee(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }
    //抽象方法work
    public abstract void work();
}
