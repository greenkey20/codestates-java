package com.codestates.section1.unit6.loop;

// 2022.9.11(일) 23h50
public class Loop17 {
    public static void main(String[] args) {

    }

    // 문제 hint = Math(square root/제곱근)를 활용해 불필요한 연산을 줄일 수 있음
    public static boolean isPrime(int num) {
        boolean result = false;

        if (num == 1) {
            return result;
        } else if (num == 2) {
            return !result;
        } else {
            for (int i = 2; i < num; i++) {
                if (num % i == 0) {
                    return result;
                }
            }

            return !result;
        }

    }
}
