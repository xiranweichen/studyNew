package com.study.shangguigu.basic.duotai;

/**
 * @author: lizhenhong
 * @description: 测试多态性的作用
 * @date: 2020/1/23 20:53
 */
public class AnimalTest {

    public static void main(String[] args) {
        AnimalTest test = new AnimalTest();
        test.function(new Animal());

    }

    public void function(Animal animal) {
        animal.eat();
        animal.shot();
    }
}

class Animal{
    public void eat() {
        System.out.println("class animal eat ....");
    }

    public void shot() {
        System.out.println("class animal shot .... ");
    }
}

class Dog extends Animal {
    public void eat() {
        System.out.println("class dog eat ....");
    }

    public void shot() {
        System.out.println("class dog shot .... ");
    }
}

