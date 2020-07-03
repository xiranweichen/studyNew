package com.study.meite.thread.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author lizhenhong
 * @Description: 阻塞式队列 BlockingQueue
 * @date 2020/6/26 15:30
 */
public class BlockingQueueTest {

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> queue = new ArrayBlockingQueue<>(3);
        queue.offer("zhangyunzhu");  //添加非阻塞式队列
        boolean lizhenhong = queue.offer("lizhenhong", 3, TimeUnit.SECONDS); //添加阻塞式队列
        System.out.println("第二个队列元素添加结果：" + lizhenhong); //第二个队列元素添加结果：true
        queue.offer("zhangyunzhu");
        boolean zhangyunzhu = queue.offer("zhangyunzhu", 3, TimeUnit.SECONDS);
        System.out.println("第四个队列元素添加结果：" + zhangyunzhu); //第四个队列元素添加结果：false
        System.out.println("第一个队列元素是：" + queue.poll()); //第一个队列元素是：zhangyunzhu
        //下面这里不会等待3s
        System.out.println("第二个队列元素是："+queue.poll(3, TimeUnit.SECONDS)); //第二个队列元素是：lizhenhong
        System.out.println("第三个队列元素是：" + queue.poll(3, TimeUnit.SECONDS)); //第三个队列元素是：zhangyunzhu
        //下面这个会等待3s，因为等待了三秒，队列中仍是满的，而且队列的大小就是3，没有第四个元素
        System.out.println("第四个队列元素是：" + queue.poll(3, TimeUnit.SECONDS)); //第四个队列元素是：null

    }

}
