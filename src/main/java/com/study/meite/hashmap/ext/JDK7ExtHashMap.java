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
    static int DEFAULT_INITIAL_CAPACITY = 1 << 4;

    @Override
    public V put(K key, V value) {
        //1. 判断table是否为空，，如果为空，做初始化
        if (table == null)
            table = new Node[DEFAULT_INITIAL_CAPACITY];
        //2. 判断是否需要扩容(判断根据：实际的size >= 负载因子 * 初始容量), 扩容为之前的数组的两倍
        if (size >= DEFAULT_LOAD_FACTOR * DEFAULT_INITIAL_CAPACITY) {
            //对table进行扩容
            reSize();
        }
        //3. 计算hash，指定下表位置
        int index = getIndex(key, DEFAULT_INITIAL_CAPACITY);
        //判断一下index位置是否有节点元素
        Node<K, V> node = table[index];
        if (node == null) {
            //没有发生hash冲突问题
            node = new Node<>(key, value, null);
            //size增大1
            size++;
        } else {
            //先定义一个newNode变量，然后在链表中一直遍历到链表的最后一个元素，如果整个链表中所有元素的key都和传入的key不相等，添加node，否则覆盖之前的node
            Node<K, V> newNode = node;
            while (newNode != null) {
                //发生hash冲突,
                if (node.getKey().equals(key) || node.getKey() == key) {
                    //key是同一个对象, 执行修改并返回老的值
                    return node.setValue(value);
                } else {
                    //hashCode取模的余数(index)相同的不同对象
                    node = new Node<>(key, value, node); //将冲突的node添加，添加到前面了
                    //size增大1
                    size++;
                }
                newNode = newNode.next;
            }
        }
        table[index] = node;
        return node.value;   //这里返回的node没啥用
    }

    public int getIndex(K k, int length) {
        int hashCode = k.hashCode();
        int index = hashCode % length;
        return index;
    }

    /**
     * 扩容
     */
    private void reSize() {
        //1. 生成新的table，大小是之前table的两倍
        Node[] newTable = new Node[DEFAULT_INITIAL_CAPACITY << 1];
        //2. 重新计算index位置
        for (int i = 0; i < table.length; i++) {
            Node<K, V> oldNode = table[i];  //原来的node
            while (oldNode != null) {
                table[i] = null;  //让垃圾回收机制回收调table[i](之前的node)
                K oldKey = oldNode.key;
                //重新计算index
                int newIndex = getIndex(oldKey, newTable.length);
                Node<K, V> oldNext = oldNode.next;
                //如果index下标在新table
                //如果newIndex计算结果相同，以链表进行存储(原来的node的下一个是最新的node，也就是原来的node排在前面)
                oldNode.next = newTable[newIndex];
                //将之前的node赋值给新的newTable[index]
                newTable[newIndex] = oldNext;
                //判断是否继续循环遍历
                oldNode = oldNext;
            }
        }
        //3. 将数据存放在新的table里面
        table = newTable;
        //将DEFAULT_INITIAL_CAPACITY修改为新的table的长度
        DEFAULT_INITIAL_CAPACITY = newTable.length;
    }

    @Override
    public V get(K k) {
        // 使用取模算法定位数组链表
        Node<K, V> nodeIndex = table[getIndex(k, DEFAULT_INITIAL_CAPACITY)];
        Node<K, V> node = getNode(nodeIndex, k);
        return node == null ? null : node.value;
    }

    public Node<K, V> getNode(Node<K, V> node, K k) {
        while (node != null) {
            if (node.getKey().equals(k))
                return node;
            node = node.next;
        }
        return node;
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

        public Node(K key, V value, Node<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    // 测试方法.打印所有的链表元素
    public void print() {

        for (int i = 0; i < table.length; i++) {
            Node<K, V> node = table[i];
            System.out.print("下标位置[" + i + "]");
            while (node != null) {
                System.out.print("[ key:" + node.getKey() + ",value:" + node.getValue() + "]");
                node = node.next;
                // if (node.next != null) {
                // node = node.next;
                // } else {
                // // 结束循环
                // node = null;
                // }

            }
            System.out.println();
        }

    }
    
    
}
