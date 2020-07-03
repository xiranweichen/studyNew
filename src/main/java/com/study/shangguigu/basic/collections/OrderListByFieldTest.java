package com.study.shangguigu.basic.collections;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 根据list的对象中的某个属性实现倒叙desc排序(从大到小)
 * @date: 2020/5/29 15:54
 * @author: lizhenhong
 */
public class OrderListByFieldTest {

    @Test
    public void testSort() {
        List<MioLogPO> poList = new ArrayList<>();
        MioLogPO po1 = new MioLogPO();
        MioLogPO po2 = new MioLogPO();
        MioLogPO po3 = new MioLogPO();
        po1.setMioDate("2019-01-01");
        po1.setId("1");
        po2.setMioDate("2000-11-11");
        po2.setId("2");
        po3.setId("3");
        po3.setMioDate("2022-11-12");
        poList.add(po1);
        poList.add(po2);
        poList.add(po3);
        
        poList.sort(MioLogPO::compareTo);
        System.out.println(poList.toString());

    }
    
}
