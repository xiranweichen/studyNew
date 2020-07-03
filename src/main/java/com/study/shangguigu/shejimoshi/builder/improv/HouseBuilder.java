package com.study.shangguigu.shejimoshi.builder.improv;

/**
 * @description: 建造者builder，抽象类
 * @date: 2020/6/16 18:54
 * @author: lizhenhong
 */
public abstract class HouseBuilder {

    protected House house = new House();

    /**
     * 建造流程
     */
    //打地基
    public abstract void buildBasic();

    //砌墙
    public abstract void buildWall();

    //封顶
    public abstract void roofed();

    //建造房子，返回结果（将产品(房子)返回）
    public House buildHouse() {
        return house;
    }
    
}
