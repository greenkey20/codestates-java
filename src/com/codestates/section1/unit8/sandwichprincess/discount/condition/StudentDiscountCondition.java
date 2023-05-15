package com.codestates.section1.unit8.sandwichprincess.discount.condition;

import com.codestates.section1.unit8.sandwichprincess.discount.policy.FixedRateDiscountPolicy;

import java.util.Scanner;

// 2023.5.16(화) 0h25
public class StudentDiscountCondition {
    private boolean isSatisfied;
    private FixedRateDiscountPolicy fixedRateDiscountPolicy = new FixedRateDiscountPolicy(10.0);

//    public StudentDiscountCondition(boolean isSatisfied) {
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
        System.out.print("학생입니까? [1] 예 [2] 아니오 > ");
        String input = scanner.nextLine();

        if (input.equals("1")) {
            setSatisfied(true);
        } else if (input.equals("2")) { // 굳이 2일 때 처리해줘야 하나?
            setSatisfied(false);
        }
    }

    public int applyDiscount(int price) {
        return fixedRateDiscountPolicy.calculateDiscountedPrice(price);

    }
}
