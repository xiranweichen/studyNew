package com.study.meite.hashmap.ext;

/**
 * @description: 基于jdk1.7的 HashMap：数组+单向链表
 * 不适用双向链表的原因：
 * @date: 2020/7/10 18:40
 * @author: lizhenhong
 */
public class JDK7ExtHashMap<K,V> implements ExtMap<K, V> {

    //1. 定义一个table， 存放HashMap 的数组元素(默认没有初始化，目的是：实现懒加载功能)
    Node<K, V>[] table = null;

    //2. 实际用到的table的存储容量
    int size;

    //3. 负载因子   默认0.75 (默认扩容的时候用到，负载因子越小，hash冲突的概率越低)
    float DEFAULT_LOAD_FACTOR = 0.75f;

    // 4. table的默认初始大小：1<<4 = 16
    static final int DEFAULT_INITIAL_CAPACITY = 1 << 4;

    @Override
    public V put(K k, V v) {
        return null;
    }

    @Override
    public V get(K k) {
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    // 定义节点
    class Node<K, V> implements Entry<K, V> {

        //定义key
        private K key;

        //定义value
        private V value;

        // 定义下一个节点Node
        private Node<K, V> next;
        
        @Override
        public K getKey() {
            return this.key;
        }

        @Override
        public V getValue() {
            return this.value;
        }

        /**
         * 设置新的值的时候(覆盖时)返回老的值
         * @param value
         * @return 老的值
         */
        @Override
        public V setValue(V value) {
            V oldValue = this.value;
            this.value = value;
            return oldValue;
        }
    }
    
    
}
