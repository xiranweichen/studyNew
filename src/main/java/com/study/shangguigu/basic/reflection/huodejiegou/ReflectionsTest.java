package com.study.shangguigu.basic.reflection.huodejiegou;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author lizhenhong
 * @Description: 调用运行时类中指定的结构(属性、方法、构造器)
 * @date 2020/5/16 22:12
 */
public class ReflectionsTest {

    /**
     * 获取属性(这种方法由于只能获得public的属性，故使用频率不高)
     */
    @Test
    public void getField() throws Exception {
        Class<Person> personClass = Person.class;
        //创建运行时类的对象
        Person person = personClass.newInstance();
        //获取指定的属性(要求此属性时public的)
        Field id = personClass.getField("id");
        /**
         * 设置当前属性的值
         * set(Object obj, Object value):
         *      参数一：指明被设置对象
         *      参数二：设置的值
         */
        id.set(person, 18);
        //获取当前对象的当前属性值
        Object o = id.get(person);
        System.out.println(o);  //18

    }

    /**
     * 这个比较重要，需要掌握
     * 获取属性(这个是常用的方法)
     */
    @Test
    public void testGetField() throws Exception {
        Class<Person> personClass = Person.class;
        //1. 创建运行时类的对象
        Person person = personClass.newInstance();
        //2。 getDeclaredField(String fieldName): 获取运行时类中指定名称的属性
        Field name = personClass.getDeclaredField("name");
        //3. etAccessible(true): 保证当前属性是可访问的
        name.setAccessible(true);
        //4. 根据实际需求设置指定对象的属性值
        name.set(person,"zhangyunzhu");
        System.out.println(name.get(person));  //zhangyunzhu

    }

    /**
     * 调用运行时类的指定方法
     */
    @Test
    public void testMethod() throws Exception {

        Class<Person> personClass = Person.class;
        //创建运行时类的对象
        Person person = personClass.newInstance();
        /**
         * 1. 获取指定的某个方法getDeclaredMethod(String name, Class<?> class):
         *    参数一: 要获取的方法的名称
         *    参数二: 方法的形参列表
         */
        Method show = personClass.getDeclaredMethod("show", String.class);
        //2. 保证当前方法是可用的
        show.setAccessible(true);
        /**
         * 3. 调用invoke(Object obj, Object args)执行
         *      参数一: 方法的调用者
         *      参数二: 被调用方法的入参(参数列表)
         * invoke方法是有返回值的，得到的返回值即为运行时类中被调用的方法的返回值
         */
        Object china = show.invoke(person, "China");
        System.out.println(china);  //China

        System.out.println("===============静态方法的调用==================");
        //调用静态方法private static void showDesc
        Method showDesc = personClass.getDeclaredMethod("showDesc");
        showDesc.setAccessible(true);
        Object invoke = showDesc.invoke(person); //调用静态方法的时候后加的
        System.out.println(invoke);  //null
    }

    /**
     * 调用运行时类的指定构造器
     */
    @Test
    public void testConstrctor() throws Exception {
        Class<Person> personClass = Person.class;
//        Person person = personClass.newInstance();  //最常用的方法，方便，实惠
        //private Person(String name) {
        /**
         * 1. 获取指定构造器
         * getDeclaredConstructor(Class<?> ... paramType)：
         *     入参: 构造器的参数列表
         */
        Constructor<Person> constructor = personClass.getDeclaredConstructor(String.class);
        //2. 保证此构造器时可访问的
        constructor.setAccessible(true);
        //3. 调用此构造器(创建运行时类的对象)
        Person person = constructor.newInstance("zhangyunzhu");
        System.out.println(person.toString());  //Person{name='zhangyunzhu', age=0, id=0}

    }


}
