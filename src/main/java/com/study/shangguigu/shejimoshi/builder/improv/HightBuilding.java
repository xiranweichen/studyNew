package com.study.shangguigu.shejimoshi.builder.improv;

/**
 * @description: 高楼
 * @date: 2020/6/16 18:56
 * @author: lizhenhong
 */
public class HightBuilding extends HouseBuilder {
    @Override
    public void buildBasic() {
        System.out.println("高楼打地基50m");
    }

    @Override
    public void buildWall() {
        System.out.println("高楼砌墙20cm");
    }

    @Override
    public void roofed() {
        System.out.println("高楼-透明屋顶");
    }
}
