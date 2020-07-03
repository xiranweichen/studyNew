package com.study.shangguigu.basic.map;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: Map的常用方法
 * @date: 2020/4/3 15:55
 * @author: lizhenhong
 */
public class MapTest {

    @Test
    public void test1() {
        Map<String, Object> map = new HashMap<>();
        map.put("lizhenhong", "LIZHENHONG");
        map.put("zhangyunzhu", "ZHANGYUNZHU");
        map.put("123", "abc");
        map.put("456", "def");
        System.out.println(map); //{zhangyunzhu=ZHANGYUNZHU, 123=abc, 456=def, lizhenhong=LIZHENHONG}
        
        //putAll(Map shangguigu.basic.map):将map中的全部元素放到新的map中
        Map<String, Object> map1 = new HashMap<>();
        map1.putAll(map);
        System.out.println(map1);  //{lizhenhong=LIZHENHONG, zhangyunzhu=ZHANGYUNZHU, 123=abc, 456=def}
        
        //remove(Object key): 按照指定的key将元素移除，返回的是要移除的value
        Object remove = map.remove("123");
        System.out.println(remove);  //abc
        System.out.println(map);  //{zhangyunzhu=ZHANGYUNZHU, 456=def, lizhenhong=LIZHENHONG}
        
        //clear(): 清空map数据(但是map对象仍然存在)
        map.clear();
        System.out.println(map.size()); //0
        System.out.println(map); //{}

    }

    @Test
    public void test2() {
        Map<String, Object> map = new HashMap<>();
        map.put("lizhenhong", "LIZHENHONG");
        map.put("zhangyunzhu", "ZHANGYUNZHU");
        map.put("123", "abc");
        map.put("456", "def");
        
        //get(Object key): 获取key对应的value
        Object zhangyunzhu = map.get("zhangyunzhu");
        System.out.println(zhangyunzhu); //ZHANGYUNZHU
        
        //containsKey(Object key): 判断map中是否包含指定的key
        boolean lizhenhong = map.containsKey("lizhenhong");
        System.out.println(lizhenhong);  //true

        //containsValue(Object value): 判断map中是否包含指定的value
        boolean lizhenhong1 = map.containsValue("lizhenhong");
        System.out.println(lizhenhong1); //false
        
        //int size():map的长度
        System.out.println(map.size()); //4

        //boolean isEmpty():判断当前map是否为空
        System.out.println(map.isEmpty());  //false
        map.clear();
        System.out.println(map.isEmpty());  //true

        //boolean equals(Object obj): 判断当前的map和obj是否相等（略）
    }
    
}
