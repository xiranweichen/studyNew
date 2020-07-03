package com.study.shangguigu.basic.duoxiancheng.threadPool;

import java.util.concurrent.*;

/**
 * @description: 实现按照任务完成的先后顺序获取任务的结果
 *              CompletionService方法可以通过completionService.take().get()方法获取最快完成的线程的返回结果
 *              （若当前没有线程执行完成则阻塞直到最快的线程执行结束），第二次调用则返回第二快完成的线程的返回结果。)
 * @date: 2020/3/31 22:15
 * @author: lizhenhong
 */
public class CompletionServiceTest {
        private static final String commandstr01 = "1111";
        private static final String commandstr02 = "2222";

        public static void main(String[] args) throws InterruptedException, ExecutionException {
            //1、创建一个线程池
            ExecutorService executorService = Executors.newCachedThreadPool();

            CompletionService<String> completionService = new ExecutorCompletionService<String>(executorService);

            completionService.submit(new MyThreadt33(commandstr01));
            completionService.submit(new MyThreadt44(commandstr01));

            executorService.shutdown();

            System.out.println(completionService.take().get());
            System.out.println(completionService.take().get());
        }
    }

    class MyThreadt33 implements Callable<String>{
        private String commandstr;          // 要运行的mingling
        public MyThreadt33(String commandstr) {
            this.commandstr = commandstr;
        }
        @Override
        public String call() throws Exception {
            int sum = 0;
            for (int i = 0; i < 100; i++) {
                Thread.sleep(200);
                sum += i;
                System.out.println("Mythread3: "+i);
            }
            return String.valueOf(sum+300000);
        }
    }

    class MyThreadt44 implements Callable<String>{
        private String commandstr;          // 要运行的mingling
        public MyThreadt44(String commandstr) {
            this.commandstr = commandstr;
        }
        @Override
        public String call() throws Exception {
            int sum = 0;
            for (int i = 0; i < 50; i++) {
                Thread.sleep(200);
                sum += i;
                System.out.println("Mythread4: "+i);
            }
            return String.valueOf(sum+400000);
        }
}
