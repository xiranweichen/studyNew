package com.study.shangguigu.basic.collection;

import org.junit.Test;

import java.util.*;

/**
 * @description: Collection接口的常用方法
 * @date: 2020/3/18 20:44
 * @author: lizhenhong
 */
public class CollectionTest {

    @Test
    public void test() {
        Collection coll = new ArrayList();
        //add(Object obj)方法:将元素obj添加到coll中
        coll.add("zhangyunzhu");
        coll.add("AA");
        coll.add(234);  //自动装箱
        coll.add(new Date());
        //size()方法：获取添加到coll中的元素的个数
        System.out.println(coll.size());  //4
        //addAll(Collection coll1)方法：将coll1集合中的元素全部添加到coll中
        Collection coll1 = new ArrayList();
        coll1.add("yunzhu");
        coll1.add(678);
        coll.addAll(coll1);
        System.out.println(coll.size());  //6
        System.out.println("==>coll是：" + coll); //==>coll是：[zhangyunzhu, AA, 234, Wed Mar 18 20:54:25 CST 2020, lo, 678]
        System.out.println("==>coll1是：" + coll1); //==>coll1是：[yunzhu, 678]
        //isEmpty(): 判断集合中是否有元素
        System.out.println(coll.isEmpty());  //false
        //clear(): 清空集合元素
        coll1.clear();
        System.out.println(coll1.isEmpty()); //true
        
    }

    @Test
    public void test2() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add("zhangyunzhu");
        coll.add(new String("JAVA"));
        coll.add(false);
        coll.add(new Person("Tom", 18));
        //contains(Object obj): 判断集合中是否包含obj
        //判断的时候，h会调用obj对象所在类的equals()方法
        boolean contains = coll.contains("zhangyunzhu");
        System.out.println(contains); //true
        System.out.println(coll.contains(new String("JAVA")));//true(这里调的是equals()方法)
        System.out.println(coll.contains(new Person("Tom", 18)));//false(如果想让他也是true，自己需要在Person类里面重写一下equals()// 方法)
        
        //containsAll(Collection coll): 判断coll集合中的元素是否都在当前(被调用的集合中)
        Collection coll1 = Arrays.asList(123, 456);
        Collection coll2 = Arrays.asList(123, "zhangyunzhu");
        System.out.println(coll.containsAll(coll1));  //false
        System.out.println(coll.containsAll(coll2));  //true
        
        //remove(Object obj)
        System.out.println(coll.toString());  //[123, zhangyunzhu, JAVA, false, Person{name='Tom', age=18}]
        coll.remove(123);
        System.out.println(coll.toString());  //[zhangyunzhu, JAVA, false, Person{name='Tom', age=18}]
        
        //removeAll(Collection coll): 将coll从当前集合中全部移除
        coll.removeAll(Arrays.asList(123, "zhangyunzhu"));
        System.out.println(coll.toString());  //[JAVA, false, Person{name='Tom', age=18}]
        
        //retainAll(Collection coll): 求两个集合的交集, 并返回给当前集合
        Collection collection = Arrays.asList(123, 456, "zhangyunzhu","JAVA");
        System.out.println(coll);  //[JAVA, false, Person{name='Tom', age=18}]
        coll.retainAll(collection);
        System.out.println("==>containsAll后的coll：" + coll); //==>containsAll后的coll：[JAVA]
        
        //equals(Object obj): obj和当前集合是否一样（如果是ArrayList<>()，则需要满足顺序也相同，否则返回false）
        
    }

    @Test
    public void test3() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add("zhangyunzhu");
        coll.add(new String("JAVA"));
        coll.add(false);
        coll.add(new Person("Tom", 18));
        //hashCode(): 返回当前对象的hash值(貌似是根据当前对象生成的一个随机数)
        System.out.println(coll.hashCode());  //-2090143225
        //toArray(): 集合-->数组
        Object[] array = coll.toArray();
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "，");  //123，zhangyunzhu，JAVA，false，Person{name='Tom', age=18}，
        }
        System.out.println();
        //数组-->集合：Arrays.asList(T t),
        // 注意：这个方法会把T实别成一个元素，如果形参的为止是基本数据类型的数组，需要将其写成其包装类数组
        List<String> asList = Arrays.asList(new String[]{"AA", "HH", "yun"});
        System.out.println(asList); //[AA, HH, yun]
        
        //iterator()：返回Iterator接口的实例，写在IteratorTest.java中
        
    }
    
}

class Person{
    private String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
