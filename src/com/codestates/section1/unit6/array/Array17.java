package com.codestates.section1.unit6.array;

// 2022.9.18(일) 19h20
public class Array17 {
    public static int[] getAllElementsButNth(int[] arr, int n) {
        if (arr.length == 0) {
            return arr;
        }

        int[] newArr = new int[arr.length - 1];
        int cnt = 0;

        if (n >= arr.length) {
            return arr;
        }

        for (int i = 0; i < arr.length; i++) {
            if (i != n) {
                newArr[cnt] = arr[i];
                cnt++;
            }
        }

        return newArr;
    }
}
