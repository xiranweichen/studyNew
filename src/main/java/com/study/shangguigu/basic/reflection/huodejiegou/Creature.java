package com.study.shangguigu.basic.reflection.huodejiegou;

import java.io.Serializable;

/**
 * @author lizhenhong
 * @Description: 造一个Person1的父类
 * @date 2020/5/16 14:54
 */
public class Creature<T> implements Serializable {

    private char gender;
    public double wight;

    private void breath() {
        System.out.println("animals all have to breath to stay alive");
    }

    public void eat() {
        System.out.println("大家都需要吃东西");
    }

}
