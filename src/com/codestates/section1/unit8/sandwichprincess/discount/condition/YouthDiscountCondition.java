package com.codestates.section1.unit8.sandwichprincess.discount.condition;

import com.codestates.section1.unit8.sandwichprincess.discount.policy.DiscountPolicy;

import java.util.Scanner;

// 2023.5.16(화) 0h30
public class YouthDiscountCondition implements DiscountCondition {
    private boolean isSatisfied;
    //    private FixedAmountDiscountPolicy fixedAmountDiscountPolicy = new FixedAmountDiscountPolicy(500); // 직접 객체 생성해서 사용 = 직접적으로 의존
    private DiscountPolicy discountPolicy;

    public YouthDiscountCondition(DiscountPolicy discountPolicy) {
        this.discountPolicy = discountPolicy;
    }

    @Override
    public boolean isSatisfied() {
        return isSatisfied;
    }

    private void setSatisfied(boolean satisfied) {
        isSatisfied = satisfied;
    }

    @Override
    public void checkDiscountCondition() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("나이가 어떻게 되십니까? > ");
        int input = Integer.parseInt(scanner.nextLine());
        setSatisfied(input < 20);
    }

    @Override
    public int applyDiscount(int price) {
        return discountPolicy.calculateDiscountedPrice(price);
    }
}
