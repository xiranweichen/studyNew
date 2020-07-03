package com.study.shangguigu.basic.reflection.huodejiegou;

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @author lizhenhong
 * @Description: 获取运行时类的其他结构
 * @date 2020/5/16 20:30
 */
public class OtherTest {

    /**
     * 获取运行时类的父类
     */
    @Test
    public void test1() {
        Class<Person> personClass = Person.class;
        Class<? super Person> superclass = personClass.getSuperclass();
        System.out.println(superclass); //class shangguigu.basic.reflection.huodejiegou.Creature
    }

    /**
     * 获取带泛型的父类
     */
    @Test
    public void test2() {
        Class<Person> personClass = Person.class;
        Type superclass = personClass.getGenericSuperclass();
        System.out.println(superclass);  //shangguigu.basic.reflection.huodejiegou.Creature<java.lang.String>

        //获取运行时类的父类的泛型
        Type genericSuperclass = personClass.getGenericSuperclass();
        ParameterizedType paramType = (ParameterizedType) genericSuperclass;
        Type[] arguments = paramType.getActualTypeArguments();
        System.out.println(arguments[0].getTypeName());  //java.lang.String
        for (Object argument : arguments) {
            System.out.println(argument);  //class java.lang.String
        }
    }

    /**
     * 获取运行时类实现的接口
     */
    @Test
    public void test3() {
        Class<Person> personClass = Person.class;
        Class<?>[] interfaces = personClass.getInterfaces();
        for (Class<?> anInterface : interfaces) {
            /**
             * interface java.lang.Comparable
             * interface shangguigu.basic.reflection.huodejiegou.MyInterface
             */
            System.out.println(anInterface);

        }
        Class<?>[] interfaces1 = personClass.getSuperclass().getInterfaces();
        for (Class<?> aClass : interfaces1) {
            System.out.println(aClass);  //interface java.shangguigu.basic.io.Serializable
        }
    }

    /**
     * 获取运行时类所在的包
     */
    @Test
    public void test5() {
        Class<Person> personClass = Person.class;
        Package aPackage = personClass.getPackage();
        System.out.println(aPackage);  //package shangguigu.basic.reflection.huodejiegou
        System.out.println(aPackage.getName());  //shangguigu.basic.reflection.huodejiegou
    }

    /**
     * 获取运行时类声明的注解
     */
    @Test
    public void test6() {
        Class<Person> personClass = Person.class;
        Annotation[] annotations = personClass.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation); //@shangguigu.basic.reflection.huodejiegou.MyAnnotation(value=Person)
        }
    }

}