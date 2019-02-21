package com.lee.java8.function_interface;

import com.lee.java8.Apple;

import java.util.function.Supplier;

/**
 * @author WangLe
 * @date 2019/2/19 16:12
 * @description Supplier:提供者
 */
public class SupplierTest {
    public static void main(String[] args) {
        Apple apple = createApple(() -> new Apple("Blue", 145L));
        System.out.println(apple);
    }

    private static Apple createApple(Supplier<Apple> supplier) {
        return supplier.get();
    }
}
