package com.study.shangguigu.basic.oneInterfaceManyImpl;

/**
 * @author lizhenhong
 * @Description:
 * @date 2020/6/6 16:31
 */
public class SalaryForPresdentImpl implements Salary {
    @Override
    public void getSalart(int num) {
        System.out.println("这里是计算-校长工资-的实现类");
        System.out.println("校长的工号是:" + num);
    }
}
