package com.study.shangguigu.shejimoshi.builder.improv;

import org.junit.Test;

/**
 * @description: 客户端
 * @date: 2020/6/16 18:58
 * @author: lizhenhong
 */
public class Client {

    @Test
    public void testCommonHouse() {
        CommonHouse commonHouse = new CommonHouse();
        //准备创建房子的指挥者
        HouseDirector houseDirector = new HouseDirector(commonHouse);
        //完成盖房子操作，返回产品(普通房子)
        House house = houseDirector.constructHouse();
        
    }

    @Test
    public void testHightBuilding() {
        HightBuilding hightBuilding = new HightBuilding();
        HouseDirector director = new HouseDirector(hightBuilding);
        director.constructHouse();
    }
    
}
