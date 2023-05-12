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
    public void printMenu() {
        printLine();
        System.out.println("[메뉴]");
        System.out.println();

        // 샌드위치 출력
        printSandwiches(); // refactoring > extract method

        // 사이드 출력
        printSides();

        // 음료 출력
        printDrinks();

        printLine();

        System.out.println("[0] 장바구니");
        System.out.println("[+] 주문하기");
        printLine();

        System.out.print("메뉴를 선택해 주세요 > ");
    }

    private void printSandwiches() {
        System.out.println("- 샌드위치");

        for (Product product : products) {
            if (product instanceof Sandwich) {
                printEachMenu(product);
            }
        }

        System.out.println();
    }

    private void printSides() {
        System.out.println("- 사이드");

        for (Product product : products) {
            if (product instanceof Side) {
                printEachMenu(product);
            }
        }

        System.out.println();
    }

    private void printDrinks() {
        System.out.println("- 음료");

        for (Product product : products) {
            if (product instanceof Drink) {
                printEachMenu(product);
            }
        }

        System.out.println();
    }

    private static void printEachMenu(Product product) {
        System.out.printf("[%d] %s %5dKcal %5d원\n", product.getId(), product.getName(), product.getKcal(), product.getPrice());
    }
}
