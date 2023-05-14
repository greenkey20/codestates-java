package com.codestates.section1.unit8.sandwichprincess;

import com.codestates.section1.unit8.sandwichprincess.product.Product;
import com.codestates.section1.unit8.sandwichprincess.product.subproduct.Drink;
import com.codestates.section1.unit8.sandwichprincess.product.subproduct.Sandwich;
import com.codestates.section1.unit8.sandwichprincess.product.subproduct.Side;

import static com.codestates.section1.unit8.sandwichprincess.common.Utils.printLine;

// 2023.5.11(목) 23h20
public class Menu {
    private Product[] products;

    public Menu(Product[] products) {
        this.products = products;
    }

    // 2023.5.12(금) 21h45

    /**
     * 전체 메뉴 출력
     */
    public void printMenu() {
        printLine();
        System.out.println("[메뉴]");
        System.out.println();

        // 샌드위치 출력
        printSandwiches(true); // refactoring > extract method

        // 사이드 출력
        printSides(true);

        // 음료 출력
        printDrinks(true);

        printLine();

        System.out.println("[0] 장바구니");
        System.out.println("[+] 주문하기");
        printLine();

        System.out.print("메뉴를 선택해 주세요 > ");
    }

    // 2023.5.14(일) 11h50 composeSet() 메서드 작성하며 수정
    private void printSandwiches(boolean printPrice) {
        System.out.println("- 샌드위치");

        for (Product product : products) {
            if (product instanceof Sandwich) {
                printEachMenu(product, printPrice);
            }
        }

        System.out.println();
    }

    // 2023.5.14(일) 11h50 composeSet() 메서드 작성하며 수정
    protected void printSides(boolean printPrice) {
        System.out.println("- 사이드");

        for (Product product : products) {
            if (product instanceof Side) {
                printEachMenu(product, printPrice);
            }
        }

        System.out.println();
    }

    // 2023.5.14(일) 11h50 composeSet() 메서드 작성하며 수정
    protected void printDrinks(boolean printPrice) {
        System.out.println("- 음료");

        for (Product product : products) {
            if (product instanceof Drink) {
                printEachMenu(product, printPrice);
            }
        }

        System.out.println();
    }

    // 2023.5.14(일) 11h45 composeSet() 메서드 작성하며 수정
    private static void printEachMenu(Product product, boolean printPrice) {
        if (printPrice) {
            System.out.printf("[%d] %s %5dKcal %5d원\n", product.getId(), product.getName(), product.getKcal(), product.getPrice());
        } else {
            System.out.printf("[%d] %s %5dKcal\n", product.getId(), product.getName(), product.getKcal());
        }
    }
}
