package com.lee.java8;

/**
 * @author WangLe
 * @date 2019/1/11 10:08
 * @description lambda表达式语法
 */
public class Test2 {
    public static void main(String[] args) {
        /*
        不带返回值的:
        方式一:
            (parameters) -> {statements};
         */
        TestFunction testFunction = i -> {
            System.out.println(i);
            System.out.println(i * i);
        };

        /*
        不带返回值的:
        方式二:
            (parameters) -> statement
         */
        TestFunction testFunction1 = (i) -> System.out.println(i * 2);


        /*
        带返回值的
        方式一:
            (parameters) -> {
                return ....;
            }

            // 也就是说后面的方法体如果被大括号{}包裹起来的,就需要使用return
         */
        TestFunction2 testFunction2 = (a, b) -> {
            return a + b;
        };

        /*
        带返回值的:
        方式二:
            (parameters) -> statement
            也就是说:如果没有带大括号,则在方法体中直接写上返回值即可
         */
        TestFunction2 testFunction22 = (a, b) -> a * b;


    }


    @FunctionalInterface // 标记它是一个方法接口
    public interface TestFunction {
        void func(Integer i);
    }

    @FunctionalInterface
    public interface TestFunction2 {
        Integer add(Integer a, Integer b);
    }
}
