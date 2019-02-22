package com.lee.java8.streams;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author WangLe
 * @date 2019/2/22 10:23
 * @description IntStream/DoubleStream等数字类型的Stream的简单使用 IntStream和DoubleStream操作类似
 */
public class NumericStream {
    public static void main(String[] args) {
        intStreamTest();
    }

    /**
     * 对象类型的Stream和IntStream之间的转化,以及IntStream的常用操作
     */
    private static void intStreamTest() {
        Integer[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        Stream<Integer> intStream = Arrays.stream(array);
        // 将对象类型的Integer的Stream转化为IntStream类型的Stream
        IntStream intStream1 = intStream.mapToInt(i -> i.intValue());
        // 求和
        int sum = intStream1.filter(i -> i % 2 == 0).sum();
        System.out.println(sum);
        System.out.println("========================================");
        // 将IntStream转化为对象类型的Stream
//        Stream<Integer> boxed = intStream1.boxed();


        // 给定三角形的一条边,另一条边在1至100中选择出来,构成一个直角三角形
        int a = 9;
        IntStream.rangeClosed(1, 100)
                .filter(b -> Math.sqrt(a * a + b * b) % 1 == 0)
                .boxed()
                .map(integer -> new Integer[]{integer, a, (int) Math.sqrt(integer * integer + a * a)})
                .forEach(integers -> System.out.println("a=" + integers[0] + ",b=" + integers[1] + ",c=" + integers[2]));

    }
}
