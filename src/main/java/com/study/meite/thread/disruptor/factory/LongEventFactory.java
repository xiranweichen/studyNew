package com.study.meite.thread.disruptor.factory;

import com.lmax.disruptor.EventFactory;
import com.study.meite.thread.disruptor.entity.LongEvent;

/**
 * @description: event工厂，作用是帮我们实例化LongEvent对象
 * @date: 2020/7/1 19:06
 * @author: lizhenhong
 */
public class LongEventFactory implements EventFactory<LongEvent> {
    @Override
    public LongEvent newInstance() {
        return new LongEvent();
    }
}
