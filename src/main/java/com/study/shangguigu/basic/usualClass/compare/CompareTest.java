package com.study.shangguigu.basic.usualClass.compare;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @description: java比较器
 * @date: 2020/3/8 15:08
 * @author: lizhenhong
 */
public class CompareTest {

    /**
     * Comparable接口(自然排序)
     */
    @Test
    public void comparableTest() {
        String[] strArr = new String[]{"PP", "BB", "DD", "AA", "FF", "QQ", "MM", "SS"};
        Arrays.sort(strArr);
        System.out.println(Arrays.toString(strArr));  //[AA, BB, DD, FF, MM, PP, QQ, SS]
    }

    /**
     * 自定义类实现Comparable自然排序
     * 如果需要排序，我们可以让自定义类实现Comparable接口，重写其中的compareTo(obj)方法
     * 需要在compareTo(obj)方法中指明如何排序
     */
    @Test
    public void goodsComparableTest() {
        Goods[] goods = new Goods[5];
        goods[0] = new Goods("小米", 699);
        goods[1] = new Goods("华为", 1099);
        goods[2] = new Goods("联想", 6299);
        goods[3] = new Goods("苹果", 1);
        goods[4] = new Goods("戴尔", 1099);
        Arrays.sort(goods);
        System.out.println(Arrays.toString(goods));//[Goods{name='苹果', price='1.0'}, Goods{name='小米', price='699.0'}, Goods{name='戴尔', price='1099.0'}, Goods{name='华为', price='1099.0'}, Goods{name='联想', price='6299.0'}]
    }

    /**
     * 定制排序(Comparator接口)
     * 实现对数组{"PP", "BB", "DD", "AA", "FF", "QQ", "MM", "SS"}内元素从大到小排列
     */
    @Test
    public void comparatorTest() {
        String[] strArr = new String[]{"PP", "BB", "DD", "AA", "FF", "QQ", "MM", "SS"};
        Arrays.sort(strArr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1 instanceof String && o2 instanceof String) {
                    return -o1.compareTo(o2);//从大到小排列
                }
                throw new RuntimeException("输入的类型不一致");
            }
        });
        System.out.println(Arrays.toString(strArr));//[SS, QQ, PP, MM, FF, DD, BB, AA]
    }

    /**
     * 自定义类实现Comparator接口定制排序
     *      先按照名称从低到高，再按照价格从高到低
     */
    @Test
    public void goodsComparatorTest() {
        Goods[] goods = new Goods[6];
        goods[0] = new Goods("mi小米", 699);
        goods[1] = new Goods("huawei华为", 1099);
        goods[2] = new Goods("lenvol联想", 6299);
        goods[3] = new Goods("iphone苹果", 1);
        goods[4] = new Goods("dell戴尔", 1099);
        goods[5] = new Goods("dell戴尔", 1);
        Arrays.sort(goods, new Comparator<Goods>() {
            @Override
            public int compare(Goods o1, Goods o2) {
                //判断，如果name相同，则按价格从高到低
                if (o1.getName().equals(o2.getName())) {
                    return -Double.compare(o1.getPrice(), o2.getPrice());
                } else {
                    return o1.getName().compareTo(o2.getName());
                }
            }
        });
        System.out.println(Arrays.toString(goods));//[Goods{name='dell戴尔', price='1099.0'}, Goods{name='dell戴尔', price='1.0'}, Goods{name='huawei华为', price='1099.0'}, Goods{name='iphone苹果', price='1.0'}, Goods{name='lenvol联想', price='6299.0'}, Goods{name='mi小米', price='699.0'}]
    }
}
