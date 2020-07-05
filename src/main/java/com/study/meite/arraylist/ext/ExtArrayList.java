package com.study.meite.arraylist.ext;

import java.util.Arrays;

/**
 * @author lizhenhong
 * @Description: 自定义ArrayList
 * 位运算符 >>:
 * 位运算符 <<:
 * 底层采用数组，默认初始化最小容量是10
 * public JDKArrayList(int initialCapacity): 指定初始化容量大小(比如 List<String> list = new ArrayList<>(2)即初始化容量大小为2)
 * jdk1.7和 1.8 的区别：
 * 1. 1.8开始，数组扩容的代码放到了add()方法里；
 * 2. arraylist底层采用数组实现，数组名称elementData，jdk1.7的时候，elementData声明的时候是有初始化的，但是1.8没有
 * @date 2020/7/4 12:08
 */
public class ExtArrayList<E> implements ExtList<E> {

    //定义数组
    private Object[] elementData;

    // 默认初始化容量
    private static final int DEFAULT_CAPACITY = 10;

    // ArrayList中实际数据的数量
    private int size;

    //构造器(带数组初始容量的)
    public ExtArrayList(int initialCapacity) {
        //初始化容量大小
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("初始容量不能小于0");
        }
        elementData = new Object[initialCapacity];
    }

    //无参构造器
    public ExtArrayList() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * add()方法
     *
     * @param e
     */
    @Override
    public void add(E e) {
        ensureExplicitCapacity(size + 1);
        elementData[size++] = e;
    }

//    public void add(Object obj){
//        //1. 判断实际存放的数据容量是否大于elementData 的size
//        if (size == elementData.length) {
//            //新数组的容量大小
//            int newCapacity = 2 * size;
//            //将老数组中的值赋值到新数组里面去
//            Object[] newObj = new Object[newCapacity];
//            for (int i = 0; i < elementData.length; i++) {
//                newObj[i] = elementData[i];
//            }
//            //将老数组复制给新数组
//            elementData = newObj;
//        }
//        //2. 使用下标进行数组赋值
//        elementData[size++] = obj;
//    }

    public void ensureExplicitCapacity(int minCapacity) {
        // 如果存入的数据超出了默认数组初始容量 就开始实现扩容
        if (size == elementData.length) {
            // 获取原来数组的长度 2
            int oldCapacity = elementData.length;
            // oldCapacity >> 1 理解成 oldCapacity/2 新数组的长度是原来长度1.5倍
            int newCapacity = oldCapacity + (oldCapacity >> 1); // 3
            if (newCapacity < minCapacity) {
                // 最小容量比新容量要小的,则采用初始容量minCapacity
                newCapacity = minCapacity;
            }
            // System.out.println("oldCapacity:" + oldCapacity + ",newCapacity:"
            // + newCapacity);
            elementData = Arrays.copyOf(elementData, newCapacity);
        }
    }

    /**
     * 使用下标获取元素
     *
     * @param index
     * @return
     */
    public Object get(int index) {
        //首先判断是否有下表越界
        if (index >= elementData.length) {
            throw new IndexOutOfBoundsException("数组下标越界！list大小: " + elementData.length + ", 传入的index: " + index);
        }
        return elementData[index];
    }

    /**
     * 根据下标删除元素
     * 删除原理: 使用System.arraycopy()方法，将被删除元素后面的数据前移，并将最后一个元素置为空
     *
     * @param index
     * @return
     */
    public Object remove(int index) {
        //查看下标元素是否存在
        Object object = get(index);
        //计算被删除元素后面的长度
        int numMoved = size - index - 1;
        //删除原理: 使用System.arraycopy()方法，将被删除元素后面的数据前移，并将最后一个元素置为空
        if (numMoved > 0)    //如果删除的是最后一个元素的话，是不会走下面的数据前移的(jdk做的NB的地方)
            System.arraycopy(elementData, index + 1, elementData, index, numMoved);
        //将最后一个元素置为空
        elementData[--size] = null;
        return object;
    }

    /**
     * 这个方法，只能删一个对象元素(第一个)，而且在遍历删除的时候，会出问题
     *
     * @param obj
     * @return
     */
    public boolean remove(Object obj) {
        for (int i = 0; i < elementData.length; i++) {
            Object element = elementData[i];
            if (element.equals(obj)) {
                remove(i);
                return true;
            }
        }
        return false;
    }

    private void rangeCheck(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException("数组越界啦!");
        }
    }

    public int getSize() {
        return size;
    }
}














