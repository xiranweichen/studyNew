package com.study.shangguigu.basic.usualClass.compare;

/**
 * @description: 自定义类实现Comparable自然排序
 *               如果需要排序，我们可以让自定义类实现Comparable接口，重写其中的compareTo(obj)方法
 *               需要在compareTo(obj)方法中指明如何排序
 * @date: 2020/3/8 15:30
 * @author: lizhenhong
 */
public class Goods implements Comparable{

    //商品名称
    private String name;
    //价格
    private double price;

    public Goods() {
    }

    public Goods(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "name='" + name + '\'' +
                ", price='" + price + '\'' +
                '}';
    }

    //排序：先按照价格从低到高，再按照名称从高到低
    @Override
    public int compareTo(Object o) {
        if (o instanceof Goods) { //如果传入的参数是Goods类型的
            Goods goods = (Goods) o;
            //方式一：手写比较大小
            if (this.price > goods.price) {
                return 1;
            } else if (this.price < goods.price) {
                return -1;
            } else {
                //如果两个price是相等的，那么根据name排序
                return -this.name.compareTo(goods.name);
            }
            //方式二：调用包装类Double中的compare()方法
            //return Double.compare(this.price, goods.price);
        } else {
            throw new RuntimeException("入参不是Goods类型的！");
        } 
    }
}
