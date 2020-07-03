package com.study.shangguigu.shejimoshi.yuanxing.improve;

import org.junit.Test;

/**
 * @description:
 * @date: 2020/6/9 19:06
 * @author: lizhenhong
 */
public class Client {

    @Test
    public void testImprove() throws CloneNotSupportedException {
        Sheep sheep = new Sheep("tom", 1, "白色");
        Sheep clone1 = (Sheep) sheep.clone();
        Sheep clone2 = (Sheep) sheep.clone();
        Sheep clone3 = (Sheep) sheep.clone();
        Sheep clone4 = (Sheep) sheep.clone();
        Sheep clone5 = (Sheep) sheep.clone();
        Sheep clone6 = (Sheep) sheep.clone();
        Sheep clone7 = (Sheep) sheep.clone();
        Sheep clone8 = (Sheep) sheep.clone();
        Sheep clone9 = (Sheep) sheep.clone();
        Sheep clone10 = (Sheep) sheep.clone();

        System.out.println("下面是用原型模式输出的克隆羊");
        System.out.println(clone1);
        System.out.println(clone2);
        System.out.println(clone3);
        System.out.println(clone4);
        System.out.println(clone5);
        System.out.println(clone6);
        System.out.println(clone7);
        System.out.println(clone8);
        System.out.println(clone9);
        System.out.println(clone10);
        
    }
    
}
