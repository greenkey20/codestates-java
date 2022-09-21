package com.codestates.section1.unit6.array;

import java.util.Arrays;

// 2022.9.18(일) 15h55
// 종이에 피보나치 수열 처음 9개 정도 원소 써놓고, f[0], f[1]과 같이 초기 정의 필요한 요소들 먼저 코드 써봄 -> f[2] 이상 일반화 케이스 코드 써봄
public class Array19 {
    public static int[] fibonacci(int num) {
        int[] result = new int[num + 1];

        result[0] = 0;
        if (num == 0) {
            return result;
        }

        result[1] = 1;
        if (num == 1) {
            return result;
        }

        for (int i = 2; i <= num; i++) {
            result[i] = result[i - 1] + result[i - 2];
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(fibonacci(8))); // [0, 1, 1, 2, 3, 5, 8, 13, 21]
    }
}
