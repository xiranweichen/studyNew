package com.study.meite.xianchengtongxun;

import org.junit.Test;

/**
 * @author lizhenhong
 * @Description: 线程通信
 * 生产者生产票，消费者买票。
 * 规则：生产者生产一个，告诉消费者买一个，然后生产者再生产一个。。。。。。
 * @date 2020/6/26 13:32
 */
public class Tonxun {

    /**
     * 这个单元测试结果有问题
     */
    @Test
    public void testTongxun() {
        Ticket ticket = new Ticket();
        Product product = new Product(ticket);
        Consumer consumer = new Consumer(ticket);
        product.start();
        consumer.start();
    }

    /**
     * 下面这个main方法是靠谱的
     * @param args
     */
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        Product product = new Product(ticket);
        Consumer consumer = new Consumer(ticket);
        product.start();
        consumer.start();
    }

}

class Ticket {
    //票张数
    private int ticketCount;

    public Ticket() {
    }

    public int getTicketCount() {
        return ticketCount;
    }

    public void setTicketCount(int ticketCount) {
        this.ticketCount = ticketCount;
    }
}

/**
 * 生产者
 */
class Product extends Thread {

    private Ticket ticket;

    public Product(Ticket ticket) {
        this.ticket = ticket;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (ticket) {
                //如果有票则进入线程等待，并唤醒消费者线程
                if (ticket.getTicketCount() > 0) {
                    try {
                        ticket.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //如果tickCount=0，则生产
                if (ticket.getTicketCount() == 0) {
                    ticket.setTicketCount(ticket.getTicketCount() + 1);
                    System.out.println("=======>生产者生产票完成");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                ticket.notify();
            }
        }
    }
}

/**
 * 消费者
 */
class Consumer extends Thread {
    private Ticket ticket;

    public Consumer(Ticket ticket) {
        this.ticket = ticket;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (ticket) {
                if (ticket.getTicketCount() == 0) {
                    try {
                        ticket.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (ticket.getTicketCount() > 0) {
                    ticket.setTicketCount(ticket.getTicketCount() - 1);
                    System.out.println("======>消费者消费一张票");
                }

                ticket.notify();
            }
        }
    }
}


