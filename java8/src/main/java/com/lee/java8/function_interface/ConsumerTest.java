package com.lee.java8.function_interface;

import com.lee.java8.Apple;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

/**
 * @author WangLe
 * @date 2019/1/11 11:33
 * @description
 */
public class ConsumerTest {
    public static void main(String[] args) {
        List<Apple> apples = Arrays.asList(new Apple("red", 130L), new Apple("red", 200L), new Apple("green", 150L));
        process(apples, apple -> apple.setColor(">" + apple.getColor() + "<"));
        System.out.println(apples);

        String label = "精品";
        process2(label, apples, (apple, s) -> apple.setColor(apple.getColor() + "(" + label + ")"));
        System.out.println(apples);
    }

    private static void process(List<Apple> list, Consumer<Apple> consumer) {
        for (Apple a : list) {
            // 对每一个Apple对象进行加工处理
            consumer.accept(a);
        }
    }

    private static void process2(String label, List<Apple> list, BiConsumer<Apple, String> consumer) {
        // 模仿对每一个苹果贴上标签
        for (Apple a : list) {
            consumer.accept(a, label);
        }
    }
}
