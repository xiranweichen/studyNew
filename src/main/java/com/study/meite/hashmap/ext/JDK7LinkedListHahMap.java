
package com.study.meite.hashmap.ext;

import java.util.LinkedList;

/**
 * @description: jdk7，基于LinkedList实现的手写HashMap
 *              使用数组+链表的方式实现
 * @date: 2020/7/9 19:41
 * @author: lizhenhong
 */
public class JDK7LinkedListHahMap {

   //先定义一个Entry数组
   // tables 存放数据元素
   LinkedList<Entry>[] tables = new LinkedList[998];

    /**
     * 这里面，当key的hashCode相同的时候，存放在同一个链表集合中
     * @param key
     * @param value
     */
    public void put(Object key, Object value) {
        //得到 key 的内存地址
        // 两个对象做比较，如果 hashCode相同， 对象的值不一定相同
        // 两个对象做比较，如果 equals() 比较结果相同， 对象的值一定相同
        int hashCode = key.hashCode();
        //使用hash算法取模
        int hash = hashCode % tables.length; 
        //1. 首先获取元素下标，判断是否有LinkedList， 
        LinkedList<Entry> entryLinkedList = tables[hash];
        Entry entryNew = new Entry(key, value);
        if (entryLinkedList == null) {
            //没有hash冲突
            entryLinkedList = new LinkedList<>();
            entryLinkedList.add(entryNew);
            tables[hash] = entryLinkedList;
        } else {
            //有hash冲突,直接在该链表中添加链表节点
            for (Entry entry : entryLinkedList) {
                //如果链表中的key和当前传入的key相同， 直接将原先的链表中的value覆盖掉
                if (entry.key.equals(key)) {
                    entry.value = value;
                } else {
                    //hashCode相同，对象值不一定相同,在LinkedList中添加元素
                    entryLinkedList.add(entryNew);
                }
            }
            
        }


    }

    //查询的时候直接根据hash值定位到数组中的位置
    public Object get(Object key) {
        int hashCode = key.hashCode();
        int hash = hashCode % tables.length;
        return tables[hash];
    }
    


}

//hash 存储对象
class Entry<Key, Value> {
    // hashMap 集合存储的key
    Key key;
    // hashMap 集合存储的value
    Value value;

    public Entry(Key key, Value value) {
        this.key = key;
        this.value = value;
    }
}
