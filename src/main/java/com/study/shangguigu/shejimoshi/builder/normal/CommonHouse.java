package com.study.shangguigu.shejimoshi.builder.normal;

/**
 * @description:
 * @date: 2020/6/16 18:38
 * @author: lizhenhong
 */
public class CommonHouse extends AbstractHouse {
    @Override
    public void buildBasic() {
        System.out.println("给普通房子打地基");
    }

    @Override
    public void buildWalls() {
        System.out.println("给普通房子砌墙");
    }

    @Override
    public void roofed() {
        System.out.println("给普通房子封顶");
    }
}
