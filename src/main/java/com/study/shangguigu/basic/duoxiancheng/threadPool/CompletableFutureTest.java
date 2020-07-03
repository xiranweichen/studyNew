package com.study.shangguigu.basic.duoxiancheng.threadPool;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Supplier;

/**
 * @description: 通过CompletableFuture接口实现异步调用
 *              所谓异步调用其实就是实现一个可无需等待被调函数的返回值而让操作继续运行的方法。简单的讲就是另启一个线程来完成调用中的部分计算，
 *              使调用继续运行或返回，而不需要等待计算结果。但调用者仍需要取线程的计算结果。
 *              JDK1.5新增了Future接口，用于描述一个异步计算的结果。虽然 Future 以及相关使用方法提供了异步执行任务的能力，但是对于结果的获取却是很不方便，
 *              只能通过阻塞或者轮询的方式得到任务的结果。
 *              JDK1.8后提出了CompletableFuture接口实现了Future和CompletionStage两个接口，CompletionStage可以看做是一个异步任务执行过程的抽象（CompletionStage代表异步计算过程中的某一个阶段，
 *              一个阶段完成以后可能会触发另外一个阶段，一个阶段的计算执行可以是一个Function，Consumer或者Runnable。比如：
 *              stage.thenApply(x -> square(x)).thenAccept(x -> System.out.print(x)).thenRun(() -> System.out.println())）
 *              我们可以基于CompletableFuture创建任务和链式处理多个任务，并实现按照任务完成的先后顺序获取任务的结果。
 *              1）创建任务
 *                   ##使用runAsync方法新建一个线程来运行Runnable对象(无返回值)；
 *                   ##使用supplyAysnc方法新建线程来运行Supplier<T>对象(有返回值)；
 *                   ##基于线程池创建
 *              2）任务的异步处理
 *                   不论Future.get()方法还是CompletableFuture.get()方法都是阻塞的，为了获取任务的结果同时不阻塞当前线程的执行，
 *                        我们可以使用CompletionStage提供的方法结合callback来实现任务的异步处理。
 *                   ##whenComplete：是执行当前任务的线程执行继续执行 whenComplete 的任务。
 *                   ##whenCompleteAsync：把 whenCompleteAsync 这个任务继续提交给线程池来进行执行，也就是并行执行。
 *                   ##thenApply：当一个线程依赖另一个线程时，可以使用 thenApply 方法来把这两个线程串行化
 *                   ##thenAccept：thenAccept接收上一阶段的输出作为本阶段的输入，并消费处理，无返回结果。　
 *                   ##thenRun：不关心前一阶段的计算结果，因为它不需要输入参数，进行消费处理，无返回结果。
 *                   ## thenCombine：会把两个 CompletionStage 的任务都执行完成后，把两个任务的结果一块交给 thenCombine 来处理。
 *                   ## applyToEither ：两个CompletionStage，谁执行返回的结果快，我就用那个CompletionStage的结果进行下一步的转化操作。
 *                   ##acceptEither 方法：两个CompletionStage，谁执行返回的结果快，我就用那个CompletionStage的结果进行下一步的消耗操作
 *                   
 *               在CompletableFuture接口中除了使用whenComplete还可以使用handle等方法能实现按照任务完成的先后顺序获取任务的结果。
 * 
 * @date: 2020/3/31 22:18
 * @author: lizhenhong
 */
public class CompletableFutureTest {
    private static final String commandstr01 = "hahah";
    private static final String commandstr02 = "hahah";
    private static final String commandstr03 = "hahah";
    private static final String commandstr04 = "hahah";

    public static void main(String[] args) throws InterruptedException, ExecutionException{

        ExecutorService executorService = Executors.newCachedThreadPool();

        CompletableFuture.supplyAsync(new MyThreadt444(commandstr02),executorService).whenComplete((result, e) -> {
            //执行线程执行完以后的操作。
            System.out.println(result + " " + e);
        }).exceptionally((e) -> {
            //抛出异常
            System.out.println("exception " + e);
            return "exception";
        });

        CompletableFuture.supplyAsync(new MyThreadt333(commandstr02),executorService).whenComplete((result, e) -> {
            //执行线程执行完以后的操作。
            System.out.println(result + " " + e);
        }).exceptionally((e) -> {
            System.out.println("exception " + e);
            return "exception";
        });
    }
}



class MyThreadt333 implements Supplier<String>{

    private String commandstr;          // 要运行的命令
    public MyThreadt333(String commandstr) {
        this.commandstr = commandstr;
    }
    @Override
    public String get() {
        int sum = 0;
        for (int i = 0; i < 30; i++) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            sum += i;
            System.out.println("Mythread333: "+i);
        }
        return String.valueOf(sum+300000);
    }
}

class MyThreadt444 implements Supplier<String>{

    private String commandstr;          // 要运行的命令
    public MyThreadt444(String commandstr) {
        this.commandstr = commandstr;
    }
    @Override
    public String get() {
        int sum = 0;
        for (int i = 0; i < 40; i++) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            sum += i;
            System.out.println("Mythread444: "+i);
        }
        return String.valueOf(sum+400000);
    }
}