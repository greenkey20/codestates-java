package com.codestates.section1.unit8.sandwichprincess.order;

import com.codestates.section1.unit8.sandwichprincess.discount.Discount;

import static com.codestates.section1.unit8.sandwichprincess.common.Utils.printLine;

// 2023.5.15(월) 23h15
public class Order {
    private Cart cart;
    //    private DiscountCondition[] discountConditions;
    private Discount discount;

    public Order(Cart cart, Discount discount) {
        this.cart = cart;
        this.discount = discount;
    }

    public void placeOrder() {
//        StudentDiscountCondition studentDiscountCondition = new StudentDiscountCondition(new FixedRateDiscountPolicy(10.0)); // 직접 객체 생성해서 사용 = 직접적으로 의존
//        YouthDiscountCondition youthDiscountCondition = new YouthDiscountCondition(new FixedAmountDiscountPolicy(500)); // 직접 객체 생성해서 사용 = 직접적으로 의존
//        studentDiscountCondition.checkDiscountCondition();
//        youthDiscountCondition.checkDiscountCondition();

        int totalPrice = cart.calculateTotalPrice();
        // 2023.5.16(화) 11h5 객체의 자율성 높이기 + 외부로부터 객체 내부로의 접근을 적절히 제한해서 객체 간의 결합도 낮춤 <- 객체의 세부적인 동작을 객체 내부로 감추고, 외부로는 객체의 메서드를 사용할 수 있는 최소한의 통로만 열어둠 = 캡슐화
        int finalPrice = discount.calculateFinalDiscountedPrice(totalPrice);

//        if (studentDiscountCondition.isSatisfied()) {
//            finalPrice = studentDiscountCondition.applyDiscount(finalPrice);
//        }

//        if (youthDiscountCondition.isSatisfied()) {
//            finalPrice = youthDiscountCondition.applyDiscount(finalPrice);
//        }

        // 2023.5.16(화) 1h50 추상화(인터페이스 생성) + 다형성 + 의존성 주입
//        for (DiscountCondition discountCondition : discountConditions) {
//            discountCondition.checkDiscountCondition();
//            if (discountCondition.isSatisfied()) finalPrice = discountCondition.applyDiscount(finalPrice);
//        }

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
