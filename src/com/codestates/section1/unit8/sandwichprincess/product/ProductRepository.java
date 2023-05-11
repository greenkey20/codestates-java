package com.codestates.section1.unit8.sandwichprincess.product;

import com.codestates.section1.unit8.sandwichprincess.product.subproduct.Drink;
import com.codestates.section1.unit8.sandwichprincess.product.subproduct.Sandwich;
import com.codestates.section1.unit8.sandwichprincess.product.subproduct.Side;

// 2023.5.11(목) 23h
public class ProductRepository {
    private final Product[] PRODUCTS = {
            new Sandwich(1, "야채샌드위치", 3500, 300, false, 4500),
            new Sandwich(2, "에그마요샌드위치", 4000, 450, false, 5000),
            new Side(3, "감자튀김", 1000, 300, 1),
            new Side(4, "어니언링", 1000, 200, 0),
            new Drink(5, "제로콜라", 1000, 0, false),
            new Drink(6, "스프라이트", 1000, 150, false)
    };

    public Product[] getAllProducts() {
        return PRODUCTS;
    }
}
