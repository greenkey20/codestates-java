package com.codestates.section1.unit9.exceptionhandling;

// 2023.7.7(금) 14h30
public class RuntimeExceptionTest {
    public static void main(String[] args) {
        System.out.println("[알파벳 소문자를 대문자로 출력하는 프로그램]");
        printMyName("tromm");
        printMyName(null);
        System.out.println("[프로그램 종료]");
    }

    static void printMyName(String str) {
        String upperCaseAlphabets = str.toUpperCase();
        System.out.println(upperCaseAlphabets);
    }
}
