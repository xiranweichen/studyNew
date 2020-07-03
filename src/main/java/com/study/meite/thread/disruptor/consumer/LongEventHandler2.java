package com.study.meite.thread.disruptor.consumer;

import com.lmax.disruptor.EventHandler;
import meite.thread.disruptor.entity.LongEvent;

/**
 * @description: 第二个消费者
 * @date: 2020/7/1 20:21
 * @author: lizhenhong
 */
public class LongEventHandler2 implements EventHandler<LongEvent> {

    @Override
    public void onEvent(LongEvent longEvent, long l, boolean b) throws Exception {
        System.out.println("====>消费者2获取的生产者数据event：" + longEvent.getValue());
    }
}
