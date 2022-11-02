package com.codestates.dailycoding;

import java.util.Arrays;

public class Solution36 {
    // 2022.11.2(수) 10h
    public static int[] insertionSort(int[] arr) {
		/* 오름차순으로 insertion(삽입) 정렬 구현 -> i < j일 때 arr[i] <= arr[j]
        knou 교과서 내용 다시 읽어봄 -> 코딩/구현 필요
        */
        // int sorted = arr[0];

        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (arr[i] < arr[j]) {
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                    continue;
                } else {
                    continue;
                }
            }
        }

        return arr;
    }

    public static void main(String[] args) {
        int[] output = insertionSort(new int[]{3, 1, 21});
        System.out.println(Arrays.toString(output));

        output = insertionSort(new int[]{5, 4, 3, 2, 1});
        System.out.println(Arrays.toString(output));

        output = insertionSort(new int[]{1, 2, 43, 100, 21, 43});
        System.out.println(Arrays.toString(output));

        output = insertionSort(new int[]{20, -10, -11, 2, 29});
        System.out.println(Arrays.toString(output));
    }
}
