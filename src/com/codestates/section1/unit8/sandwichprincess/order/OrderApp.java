package com.codestates.section1.unit8.sandwichprincess.order;

import com.codestates.section1.unit8.sandwichprincess.discount.condition.DiscountCondition;
import com.codestates.section1.unit8.sandwichprincess.discount.condition.StudentDiscountCondition;
import com.codestates.section1.unit8.sandwichprincess.discount.condition.YouthDiscountCondition;
import com.codestates.section1.unit8.sandwichprincess.discount.policy.FixedAmountDiscountPolicy;
import com.codestates.section1.unit8.sandwichprincess.discount.policy.FixedRateDiscountPolicy;
import com.codestates.section1.unit8.sandwichprincess.product.Menu;
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

        // 2023.5.15(월) 0h5
        Cart cart = new Cart(productRepository, menu);

        // 2023.5.16(화) 0h5
        Order order = new Order(cart, new DiscountCondition[]{
                new StudentDiscountCondition(new FixedRateDiscountPolicy(10.0)),
                new YouthDiscountCondition(new FixedAmountDiscountPolicy(500))
        });

        while (true) {
            // 메뉴 출력
            menu.printMenu();

            // 사용자 입력받기
            String input = scanner.nextLine();

            if (input.equals("+")) {
                // 주문 내역 출력
                order.placeOrder();
                break;
            } else if (input.equals("0")) {
                // 장바구니 출력
                cart.printCart();
            } else { // 사용자 입력 == 1 ~ 메뉴 마지막 번호
                int productIdChosen = Integer.parseInt(input);
                // 사용자가 고른 상품의 옵션 보여주고 고르게 함 = menu.chooseOption() = addToCart() 안에서 호출됨
                // 장바구니에 담기
                cart.addToCart(productIdChosen);
            }
        }


    }
}