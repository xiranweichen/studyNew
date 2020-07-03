package com.study.shangguigu.basic.reflection;

import java.io.Serializable;

/**
 * @description:
 * @date: 2020/5/11 19:25
 * @author: lizhenhong
 */
public class Creature<T> implements Serializable {

    private char gender;
    private double weight;

    private void breath() {
        System.out.println("生物呼吸");
    }

    public void eat() {
        System.out.println("吃饭乃人生第一大事");
    }

}
