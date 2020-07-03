package com.study.shangguigu.basic.usualClass.string;

/**
 * @description:
 * @date: 2020/2/16 19:20
 * @author: lizhenhong
 */
public class StringTest2 {

    public static void main(String[] args) {
        String s1 = "java";
        String s2 = "java";
        String s3 = new String("java");
        String s4 = new String("java");

        System.out.println(s1 == s2);      //true
        System.out.println(s1 == s3);     //false
        System.out.println(s1 == s4);     //false
        System.out.println(s3 == s4);     //false

        Person p1 = new Person("lizhenhong", 11);
        Person p2 = new Person("lizhenhong", 10);
        System.out.println("p1.name.equals(p2.name)结果：" + p1.name.equals(p2.name));  //true
        System.out.println("p1.name == p2.name结果: " + (p1.name == p2.name));          //true
        
    }
}

class Person {
    String name;
    int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
