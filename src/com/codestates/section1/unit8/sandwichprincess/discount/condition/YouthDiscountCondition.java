package com.codestates.section1.unit8.sandwichprincess.discount.condition;

import com.codestates.section1.unit8.sandwichprincess.discount.policy.FixedAmountDiscountPolicy;

import java.util.Scanner;

// 2023.5.16(화) 0h30
public class YouthDiscountCondition {
    private boolean isSatisfied;
    private FixedAmountDiscountPolicy fixedAmountDiscountPolicy = new FixedAmountDiscountPolicy(500);

//    public YouthDiscountCondition(boolean isSatisfied) {
//        this.isSatisfied = isSatisfied;
//    }

    public boolean isSatisfied() {
        return isSatisfied;
    }

    private void setSatisfied(boolean satisfied) {
        isSatisfied = satisfied;
    }

    public void checkDiscountCondition() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("나이가 어떻게 되십니까? > ");
        int input = Integer.parseInt(scanner.nextLine());
        setSatisfied(input < 20);
    }

    public int applyDiscount(int price) {
        return fixedAmountDiscountPolicy.calculateDiscountedPrice(price);
    }
}
