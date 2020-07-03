package com.study.shangguigu.basic.recursion;

/**
 * @author: lizhenhong
 * @description: 递归方法的使用
 * @date: 2020/1/4 15:51
 */
public class RecursionDemo {

    /**
     * 计算1-100的和
     */
    public static void main(String[] args) {
        //1. 用for循环
        int sunFor = 0;
        for (int i = 0; i <= 100; i++) {
            sunFor += i;
        }
        System.out.println("=======>用for循环输出1-100的和：" + sunFor);
        //2. 用递归
        int sum = getSum(100);
        System.out.println("=======>用递归输出1-100的和：" + sum);
        //3. 用递归计算1到100的乘积
        double chengJi = getChengJi(100);
        System.out.println("=======>用递归输出1-100的乘积：" + chengJi);
    }

    //用递归计算前n个数 的和，
    public static int getSum(int i) {
        //如果接到的参数是1，则返回1，否则返回
        if (i == 1) {
            return 1;
        } else {
            return i + getSum(i - 1);
        }
    }

    //用递归计算1到100的乘积
    public static double getChengJi(int i) {
        if (i == 1) {
            System.out.println("---------");
            return 1;
        } else {
            double j = i * getChengJi(i - 1);
            System.out.println(j);
            return j;
        }
    }

}
