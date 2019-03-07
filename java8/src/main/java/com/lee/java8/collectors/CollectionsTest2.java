package com.lee.java8.collectors;

import com.lee.java8.streams.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author WangLe
 * @date 2019/2/25 14:30
 * @description
 */
public class CollectionsTest2 {
    private static List<Dish> menu = Arrays.asList(
            new Dish("凉拌黄瓜", 350),
            new Dish("凉拌黄瓜", 180),
            new Dish("酸辣土豆片", 350),
            new Dish("清炒时蔬", 600),
            new Dish("清炒时蔬", 100),
            new Dish("白开水", 0),
            new Dish("白开水", 0),
            new Dish("可乐", 300)
    );

    public static void main(String[] args) {
        testCurrentGroup();
        testCurrentGroup2();
        joining();

    }

    /**
     * 并发进行分组
     */
    private static void testCurrentGroup() {
        System.out.println("testCurrentGroup");
        Optional.of(menu.stream().collect(Collectors.groupingByConcurrent(Dish::getCalories))).ifPresent(System.out::println);
    }

    private static void testCurrentGroup2() {
        System.out.println("testCurrentGroup2");
        Optional.of(menu.stream().collect(Collectors.groupingByConcurrent(Dish::getName, Collectors.summingInt(Dish::getCalories)))).ifPresent(System.out::println);
    }

    private static void joining() {
        System.out.println("joining");
        Optional.of(menu.stream().map(dish -> dish.getName()).collect(Collectors.joining())).ifPresent(System.out::println);
        // 字符串连接,用上分号进行字符串连接
        Optional.of(menu.stream().map(dish -> dish.getName()).collect(Collectors.joining(";"))).ifPresent(System.out::println);
    }
}
