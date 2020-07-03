package com.study.shangguigu.basic.reflection.exer;

/**
 * @author lizhenhong
 * @Description:
 * @date 2020/5/17 15:39
 */
public class Student2 {

    private String name;
    private int age;
    public int grade;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student2{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", grade=" + grade +
                '}';
    }
}
