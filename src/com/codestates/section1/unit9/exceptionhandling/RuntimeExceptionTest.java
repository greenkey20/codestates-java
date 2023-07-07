package com.codestates.section1.unit9.exceptionhandling;

// 2023.7.7(금) 14h30
public class RuntimeExceptionTest {
    public static void main(String[] args) {
        try {
            System.out.println("[알파벳 소문자를 대문자로 출력하는 프로그램]");
            printMyName("tromm");
            printMyName(null);
        } catch (ArithmeticException e) {
            System.out.println("ArithmeticException 발생!");
        } catch (NullPointerException e) {
            System.out.println("NullPointerException 발생!");
            System.out.println("e.getMessage() = " + e.getMessage()); // 예외 정보 얻는 방법1
            System.out.println("e.toString() = " + e.toString()); // 예외 정보 얻는 방법2
            e.printStackTrace(); // 예외 정보 얻는 방법3
        } finally {
            System.out.println("[프로그램 종료]");
        }
    }

    static void printMyName(String str) {
        String upperCaseAlphabets = str.toUpperCase();
        System.out.println(upperCaseAlphabets);
    }
}
