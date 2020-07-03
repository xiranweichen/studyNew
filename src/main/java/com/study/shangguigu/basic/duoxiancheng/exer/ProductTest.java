package com.study.shangguigu.basic.duoxiancheng.exer;

/**
 * @description: 一个多线程的经典问题：
 *               生产者Product将产品交给店员(Clerk),而消费者(Consumer)从店员处取走商品，店员一次只能持有固定数量的商品20件，
 *               如果生产者试图生产更多的商品，店员就会让生产者停一下，如果店里有空位了就会通知生产者继续生产；如果店里没有
 *               产品了，店员会告诉消费者等一下，等店中有商品了店员再通知消费者取走商品。
 *               
 *  1. 是否是多线程的问题：是，最少有生产者线程 && 消费者线程 (这里暂时设置两个消费者，一个生产者)
 *  2. 是否有共享数据： 产品
 *  3. 解决线程安全问题：同步机制
 *  4. 涉及到线程通信
 *  
 * @date: 2020/2/13 19:52
 * @author: lizhenhong
 */
public class ProductTest {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        Product product = new Product(clerk);
        product.setName("生产者1");
        Consumer consumer1 = new Consumer(clerk);
        consumer1.setName("消费者1");
        Consumer consumer2 = new Consumer(clerk);
        consumer2.setName("消费者2");
        product.start();
        consumer1.start();
        consumer2.start();
    }
}

//店员类
class Clerk{
    //产品数量，初始定为0
    private int productCount = 0;
    //生产产品
    public synchronized void product() {
        if (productCount < 20) {
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            productCount++;
            System.out.println(Thread.currentThread().getName() + "-开始生产-第" + productCount + "-个产品");
            notify();
        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } 
    }
    //消费产品
    public synchronized void consume() {
        if (productCount > 0) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "-开始消费-第" + productCount + "-个产品");
            productCount--;
            notify();
        } else {
            System.out.println("没有商品了，稍等一下");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } 
    }
}
//生产者类
class Product extends Thread{
    private Clerk clerk;

    public Product(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "：开始生产商品*************");
        while (true) {
            clerk.product();
        }
    }
}
//消费者类
class Consumer extends Thread{
    private Clerk clerk;

    public Consumer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ": 开始消费商品");
        while (true) {
            clerk.consume();
        }
    }
}
