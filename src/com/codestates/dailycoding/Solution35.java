package com.codestates.dailycoding;

import java.util.Arrays;

public class Solution35 {
    // 2022.11.1(화) 10h30
    public static int[] quickSort(int[] arr) {
		/* 오름차순으로 quick 정렬 구현 -> i < j일 때 arr[i] <= arr[j]
    quick 정렬 = 분할 정복 알고리즘
    knou 교과서 내용 다시 읽어봄 -> 코딩/구현 필요 -> knou 교과서 알고리즘 따라서 일단 대충(동작에 대한 깊은 생각/검증 안 하고ㅠㅠ) 구현해봄
    */

        // 문제를 더 이상 쪼갤 수 없을 때
        if (arr.length == 1) {
            return arr;
        }

        int pivot = 0;
        pivot = partition(arr);
        quickSort(Arrays.copyOfRange(arr, 0, pivot));
        quickSort(Arrays.copyOfRange(arr, pivot + 1, arr.length));
        return arr;
    }

    public static int partition(int[] arr) {
        int left = 1;
        int right = arr.length - 1;

        while (left < right) {
            while (left < arr.length && arr[left] < arr[0]) left++;
            while (right > 0 && arr[right] >= arr[0]) right--; // ArrayIndexOutOfBoundsException

            if (left < right) {
                int temp = right;
                right = left;
                left = temp;
            } else {
                int temp = right;
                right = arr[0];
                arr[0] = temp;
            }
        }

        return right;
    }

    public static void main(String[] args) {
        int[] output = quickSort(new int[]{3, 1, 21});
        System.out.println(Arrays.toString(output));

        output = quickSort(new int[]{5, 4, 3, 2, 1});
        System.out.println(Arrays.toString(output));

        output = quickSort(new int[]{1, 2, 43, 100, 21, 43});
        System.out.println(Arrays.toString(output));

        output = quickSort(new int[]{20, -10, -11, 2, 29});
        System.out.println(Arrays.toString(output));
    }
}
