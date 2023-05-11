package com.codestates.section1.unit8.sandwichprincess.product.subproduct;

import com.codestates.section1.unit8.sandwichprincess.product.Product;

// 2023.5.11(목) 22h40
public class Sandwich extends Product {
    private boolean isSandwichSet;
    private int sandwichSetPrice;

    public Sandwich(long id, String name, int price, int kcal, boolean isSandwichSet, int sandwichSetPrice) {
        super(id, name, price, kcal);
        this.isSandwichSet = isSandwichSet;
        this.sandwichSetPrice = sandwichSetPrice;
    }

    public boolean isSandwichSet() {
        return isSandwichSet;
    }

    public void setSandwichSet(boolean sandwichSet) {
        isSandwichSet = sandwichSet;
    }

    public int getSandwichSetPrice() {
        return sandwichSetPrice;
    }

    public void setSandwichSetPrice(int sandwichSetPrice) {
        this.sandwichSetPrice = sandwichSetPrice;
    }
}
