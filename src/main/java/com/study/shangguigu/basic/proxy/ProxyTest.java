package com.study.shangguigu.basic.proxy;

/**
 * @description: 代理模式
 * @date: 2020/2/3 13:31
 * @author: lizhenhong
 */
public class ProxyTest {
    public static void main(String[] args) {
        Server server = new Server();     //new一个被代理类的对象
        ProxyServer proxyServer = new ProxyServer(server); //初始化代理类，并将被代理类对象放进去
        proxyServer.brose();    //调用代理类的方法完成被代理类的操作
    }
}
interface NetWork{
    public void brose();   //浏览，联网操作方法
}

//被代理类(相当于明星)
class Server implements NetWork{

    @Override
    public void brose() {
        //真正的此操作
        System.out.println("========>访问网络真是的服务器");
    }
}

//代理类(除了实现接口中的方法之外还有其自己的方法，相当于经纪人)
class ProxyServer implements NetWork{

    private NetWork work;

    public ProxyServer(NetWork work) {
        this.work = work;
    }
    
    public void check() {
        System.out.println("============>这里是联网之前的检查工作");
    }
    @Override
    public void brose() {
        check();
        work.brose();
    }
}
