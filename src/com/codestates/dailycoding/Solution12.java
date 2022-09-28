package com.codestates.dailycoding;

import java.util.Arrays;

public class Solution12 {
    // 2022.9.28(수) 10h30
    public static int[] reverseArr(int[] arr) {
        /* 재귀함수의 형태로 작성, 반복문(for, while) 사용 금지,
        입력받은 배열은 함수의 호출 뒤에도 처음 상태를 유지(immutability)
        빈 배열은 빈 배열 그대로를 리턴
        함수 reverseArr의 재귀 호출 횟수는 배열의 길이와 비슷해야 함
        */
        // 문제를 더 이상 쪼갤 수 없는 경우
        if (arr.length == 0) {
            return arr;
        }

        // 더 작게 쪼개지는 경우
        int[] result = new int[arr.length];
        result[0] = arr[arr.length - 1];

        // 재귀 호출 시 매개변수로 넘길 배열 준비
        int[] tail = new int[arr.length - 1];
        System.arraycopy(arr, 0, tail, 0, arr.length - 1);

        // tail 배열을 매개변수로 reverseArr() 메서드를 재귀 호출한 결과를 result 배열 뒷부분(인덱스 1 ~ 마지막 인덱스)에 붙임 -> 11h 테스트 시 결과 = [3, 0, 0] -> 내가 주석으로 쓴 아이디어를 올바르게 구현 못함
//        System.arraycopy(result, 1, reverseArr(tail), 0, result.length - 1);
        System.arraycopy(reverseArr(tail), 0, result, 1, result.length - 1);

        return result;
    }

    public static void main(String[] args) {
        int[] output = reverseArr(new int[]{1, 2, 3});
        System.out.println(Arrays.toString(output));
    }

    public int[] reverseArrReference(int[] arr) {
        if (arr.length == 0) return new int[]{};
        int[] head = Arrays.copyOfRange(arr, arr.length - 1, arr.length);
        int[] tail = reverseArr(Arrays.copyOfRange(arr, 0, arr.length - 1));

        int[] dest = new int[head.length + tail.length];
        System.arraycopy(head, 0, dest, 0, head.length);
        System.arraycopy(tail, 0, dest, head.length, tail.length);
        return dest;
    }
}
