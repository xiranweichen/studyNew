package com.study.shangguigu.basic.oneInterfaceManyImpl;

/**
 * @author lizhenhong
 * @Description:
 * @date 2020/6/6 16:32
 */
public class SalaryInfo {

    public static void main(String[] args) {
        SalaryForPresdentImpl presdent = new SalaryForPresdentImpl();
        presdent.getSalart(1);
        SalaryForTeacherImpl teacher = new SalaryForTeacherImpl();
        teacher.getSalart(2);

    }

}
