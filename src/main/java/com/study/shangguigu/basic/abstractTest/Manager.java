package com.study.shangguigu.basic.abstractTest;

/**
 * @author: lizhenhong
 * @description: 管理者，继承Employee
 *              对于Manager来说，既是员工，也有奖金(bonus)的属性
 * @date: 2020/2/2 16:19
 */
public class Manager extends Employee {

    private double bonus;  //奖金

    public Manager(double bonus) {
        this.bonus = bonus;
    }

    public Manager(String name, int age, double salary, double bonus) {
        super(name, age, salary);
        this.bonus = bonus;
    }

    //重写Employee中的work()方法
    @Override
    public void work() {
        System.out.println("管理者能管理员工");
    }

    public static void main(String[] args) {
        Manager manager = new Manager(1);
        manager.work();
    }

}
