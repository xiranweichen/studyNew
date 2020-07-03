package com.study.shangguigu.basic.reflection;

import org.junit.Test;

/**
 * @author lizhenhong
 * @Description: 了解类的加载器
 * @date 2020/5/7 20:54
 */
public class ClassLoaderTest {

    @Test
    public void test() {

        //对于自定义类，是使用系统类加载器进行加载
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        System.out.println(classLoader);  //sun.misc.Launcher$AppClassLoader@18b4aac2

        //调用系统类加载器的getParent()方法，可以获取扩展类加载器
        ClassLoader loaderParent = classLoader.getParent();
        System.out.println(loaderParent);  //sun.misc.Launcher$ExtClassLoader@a09ee92
        //调用扩展类加载器的getParent()方法，是不能获取引导类加载器的，
        // 引导类加载器主要加载Java核心类库，是无法加载自定义类的
        ClassLoader classLoader1 = loaderParent.getParent();
        System.out.println(classLoader1);  //null
    }

}
