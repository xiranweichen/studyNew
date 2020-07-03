package com.study.shangguigu.basic.duotai;

/**
 * @author: lizhenhong
 * @description:
 * @date: 2020/1/21 20:47
 */
public class Woman extends Person {

    private boolean isBeauty;

    //重写父类
    public void eat() {
        System.out.println("=======>少 eat 饭 减肥");
    }

    public void walk() {
        System.out.println("=======> 窈窕的 walk 路");
    }

    //特有的方法
    public void goShopping() {
        System.out.println("=====> 女人喜欢逛商场");
    }



}
