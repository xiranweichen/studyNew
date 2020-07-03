package com.study.shangguigu.shejimoshi.builder.normal;

/**
 * @description:
 * @date: 2020/6/16 18:37
 * @author: lizhenhong
 */
public abstract class AbstractHouse {

    //打地基
    public abstract void buildBasic();

    //砌墙
    public abstract void buildWalls();

    //封顶
    public abstract void roofed();

    //用一个方法将三个流程合并
    public void build() {
        buildBasic();
        buildWalls();
        roofed();
    }
    
}
