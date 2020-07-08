package com.study.meite.linkedList.ext;

/**
 * @author lizhenhong
 * @Description: 自定义LinkedList
 * @date 2020/7/5 20:18
 */
public class ExtLinkedList<E> {

    /**
     * 链表实际存储元素个数
     */
    transient int size = 0;

    /**
     * Pointer to first node. 第一个元素(头节点, 为了查询开始)
     * Invariant: (first == null && last == null) ||
     *            (first.prev == null && first.item != null)
     */
    transient ExtLinkedList.Node first;

    /**
     * Pointer to last node. 最后一个元素
     * Invariant: (first == null && last == null) ||
     *            (last.next == null && last.item != null)
     */
    transient ExtLinkedList.Node last;

    /**
     * add()增加方法
     * @param e
     */
    public void add(E e) {
        Node node = new Node();//创建节点
        if (first == null) {
            //如果头节点为空，添加第一条数据
            //给节点复制
            node.item = e;
            //给第一个元素节点复制
            first = node;
            ///第一个元素的头和尾都属于自己，都是node
        } else {
            //否则，添加第二条或者第二条以上的数据
            node.prev = last;
            //将上一个元素的next赋值
            last.next = node;
        }
        last = node;
        //实际长度增加1
        size++;
    }

    /**
     * 定义一个节点内部类
     */
    private class Node {
        //存放的元素
        private Object item;
        //上一个节点Node
        private Object prev;
        //下一个节点Node
        private Object next;

//        public Node(Object item, Object prev, Object next) {
//            this.item = item;
//            this.prev = prev;
//            this.next = next;
//        }
    }

}
