package com.study.tree;

import com.sun.org.apache.regexp.internal.RE;

/**
 * @description: 红黑树
 * @date: 2020/7/23 20:09
 * @author: lizhenhong
 */
public class RedBlackTree {

    private final int BLACK = 1;
    private final int RED = 0;

    private Node root;

    class Node {
        int data;
        //默认射程黑色
        int color = BLACK;
        Node left;
        Node right;
        Node parent;

        public Node(int data) {
            this.data = data;
        }
    }

    /**
     * 插入
     *
     * @param node
     */
    public void insert(Node node) {
        //这里一定要把所有的节点颜色设置为红色
        node.color = RED;
    }

    /**
     * 左旋
     */
    public void leftRound(Node node) {
        //如果它的父节点不是null
        if (node.parent != null) {
            //这里更复杂

        } else {
            //因为没有父节点，就是根节点
            //根节点左旋
            Node right = root.right;
            root.right = right.left;
            right.left.parent = root;
            root.parent = right;
            right.parent = null;
            root = right;
        }
    }

}
