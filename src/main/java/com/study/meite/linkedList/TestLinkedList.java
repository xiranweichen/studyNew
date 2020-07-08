package com.study.meite.linkedList;

import com.study.shangguigu.basic.duotai.Person;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @description:
 * @date: 2020/7/6 14:05
 * @author: lizhenhong
 */
public class TestLinkedList {
    @Test
    public void test1() {
        List<Person> personList = new LinkedList<>();
        personList.add(new Person("lizhenhong", 26));
        personList.add(new Person("zhangyunzhu", 18));
        System.out.println(personList.toString());
    }
}
