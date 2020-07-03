package com.study.shangguigu.basic.proxy;

/**
 * @description: 明星和经纪人的关系的代理类
 * @date: 2020/2/3 15:51
 * @author: lizhenhong
 */
public class ProxyTestForStar {
    public static void main(String[] args) {
        RealStar realStar = new RealStar();
        Proxy proxy = new Proxy(realStar);
        proxy.confer();
        proxy.singContract();
        proxy.sing();
        proxy.collectMoney();
    }
}

//声明一个接口，定义方法
interface Star{
    //面谈业务
    void confer();
    //签合同
    void singContract();
    //唱歌
    void sing();
    //收钱
    void collectMoney();
}
//明星
class RealStar implements Star{
    //面谈业务,是代理人帮忙完成
    @Override
    public void confer() {
    }
    //签合同，是代理人帮忙完成
    @Override
    public void singContract() {
    }
    //唱歌，明星自己完成
    @Override
    public void sing() {
        System.out.println("起来，不愿做奴隶的人们！");
    }
    //收钱，代理人帮忙完成
    @Override
    public void collectMoney() {
    }
}

//代理人
class Proxy implements Star{
    private Star realStar;
    //通过构造器对属性进行初始化
    public Proxy(Star realStar) {
        this.realStar = realStar;
    }

    @Override
    public void confer() {
        System.out.println("这里是经纪人-面谈业务");
    }

    @Override
    public void singContract() {
        System.out.println("这里是经纪人-签合同");
    }

    @Override
    public void sing() {
        //这里调用的是明星的sing()方法
        realStar.sing();   
    }

    @Override
    public void collectMoney() {
        System.out.println("这里是经纪人-收钱");
    }
}


