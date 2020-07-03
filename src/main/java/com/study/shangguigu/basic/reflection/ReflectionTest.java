package com.study.shangguigu.basic.reflection;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author: lizhenhong
 * @description: java反射机制
 * @date: 2020/4/19 20:19
 */
public class ReflectionTest {

    /**
     * 不用反射的方式
     */
    @Test
    public void testNormal() {
        Person person = new Person("zhangyunzhu", 23);
        System.out.println(person.toString());  //Person{name='zhangyunzhu', age=23}
        person.age = 18;
        System.out.println(person.toString());  //Person{name='zhangyunzhu', age=18}
        person.show();  //this is a person class
    }

    /**
     * 使用反射
     * @throws Exception
     */
    @Test
    public void testReflection() throws Exception {
        Class personClass = Person.class;
        //1. 通过反射，创建Person类的对象
        Constructor constructor = personClass.getConstructor(String.class, int.class);
        Person zhangyunzhu = (Person) constructor.newInstance("zhangyunzhu", 23);
        System.out.println(zhangyunzhu.toString());  //Person{name='zhangyunzhu', age=23}

        //2. 通过反射，调用对象指定的属性、方法
        //2.1 调用属性
        Field age = personClass.getDeclaredField("age");  //去到Person中的age属性
        age.set(zhangyunzhu, 18);  //将age属性设置为18
        System.out.println(zhangyunzhu.toString());  //Person{name='zhangyunzhu', age=18}

        //2.2 调用方法
        Method show = personClass.getDeclaredMethod("show"); //调用空参的show方法
        show.invoke(zhangyunzhu);
        //这里输出的是: this is a person class
    }

    /**
     * 通过反射，调用类内部的私有结构，如：构造器、属性、方法
     */
    @Test
    public void testReflection1() throws Exception{
        Class<Person> personClass = Person.class;
        //1. 调用私有的构造器
        Constructor<Person> constructor = personClass.getDeclaredConstructor(String.class);
        constructor.setAccessible(true);
        Person person = constructor.newInstance("Tom");//private Person(String name)
        System.out.println(person);  //Person{name='person', age=0}
        //2. 调用私有属性
        Field name = personClass.getDeclaredField("name");
        name.setAccessible(true);
        name.set(person, "lizhenhong");
        System.out.println(person);  //Person{name='lizhenhong', age=0}
        //3. 调用私有方法
        Method nation = personClass.getDeclaredMethod("showNation", String.class);
        nation.setAccessible(true);
        String china = (String) nation.invoke(person, "China");//相当于person.showNation("中国")方法
        //上面输出的是: 我的国籍是:China
        System.out.println(china);  //China
    }

    /**
     * Class实例的获取
     */
    @Test
    public void testForClass() throws ClassNotFoundException {
        //方式一：调用运行时类的属性: .class
        Class<Person> personClass1 = Person.class;
        System.out.println(personClass1);  //class shangguigu.basic.reflection.Person

        //方式二：通过运行时类的对象,调用getClass()方法
        Person p1 = new Person();
        Class<? extends Person> p1Class = p1.getClass();
        System.out.println(p1Class);  //class shangguigu.basic.reflection.Person

        //方式三：通过调用Class的静态方法
        Class<?> name = Class.forName("shangguigu.basic.reflection.ReflectionTest");
        System.out.println(name);  //class shangguigu.basic.reflection.ReflectionTest

        //方式四：使用类的加载器: ClassLoader
        ClassLoader classLoader = ReflectionTest.class.getClassLoader();
        Class<?> loadClass = classLoader.loadClass("shangguigu.basic.reflection.ReflectionTest");
        System.out.println(loadClass);  //class shangguigu.basic.reflection.ReflectionTest


    }

}