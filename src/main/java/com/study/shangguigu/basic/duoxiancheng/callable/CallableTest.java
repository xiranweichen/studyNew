package com.study.shangguigu.basic.duoxiancheng.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @description: 以实现Callable接口的方式创建多线程
 * @date: 2020/2/15 15:24
 * @author: lizhenhong
 */
public class CallableTest {
    public static void main(String[] args) {
        //3. 创建实现Callable接口的实现类的对象
        Number num = new Number();
        //4. 将此Callable的实现类的对象作为参数传入FutureTask的构造器中，创建FutureTask对象
        FutureTask futureTask = new FutureTask(num);
        //5. 将此FutureTask对象作为参数传入Thread构造器中创建Thread对象，并调用start()启动线程
        new Thread(futureTask).start();
        try {
            //6. 获取Callable中的call()方法的返回值
            //调用FutureTask的get()方法，回调Number中的call()方法，相当于调的Number中的call方法，用一个Object接收返回值
            Object sum = futureTask.get();
            System.out.println("1-100之内的偶数的和是：" + sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
//1. 创建一个实现Callable接口的实现类
class Number implements Callable{

    //实现call()方法，将此线程要做的操作声明在call()方法中（可以有返回值）
    @Override
    public Object call() throws Exception {
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            if (i%2==0) {
                sum += i;
            }
        }
        return sum;
    }
}
