package com.study.shangguigu.basic.enums;

import org.junit.Test;

/**
 * @description: 枚举类
 * @date: 2020/3/14 16:29
 * @author: lizhenhong
 */
public class ZiDingYiEnumTest {
    
    //自定义方式创建枚举类(jdk5.0之前)
    @Test   
    public void testZidingyi() {
        Reason reason = Reason.SPRING;
        System.out.println(reason);
    }
    
}

/**
 * 自定义枚举类(jdk5.0之前)
 */
class Reason{

    //1. 声明Reason对象的属性(用private final修饰)
    private final String seasonName;
    private final String seasonDesc;

    //2. 私有化类的构造器，并给对象赋值
    private Reason(String seasonName, String seasonDesc) {
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }

    //3. 提供当前枚举类的多个对象(public static final 的)
    public static final Reason SPRING = new Reason("春天", "春天来了");
    public static final Reason SUMMER = new Reason("夏天", "夏至未至");
    public static final Reason AUTUMN = new Reason("秋天", "秋高气爽");
    public static final Reason WINTER = new Reason("冬天", "冰天雪地");
    
    //4. 其他诉求(比如获得枚举类的属性)
    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }
    
    //其他诉求2(比如提供toString()方法)
    @Override
    public String toString() {
        return "Reason{" +
                "seasonName='" + seasonName + '\'' +
                ", seasonDesc='" + seasonDesc + '\'' +
                '}';
    }
}


