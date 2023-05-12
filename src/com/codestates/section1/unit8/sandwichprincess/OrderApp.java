package com.codestates.section1.unit8.sandwichprincess;

import com.codestates.section1.unit8.sandwichprincess.product.Product;
import com.codestates.section1.unit8.sandwichprincess.product.ProductRepository;

import java.util.Scanner;

// 2023.5.11(목) 23h10
public class OrderApp {
    public void view() {
        Scanner scanner = new Scanner(System.in);

        ProductRepository productRepository = new ProductRepository();
        Product[] PRODUCTS = productRepository.getAllProducts();
        Menu menu = new Menu(PRODUCTS);

        System.out.println("== 🥪 Sandwich Princess order service ==");

//        while (true) {
            // 메뉴 출력
        menu.printMenu();

            // 사용자 입력받기
        String input = scanner.nextLine();

            // if (사용자 입력 == '+') {
                // 주문 내역 출력
//                 break;
//            } else if (사용자 입력 == '0') {
                // 장바구니 출력
//            } else { // 사용자 입력 == 1 ~ 메뉴 마지막 번호
                // 사용자가 고른 상품의 옵션 보여주고 고르게 함
                // 장바구니에 담기
//            }
//        }
    }
}
