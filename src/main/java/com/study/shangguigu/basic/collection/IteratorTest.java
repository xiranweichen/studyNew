package com.study.shangguigu.basic.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * @description: 使用Iterator迭代器进行集合元素的遍历
 *              应用迭代器中的hasNext()方法和next()方法
 * @date: 2020/3/22 16:30
 * @author: lizhenhong
 */
public class IteratorTest {

    //常规遍历
    @Test
    public void test() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("zhangyunzhu",18));
        coll.add(new String("zhangyunzhu"));
        coll.add(false);
        Iterator iterator = coll.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next()+", ");//123, 456, Person{name='zhangyunzhu', age=18}, zhangyunzhu, false,
        }
        System.out.println();
    }

    //常见的错误写法
    @Test
    public void test1() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("zhangyunzhu",18));
        coll.add(new String("zhangyunzhu"));
        coll.add(false);
        Iterator iterator = coll.iterator();
        //错误写法一，跳跃输出，并且报错java.util.NoSuchElementException
//        while (iterator.next() != null) {
//            System.out.println(iterator.next());
//        }
        
        //错误写法二：会导致无限循环输出第一个元素，
//        while (coll.iterator().hasNext()) {
//            System.out.println(coll.iterator().next());
//        }
    }

    //remove()移除
    @Test
    public void test2() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("zhangyunzhu",18));
        coll.add(new String("zhangyunzhu"));
        coll.add(false);
        Iterator iterator = coll.iterator();
        System.out.println("移除前的coll：" + coll.toString());//移除前的coll：[123, 456, Person{name='zhangyunzhu', age=18}, zhangyunzhu, false]
        while (iterator.hasNext()) {
            Object o = iterator.next();
            if ("zhangyunzhu".equals(o)) {
                iterator.remove();
            }
        }
        //这里必须重新声明一个，因为上面的那个iterator的指针已经到了最后了
        Iterator iterator1 = coll.iterator();
        System.out.println("移除后的coll:");
        while (iterator1.hasNext()) {
            System.out.print(iterator1.next() + ", ");  //123, 456, Person{name='zhangyunzhu', age=18}, false, 
        }
        System.out.println();
    }
    
}
