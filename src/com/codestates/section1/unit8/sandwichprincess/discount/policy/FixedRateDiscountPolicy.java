package com.codestates.section1.unit8.sandwichprincess.discount.policy;

// 2023.5.16(화) 0h15
public class FixedRateDiscountPolicy {
    private double discountRate;

    public FixedRateDiscountPolicy(double discountRate) {
        this.discountRate = discountRate;
    }

    public int calculateDiscountedPrice(int price) {
        return (int) (price * (1 - discountRate / 100));
    }
}
