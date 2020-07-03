package com.study.meite.thread.disruptor.producer;

import com.lmax.disruptor.RingBuffer;
import meite.thread.disruptor.entity.LongEvent;

import java.nio.ByteBuffer;

/**
 * @description: 生产者
 * @date: 2020/7/1 19:27
 * @author: lizhenhong
 */
public class LongEventProducer {

    private RingBuffer<LongEvent> ringBuffer;

    public LongEventProducer(RingBuffer<LongEvent> ringBuffer) {
        this.ringBuffer = ringBuffer;
    }

    public void onData(ByteBuffer byteBuffer) {
        //拿到环形的序列位置，获取事件队列的下标位置
        long sequence = ringBuffer.next();
        try {
            //取出空队列(Event)
            LongEvent longEvent = ringBuffer.get(sequence);
            //给空的队列赋值，然后将数据推送到消费端
            longEvent.setValue(byteBuffer.getLong(0));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("====>生产者开始给消费者发送数据");
            //发送数据
            ringBuffer.publish(sequence);
        }
        
    }
    
}
