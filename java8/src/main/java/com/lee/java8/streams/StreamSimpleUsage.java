package com.lee.java8.streams;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author WangLe
 * @date 2019/2/20 16:14
 * @description stream的简单使用示例
 * <p>
 * 需求: 找出卡路里小于400的食物,并根据卡路里的数量进行顺序排列,打印出食物名称
 */
public class StreamSimpleUsage {
    public static void main(String[] args) {
        List<Dish> menu = Arrays.asList(
                new Dish("西红柿炒鸡蛋", 350),
                new Dish("凉拌黄瓜", 180),
                new Dish("酸辣土豆片", 350),
                new Dish("红烧排骨", 600),
                new Dish("清炒时蔬", 100),
                new Dish("白开水", 0),
                new Dish("可乐", 300)
        );

        System.out.println(getMenu(menu));
        System.out.println("====================");
        System.out.println(getMenuWithStream(menu));

    }

    /**
     * 传统方法
     *
     * @param menu
     * @return
     */
    private static List<String> getMenu(List<Dish> menu) {
        List<Dish> rawMenu = new ArrayList<>();
        for (Dish d : menu) {
            if (d.getCalories() < 400) {
                rawMenu.add(d);
            }
        }

        Collections.sort(rawMenu, Comparator.comparing(Dish::getCalories));

        List<String> resultMenu = new ArrayList<>();
        for (Dish d : rawMenu) {
            resultMenu.add(d.getName());
        }

        return resultMenu;
    }

    /**
     * 使用stream来过滤
     *
     * @param menu
     * @return
     */
    private static List<String> getMenuWithStream(List<Dish> menu) {
        return menu.stream()
                .filter(dish -> dish.getCalories() < 400)
                .sorted(Comparator.comparing(Dish::getCalories))
                .map(Dish::getName)
                .collect(Collectors.toList());
    }
}
