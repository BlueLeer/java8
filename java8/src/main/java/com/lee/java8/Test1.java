package com.lee.java8;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author WangLe
 * @date 2019/1/11 9:47
 * @description lambda表达式的基础语法
 */
public class Test1 {
    public static void main(String[] args) {
        List<Apple> apples = Collections.emptyList();

        // lambda表达式的基础语法:
        /*
            (param1,param2) -> 方法体(如果方法体不是一条语句,那么需要用大括号{}括起来)
         */
        /*
        能够使用lambda表达式的前提是接口只有一个方法(default方法也可以额外包含)
         */
        apples.sort((a1, a2) -> a1.getColor().compareTo(a2.getColor()));
        apples.sort(Comparator.comparing(apple -> apple.getColor()));
        apples.sort(Comparator.comparing(Apple::getColor));
        /*
        由上到下依次为进化版本
         */
    }
}
