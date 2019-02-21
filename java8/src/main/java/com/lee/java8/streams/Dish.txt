package com.lee.java8.streams;

import java.util.Objects;

/**
 * @author WangLe
 * @date 2019/2/20 16:12
 * @description 食物
 */
public class Dish {
    private String name;
    private Integer calories;

    public Dish() {
    }

    public Dish(String name, Integer calories) {
        this.name = name;
        this.calories = calories;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCalories() {
        return calories;
    }

    public void setCalories(Integer calories) {
        this.calories = calories;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "name='" + name + '\'' +
                ", calories=" + calories +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dish dish = (Dish) o;
        return Objects.equals(name, dish.name) &&
                Objects.equals(calories, dish.calories);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, calories);
    }
}
