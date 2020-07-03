package com.study.shangguigu.basic.reflection;

/**
 * @description:
 * @date: 2020/5/12 18:40
 * @author: lizhenhong
 */
public class Person1 extends Creature<String> {

    private String name;
    int age;
    public int id;

    public Person1() {
    }

    Person1(String name, int age) {
        this.name = name;
        this.age = age;
    }

    private Person1(String name) {
        this.name = name;
    }

    private void show() {
        System.out.println("this is a person class");
    }

    public void info() {
        System.out.println(" I'm a person");
    }

    public String display(String interests) {
        return interests;
    }

    private String showNation(String nation) {
        System.out.println("我的国籍是:" + nation);
        return nation;
    }

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

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

