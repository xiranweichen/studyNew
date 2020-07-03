package com.study.shangguigu.basic.collection;

import org.junit.Test;

import java.util.*;

/**
 * @description: 
 * @date: 2020/3/28 19:16
 * @author: lizhenhong
 */
public class SetTest {
    
    @Test
    public void test1(){

        Set set = new HashSet();
        set.add(123);
        set.add("ABC");
        set.add("zhangyunzhu");
        set.add(new Person("zhangyunzhu", 18));
        set.add(false);
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            //输出的顺序和添加的可能不同，但是每次输出的是相同的
            System.out.print(iterator.next()+",");  //ABC,zhangyunzhu,Person{name='zhangyunzhu', age=18},false,123,
        }
        System.out.println();
    }

}
