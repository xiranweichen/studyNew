package com.study.shangguigu.shejimoshi.builder.improv;

/**
 * @description: 普通房子
 * @date: 2020/6/16 18:56
 * @author: lizhenhong
 */
public class CommonHouse extends HouseBuilder{
    @Override
    public void buildBasic() {
        System.out.println("给普通房子打5m地基");
    }

    @Override
    public void buildWall() {
        System.out.println("给普通房子砌墙10cm");
    }

    @Override
    public void roofed() {
        System.out.println("给普通房子盖屋顶");
    }
}
