package com.study.shangguigu.basic.reflection.huodejiegou;

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * @author lizhenhong
 * @Description: 获取运行时类的方法结构
 * @date 2020/5/16 16:34
 */
public class MethodTest {

    @Test
    public void test1() {
        Class<Person> personClass = Person.class;

        //获取所有的方法(getMethods(): 获取当前运行时类及其所有父类的public的方法)
        //也可以用getName()获得方法名称
        Method[] methods = personClass.getMethods();
        for (Method method : methods) {
            /**
             * public int shangguigu.basic.reflection.huodejiegou.Person.compareTo(java.lang.String)
             * public int shangguigu.basic.reflection.huodejiegou.Person.compareTo(java.lang.Object)
             * public void shangguigu.basic.reflection.huodejiegou.Person.info()
             * public java.lang.String shangguigu.basic.reflection.huodejiegou.Person.display(java.lang.String)
             * public void shangguigu.basic.reflection.huodejiegou.Creature.eat()
             * public final void java.lang.Object.wait() throws java.lang.InterruptedException
             * public final void java.lang.Object.wait(long,int) throws java.lang.InterruptedException
             * public final native void java.lang.Object.wait(long) throws java.lang.InterruptedException
             * public boolean java.lang.Object.equals(java.lang.Object)
             * public java.lang.String java.lang.Object.toString()
             * public native int java.lang.Object.hashCode()
             * public final native java.lang.Class java.lang.Object.getClass()
             * public final native void java.lang.Object.notify()
             * public final native void java.lang.Object.notifyAll()
             */
            System.out.println(method);  //太长了，写到上面了，下同
        }

        //getDeclaredMethods(): 获取当前运行时类中声明的所有方法(不包含父类中的)
        //也可以用getName()获得方法名称
        Method[] declaredMethods = personClass.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            /**
             * public int shangguigu.basic.reflection.huodejiegou.Person.compareTo(java.lang.String)
             * public int shangguigu.basic.reflection.huodejiegou.Person.compareTo(java.lang.Object)
             * public void shangguigu.basic.reflection.huodejiegou.Person.info()
             * private java.lang.String shangguigu.basic.reflection.huodejiegou.Person.show(java.lang.String)
             * public java.lang.String shangguigu.basic.reflection.huodejiegou.Person.display(java.lang.String)
             */
            System.out.println(declaredMethod);
            /**
             * compareTo
             * compareTo
             * info
             * display
             * show
             */
            System.out.println(declaredMethod.getName());

        }
        //getConstructors(): 获取运行时类自己的构造器(public的)
        Constructor<?>[] constructors = personClass.getConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor);  //public shangguigu.basic.reflection.huodejiegou.Person()
        }

        //getDeclaredConstructors(): 获取当前运行时类自己的所有构造方法(包括private的)
        Constructor<?>[] declaredConstructor = personClass.getDeclaredConstructors();
        for (Constructor<?> constructor : declaredConstructor) {
            /**
             * shangguigu.basic.reflection.huodejiegou.Person(java.lang.String,int)
             * private shangguigu.basic.reflection.huodejiegou.Person(java.lang.String)
             * public shangguigu.basic.reflection.huodejiegou.Person()
             */
            System.out.println(constructor);
        }

    }

    /**
     * 获取方法内部的结构
     * @ 注解
     * 权限修饰符、返回值类型、方法名(参数列表) throws xxxException{}
     * 输出结果：
     * public int compareTo(java.lang.String args_0)
     * public volatile int compareTo(java.lang.Object args_0)
     * public void info()
     * public java.lang.String display(java.lang.String args_0, int args_1) throws java.lang.NullPointerException, java.lang.ClassCastException
     *
     * @reflection.huodejiegou.MyAnnotation(value=hello)
     * private java.lang.String show(java.lang.String args_0)
     */
    @Test
    public void test2() {

        Class<Person> personClass = Person.class;
        Method[] declaredMethods = personClass.getDeclaredMethods();
        for (Method method : declaredMethods) {
            //1. 获取方法的注解(@Retention(RetentionPolicy.RUNTIME)的才能获取到，CLASS的和SOURCE的都不能)
            Annotation[] annotations = method.getAnnotations();
            for (Annotation annotation : annotations) {
                System.out.println(annotation); //@shangguigu.basic.reflection.huodejiegou.MyAnnotation(value=hello)
            }
            //2. 权限修饰符
            System.out.print(Modifier.toString(method.getModifiers()) + " ");  //public	public volatile	public	private	public

            //3. 返回值类型
            /**
             * int
             * int
             * void
             * class java.lang.String
             * class java.lang.String
             */
            Class<?> returnType = method.getReturnType();
//            System.out.print(returnType + " ");
            /**
             * int
             * int
             * void
             * java.lang.String
             * java.lang.String
             */
            System.out.print(returnType.getName() + " ");

            //4. 方法名
            /**
             * compareTo
             * compareTo
             * info
             * display
             * show
             */
            String name = method.getName();
            System.out.print(name);
            System.out.print("(");
            //5. 形参列表
            Class<?>[] parameterTypes = method.getParameterTypes();
            int i = 0;
            if (parameterTypes != null && parameterTypes.length > 0) {
                for (Class<?> type : parameterTypes) {
                    if (i < parameterTypes.length - 1) {
                        System.out.print(type.getName() + " " + "args_" + i + ", ");
                    } else {
                        System.out.print(type.getName() + " " + "args_" + i);
                    }
                    i++;
                }
            }
            System.out.print(")");

            //6. 抛出的异常
            Class<?>[] exceptionTypes = method.getExceptionTypes();
            if (exceptionTypes != null && exceptionTypes.length > 0) {
                System.out.print(" throws ");
                int j = 0;
                for (Class<?> type : exceptionTypes) {
                    if (j < exceptionTypes.length - 1) {
                        System.out.print(type.getName() + ", ");
                    } else {
                        System.out.println(type.getName());
                    }
                    j++;
                }
            }

            System.out.println();
        }

    }

    /**
     * 构造器
     */
    @Test
    public void test3() {
        Class<Person> personClass = Person.class;
        //getConstructors(): 获取当前运行时类中声明为public的构造器
        Constructor<?>[] constructors = personClass.getConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor);  //public shangguigu.basic.reflection.huodejiegou.Person()
        }

        //getDeclaredConstructors(): 获取当前运行时类中声明的所有的构造器(包括private的)
        Constructor<?>[] declaredConstructors = personClass.getDeclaredConstructors();
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            /**
             * shangguigu.basic.reflection.huodejiegou.Person(java.lang.String,int)
             * private shangguigu.basic.reflection.huodejiegou.Person(java.lang.String)
             * public shangguigu.basic.reflection.huodejiegou.Person()
             */
            System.out.println(declaredConstructor);
        }
    }

}
