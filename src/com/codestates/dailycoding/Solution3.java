package com.codestates.dailycoding;

public class Solution3 {
    // 2022.9.20(화) 10h24
    public boolean powerOfTwo(long num) {
        // num은 1 이상의 정수, 반복(while)문 사용, Math.log 사용x
        if (num == 1) {
            return true;
        }

        if (num % 2 == 1) {
            return false;
        }

        num = num / 2;

        while (num > 2) {
            if (num % 2 == 1) {
                return false;
            }

            num = num / 2;
        }

        return true;
    }
}
