package com.study.shangguigu.shejimoshi.yuanxing.deepClone;

import org.junit.Test;

/**
 * @description: 测试深克隆
 * @date: 2020/6/9 19:43
 * @author: lizhenhong
 */
public class Client {

    /**
     * 用方式一：使用重写clone方法的方式完成深拷贝
     * @throws CloneNotSupportedException
     */
    @Test
    public void testDeepClone() throws CloneNotSupportedException {
        DeepProtoType p = new DeepProtoType();
        p.setName("zhangyunzhu");
        DeepCloneableTarget deepCloneableTarget = new DeepCloneableTarget("lizhenhong", "Class");
        p.setDeepCloneableTarget(deepCloneableTarget);
        //完成深拷贝
        DeepProtoType p2 = (DeepProtoType) p.clone();
        System.out.println("p.name = " + p.getName() + ", p.deepCloneableTarget = " + p.getDeepCloneableTarget().hashCode());  //p.name = zhangyunzhu, p.deepCloneableTarget = 1642360923
        System.out.println("p2.name = " + p2.getName() + ", p2.deepCloneableTarget = " + p2.getDeepCloneableTarget().hashCode()); //p2.name = zhangyunzhu, p2.deepCloneableTarget = 1343441044
    }

    /**
     * 使用方式二：通过对象的序列化实现的方式实现深克隆
     */
    @Test
    public void testMethod() {
        DeepProtoType p = new DeepProtoType();
        p.setName("yunzhu");
        p.setDeepCloneableTarget(new DeepCloneableTarget("lizhenhong", "javaClass"));
        DeepProtoType p2 = (DeepProtoType) p.deepClone();

        System.out.println("p.name = " + p.getName() + ", p.deepCloneableTarget = " + p.getDeepCloneableTarget().hashCode());  //p.name = yunzhu, p.deepCloneableTarget = 233530418
        System.out.println("p2.name = " + p2.getName() + ", p2.deepCloneableTarget = " + p2.getDeepCloneableTarget().hashCode());//p2.name = yunzhu, p2.deepCloneableTarget = 1361960727
    }


}
