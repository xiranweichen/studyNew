package com.study.shangguigu.basic.duoxiancheng.exer;

/**
 * @description: 两个储户分别向同一账户存3000元，每次存1000，存3次，每次存完打印账户余额
 *              1. 是多线程问题，两个储户线程
 *              2. 是否有共享数据？有，是账户余额
 *              3. 要考虑线程安全问题
 * @date: 2020/2/9 10:11
 * @author: lizhenhong
 */
public class AccountTest {
    public static void main(String[] args) {
        Account account = new Account(0);  //最初账户余额为0
        Customer cus1 = new Customer(account);
        Customer cus2 = new Customer(account);
        cus1.setName("甲");
        cus2.setName("乙");
        cus1.start();
        cus2.start();
    }
}

class Account{

    public Account(double balance) {
        this.balance = balance;
    }

    private double balance;

    //存钱的方法
    public synchronized void saveMoney(double amnt) {
        balance += amnt;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + ":存钱成功，余额为" + balance + "元");
    }
    
}

class Customer extends Thread{
    private Account acct;

    public Customer(Account acct) {
        this.acct = acct;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            acct.saveMoney(1000);
        }
    }
}
