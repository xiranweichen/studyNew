package com.study.shangguigu.basic;

/**
 * @description: 构造器
 * @date: 2020/1/18 12:09
 * @author: lizhenhong
 */
public class ConstroctorTest {

    public static void main(String[] args) {
        Person p = new Person("lizhenhong");
        System.out.println("=============> 通过构造器初始化的name的属性值是：" + p.name);   
    }
    
}

class Person{
    String name;
    int age;
    
    public Person() {
    }
    

    public Person(String n) {
        name = n;
    }
}
