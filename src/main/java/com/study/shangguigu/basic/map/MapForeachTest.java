package com.study.shangguigu.basic.map;

import org.junit.Test;

import java.util.*;

/**
 * @description: map的遍历
 * @date: 2020/4/4 17:06
 * @author: lizhenhong
 */
public class MapForeachTest {

    @Test
    public void test1() {
        Map<String, Object> map = new HashMap<>();
        map.put("lizhenhong", "LIZHENHONG");
        map.put("zhangyunzhu", "ZHANGYUNZHU");
        map.put("123", "abc");
        map.put("456", "def");

        //遍历所有的key集合:keySet()
        Set<String> keySet = map.keySet();
        Iterator<String> iterator = keySet.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + ",");  //zhangyunzhu,123,456,lizhenhong,
        }
        System.out.println();
        
        //遍历所有的value集合：values()
        Collection<Object> values = map.values();
        for (Object value : values) {
            System.out.print(value+",");  //ZHANGYUNZHU,abc,def,LIZHENHONG,
        }
        System.out.println();
        
        //遍历所有的key-value: entrySet()
        Set<Map.Entry<String, Object>> entrySet = map.entrySet();
        Iterator<Map.Entry<String, Object>> entry = entrySet.iterator();
        while (entry.hasNext()) {
            Map.Entry<String, Object> next = entry.next();
            System.out.print(next+",");  //zhangyunzhu=ZHANGYUNZHU,123=abc,456=def,lizhenhong=LIZHENHONG,
        }


    }
    
}
