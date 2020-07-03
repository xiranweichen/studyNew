package com.study.shangguigu.basic.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: Collection的子接口之List接口
 * @date: 2020/3/28 16:05
 * @author: lizhenhong
 */
public class ListTest {
    
    @Test
    public void test1(){
        ArrayList list = new ArrayList();
        list.add(123);
        list.add("zhangyunzhu");
        list.add(12);
        list.add(new Person("Tom", 11));
        list.add(false);
        System.out.println(list);  //[123, zhangyunzhu, 12, Person{name='Tom', age=11}, false]
        
        //void add(int index, Object obj) : 在index位置插入obj元素
        list.add(1, 3333);
        System.out.println(list);  //[123, 3333, zhangyunzhu, 12, Person{name='Tom', age=11}, false]
        
        //boolean addAll(int index, Collection coll) : 在index位置开始将coll中的所有元素添加到list中去
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5);
        list.addAll(1, list1);
        System.out.println(list);  //[123, 1, 2, 3, 4, 5, 3333, zhangyunzhu, 12, Person{name='Tom', age=11}, false]
        System.out.println(list.size());  // 11
    }
    
    @Test
    public void test2(){
        ArrayList list = new ArrayList();
        list.add(123);
        list.add("zhangyunzhu");
        list.add(12);
        list.add(new Person("Tom", 11));
        list.add(false);
        System.out.println(list);  //[123, zhangyunzhu, 12, Person{name='Tom', age=11}, false]
        
        //int indexOf(Object obj) :  返回obj元素在当前集合中首次出现的index位置(没有返回-1) 
        int index = list.indexOf("zhangyunzhu");
        System.out.println(index);  //1
        int index1 = list.indexOf(1111);
        System.out.println(index1); //-1
        
        //int lastIndexOf(Object obj): 返回obj元素在当前集合中最后一次出现的index位置(没有返回-1)
        int zhangyunzhu = list.lastIndexOf("zhangyunzhu");
        System.out.println(zhangyunzhu); //1
        
        //Object remove(int index): 移除指定index位置的元素，并返回此元素
        Object remove = list.remove(0);
        System.out.println(remove);  //123
        System.out.println(list);  //[zhangyunzhu, 12, Person{name='Tom', age=11}, false]
        
        //Object set(int index, Object obj): 设置index位置的元素为obj，并返回设置之前的元素
        Object shezhi = list.set(1, "shezhi");
        System.out.println(shezhi);  //12
        System.out.println(list);  //[zhangyunzhu, shezhi, Person{name='Tom', age=11}, false]
        
        //List subList(int fromIndex, int toIndex): 返回从fromIndex到toIndex位置左闭右开区间的子集合
        List subList = list.subList(0, 2);
        System.out.println(subList); //[zhangyunzhu, shezhi]
        System.out.println(list); //[zhangyunzhu, shezhi, Person{name='Tom', age=11}, false]

    }
    
    
}
