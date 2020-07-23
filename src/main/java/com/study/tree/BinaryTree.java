package com.study.tree;

/**
 * @description: 手写二叉树
 * @date: 2020/7/23 19:07
 * @author: lizhenhong
 */
public class BinaryTree {

    private int data;    //数据
    private BinaryTree left;
    private BinaryTree right;

    public BinaryTree(int data) {
        this.data = data;
        left = null;
        right = null;
    }

    /**
     * 插入数据
     * @param root 父节点
     * @param data 数据
     */
    public void insert(BinaryTree root, int data) {
        if (root.data < data) { //如果根节点小于data，则插入右子树
            if (root.right == null) {
                //右边没有值，直接插入到右边
                root.right = new BinaryTree(data);
            } else {
                insert(root.right, data);
            }
        } else {
            //否则，插入左子树
            if (root.left == null) {
                root.left = new BinaryTree(data);
            } else {
                insert(root.left, data);
            }
        }
    }

    /**
     * 中序遍历    左根 输出 右
     * @param root
     */
    public void in(BinaryTree root) {
        if (root != null) {
            in(root.left);
            System.out.print(root.data + " ");
            in(root.right);
        }
    }


    public static void main(String[] args) {
        int[] data = {5, 9, 0, 1, 2, 3, 10, 23, 12, 8};
        //让序列的第一个元素作为root节点
        BinaryTree binaryTree = new BinaryTree(data[0]);
        for (int i = 0; i < data.length; i++) {
            binaryTree.insert(binaryTree, data[i]);
        }
        System.out.println("中序遍历的结果为：");
        binaryTree.in(binaryTree);
    }

}
