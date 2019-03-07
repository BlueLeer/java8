package com.lee.java8.optional;


import java.util.Optional;

/**
 * @author WangLe
 * @date 2019/2/22 14:52
 * @description 一个Optional的小练习, 关键是使用Optional的flatMap方法
 */
public class OptionalAction {
    public static void main(String[] args) {
        test();
    }

    private static void test() {
        Student s1 = new Student();
        s1.setName("王五");
        s1.setInsurance(new Insurance(100.0));

        double d = Optional.ofNullable(s1).flatMap(student -> Optional.of(student.getInsurance())).map(Insurance::getFee).orElse(0.00);
        System.out.println(d);
    }


}
