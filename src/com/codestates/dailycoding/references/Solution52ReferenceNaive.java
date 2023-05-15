package com.codestates.dailycoding.references;

// 2022.11.25(금) 11h40 참고
public class Solution52ReferenceNaive {
    // naive solution
    public int uglyNumbers(int n) {
        int num = 0;
        int count = 0;
        while (n > count) {
            num++;
            if (isUgly(num)) count++;
        }
        return num;
    }

    public boolean isUgly(int num) {
        num = decompose(num, 2);
        num = decompose(num, 3);
        num = decompose(num, 5);
        return num == 1;
    }

    public int decompose(int num, int factor) {
        while (num % factor == 0) num = num / factor;
        return num;
    }
}
