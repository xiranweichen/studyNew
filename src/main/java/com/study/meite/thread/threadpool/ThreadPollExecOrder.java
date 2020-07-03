package com.study.meite.thread.threadpool;

import com.study.shangguigu.basic.duotai.Person;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

/**
 * @description: 测试一下自定义线程池中核心线程、最大线程、阻塞队列中的线程的执行顺序
 *               经过多次测试：线程池的执行顺序为：核心线程数种的线程-->借来的线程-->阻塞队列种的线程
 * @date: 2020/7/1 13:44
 * @author: lizhenhong
 */
public class ThreadPollExecOrder {

    @Test
    public void test() throws InterruptedException {

        ThreadPoolExecutor executor = creatExecutor();
        List<Future<List<Person>>> futures = executor.invokeAll(getThreadList());
        executor.shutdown();
    }

    private List<Callable<List<Person>>> getThreadList() {
        List<Callable<List<Person>>> threadList = new ArrayList<>();
        Callable<List<Person>> thread1 = new Person1();
        Callable<List<Person>> thread2 = new Person2();
        Callable<List<Person>> thread3 = new Person3();
        Callable<List<Person>> thread4 = new Person4();
        Callable<List<Person>> thread5 = new Person5();
        Callable<List<Person>> thread6 = new Person6();
        threadList.addAll(Arrays.asList(thread1, thread2, thread3, thread4, thread5, thread6));
        return threadList;
    }

    /**
     * 创建线程池
     * @return: ThreadPoolExecutor
     */
    private ThreadPoolExecutor creatExecutor() {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(3,
                6,
                0L,
                TimeUnit.MILLISECONDS,
                new LinkedBlockingDeque<>(4),
                new ThreadPoolExecutor.AbortPolicy());
        return executor;
    }
    
}

class Person1 implements Callable<List<Person>> {

    @Override
    public List<Person> call() throws Exception {
        Thread.sleep(2000);
        System.out.println(Thread.currentThread().getName() + "=====>线程一-PersonList线程开始执行");
        List<Person> personList = new ArrayList<>();
        Person p1 = new Person();
        p1.setAge(1);
        personList.add(p1);
        return personList;
    }
}

class Person2 implements Callable<List<Person>> {

    @Override
    public List<Person> call() throws Exception {
        Thread.sleep(2000);
        System.out.println(Thread.currentThread().getName() + "=====>线程二-PersonList线程开始执行");
        List<Person> personList = new ArrayList<>();
        Person p1 = new Person();
        p1.setAge(1);
        personList.add(p1);
        return personList;
    }

}

class Person3 implements Callable<List<Person>>{

    @Override
    public List<Person> call() throws Exception {
        Thread.sleep(2000);
        System.out.println(Thread.currentThread().getName() + "=====>线程三-PersonList线程开始执行");
        List<Person> personList = new ArrayList<>();
        Person p1 = new Person();
        p1.setAge(1);
        personList.add(p1);
        return personList;
    }
}

class Person4 implements Callable<List<Person>>{

    @Override
    public List<Person> call() throws Exception {
        Thread.sleep(2000);
        System.out.println(Thread.currentThread().getName() + "=====>线程四-PersonList线程开始执行");
        List<Person> personList = new ArrayList<>();
        Person p1 = new Person();
        p1.setAge(1);
        personList.add(p1);
        return personList;
    }
}

class Person5 implements Callable<List<Person>>{

    @Override
    public List<Person> call() throws Exception {
        Thread.sleep(2000);
        System.out.println(Thread.currentThread().getName() + "=====>线程五-PersonList线程开始执行");
        List<Person> personList = new ArrayList<>();
        Person p1 = new Person();
        p1.setAge(1);
        personList.add(p1);
        return personList;
    }
}

class Person6 implements Callable<List<Person>>{

    @Override
    public List<Person> call() throws Exception {
        Thread.sleep(2000);
        System.out.println(Thread.currentThread().getName() + "=====>线程六-PersonList线程开始执行");
        List<Person> personList = new ArrayList<>();
        Person p1 = new Person();
        p1.setAge(1);
        personList.add(p1);
        return personList;
    }
}