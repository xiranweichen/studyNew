package com.study.shangguigu.basic.reflection.exer;

/**
 * @author lizhenhong
 * @Description:
 * @date 2020/5/17 15:41
 */
public class Student4 {

    private String name;
    private int age;
    public char gender;
    private int grade;

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

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public void show() {
        System.out.println("这里是Student4.class的show()方法！");
    }

    @Override
    public String toString() {
        return "Student4{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", grade=" + grade +
                '}';
    }
}
