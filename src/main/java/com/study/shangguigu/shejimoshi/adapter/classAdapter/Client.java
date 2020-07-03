package com.study.shangguigu.shejimoshi.adapter.classAdapter;

import org.junit.Test;

/**
 * @author lizhenhong
 * @Description:
 * @date 2020/6/21 16:00
 */
public class Client {

    @Test
    public void test() {
        System.out.println("类适配器模式");
        Phone phone = new Phone();
        phone.chaming(new VoltageAdapter());

    }

}
