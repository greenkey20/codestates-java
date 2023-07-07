package com.codestates.section1.unit9.exceptionhandling;

// 2023.7.7(금) 14h40
public class ThrowExceptionTest {
    public static void main(String[] args) {
        try {
            throwException();
        } catch (ClassNotFoundException e) { // Exception 'java.lang.ClassNotFoundException' is never thrown in the corresponding try block
            System.out.println("e.getMessage() = " + e.getMessage());
        }
    }

    static void throwException() throws ClassNotFoundException, NullPointerException {
        Class.forName("java.lang.StringX");
    }
}
