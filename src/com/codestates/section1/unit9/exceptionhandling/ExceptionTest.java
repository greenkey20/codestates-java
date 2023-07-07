package com.codestates.section1.unit9.exceptionhandling;

// 2023.7.7(금) 14h50
public class ExceptionTest {
    public static void main(String[] args) {
        try {
            Exception intendedException = new Exception("의도된 예외 만들기");
            throw intendedException;
        } catch (Exception e) {
            System.out.println("고의로 예외 발생 시키기 성공!");
        }
    }
}
