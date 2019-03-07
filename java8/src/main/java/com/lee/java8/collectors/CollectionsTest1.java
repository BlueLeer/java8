package com.lee.java8.collectors;

import com.lee.java8.Apple;
import com.lee.java8.streams.Dish;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

/**
 * @author WangLe
 * @date 2019/2/22 16:45
 * @description
 */
public class CollectionsTest1 {

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
//        averageValueAndGroup();
//        groupAndThen();
        testSummarizingInt();
    }

    /**
     * 分组和求平均值
     */
    private static void averageValueAndGroup() {
        List<Apple> apples = Arrays.asList(new Apple("red", 130L), new Apple("red", 200L), new Apple("green", 150L));
        // 调用Stream的collect方法,根据颜色进行分组
        Map<String, List<Apple>> collect = apples.stream().collect(Collectors.groupingBy(new Function<Apple, String>() {
            @Override
            public String apply(Apple s) {
                return s.getColor();
            }
        }));
        collect.forEach((s, list) -> System.out.println(s + " -> " + list.toString()));


        // 求重量的平均值
        Double averagingResult = apples.stream().collect(Collectors.averagingLong(apple -> apple.getWeight()));
        System.out.println(averagingResult);

        // 求重量的最大值
        Optional<Apple> collect1 = apples.stream().collect(Collectors.maxBy(Comparator.comparing(Apple::getWeight)));
        System.out.println(collect1.get());
    }

    private static void groupAndThen() {
        // 先分组,然后对每一个组中的list再执行一次collect操作
//        Optional.of(menu.stream().collect(Collectors.groupingBy(dish -> dish.getName(), Collectors.averagingInt(Dish::getCalories)))).ifPresent(System.out::println);

        TreeMap<String, Integer> collect = menu.stream().collect(Collectors.groupingBy(Dish::getName, TreeMap::new, Collectors.summingInt(value -> value.getCalories())));

        System.out.println(collect);
    }

    /**
     * 总结list当中的值
     */
    private static void testSummarizingInt() {
        Optional.of(menu.stream().collect(Collectors.summarizingInt(Dish::getCalories))).ifPresent(System.out::println);
        /*
            结果为:
                  IntSummaryStatistics{count=8, sum=1880, min=0, average=235.000000, max=600}
         */
    }
}
