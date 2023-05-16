package com.codestates.section1.unit8.sandwichprincess.common;

// 2023.5.16(화) 11h15

import com.codestates.section1.unit8.sandwichprincess.discount.Discount;
import com.codestates.section1.unit8.sandwichprincess.discount.condition.DiscountCondition;
import com.codestates.section1.unit8.sandwichprincess.discount.condition.StudentDiscountCondition;
import com.codestates.section1.unit8.sandwichprincess.discount.condition.YouthDiscountCondition;
import com.codestates.section1.unit8.sandwichprincess.discount.policy.FixedAmountDiscountPolicy;
import com.codestates.section1.unit8.sandwichprincess.discount.policy.FixedRateDiscountPolicy;
import com.codestates.section1.unit8.sandwichprincess.order.Cart;
import com.codestates.section1.unit8.sandwichprincess.order.Order;
import com.codestates.section1.unit8.sandwichprincess.product.Menu;
import com.codestates.section1.unit8.sandwichprincess.product.ProductRepository;

/**
 * 프로그램 동작에 필요한 모든 객체들을 생성 + 각 객체의 동작에 필요한 다른 객체들을 결정(의존 관계 맺어줌)
 */
public class AppConfigurer {
    public ProductRepository productRepository() {
        return new ProductRepository();
    }

    public Menu menu() {
        return new Menu(productRepository().getAllProducts());
    }

    public Cart cart() {
        return new Cart(productRepository(), menu());
    }

    public Discount discount() {
        return new Discount(new DiscountCondition[]{
                new StudentDiscountCondition(new FixedRateDiscountPolicy(10.0)),
                new YouthDiscountCondition(new FixedAmountDiscountPolicy(500))
        });
    }

    public Order order() {
        return new Order(cart(), discount());
    }
}
