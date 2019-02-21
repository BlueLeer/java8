package com.lee.java8.function_reference;

import com.lee.java8.Apple;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * @author WangLe
 * @date 2019/2/20 10:39
 * @description 方法推导, 方法引用
 */
public class Test1 {
    public static void main(String[] args) {
        // 静态方法
        Function<Integer, String> stringFunction = String::valueOf;
        String s1 = stringFunction.apply(5);
        Function<Integer, Integer> integerIntegerFunction = stringFunction.andThen(String::length);
        Integer length = integerIntegerFunction.apply(545454);
        System.out.println(s1);
        System.out.println(length);

        System.out.println("======================================");
        // 实例方法
        String ss = "Hello";
        Function<String, Integer> function = ss::indexOf;
        Integer index = function.apply("o");
        System.out.println(index);
        System.out.println("======================================");

        // 构造方法也是个特殊的方法,也可以使用方法推导
        BiFunction<String, Long, Apple> createFunction = Apple::new;
        Apple redApple = createFunction.apply("Red", 300L);
        System.out.println(redApple);
    }
}
