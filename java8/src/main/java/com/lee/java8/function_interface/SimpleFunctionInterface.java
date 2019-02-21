package com.lee.java8.function_interface;

/**
 * @author WangLe
 * @date 2019/2/19 14:27
 * @description
 */
@FunctionalInterface
public interface SimpleFunctionInterface {
    default void print() {
        System.out.println("hahah");
    }

    void saySomething();
}
