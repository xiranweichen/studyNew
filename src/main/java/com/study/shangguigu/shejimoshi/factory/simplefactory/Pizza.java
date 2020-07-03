package com.study.shangguigu.shejimoshi.factory.simplefactory;

/**
 * @description: pizza类
 * @date: 2020/6/8 19:24
 * @author: lizhenhong
 */

public class Pizza {

    //pizza名字
    protected String name;

    //准备原材料，由于不同 的pizza不同，所以我们做成抽象方法
    public void prepare(){
        System.out.println(name + " -prepared");
    }

    public void bake() {
        System.out.println(name + " -baking");
    }

    public void cut() {
        System.out.println(name + " - cutting");
    }

    public void box() {
        System.out.println(name + " -boxing");
    }

    public String setName(String name) {
        this.name = name;
        return name;
    }
    
}
