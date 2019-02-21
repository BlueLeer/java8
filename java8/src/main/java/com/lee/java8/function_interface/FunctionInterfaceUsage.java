package com.lee.java8.function_interface;

/**
 * @author WangLe
 * @date 2019/2/19 14:33
 * @description Function Interface 的使用
 */
public class FunctionInterfaceUsage {
    public static void main(String[] args) {
        SimpleFunctionInterface simpleFunctionInterface = () -> System.out.println("Hello");
        process(simpleFunctionInterface);

        process(() -> System.out.println("Hello"));
    }

    private static void process(SimpleFunctionInterface function) {
        function.saySomething();
    }
}
