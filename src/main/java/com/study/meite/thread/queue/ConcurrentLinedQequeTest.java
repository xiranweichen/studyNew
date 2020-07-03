package com.study.meite.thread.queue;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author lizhenhong
 * @Description:
 * @date 2020/6/26 15:14
 */
public class ConcurrentLinedQequeTest {

    public static void main(String[] args) {
        //非阻塞式队列，无界队列
        ConcurrentLinkedQueue<String> linkedDeque = new ConcurrentLinkedQueue<>();
        //添加队列
        linkedDeque.add("zhangyunzhu");
        linkedDeque.add("lizhenhong");
        linkedDeque.add("hahaha");
        //获取队列信息（这个只能获取一个队列元素,不删除队列元素）
        System.out.println("===>队列信息：" + linkedDeque.peek());//===>队列信息：zhangyunzhu
        //获取队列个数
        System.out.println("===>队列个数：" + linkedDeque.size());
        //获取队列信息（这个只能获取一个队列元素，删除队列元素）
        System.out.println("===>队列信息1：" + linkedDeque.poll());//===>队列信息1：zhangyunzhu
        System.out.println("===>队列信息2：" + linkedDeque.poll());//===>队列信息2：lizhenhong
        System.out.println("===>队列信息3：" + linkedDeque.poll());//===>队列信息3：hahaha
        System.out.println("===>队列信息4：" + linkedDeque.poll());//===>队列信息4：null
        System.out.println("===>队列个数：" + linkedDeque.size()); //===>队列个数：0    (体现了FIFO)
    }

}
