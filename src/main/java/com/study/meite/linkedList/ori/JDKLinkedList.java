package com.study.meite.linkedList.ori;

import java.util.*;

/**
 * @description: 带注释版的LinkedList
 * @date: 2020/7/7 17:56
 * @author: lizhenhong
 */

public class JDKLinkedList<E>extends AbstractSequentialList<E>
        implements List<E>, Deque<E>, Cloneable, java.io.Serializable {
    transient int size = 0;   //LinkedList中存放的元素个数

    transient Node<E> first;  //头节点

    transient Node<E> last;   //尾节点

    //构造方法，创建一个空的列表
    public JDKLinkedList() {
    }

    //将一个指定的集合添加到JDKLinkedList中，先完成初始化，在调用添加操作
    public JDKLinkedList(Collection<? extends E> c) {
        this();
        addAll(c);
    }

    //插入头节点
    private void linkFirst(E e) {
        final Node<E> f = first;  //将头节点赋值给f节点
        //new 一个新的节点，此节点的data = e , pre = null , next - > f 
        final Node<E> newNode = new Node<>(null, e, f);
        first = newNode; //将新创建的节点地址复制给first
        if (f == null)  //f == null，表示此时JDKLinkedList为空
            last = newNode;  //将新创建的节点赋值给last
        else
            f.prev = newNode;  //否则f.前驱指向newNode
        size++;
        modCount++;
    }

    //插入尾节点
    /**
     * Links e as last element.
     * 这篇博文是写的比较好的：https://zhuanlan.zhihu.com/p/28101975
     */
    void linkLast(E e) {
        //将最后一个元素赋值给新声明的节点(第一次添加元素的时候，last值为null)
        final JDKLinkedList.Node<E> l = last;
        //根据传入的对象新建一个节点，并将上面声明的节点l作为新节点的prev
        final JDKLinkedList.Node<E> newNode = new JDKLinkedList.Node<>(l, e, null);
        // 将第二步新建的节点赋值给last
        last = newNode;
        //如果之前的最后一个元素是null(之前是空list)，则将新建的节点赋值给第一个元素，
        if (l == null)
            first = newNode;
        else
            //否则，赋值给下一个节点
            l.next = newNode;
        last.prev = l;   //这个是我自己加的
        //list.size+1
        size++;
        //被修改过的count+1，这个我看着咋没啥用呢
        modCount++;
    }

    //在succ节点前插入e节点，并修改各个节点之间的前驱后继
    void linkBefore(E e, Node<E> succ) {
        // assert succ != null;
        final Node<E> pred = succ.prev;
        final Node<E> newNode = new Node<>(pred, e, succ);
        succ.prev = newNode;
        if (pred == null)
            first = newNode;
        else
            pred.next = newNode;
        size++;
        modCount++;
    }

    //删除头节点
    private E unlinkFirst(Node<E> f) {
        // assert f == first && f != null;
        final E element = f.item;
        final Node<E> next = f.next;
        f.item = null;
        f.next = null; // help GC
        first = next;
        if (next == null)
            last = null;
        else
            next.prev = null;
        size--;
        modCount++;
        return element;
    }

    //删除尾节点
    private E unlinkLast(Node<E> l) {
        // assert l == last && l != null;
        final E element = l.item;
        final Node<E> prev = l.prev;
        l.item = null;
        l.prev = null; // help GC
        last = prev;
        if (prev == null)
            first = null;
        else
            prev.next = null;
        size--;
        modCount++;
        return element;
    }

    //删除指定节点
    E unlink(Node<E> x) {
        // assert x != null;
        final E element = x.item;
        final Node<E> next = x.next;  //获取指定节点的前驱
        final Node<E> prev = x.prev;  //获取指定节点的后继

        if (prev == null) {
            first = next;   //如果前驱为null, 说明此节点为头节点
        } else {
            prev.next = next;  //前驱结点的后继节点指向当前节点的后继节点
            x.prev = null;     //当前节点的前驱置空
        }

        if (next == null) {    //如果当前节点的后继节点为null ,说明此节点为尾节点
            last = prev;
        } else {
            next.prev = prev;  //当前节点的后继节点的前驱指向当前节点的前驱节点
            x.next = null;     //当前节点的后继置空
        }

        x.item = null;     //当前节点的元素设置为null ,等待垃圾回收
        size--;
        modCount++;
        return element;
    }

    //获取JDKLinkedList中的第一个节点信息
    public E getFirst() {
        final Node<E> f = first;
        if (f == null)
            throw new NoSuchElementException();
        return f.item;
    }

    //获取JDKLinkedList中的最后一个节点信息
    public E getLast() {
        final Node<E> l = last;
        if (l == null)
            throw new NoSuchElementException();
        return l.item;
    }

    //删除头节点
    public E removeFirst() {
        final Node<E> f = first;
        if (f == null)
            throw new NoSuchElementException();
        return unlinkFirst(f);
    }

    //删除尾节点
    public E removeLast() {
        final Node<E> l = last;
        if (l == null)
            throw new NoSuchElementException();
        return unlinkLast(l);
    }

    //将添加的元素设置为JDKLinkedList的头节点
    public void addFirst(E e) {
        linkFirst(e);
    }

    //将添加的元素设置为JDKLinkedList的尾节点
    public void addLast(E e) {
        linkLast(e);
    }

    //判断JDKLinkedList是否包含指定的元素
    public boolean contains(Object o) {
        return indexOf(o) != -1;
    }

    //返回List中元素的数量
    public int size() {
        return size;
    }

    //在JDKLinkedList的尾部添加元素
    public boolean add(E e) {
        linkLast(e);
        return true;
    }

    //删除指定的元素
    public boolean remove(Object o) {
        if (o == null) {
            for (Node<E> x = first; x != null; x = x.next) {
                if (x.item == null) {
                    unlink(x);
                    return true;
                }
            }
        } else {
            for (Node<E> x = first; x != null; x = x.next) {
                if (o.equals(x.item)) {
                    unlink(x);
                    return true;
                }
            }
        }
        return false;
    }

    //将集合中的元素添加到List中
    public boolean addAll(Collection<? extends E> c) {
        return addAll(size, c);
    }

    //将集合中的元素全部插入到List中，并从指定的位置开始
    public boolean addAll(int index, Collection<? extends E> c) {
        checkPositionIndex(index);

        Object[] a = c.toArray();  //将集合转化为数组
        int numNew = a.length;  //获取集合中元素的数量
        if (numNew == 0)   //集合中没有元素，返回false
            return false;

        Node<E> pred, succ;
        if (index == size) {
            succ = null;
            pred = last;
        } else {
            succ = node(index); //获取位置为index的结点元素，并赋值给succ
            pred = succ.prev;
        }

        for (Object o : a) {  //遍历数组进行插入操作。修改节点的前驱后继
            @SuppressWarnings("unchecked") E e = (E) o;
            Node<E> newNode = new Node<>(pred, e, null);
            if (pred == null)
                first = newNode;
            else
                pred.next = newNode;
            pred = newNode;
        }

        if (succ == null) {
            last = pred;
        } else {
            pred.next = succ;
            succ.prev = pred;
        }

        size += numNew;
        modCount++;
        return true;
    }

    //删除List中所有的元素
    public void clear() {
        // Clearing all of the links between nodes is "unnecessary", but:
        // - helps a generational GC if the discarded nodes inhabit
        //   more than one generation
        // - is sure to free memory even if there is a reachable Iterator
        for (Node<E> x = first; x != null; ) {
            Node<E> next = x.next;
            x.item = null;
            x.next = null;
            x.prev = null;
            x = next;
        }
        first = last = null;
        size = 0;
        modCount++;
    }


    //获取指定位置的元素
    public E get(int index) {
        //首先判断index是否合法，
        //如果合法，则返回节点查找结果的item
        checkElementIndex(index);
        return node(index).item;
    }

    //将节点防止在指定的位置
    public E set(int index, E element) {
        checkElementIndex(index);
        Node<E> x = node(index);
        E oldVal = x.item;
        x.item = element;
        return oldVal;
    }

    //将节点放置在指定的位置
    public void add(int index, E element) {
        checkPositionIndex(index);

        if (index == size)
            linkLast(element);
        else
            linkBefore(element, node(index));
    }

    //删除指定位置的元素
    public E remove(int index) {
        checkElementIndex(index);
        return unlink(node(index));
    }

    //判断索引是否合法
    private boolean isElementIndex(int index) {
        return index >= 0 && index < size;
    }

    //判断位置是否合法
    private boolean isPositionIndex(int index) {
        return index >= 0 && index <= size;
    }

    //索引溢出信息
    private String outOfBoundsMsg(int index) {
        return "Index: "+index+", Size: "+size;
    }
    //检查节点是否合法
    private void checkElementIndex(int index) {
        if (!isElementIndex(index))
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }
    //检查位置是否合法
    private void checkPositionIndex(int index) {
        if (!isPositionIndex(index))
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }

    /**
     * 返回指定位置的节点信息
     * JDKLinkedList无法随机访问，只能通过遍历的方式找到相应的节点
     * 为了提高效率，当前位置首先和元素数量的中间位置开始判断，小于中间位置，
     * 从头节点开始遍历，大于中间位置从尾节点开始遍历
     * @param index
     * @return
     */
    Node<E> node(int index) {
        // assert isElementIndex(index);
        /**
         * LinkedList无法随机访问，只能通过遍历的方式找到相应的节点
         * 如果传入的index < size/2(即中间位置的前面)，声明一个新的Node x，并将list中的第一个元素赋值给x，
         * 小于中间位置，从头节点开始遍历，大于中间位置从尾节点开始遍历
         */
        if (index < (size >> 1)) {
            Node<E> x = first;
            for (int i = 0; i < index; i++)
                x = x.next;
            return x;
        } else {
            Node<E> x = last;
            for (int i = size - 1; i > index; i--)
                x = x.prev;
            return x;
        }
    }

    //返回第一次出现指定元素的位置
    public int indexOf(Object o) {
        int index = 0;
        if (o == null) {
            for (Node<E> x = first; x != null; x = x.next) {
                if (x.item == null)
                    return index;
                index++;
            }
        } else {
            for (Node<E> x = first; x != null; x = x.next) {
                if (o.equals(x.item))
                    return index;
                index++;
            }
        }
        return -1;
    }

    //返回最后一次出现元素的位置
    public int lastIndexOf(Object o) {
        int index = size;
        if (o == null) {
            for (Node<E> x = last; x != null; x = x.prev) {
                index--;
                if (x.item == null)
                    return index;
            }
        } else {
            for (Node<E> x = last; x != null; x = x.prev) {
                index--;
                if (o.equals(x.item))
                    return index;
            }
        }
        return -1;
    }

    //弹出第一个元素的值
    public E peek() {
        final Node<E> f = first;
        return (f == null) ? null : f.item;
    }

    //获取第一个元素
    public E element() {
        return getFirst();
    }

    //弹出第一元素，并删除
    public E poll() {
        final Node<E> f = first;
        return (f == null) ? null : unlinkFirst(f);
    }

    //删除第一个元素
    public E remove() {
        return removeFirst();
    }

    //添加到尾部
    public boolean offer(E e) {
        return add(e);
    }

    //添加到头部
    public boolean offerFirst(E e) {
        addFirst(e);
        return true;
    }

    //插入到最后一个元素
    public boolean offerLast(E e) {
        addLast(e);
        return true;
    }
    //队列操作
    //尝试弹出第一个元素，但是不删除元素
    public E peekFirst() {
        final Node<E> f = first;
        return (f == null) ? null : f.item;
    }
    //队列操作
    //尝试弹出最后一个元素，不删除
    public E peekLast() {
        final Node<E> l = last;
        return (l == null) ? null : l.item;
    }

    //弹出第一个元素，并删除
    public E pollFirst() {
        final Node<E> f = first;
        return (f == null) ? null : unlinkFirst(f);
    }

    //弹出最后一个元素，并删除
    public E pollLast() {
        final Node<E> l = last;
        return (l == null) ? null : unlinkLast(l);
    }

    //如队列，添加到头部
    public void push(E e) {
        addFirst(e);
    }

    //出队列删除第一个节点
    public E pop() {
        return removeFirst();
    }

    //删除指定元素第一次出现的位置
    public boolean removeFirstOccurrence(Object o) {
        return remove(o);
    }

    //删除指定元素最后一次出现的位置
    public boolean removeLastOccurrence(Object o) {
        if (o == null) {
            for (Node<E> x = last; x != null; x = x.prev) {
                if (x.item == null) {
                    unlink(x);
                    return true;
                }
            }
        } else {
            for (Node<E> x = last; x != null; x = x.prev) {
                if (o.equals(x.item)) {
                    unlink(x);
                    return true;
                }
            }
        }
        return false;
    }

    //遍历方法
    public ListIterator<E> listIterator(int index) {
        checkPositionIndex(index);
        return new ListItr(index);
    }
    //内部类，实现ListIterator接口
    private class ListItr implements ListIterator<E> {
        private Node<E> lastReturned = null;
        private Node<E> next;
        private int nextIndex;
        private int expectedModCount = modCount;

        ListItr(int index) {
            // assert isPositionIndex(index);
            next = (index == size) ? null : node(index);
            nextIndex = index;
        }

        public boolean hasNext() {
            return nextIndex < size;
        }

        public E next() {
            checkForComodification();
            if (!hasNext())
                throw new NoSuchElementException();

            lastReturned = next;
            next = next.next;
            nextIndex++;
            return lastReturned.item;
        }

        public boolean hasPrevious() {
            return nextIndex > 0;
        }

        public E previous() {
            checkForComodification();
            if (!hasPrevious())
                throw new NoSuchElementException();

            lastReturned = next = (next == null) ? last : next.prev;
            nextIndex--;
            return lastReturned.item;
        }

        public int nextIndex() {
            return nextIndex;
        }

        public int previousIndex() {
            return nextIndex - 1;
        }

        public void remove() {
            checkForComodification();
            if (lastReturned == null)
                throw new IllegalStateException();

            Node<E> lastNext = lastReturned.next;
            unlink(lastReturned);
            if (next == lastReturned)
                next = lastNext;
            else
                nextIndex--;
            lastReturned = null;
            expectedModCount++;
        }

        public void set(E e) {
            if (lastReturned == null)
                throw new IllegalStateException();
            checkForComodification();
            lastReturned.item = e;
        }

        public void add(E e) {
            checkForComodification();
            lastReturned = null;
            if (next == null)
                linkLast(e);
            else
                linkBefore(e, next);
            nextIndex++;
            expectedModCount++;
        }

        final void checkForComodification() {
            if (modCount != expectedModCount)
                throw new ConcurrentModificationException();
        }
    }
    //静态内部类，创建节点
    private static class Node<E> {
        E item;  //节点内容(数据元素)
        Node<E> next;  //上一个节点 
        Node<E> prev;  //下一个节点

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }

    /**
     * @since 1.6
     */
    public Iterator<E> descendingIterator() {
        return new DescendingIterator();
    }

    /**
     * Adapter to provide descending iterators via ListItr.previous
     */
    private class DescendingIterator implements Iterator<E> {
        private final ListItr itr = new ListItr(size());
        public boolean hasNext() {
            return itr.hasPrevious();
        }
        public E next() {
            return itr.previous();
        }
        public void remove() {
            itr.remove();
        }
    }

    @SuppressWarnings("unchecked")
    private JDKLinkedList<E> superClone() {
        try {
            return (JDKLinkedList<E>) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new InternalError();
        }
    }

    /**
     * Returns a shallow copy of this {@code JDKLinkedList}. (The elements
     * themselves are not cloned.)
     *
     * @return a shallow copy of this {@code JDKLinkedList} instance
     */
    public Object clone() {
        JDKLinkedList<E> clone = superClone();

        // Put clone into "virgin" state
        clone.first = clone.last = null;
        clone.size = 0;
        clone.modCount = 0;

        // Initialize clone with our elements
        for (Node<E> x = first; x != null; x = x.next)
            clone.add(x.item);

        return clone;
    }


    public Object[] toArray() {
        Object[] result = new Object[size];
        int i = 0;
        for (Node<E> x = first; x != null; x = x.next)
            result[i++] = x.item;
        return result;
    }


    @SuppressWarnings("unchecked")
    public <T> T[] toArray(T[] a) {
        if (a.length < size)
            a = (T[])java.lang.reflect.Array.newInstance(
                    a.getClass().getComponentType(), size);
        int i = 0;
        Object[] result = a;
        for (Node<E> x = first; x != null; x = x.next)
            result[i++] = x.item;

        if (a.length > size)
            a[size] = null;

        return a;
    }

    private static final long serialVersionUID = 876323262645176354L;

    //将对象写入到输出流中
    private void writeObject(java.io.ObjectOutputStream s)
            throws java.io.IOException {
        // Write out any hidden serialization magic
        s.defaultWriteObject();

        // Write out size
        s.writeInt(size);

        // Write out all elements in the proper order.
        for (Node<E> x = first; x != null; x = x.next)
            s.writeObject(x.item);
    }

    //从输入流中将对象读出
    @SuppressWarnings("unchecked")
    private void readObject(java.io.ObjectInputStream s)
            throws java.io.IOException, ClassNotFoundException {
        // Read in any hidden serialization magic
        s.defaultReadObject();

        // Read in size
        int size = s.readInt();

        // Read in all elements in the proper order.
        for (int i = 0; i < size; i++)
            linkLast((E)s.readObject());
    }

}
