package com.lee.java8.optional;

/**
 * @author WangLe
 * @date 2019/2/22 14:23
 * @description
 */
public class Student {
    private String name;
    private Insurance insurance;

    public Student() {
    }

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Insurance getInsurance() {
        return insurance;
    }

    public void setInsurance(Insurance insurance) {
        this.insurance = insurance;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", insurance=" + insurance +
                '}';
    }
}
