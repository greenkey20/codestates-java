package com.codestates.section1.unit8.sandwichprincess.product.subproduct;

import com.codestates.section1.unit8.sandwichprincess.product.Product;

// 2023.5.11(목) 22h45
public class Side extends Product {
    private int ketchup;

    public Side(long id, String name, int price, int kcal, int ketchup) {
        super(id, name, price, kcal);
        this.ketchup = ketchup;
    }

    public int getKetchup() {
        return ketchup;
    }

    public void setKetchup(int ketchup) {
        this.ketchup = ketchup;
    }
}
