package com.codestates.section1.unit8.sandwichprincess.common;

// 2023.5.16(화) 11h15 -> 2023.5.21(일) 23h40 Spring framework 사용해서 전환
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
 * 프로그램 동작에 필요한 모든 객체들을 생성 + 각 객체의 동작에 필요한 다른 객체들을 결정(DI/의존성 주입을 통해 각 객체들 간 의존 관계 맺어줌)
 * '기획자, director'
 *
 * 코드 흐름의 주도권이 개발자(x) framework(o)로 넘어감 = 제어의 역전(inversion of control)
 */
@Configuration
public class AppConfigurer {
    // 2023.5.16(화) 12h Singleton 패턴
    private Cart cart = new Cart(productRepository(), menu()); // Cart 인스턴스가 단 1번만 생성될 수 있도록 필드 정의 + 바로 초기화 -> cart() 메서드는 이렇게 생성된 cart 인스턴스를 반환

    public ProductRepository productRepository() {
        return new ProductRepository();
    }

    public Menu menu() {
        return new Menu(productRepository().getAllProducts());
    }

    public Cart cart() {
//        return new Cart(productRepository(), menu());
        return cart;
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
