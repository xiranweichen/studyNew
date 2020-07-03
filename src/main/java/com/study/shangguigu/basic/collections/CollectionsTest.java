package com.study.shangguigu.basic.collections;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @description: Collections工具类的常用方法
 * @date: 2020/4/4 18:25
 * @author: lizhenhong
 */
public class CollectionsTest {

    @Test
    public void test1() {
        List<Integer> list = new ArrayList<>();
        list.add(12);
        list.add(23);
        list.add(12);
        list.add(5435);
        list.add(-33);
        list.add(0);
        System.out.println(list);  //[12, 23, 12, 5435, -33, 0]
        //reverse(List list): 将list中的元素反转
        Collections.reverse(list);
        System.out.println(list);  //[0, -33, 5435, 12, 23, 12]
        
        //shuffle(List list): 将list进行随机排序
        Collections.shuffle(list);
        System.out.println(list);  //[5435, 23, 0, -33, 12, 12]  (这个的话每次输出结果是不同的)
        
        //sort(List list): 将list中的元素进行升序排序（从小到大）
        Collections.sort(list);
        System.out.println(list);  //[-33, 0, 12, 12, 23, 5435]
        
        //swap(List list, int index1, int index2): 将list的index1和index2位置的元素进行交换
        Collections.swap(list, 1, 2);
        System.out.println(list);  //[-33, 12, 0, 12, 23, 5435]
        
        //int frequency(Collection coll, Object obj): coll集合中obj出现的频率
        int frequency = Collections.frequency(list, 12);
        System.out.println(frequency); //2
    }

    @Test
    public void test2() {
        List<Integer> list = new ArrayList<>();
        list.add(12);
        list.add(23);
        list.add(12);
        list.add(5435);
        list.add(-33);
        list.add(0);
        
        //copy(List dest, List src): 将src中的元素赋值到dest中
        List<Integer> dest = Arrays.asList(new Integer[list.size()]);
        System.out.println(dest.size());  //6
        Collections.copy(dest, list);
        System.out.println(dest);  //[12, 23, 12, 5435, -33, 0]

        //synchronizedXXX(XXX): 将list，map等转换成线程安全的
        List<Integer> integerList = Collections.synchronizedList(list);
        
    }
    
}
