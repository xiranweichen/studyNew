package com.study.shangguigu.basic.enums;

import org.junit.Test;

/**
 * @description: 使用enum关键字定义枚举类(定义的枚举类默认继承于java.lang.Enum类)
 * @date: 2020/3/14 17:13
 * @author: lizhenhong
 */
public class EnumTest {
    @Test
    public void testEnum() {
        Reason1 autumn = Reason1.AUTUMN;
        //toString()方法
        System.out.println(autumn);  //AUTUMN
        //values()方法
        Reason1[] values = Reason1.values();
        for (Reason1 value : values) {
            System.out.println("====>使用values()方法返回的数组对象：" + value);
            //====>使用values()方法返回的数组对象：SPRING
            //====>使用values()方法返回的数组对象：SUMMER
            //====>使用values()方法返回的数组对象：AUTUMN
            //====>使用values()方法返回的数组对象：WINTER
        }
        //valueOf(String str)方法：根据提供的str返回枚举类中对象名是str的对象
        //如果没有str的枚举类对象，则会抛异常IllegalArgumentException: No enum constant shangguigu.basic.enums.Reason1....
        Reason1 winter = Reason1.valueOf("WINTER");
        //Reason1 winter = Reason1.valueOf("WINTER1");(没有str的枚举类对象)
        System.out.println("=====>使用valueOf(String str)方法返回的对象：" + winter);//====>使用valueOf(String str)方法返回的对象：WINTER
    }
}

/**
 * 使用enum关键字定义枚举类(jdk5.0及以后)
 */
enum  Reason1{

    //1. 提供当前枚举类的对象(多个对象之间用","隔开，末尾的对象用";"结束)
    SPRING("春天", "春天来了"),
    SUMMER("夏天", "夏至未至"),
    AUTUMN("秋天", "秋高气爽"),
    WINTER("冬天", "冰天雪地");

    //2. 声明Reason1对象的属性(用private final修饰)
    private final String seasonName;
    private final String seasonDesc;

    //2. 私有化类的构造器，并给对象赋值
    private Reason1(String seasonName, String seasonDesc) {
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }


    //4. 其他诉求(比如获得枚举类的属性)
    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }

    //其他诉求2(比如提供toString()方法)(enum不需要提供toString()方法)
//    @Override
//    public String toString() {
//        return "Reason1{" +
//                "seasonName='" + seasonName + '\'' +
//                ", seasonDesc='" + seasonDesc + '\'' +
//                '}';
//    }
}
