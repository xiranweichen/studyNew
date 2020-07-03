package com.study.shangguigu.basic.oneInterfaceManyImpl;

/**
 * @author lizhenhong
 * @Description:
 * @date 2020/6/6 16:30
 */
public class SalaryForTeacherImpl implements Salary {
    @Override
    public void getSalart(int num) {
        System.out.println("这里是计算-教师工资-的实现类");
        System.out.println("教师的工号是：" + num);
    }
}
