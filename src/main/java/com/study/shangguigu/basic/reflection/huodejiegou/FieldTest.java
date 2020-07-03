package com.study.shangguigu.basic.reflection.huodejiegou;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * @author lizhenhong
 * @Description: 通过反射获取当前运行时类的所有属性、以记属性的权限修饰符、数据类型
 * @date 2020/5/16 15:27
 */
public class FieldTest {

    @Test
    public void test1() {
        Class<Person> personClass = Person.class;
        //获取属性结构
        //1. getFields(): 获取当前运行时类及其父类中public的属性
        Field[] fields = personClass.getFields();
        //遍历获得的属性
        for (Field field : fields) {
            System.out.println(field);//public int shangguigu.basic.reflection.huodejiegou.Person.id
                                      //public double shangguigu.basic.reflection.huodejiegou.Creature.wight
        }

        System.out.println("====================================");
        //2. getDeclaredFields(): 获取当前运行时类中声明的所有属性(包括private的)(不包含父类中声明的属性)
        Field[] declaredFields = personClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField); //private java.lang.String shangguigu.basic.reflection.huodejiegou.Person.name
                                               //int shangguigu.basic.reflection.huodejiegou.Person.age
                                               //public int shangguigu.basic.reflection.huodejiegou.Person.id
        }
    }

    /**
     * 获取具体类型的属性(包括具体的权限修饰符、数据类型、变量名)
     */
    @Test
    public void test2() {
        Class<Person> personClass = Person.class;
        Field[] declaredFields = personClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            //1. 权限修饰符(getModifiers(): 获取的是int类型数字，可以用Modifier.toString(modifier)方法转换成具体的修饰符)
            int modifier = declaredField.getModifiers();
            System.out.println(modifier);  //2
                                           //0
                                           //1
//            System.out.println("====================================");
            String modifierString = Modifier.toString(modifier);
            System.out.println(modifierString); //private
                                                //
                                                //public
            System.out.println("====================================");
            //2. 数据类型(getType(): 获得的是全限定名类的数据类型，可以加一个getName()方法)
            Class type = declaredField.getType();
            System.out.println(modifierString + "\t" + type.getName());//privateclass java.lang.String
                                                                       //int
                                                                       //public	int

            //3. 变量名(getName()方法：获得属性名)
            String name = declaredField.getName();
            System.out.println(name);  //name
                                       //age
                                       //id
        }
    }

}











