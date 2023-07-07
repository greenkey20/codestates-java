package com.codestates.section1.unit10.methodref;

import java.util.function.IntBinaryOperator;

// 2022.9.16(금) 8h
// 메서드 참조/references -> 불필요한 매개변수 제거
public class MethodReferences {
    public static void main(String[] args) {
        IntBinaryOperator operator;

        // 정적 메서드 참조
//        operator = Calculator.staticMethod(3, 5);
        operator = Calculator::staticMethod;
        System.out.println("static/정적 메서드 결과 = " + operator.applyAsInt(3, 5)); // 8

        // 인스턴스 메서드 참조
        Calculator calculator = new Calculator();
        operator = calculator::instanceMethod;
        System.out.println("instance 메서드 결과 = " + operator.applyAsInt(3, 5)); // 15
    }
}
