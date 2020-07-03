package com.study.shangguigu.basic.usualClass.string;

/**
 * @description: String
 * @date: 2020/2/16 9:05
 * @author: lizhenhong
 */
public class StringTest {
//    @Test
//    public void test1() {
//        String s1 = "abc";   //字面量的定义方式（有点类似于基本数据类型，不用new直接赋值）
//        String s2 = "def";
//        s1 = "hello";
//        System.out.println(s1 == s2);  //false
//    }

    public static void main(String[] args) {
        String s1 = "abc";   //字面量的定义方式（有点类似于基本数据类型，不用new直接赋值）
        String s2 = "def";
        s1 = "hello";
        System.out.println("判断地址值是否相等: " + (s1 == s2));  //判断地址值是否相等，输出结果是false,如果将上一行注释调，结果是true
        System.out.println("=====================");

        String s3 = "abc";
        s3 += "def";
        System.out.println("s3 += def 后的s3 是：" + s3);
        System.out.println("================");   //abcdef

        String s4 = "abc";
        String s5 = s4.replace('a', 'm');  //将s4中的a替换为m
        System.out.println("s4是：" + s4);   //abc
        System.out.println("s5是：" + s5);   //mbc
        
        

    }
}
