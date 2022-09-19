package com.codestates.section1.unit8.abstraction;

// 2022.9.19(월) 14h35
public class CafeOrderExample {
    public static void main(String[] args) {
        CafeOwner cafeOwner = new CafeOwner();
        CafeCustomerA customerA = new CafeCustomerA();
        CafeCustomerB customerB = new CafeCustomerB();

        cafeOwner.giveItem(customerA);
        cafeOwner.giveItem(customerB);
    }
}

class CafeOwner {
    // Customer 인터페이스 미 사용 시, 손님 수만큼 giveItem() 메서드가 필요
    /*
    public void giveItem(CafeCustomerA cafeCustomerA) {
        System.out.println("단골A에게 아이스아메리카노 1잔 드리기");
    }

    public void giveItem(CafeCustomerB cafeCustomerB) {
        System.out.println("단골B에게 딸기라떼 1잔 드리기");
    }
     */

    // 손님에게 의존적인(x) 독립적인 기능 수행하는(o) 클래스가 됨 <- 각 단골 손님의 개별 주문 받아옴 <- Customer 인터페이스의 추상 메서드
    public void giveItem(Customer customer) {
        System.out.println(customer + "에게 " + customer.getOrder() + " 드리기");
    }
}

class CafeCustomer {
    private String cafeCustomerName;

    public void setCafeCustomerName(String cafeCustomerName) {
        this.cafeCustomerName = cafeCustomerName;
    }
}

interface Customer {
    abstract String getOrder();
    String toString();
}

class CafeCustomerA /*extends CafeCustomer*/ implements Customer {
    @Override
    public String getOrder() {
        return "아이스 아메리카노 1잔";
    }

    @Override
    public String toString() {
        return "단골손님A";
    }
}

class CafeCustomerB /*extends CafeCustomer*/ implements Customer {
    @Override
    public String getOrder() {
        return "딸기라떼 1잔";
    }

    @Override
    public String toString() {
        return "단골손님B";
    }
}