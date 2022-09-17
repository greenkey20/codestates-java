package com.codestates.section1.unit6.loop;

// 2022.9.17(토) 21h50
public class Loop9 {
    public int makeMultiplesOfDigit2(int num1, int num2) {
        int cnt = 0;

        // num1이 num2보다 작지 않을 수도 있음
        int max = num1;
        int min = num2;
        if (num1 < num2) {
            max = num2;
            min = num1;
        }

        // 더 작은 수 ~ 더 큰 수
        for (int i = min; i <= max; i++) {
            if (i % 2 == 0 && i != 0) { // 0은 2의 배수가 아니라고 가정
                cnt++;
            }
        }

        return cnt;
    }
}
