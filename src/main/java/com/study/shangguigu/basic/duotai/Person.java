package com.study.shangguigu.basic.duotai;

/**
 * @author: lizhenhong
 * @description: 父类
 * @date: 2020/1/21 15:20
 */
public class Person {

    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void eat() {
        System.out.println("=======>eat 饭");
    }

    public void walk() {
        System.out.println("=======> walk 路");
    }

}
