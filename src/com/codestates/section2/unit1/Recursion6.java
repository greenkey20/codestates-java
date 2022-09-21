package com.codestates.section2.unit1;

import java.util.Arrays;

// 2022.9.21(수) 8h45
public class Recursion6 {
    public static int arrProduct(int[] arr) {
        /* 문제 요구 사항
        1. 재귀 함수 형태로 작성
        2. 반복문 사용x
        3. 입력받은 배열 arr은 함수의 호출 뒤에도 처음 상태를 유지(immutability)
        4. 빈 배열의 합 = 1
        5. 함수 arrProduct()의 재귀 호출 횟수는 입력값의 크기와 비슷해야 함
         */
        // 더 이상 쪼갤 수 없는 경우
        if (arr.length == 0) {
            return 1;
        }

        // 작은 단위로 쪼갤 수 있는 경우
        return arr[0] * arrProduct(Arrays.copyOfRange(arr, 1, arr.length));
    }

    public static void main(String[] args) {
        System.out.println(arrProduct(new int[]{3, -2, 4, 7}));
    }
}
