package com.lee.java8.collectors;

import com.lee.java8.streams.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author WangLe
 * @date 2019/2/25 14:51
 * @description
 */
public class CollectionsTest3 {
    private static List<Dish> menu = Arrays.asList(
            new Dish("西红柿炒鸡蛋", 350),
            new Dish("凉拌黄瓜", 180),
            new Dish("酸辣土豆片", 350),
            new Dish("红烧排骨", 600),
            new Dish("清炒时蔬", 100),
            new Dish("白开水", 0),
            new Dish("白开水", 0),
            new Dish("可乐", 300)
    );

    public static void main(String[] args) {
//        testPartitioningBy();
//        testReducing();
        testReducing2();
    }

    /**
     * 按照一定的条件进行分区
     */
    private static void testPartitioningBy() {
        Optional.of(menu.stream().collect(Collectors.partitioningBy(dish -> dish.getCalories() > 300))).ifPresent(System.out::println);
    }

    private static void testReducing() {
        menu.stream().collect(Collectors.reducing((dish, dish2) -> new Dish(dish.getName() + dish2.getName(), dish.getCalories() + dish2.getCalories()))).ifPresent(System.out::println);
    }

    private static void testReducing2() {
        Integer collect = menu.stream().map(Dish::getCalories).reduce(0, (d1, d2) -> d1 + d2);
        System.out.println(collect);

    }
}

