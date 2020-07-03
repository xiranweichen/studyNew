package com.study.shangguigu.basic.abstractTest;

/**
 * @author: lizhenhong
 * @description: 普通员工
 * @date: 2020/2/2 16:24
 */
public class CommonEmployee extends Employee {
    @Override
    public void work() {
        System.out.println("这里是普通员工类");
    }
}
