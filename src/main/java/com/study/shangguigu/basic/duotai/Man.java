package com.study.shangguigu.basic.duotai;

/**
 * @author: lizhenhong
 * @description: 子类
 * @date: 2020/1/21 15:22
 */
public class Man extends Person {

    private boolean isTall;

    //下面两个方法是重写person类里面的方法
    public void eat() {
        System.out.println("=======>男人 eat 饭");
    }

    public void walk() {
        System.out.println("=======>男人  walk 路");
    }

    //man类中特有的
    public void earnMoney() {
        System.out.println("====> man earn money");
    }

    

}
