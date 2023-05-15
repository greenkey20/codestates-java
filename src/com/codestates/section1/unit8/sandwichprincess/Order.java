package com.codestates.section1.unit8.sandwichprincess;

import static com.codestates.section1.unit8.sandwichprincess.common.Utils.printLine;

// 2023.5.15(월) 23h15
public class Order {
    private Cart cart;

    public Order(Cart cart) {
        this.cart = cart;
    }

    public void placeOrder() {
        System.out.println("[✅] 주문이 완료되었습니다");
        System.out.println("[✅] 주문 내역은 다음과 같습니다");
        printLine();
        // 주문 내역 상세 출력
        printLine();

        System.out.printf("[💲] 금액 합계 : %d원\n", );

    }
}
