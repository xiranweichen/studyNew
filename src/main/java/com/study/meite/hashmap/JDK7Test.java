package com.study.meite.hashmap;

import com.study.meite.hashmap.ext.JDK7ExtHashMap;
import org.junit.Test;

/**
 * @author lizhenhong
 * @Description:
 * @date 2020/7/11 10:19
 */
public class JDK7Test {

    @Test
    public void test() {
        JDK7ExtHashMap extHashMap = new JDK7ExtHashMap<String, String>();
        extHashMap.put("1号", "1号");// 0
        extHashMap.put("2号", "1号");// 1
        extHashMap.put("3号", "1号");// 2
        extHashMap.put("4号", "1号");// 3
        extHashMap.put("6号", "1号");// 4
        extHashMap.put("7号", "1号");
        extHashMap.put("14号", "1号");

        extHashMap.put("22号", "1号");
        extHashMap.put("26号", "1号");
        extHashMap.put("27号", "1号");
        extHashMap.put("28号", "1号");
        extHashMap.put("66号", "66");
        extHashMap.put("30号", "1号");
        System.out.println("扩容前数据....");
        extHashMap.print();
        System.out.println("扩容后数据....");
        extHashMap.put("31号", "1号");
        extHashMap.put("66号", "123466666");
        extHashMap.print();
        // 修改3号之后
        System.out.println(extHashMap.get("66号"));
        // System.out.println("扩容之前获取数据:" + extHashMap.get("1号"));
        // extHashMap.print();
        // System.out.println();
        // // extHashMap.put(14 + "号", 14 + "号");
        // // extHashMap.put(1 + "号", "4444号");
        // System.out.println("扩容之后获取数据:" + extHashMap.get("1号"));
        // extHashMap.print();
    }

}
