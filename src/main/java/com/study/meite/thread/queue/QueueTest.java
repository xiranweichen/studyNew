package com.study.meite.thread.queue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author lizhenhong
 * @Description: 使用阻塞式队列-LinkedBlockingQueue实现线程通信
 * @date 2020/6/26 16:04
 */
public class QueueTest {

    public static void main(String[] args) throws InterruptedException {

        LinkedBlockingQueue queue = new LinkedBlockingQueue(10);
        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);
        Thread p = new Thread(producer);
        Thread c = new Thread(consumer);
        p.start();
        c.start();
        //等待生产者生产10s，然后生产者退出调
        Thread.sleep(1000*20);
        producer.stop();
    }

}

//生产者线程(添加队列)
class Producer implements Runnable{
    private BlockingQueue<String> queue;
    private volatile boolean FLAG = true;
    //并发包里面的类，保证计数时的线程安全
    AtomicInteger atomicInteger = new AtomicInteger();

    public Producer(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        System.out.println("生产者线程开始启动");
        try {
            while (FLAG) {
                String data = String.valueOf(atomicInteger.incrementAndGet());
                try {
                    boolean offer = queue.offer(data, 2, TimeUnit.SECONDS);
                    if (offer) {
                        System.out.println("生产者存入队列成功，data=" + data);
                    } else {
                        System.out.println("生产者存入队列失败，data=" + data);
                    }
                    //考虑到一直生产的话，程序执行太快，让每次执行完线程休眠1秒
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("生产者生产队列结束");
        }
    }

    public void stop() {
        this.FLAG = false;
    }
}

//队列的消费者
class Consumer implements Runnable{
    private BlockingQueue<String> queue;
    private boolean FLAG = true;

    public Consumer(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        System.out.println("消费者线程启动");
        try {
            while (FLAG) {
                //当等待两秒时消费者仍然没有拿到队列信息，则flag=false，退出
                String poll = queue.poll(2, TimeUnit.SECONDS);
                if (poll == null) {
                    System.out.println("超过两秒钟没有获取到队列信息");
                    FLAG = false;
                    break;
                }
                System.out.println("消费者获取到队列信息，data = " + poll);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            System.out.println("消费者已经停止消费队列");
        }
    }
}