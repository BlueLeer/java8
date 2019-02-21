package com.lee.java8;

/**
 * @author WangLe
 * @date 2019/1/11 9:53
 * @description
 */
public class Apple {
    // 颜色
    private String color;
    // 重量
    private Long weight;

    public Apple(String color, Long weight) {
        this.color = color;
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Long getWeight() {
        return weight;
    }

    public void setWeight(Long weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "color='" + color + '\'' +
                ", weight=" + weight +
                '}';
    }
}
