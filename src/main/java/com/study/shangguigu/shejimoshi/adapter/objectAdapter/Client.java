package com.study.shangguigu.shejimoshi.adapter.objectAdapter;

import org.junit.Test;

/**
 * @author lizhenhong
 * @Description:
 * @date 2020/6/21 16:00
 */
public class Client {

    @Test
    public void test() {
        Phone phone = new Phone();
        phone.chaming(new VoltageAdapter(new Voltage220V()));

    }

}
