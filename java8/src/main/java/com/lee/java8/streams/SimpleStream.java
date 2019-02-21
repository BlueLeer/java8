package com.lee.java8.streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * @author WangLe
 * @date 2019/2/21 11:02
 * @description stream的一些常用方法介绍
 */
public class SimpleStream {
    public static void main(String[] args) {
        List<Dish> menu = Arrays.asList(
                new Dish("西红柿炒鸡蛋", 350),
                new Dish("凉拌黄瓜", 180),
                new Dish("酸辣土豆片", 350),
                new Dish("红烧排骨", 600),
                new Dish("清炒时蔬", 100),
                new Dish("白开水", 0),
                new Dish("白开水", 0),
                new Dish("可乐", 300)
        );

        /*
        menu.stream()
                // 将menu中每一个元素转化成一个新的stream
                .flatMap((Function<Dish, Stream<?>>) dish -> Stream.of(dish.getName(), dish.getCalories()))
                // forEach操作是一个terminal operation(终端操作),也就是说执行完次操作以后stream就不能再使用了
                .forEach(o -> {
                    System.out.println(o);
                    System.out.println("==========");
                });

        // distinct是去重操作,当且仅当 equals()方法返回true时才会执行去重操作
        menu.stream().distinct().forEach(System.out::println);

        // 其中只要任何一个满足
        boolean allMatch = menu.stream().anyMatch(dish -> dish.getName().equals("白开水"));
        System.out.println(allMatch);
       */

        menu.stream().peek(dish -> System.out.println(dish.getName() + ":")).forEach(System.out::println);
    }
}
