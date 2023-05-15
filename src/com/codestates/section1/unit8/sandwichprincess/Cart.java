package com.codestates.section1.unit8.sandwichprincess;

import com.codestates.section1.unit8.sandwichprincess.product.Product;
import com.codestates.section1.unit8.sandwichprincess.product.ProductRepository;
import com.codestates.section1.unit8.sandwichprincess.product.subproduct.Drink;
import com.codestates.section1.unit8.sandwichprincess.product.subproduct.Sandwich;
import com.codestates.section1.unit8.sandwichprincess.product.subproduct.SandwichSet;
import com.codestates.section1.unit8.sandwichprincess.product.subproduct.Side;

import java.util.Scanner;

import static com.codestates.section1.unit8.sandwichprincess.common.Utils.printLine;

// 2023.5.12(금) 22h10
public class Cart {
    private Product[] cartItems = new Product[0];

    // 2023.5.13(토) 23h45
    private ProductRepository productRepository; // productRepository = 상품 정보 저장 + 상품 정보에 접근하는 역할 수행하는 객체
    private Scanner scanner = new Scanner(System.in);

    // 2023.5.14(일) 11h30
    private Menu menu;

    // Cart 클래스의 인스턴스 생성 시 초기화할 것들 <- 매개변수 있는 생성자
    public Cart(ProductRepository productRepository, Menu menu) {
        this.productRepository = productRepository;
        this.menu = menu;
    }

    public void addToCart(int productId) {
        // 객체지향적이지 않은 코드 = 상품ID로 product 검색 여기에 작성 vs productRepository가 상품 검색 기능(findById)을 자율적으로 수행할 수 있도록 함(캡슐화) + Cart 인스턴스는 PRODUCTS가 어디 있는지, 어떻게 검색이 이루어지는지 모르고, findById() 호출만 함
        /*
        Product product;

        for (Product p : productRepository.getAllProducts()) {
            if (p.getId() == productId) {
                product = p;
            }
        }
         */

        // 객체지향적 코드
        Product product = productRepository.findById(productId);

        // 2023.5.15(월) 1h20 추가 -> 객체의 깊은 복사
        Product productToAddToCart;

        if (product instanceof Sandwich) {
            productToAddToCart = new Sandwich((Sandwich) product);
        } else if (product instanceof Side) {
            productToAddToCart = new Side((Side) product);
        } else /*if (product instanceof Drink)*/ {
            productToAddToCart = new Drink((Drink) product);
        }

        chooseOption(productToAddToCart);

        if (productToAddToCart instanceof Sandwich) {
            Sandwich sandwich = (Sandwich) productToAddToCart;
            if (sandwich.isSandwichSet()) {
                productToAddToCart = composeSet(sandwich);
            }
        }

        // 장바구니에 담긴 상품 목록 cartItems에 금번 주문 상품을 더해야 함 = cartItems 배열의 길이를 1로 늘리고, '기존에 담겼던 상품(들) + 금번 주문 상품'을 원소로 갖는 배열 필요
        Product[] newCartItems = new Product[cartItems.length + 1];
        System.arraycopy(cartItems, 0, newCartItems, 0, cartItems.length);
        newCartItems[newCartItems.length - 1] = productToAddToCart;
        cartItems = newCartItems;

        System.out.printf("[✅] %s를/을 장바구니에 담았습니다\n", productToAddToCart.getName());
    }

    // 2023.5.14(일) 11h10

    /**
     * 주문자가 주문한 상품에 대한 옵션을 보여주고, 옵션 선택에 따른 처리까지 하는 메서드
     *
     * @param product
     */
    private void chooseOption(Product product) {
        String input;

        if (product instanceof Sandwich) {
            System.out.printf("단품으로 주문하시겠어요? [1] 단품(%d원) [2] 세트(%d원) > ",
                    product.getPrice(), ((Sandwich) product).getSandwichSetPrice());
            input = scanner.nextLine();
            if (input.equals("2")) {
                ((Sandwich) product).setSandwichSet(true);
            }
        } else if (product instanceof Side) {
            System.out.print("케첩은 몇 개 필요하신가요? > ");
            input = scanner.nextLine();
            ((Side) product).setKetchup(Integer.parseInt(input));
        } else if (product instanceof Drink) {
            System.out.print("빨대가 필요하신가요? [1] 예 [2] 아니오 > "); // productRepository에서 기본값을 '필요 없음(false)'으로 해두었음
            input = scanner.nextLine();
            if (input.equals("1")) {
                ((Drink) product).setHasStraw(true);
            }
        }
    }

    // 2023.5.14(일) 11h25

    /**
     * 주문자가 샌드위치 세트를 주문한다고 했을 때, 세트 관련 옵션을 보여주고, 옵션 선택에 따른 처리까지 하는 메서드
     *
     * @param sandwich
     * @return
     */
    private SandwichSet composeSet(Sandwich sandwich) {
        // 사이드 선택 관련 옵션 설정 + 처리
        System.out.println("사이드를 골라주세요 > ");
        menu.printSides(true);
        int sideId = Integer.parseInt(scanner.nextLine());
        Side side = (Side) productRepository.findById(sideId);
        Side sideToComposeSet = new Side(side); // 깊은 복사
        chooseOption(sideToComposeSet);

        // 음료 선택 관련 옵션 설정 + 처리
        System.out.println("음료를 골라주세요 > ");
        menu.printDrinks(true);
        int drinkId = Integer.parseInt(scanner.nextLine());
        Drink drink = (Drink) productRepository.findById(drinkId);
        Drink drinkToComposeSet = new Drink(drink); // 깊은 복사
        chooseOption(drinkToComposeSet);

        String setName = sandwich.getName() + " 세트";
        int setPrice = sandwich.getSandwichSetPrice();
        int setKcal = sandwich.getKcal() + side.getKcal() + drink.getKcal();

        return new SandwichSet(setName, setPrice, setKcal, sandwich, sideToComposeSet, drinkToComposeSet);
    }

    public void printCart() {
        printLine();
        System.out.println("[장바구니]");

        // 장바구니 상품들 + 옵션 정보 출력
        printCartItemsDetail();
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
