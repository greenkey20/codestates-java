package com.codestates.section1.unit8.sandwichprincess.product.subproduct;

import com.codestates.section1.unit8.sandwichprincess.product.Product;

// 2023.5.11(목) 22h45
public class Drink extends Product {
    private boolean hasStraw;

    public Drink(long id, String name, int price, int kcal, boolean hasStraw) {
        super(id, name, price, kcal);
        this.hasStraw = hasStraw;
    }

    public boolean hasStraw() { // 자동생성한 getter의 이름(isHasStraw)을 의미에 부합하게 변경
        return hasStraw;
    }

    public void setHasStraw(boolean hasStraw) {
        this.hasStraw = hasStraw;
    }
}
