package com.codestates.dailycoding;

import java.util.Arrays;

public class Solution37 {
    // 2022.11.3(목) 10h40
    public static int[] radixSort(int[] arr) {
		/* 오름차순으로 radix(기수) 정렬 구현 -> i < j일 때 arr[i] <= arr[j]
        기수 정렬은 내부적으로 계수(counting) 정렬 사용 -> 어떤 경우에 기수 정렬 사용하는지 = 정렬 대상 정수의 자리수가 정해져있는 경우

        knou 교과서 내용 다시 읽어봄 -> 기수 정렬은 알고리즘 기술 안 되어 있어서, 예제12 가지고 직접 동작을 종이에 써봄
        */
        // arr의 원소들이 최대 몇 자리 수(size)인지 파악(+ 비어있는 자리는 0으로 채움 = String.format()으로 0 채울 때 최대 몇 자리를 만들 것인지 '변수'를 넣을 수는 없는 것 같아 접근 방법 바꿈)
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) max = arr[i];
        }

        int size = String.valueOf(max).length();

        for (int i = 1; i <= size; i++) {

        }

        return null;
    }

    public static void main(String[] args) {
        int[] output = radixSort(new int[]{3, 1, 21});
        System.out.println(Arrays.toString(output));

        output = radixSort(new int[]{5, 4, 3, 2, 1});
        System.out.println(Arrays.toString(output));

        output = radixSort(new int[]{1, 2, 43, 100, 21, 43});
        System.out.println(Arrays.toString(output));

        output = radixSort(new int[]{20, -10, -11, 2, 29});
        System.out.println(Arrays.toString(output));
    }
}
