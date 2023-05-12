package com.codestates.section1.unit8.sandwichprincess;

import com.codestates.section1.unit8.sandwichprincess.product.Product;
import com.codestates.section1.unit8.sandwichprincess.product.subproduct.Drink;
import com.codestates.section1.unit8.sandwichprincess.product.subproduct.Sandwich;
import com.codestates.section1.unit8.sandwichprincess.product.subproduct.SandwichSet;
import com.codestates.section1.unit8.sandwichprincess.product.subproduct.Side;

import java.util.Scanner;

import static com.codestates.section1.unit8.sandwichprincess.common.Utils.printLine;

// 2023.5.12(금) 22h10
public class Cart {
    private Product[] cartItems = new Product[0];
    private Scanner scanner = new Scanner(System.in);

    public void printCart() {
        printLine();
        System.out.println("[장바구니]");

        // 장바구니 상품들 + 옵션 정보 출력

        System.out.printf("합계 = %d원\n", calculateTotalPrice());

        System.out.println("이전으로 돌아가려면 Enter를 누르세요");
        scanner.nextLine();
    }

    private void printCartItemsDetail() {
        for (Product cartItem : cartItems) {
            if (cartItem instanceof SandwichSet) {
                SandwichSet sandwichSet = (SandwichSet) cartItem; // 다운캐스팅
                System.out.printf("  %s %6d원 (%s(케첩 %d개), %s(빨대 %s))\n",
                        sandwichSet.getName(),
                        sandwichSet.getPrice(),
                        sandwichSet.getSide().getName(),
                        sandwichSet.getSide().getKetchup(),
                        sandwichSet.getDrink().getName(),
                        printHasStraw(sandwichSet.getDrink().hasStraw()) // extract method
                );
            } else if (cartItem instanceof Sandwich) {
                System.out.printf("  %-8s %6d원 (단품)\n",
                        cartItem.getName(),
                        cartItem.getPrice()
                );
            } else if (cartItem instanceof Side) {
                System.out.printf("  %-8s %6d원 (케첩 %d개)\n",
                        cartItem.getName(),
                        cartItem.getPrice(),
                        ((Side) cartItem).getKetchup() // 다운캐스팅
                );
            } else if (cartItem instanceof Drink) {
                System.out.printf("  %-8s %6d원 (빨대 %s)\n",
                        cartItem.getName(),
                        cartItem.getPrice(),
                        printHasStraw(((Drink) cartItem).hasStraw()) // 다운캐스팅 + extract method
                );
            }
        }
    }

    private String printHasStraw(boolean hasStraw) {
        return hasStraw ? "있음" : "없음";
    }

    private int calculateTotalPrice() {
        int totalPrice = 0;

        for (Product cartItem : cartItems) {
            totalPrice += cartItem.getPrice();
        }

        return totalPrice;
    }
}
