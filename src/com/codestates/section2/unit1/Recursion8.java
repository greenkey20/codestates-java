package com.codestates.section2.unit1;

import java.util.Arrays;

// 2022.9.21(수) 8h55
public class Recursion8 {
    public static int[] drop(int num, int[] arr) {
        // num과 arr.length 중 최소값만큼 제거

        // 더 쪼갤 수 없는 경우
        if (num > arr.length) {
            return new int[]{};
        }

        if (num == 0) {
            return arr;
        }

        // 작은 단위로 쪼갤 수 있는 경우
        return drop(num - 1, Arrays.copyOfRange(arr, 1, arr.length));

        /* 페어님 idea
        if (arr.length == 0 || num == 0) {
          return arr;
        }

        int head = arr[0];
        int[] tail = Arrays.copyOfRange(arr, 1, arr.length);

        return drop(num - 1, tail);
         */
    }

    // 2023.7.10(월) 18h20
    // for문으로 먼저 짜보면
    public static int[] dropWithForLoop(int num, int[] arr) {
        int[] result = new int[]{};
        if (num > arr.length) num = arr.length;
        for (int i = 0; i < num; i++) {
            result = Arrays.copyOfRange(arr, i + 1, arr.length);
        }

        return result;
    }

    // 2023.7.10(월) 18h35
    public static int[] dropV2(int num, int[] arr) {
        if (num == 0) {
            return arr;
        }

        if (arr.length == 0) {
            return new int[]{};
        }

        /*
        int head = arr[0];
        int tail[] = Arrays.copyOfRange(arr, 1, arr.length);
        return dropV2(num - 1, tail);
         */
        return dropV2(num - 1, Arrays.copyOfRange(arr, 1, arr.length));
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(dropV2(2, new int[]{3, -2, 4, 7})));
        System.out.println(Arrays.toString(dropV2(5, new int[]{3, -2, 4, 7})));
    }
}
