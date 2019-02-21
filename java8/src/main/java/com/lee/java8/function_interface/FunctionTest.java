package com.lee.java8.function_interface;

import com.lee.java8.Apple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 * @author WangLe
 * @date 2019/2/19 15:56
 * @description jdk自带的Function方法接口的使用示例
 * Function<T,R> T代表输入的类型,而R代表输出的类型
 */
public class FunctionTest {
    public static void main(String[] args) {
        List<Apple> apples = Arrays.asList(new Apple("red", 130L), new Apple("red", 200L), new Apple("green", 150L));

        process(apples, apple -> new Apple(apple.getColor(), apple.getWeight() * 100));
    }

    private static void process(List<Apple> apples, Function<Apple, Apple> function) {
        List<Apple> result = new ArrayList<>();
        for (Apple a : apples) {
            Apple apply = function.apply(a);
            result.add(apply);
        }

        System.out.println(result);
    }
}
