package com.study.shangguigu.shejimoshi.builder.improv;

/**
 * @description: 指挥者,指定制作流程，返回具体产品
 * @date: 2020/6/16 18:57
 * @author: lizhenhong
 */
public class HouseDirector {

    HouseBuilder builder = null;

    //通过构造器传入huilder
    public HouseDirector(HouseBuilder builder) {
        this.builder = builder;
    }
    
    //通过setter方法传入builder
    public void setBuilder(HouseBuilder builder) {
        this.builder = builder;
    }

    //把如何建造房子的流程交给指挥者
    public House constructHouse() {
        builder.buildBasic();
        builder.buildWall();
        builder.roofed();
        return builder.buildHouse();
    }
    
    
}
