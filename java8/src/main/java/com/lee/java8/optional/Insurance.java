package com.lee.java8.optional;

/**
 * @author WangLe
 * @date 2019/2/22 14:21
 * @description
 */
public class Insurance {
    private Double fee;

    public Insurance(Double fee) {
        this.fee = fee;
    }

    public Insurance() {
    }

    public Double getFee() {
        return fee;
    }

    public void setFee(Double fee) {
        this.fee = fee;
    }

    @Override
    public String toString() {
        return "Insurance{" +
                "fee=" + fee +
                '}';
    }
}
