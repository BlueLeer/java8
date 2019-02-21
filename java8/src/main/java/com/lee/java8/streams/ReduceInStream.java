package com.lee.java8.streams;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;

/**
 * @author WangLe
 * @date 2019/2/21 16:34
 * @description
 */
public class ReduceInStream {
    public static void main(String[] args) {
        Integer[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        Stream<Integer> stream = Arrays.stream(nums);

        // 获取最大值
        Optional<Integer> optional = stream.reduce(new BinaryOperator<Integer>() {
            @Override
            public Integer apply(Integer integer, Integer integer2) {
                return integer > integer2 ? integer : integer2;
            }
        });
        Integer maxInteger = optional.get();
        System.out.println(maxInteger);

        // 取得最小值
        stream = Arrays.stream(nums);
        stream.reduce((a, b) -> Integer.min(a, b)).ifPresent(System.out::println);
    }
}
