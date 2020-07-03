package com.study.shangguigu.basic.abstractTest;

/**
 * @author: lizhenhong
 * @description: abstract的测试
 * @date: 2020/2/2 16:28
 */
public class AbstractTest {

    public static void main(String[] args) {
        Manager manager = new Manager( "lizhenhong",888, 19, 999);
        manager.work();
        CommonEmployee commonEmployee = new CommonEmployee();
        commonEmployee.work();
    }

}
