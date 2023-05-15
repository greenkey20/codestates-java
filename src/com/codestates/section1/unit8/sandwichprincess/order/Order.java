package com.codestates.section1.unit8.sandwichprincess.order;

import com.codestates.section1.unit8.sandwichprincess.discount.condition.YouthDiscountCondition;
import com.codestates.section1.unit8.sandwichprincess.discount.condition.StudentDiscountCondition;
import com.codestates.section1.unit8.sandwichprincess.discount.policy.FixedAmountDiscountPolicy;
import com.codestates.section1.unit8.sandwichprincess.discount.policy.FixedRateDiscountPolicy;

import static com.codestates.section1.unit8.sandwichprincess.common.Utils.printLine;

// 2023.5.15(월) 23h15
public class Order {
    private Cart cart;

    public Order(Cart cart) {
        this.cart = cart;
    }

    public void placeOrder() {
        StudentDiscountCondition studentDiscountCondition = new StudentDiscountCondition(new FixedRateDiscountPolicy(10.0)); // 직접 객체 생성해서 사용 = 직접적으로 의존
        YouthDiscountCondition youthDiscountCondition = new YouthDiscountCondition(new FixedAmountDiscountPolicy(500)); // 직접 객체 생성해서 사용 = 직접적으로 의존
        studentDiscountCondition.checkDiscountCondition();
        youthDiscountCondition.checkDiscountCondition();

        int totalPrice = cart.calculateTotalPrice();
        int finalPrice = totalPrice;

        if (studentDiscountCondition.isSatisfied()) {
            finalPrice = studentDiscountCondition.applyDiscount(finalPrice);
        }

        if (youthDiscountCondition.isSatisfied()) {
            finalPrice = youthDiscountCondition.applyDiscount(finalPrice);
        }

        System.out.println("[✅] 주문이 완료되었습니다");
        System.out.println("[✅] 주문 내역은 다음과 같습니다");
        printLine();
        // 주문 내역 상세 출력
        cart.printCartItemsDetail();
        printLine();

        System.out.printf("[💲] 금액 합계 : %d원\n", totalPrice);
        System.out.printf("[💲] 할인 적용 금액 : %d원\n", finalPrice);

    }
}
