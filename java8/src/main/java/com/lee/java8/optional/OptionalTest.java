package com.lee.java8.optional;

import java.util.Optional;

/**
 * @author WangLe
 * @date 2019/2/22 11:16
 * @description
 */
public class OptionalTest {
    public static void main(String[] args) {
        // Optional包装了一个空的对象,使用get方法获取该对象会报NoSuchElementException错误
//        Optional<Student> s1 = Optional.empty();
//        System.out.println(s1.get());

//        Optional<Student> s2 = Optional.of(new Student());
//        System.out.println(s2.get());

//        Optional<Student> s3 = Optional.ofNullable(null);
//        // 如果存在就打印出来,里面使用的是一个Consumer
//        s3.ifPresent(System.out::println);
//        // 如果Optional中包括的对象为空,就另外给出一个
//        Student student = s3.orElse(new Student("张三"));
//        System.out.println(student);
//
//        // 如果Optional中包含的对象为空,就抛出一个异常(运行时异常)
//        s3.orElseThrow(() -> new RuntimeException("包装的对象为空"));

        optionalSimpleUsage();


    }

    /**
     * Optional常用的方法
     */
    private static void optionalSimpleUsage() {

        Student s1 = new Student();
        s1.setName("王五");
        s1.setInsurance(new Insurance(100.0));

        // 经过一层的过滤,过滤出买了保险的学生
        Student student = Optional.of(s1).filter(s -> s.getInsurance() != null).get();
        System.out.println(student);

        // 过滤出保险费的金额
        Double fee = Optional.of(s1).map(student1 -> student1.getInsurance().getFee()).get();
        System.out.println(fee);


    }
}
