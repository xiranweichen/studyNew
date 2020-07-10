package com.study.meite.hashmap.ext;

/**
 * @description: 手写Map接口
 * @date: 2020/7/10 19:24
 * @author: lizhenhong
 */
public interface ExtMap<K, V> {

    // 向集合中插入数据
    public V put(K k, V v);

    // 根据k 从Map集合中查询元素
    public V get(K k);

    // 获取集合元素个数
    public int size();

    //作用：相当于 Node节点
    interface Entry<K, V> {
        K getKey();

        V getValue();

        V setValue(V value);
    }

}
