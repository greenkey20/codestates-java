package com.codestates.section1.unit6.loop;

// 2022.9.18(일) 1h55
public class Loop3 {
    public static int factorial(int num) {
        int result = 1;

        // 방법1) 내가 작성한 풀이
        /*
        for (int i = 1; i <= num; i++) {
            result *= i;
        }
         */

        /* 방법2) 강사님 풀이 with for문
        1은 굳이 곱할 필요 없으므로, 반복 횟수 1번이라도 줄일 수 있음
         */
        /*
        for (; num > 1; num--) {
            result *= num;
        }
         */

        // 방법3) 강사님 풀이 with while문
        while (num > 1) {
            result *= num;
            num--;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(factorial(5));
    }
}
