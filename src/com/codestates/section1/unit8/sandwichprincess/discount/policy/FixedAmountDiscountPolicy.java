package com.codestates.section1.unit8.sandwichprincess.discount.policy;

// 2023.5.16(화) 0h20
public class FixedAmountDiscountPolicy {
    private int discountAmount;

    public FixedAmountDiscountPolicy(int discountAmount) {
        this.discountAmount = discountAmount;
    }

    public int calculateDiscountedPrice(int price) {
        return price - discountAmount;
    }
}
