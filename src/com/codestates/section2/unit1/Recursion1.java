package com.codestates.section2.unit1;

// 2022.9.21(수) 7h55
public class Recursion1 {
    public static int sumTo(int num) {
        // 입력 num = 0 이상의 정수
        // sumTo() 함수는 재귀 함수의 형태로 작성, 반복(for, while)문 사용x, 사칙연산/공식 사용x
        // 함수 sumTo()의 재귀 호출 횟수는 입력값의 크기와 비슷해야 함

        // 0을 입력받은 경우 0을 리턴해야 한다는 test case를 아래 base case/재귀의 기초는 충족시키지 못함 <- StackOverflowError
        /*
        if (num == 1) {
            return 1;
        }
         */

        // base case/더 이상 쪼갤 수 없는 경우 = 재귀 탈출/호출 멈추는 조건 -> 작성 안 하고 프로그램 실행 시 stack overflow error 발생
        if (num == 0) {
            return 0;
        }

        return num + sumTo(num - 1);
    }

    public static void main(String[] args) {
        System.out.println(sumTo(5));
    }
}
