package com.study.meite.thread.disruptor.entity;

/**
 * @description: 声明一个event，表示生产这与消费者传递的数据类型
 * @date: 2020/7/1 19:05
 * @author: lizhenhong
 */
public class LongEvent {

    private Long value;

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }
}
