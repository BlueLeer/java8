package com.lee.java8.function_interface;

import com.lee.java8.Apple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.LongPredicate;
import java.util.function.Predicate;

/**
 * @author WangLe
 * @date 2019/1/11 11:05
 * @description 使用Predicate, 类似的还有IntPredicate, DoublePredicate, ShortPredicate等等
 * 注意:Predicate和IntPredicate等其他的没有什么直接的关系,他们的区别是test方法中接收的参数的类型是不一样的
 * 例如IntPredicate接收的参数只能是int类型的
 */
public class PredicateTest {
    public static void main(String[] args) {
        List<Apple> apples = Arrays.asList(new Apple("red", 120L), new Apple("red", 140L), new Apple("green", 180L));
        // 使用Predicate
        List<Apple> apples1 = filter1(apples, apple -> apple.getColor().equals("red"));
        System.out.println(apples1);
        // Predicate(诊断/断言)
        List<Apple> apples2 = filter2(apples, w -> w > 130L);
        System.out.println(apples2);

        List<Apple> apples3 = filter3(apples, (color, weight) -> color.equalsIgnoreCase("red") && weight > 130);
        System.out.println(apples3);

    }

    // 使用Predicate
    private static List<Apple> filter1(List<Apple> source, Predicate<Apple> predicate) {

        List<Apple> result = new ArrayList<>();
        for (Apple a : source) {
            if (predicate.test(a)) {
                result.add(a);
            }
        }

        return result;
    }

    // 使用LongPredicate
    private static List<Apple> filter2(List<Apple> source, LongPredicate intPredicate) {
        List<Apple> newResult = new ArrayList<>();
        for (Apple apple : source) {
            if (intPredicate.test(apple.getWeight())) {
                newResult.add(apple);
            }
        }

        return newResult;
    }

    // BiPredicate是接收两个参数,相比于Predicate的区别是test方法接收一个参数和两个参数的区别
    private static List<Apple> filter3(List<Apple> source, BiPredicate<String, Long> biPredicate) {
        List<Apple> newResult = new ArrayList<>();
        for (Apple a : source) {
            if (biPredicate.test(a.getColor(), a.getWeight())) {
                newResult.add(a);
            }
        }

        return newResult;
    }
}
