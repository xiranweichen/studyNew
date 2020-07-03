package com.study.shangguigu.basic.annotation;

/**
 * @description: 自定义注解
 * @date: 2020/3/15 16:22
 * @author: lizhenhong
 */
public @interface MyAnnotation {

    //没有属性值的
    String value();

    //又属性值的
    String value1() default "hello";
    
}
