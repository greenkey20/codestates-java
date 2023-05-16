package com.codestates.section1.unit8.sandwichprincess;
// 자바에서는 원칙적으로 default 패키지의 클래스들을 다른 클래스에서 import 할 수 없음 -> 다른 클래스에서 사용할 예정이라면 클래스들을 일단 하나의 패키지 안에 포함시켜주는 것이 좋음

import com.codestates.section1.unit8.sandwichprincess.common.AppConfigurer;
import com.codestates.section1.unit8.sandwichprincess.order.OrderApp;

// 2023.5.11(목) 22h20 oop 심화 실습
public class Main {
    public static void main(String[] args) {
        AppConfigurer appConfigurer = new AppConfigurer();
        OrderApp orderApp = new OrderApp(
                appConfigurer.productRepository(),
                appConfigurer.menu(),
                appConfigurer.cart(), // 2023.5.16(화) 11h55 현재 여기서 할당되는 Cart 인스턴스와
                appConfigurer.order() // 여기서 할당되는 Cart 인스턴스가 다름 -> 주문 시 장바구니 내역이 보이지 않음
        );

        orderApp.view();
    }
}
