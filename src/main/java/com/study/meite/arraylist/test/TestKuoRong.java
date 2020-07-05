package com.study.meite.arraylist.test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lizhenhong
 * @Description: 数组扩容
 * @date 2020/7/4 12:24
 */
public class TestKuoRong {

    @Test
    public void testCopyOf() {
        Object[] objects = {1, 2};
        System.out.println(objects.length);
        //返回新数组，10表示扩充后的长度，原来本身的数据不变
        Object[] copy = Arrays.copyOf(objects, 10);
        System.out.println(copy.length);  //10
        System.out.print("数组中的元素: ");
        for (Object o : copy) {
            System.out.print(o+" ,");  //数组中的元素: 1 ,2 ,null ,null ,null ,null ,null ,null ,null ,null ,
        }

    }

    /**
     * arraycopy(Object src,  int  srcPos, Object dest, int destPos, int length)
     *          src:源数组；
     *          srcPos:源数组要复制的起始位置
     *          dest:目的数组
     *          destPos:目的数组放置的起始位置
     *          length:复制的长度
     *          注意：src and dest都必须是同类型或者可以进行转换类型的数组
     */
    @Test
    public void testArraycopy(){
        int[] fun ={0,1,2,3,4,5,6};
        System.arraycopy(fun,0,fun,3,3);
        System.out.print("复制后的数组: ");
        for (int i : fun) {
            System.out.print(i + ", "); //复制后的数组: 0, 1, 2, 0, 1, 2, 6,
        }
    }

}
