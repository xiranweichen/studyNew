package com.study.shangguigu.basic.block;

/**
 * @author: lizhenhong
 * @description: 代码块（初始化块）
 * @date: 2020/2/1 20:36
 */
public class BlockTest {
    public static void main(String[] args) {
        String desc = Person.desc;
        Person person = new Person();
    }
}
class Person{
    String name;
    int age;
    static String desc = "I'm a person";

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    //静态代码块(随着类的加载而执行且只执行一次)
    static {
        System.out.println("这里是静态代码块");
    }
    //非静态代码块(随着对象的创建而执行，没创建一次对象都执行一次)
    {
        System.out.println("这里是非静态代码块");
    }

    public void eat() {
        System.out.println("这里是吃饭的方法");
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
