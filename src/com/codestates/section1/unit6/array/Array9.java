package com.codestates.section1.unit6.array;

import java.util.Arrays;

// 2023.7.8(토) 0h50
public class Array9 {
    public int[] getEvenNumbers(int[] arr) {
        int cnt = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                cnt++;
            }
        }

        int[] evenArr = new int[cnt]; // 2, 4, 6, 0, 0
        cnt = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                evenArr[cnt] = arr[i];
                cnt++;
            }
        }

        if (cnt == 0) {
            return new int[]{};
        } else {
            return evenArr;
        }
    }

    public int[] getEvenNumbersReference1(int[] arr) {
        int[] concatArray = new int[]{};

        if (arr.length == 0) {
            return new int[]{};
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                concatArray = Arrays.copyOf(concatArray, concatArray.length + 1);
                concatArray[concatArray.length - 1] = arr[i];
            }
        }

        return concatArray;
    }

    // # 방법 2
    // 짝수의 개수만큼의 크기를 가진 배열을 선언한 후, 하나씩 입력하는 방법입니다.
    public int[] getEvenNumbersReference2(int[] arr) {
        int count = 0;

        if (arr.length == 0) {
            return new int[]{};
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                count++;
            }
        }

        int[] result = new int[count];
        count = 0;

        for (int j = 0; j < arr.length; j++) {
            if (arr[j] % 2 == 0) {
                result[count] = arr[j];
                count++;
            }
        }

        return result;
    }
}
