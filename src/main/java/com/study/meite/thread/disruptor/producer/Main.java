package com.study.meite.thread.disruptor.producer;

import com.lmax.disruptor.EventFactory;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.YieldingWaitStrategy;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;
import meite.thread.disruptor.consumer.LongEventHandler;
import meite.thread.disruptor.consumer.LongEventHandler2;
import meite.thread.disruptor.entity.LongEvent;
import meite.thread.disruptor.factory.LongEventFactory;
 
import java.nio.ByteBuffer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * disruptor框架在"美团点评技术团队"里面有比较详细的介绍，网址：https://tech.meituan.com/2016/11/18/disruptor.html
 * @description: 创建disruptor过程
 * @date: 2020/7/1 19:15
 * @author: lizhenhong
 */
public class Main {

    public static void main(String[] args) {
        //1. 创建一个可缓存的线程池，发送给consumer处理
        ExecutorService executor = Executors.newCachedThreadPool();
        //2. 创建工厂
        EventFactory factory = new LongEventFactory();
        //3. 创建ringbuffer，大小一定要是2的n次方
        int ringbuffer = 1024 * 1024;  //这里一定要是2的n次方
        //4. 创建disruptor
        Disruptor<LongEvent> disruptor = new Disruptor<LongEvent>(factory,
                ringbuffer,
                executor,
                ProducerType.MULTI,
                new YieldingWaitStrategy()
        );
        //5. 连接消费者(注册消费者)
        //多个消费者、一个生产者，会重复消费event；如果想要消费均摊，需要配置分组
        disruptor.handleEventsWith(new LongEventHandler());   //往哪个handler投递信息
//        disruptor.handleEventsWith(new LongEventHandler2());   //往哪个handler投递信息
        //6. 启动disruptor
        disruptor.start();
        //7. 创建ringbuffer容器
        RingBuffer<LongEvent> ringBuffer = disruptor.getRingBuffer();
        //8. 创建生产者
        LongEventProducer producer = new LongEventProducer(ringBuffer);
        //9. 指定缓冲区大小
        ByteBuffer byteBuffer = ByteBuffer.allocate(8);  //大小为8
        for (int i = 1; i < 100; i++) {
            byteBuffer.putLong(0, i);  //0表示byteBuffer的第一个元素
            producer.onData(byteBuffer);
        }
        //10. 关闭executor && disruptor
        executor.shutdown();
        disruptor.shutdown();
    }
    
}
