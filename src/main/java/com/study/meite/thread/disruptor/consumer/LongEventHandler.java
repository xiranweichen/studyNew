package com.study.meite.thread.disruptor.consumer;

import com.lmax.disruptor.EventHandler;
import com.study.meite.thread.disruptor.entity.LongEvent;

/**
 * @description: 消费者,获取生产这推送的数据
 * @date: 2020/7/1 19:09
 * @author: lizhenhong
 */
public class LongEventHandler implements EventHandler<LongEvent> {

    @Override
    public void onEvent(LongEvent longEvent, long l, boolean b) throws Exception {
        System.out.println("====>消费者1获取的生产者数据event：" + longEvent.getValue());
    }
}
