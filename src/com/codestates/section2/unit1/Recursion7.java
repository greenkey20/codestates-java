package com.codestates.section2.unit1;

import java.util.Arrays;

// 2022.9.21(수) 8h50
public class Recursion7 {
    public static int arrLength(int[] arr) {
        // 함수 arrLength()의 재귀 호출 횟수는 입력값의 크기와 비슷해야 함

        // 더 이상 쪼갤 수 없는 경우
        if (arr.length == 0) {
            return 0;
        }

        // 작은 단위로 쪼갤 수 있는 경우
        return 1 + arrLength(Arrays.copyOfRange(arr, 1, arr.length));
    }

    public static void main(String[] args) {
        System.out.println(arrLength(new int[]{3, -2, 4, 7}));
    }
}
