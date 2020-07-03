package com.study.tencent.jvm;


import com.study.shangguigu.basic.duotai.Person;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lizhenhong
 * @Description: jvm的ath类
 * @date 2020/5/24 14:58
 */
public class Math {

    public static void main(String[] args) throws InterruptedException {
        Person person = new Person();
        List<Person> personList = new ArrayList<>();
        int i = 0;
        while (true) {
            Thread.sleep(1000);
            personList.add(person);
            i++;
            System.out.println("第" + i + "个person装配成功");
        }
    }

}
