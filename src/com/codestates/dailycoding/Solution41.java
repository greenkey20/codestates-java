package com.codestates.dailycoding;

import java.util.Arrays;

public class Solution41 {
    // 2022.11.9(수) 10h25 -> 10h40 1차 제출 = 테스트케이스4 및 5 통과 못함
    public static int binarySearch(int[] arr, int target) {
		/* 이진 탐색 알고리즘(O(logN) 성능) -> target이 오름차순 정렬된 정수의 배열 arr에 있으면 arr 배열에서의 인덱스 값 리턴 vs 없는 경우 -1을 리턴
    urclass section2 이진 탐색 알고리즘 페이지 다시 한 번 보기
    */
        if (arr.length == 1) {
            if (arr[0] == target) {
                return 0;
            } else {
                return -1;
            }
        }

        int result = 0;

        int mid = arr.length / 2;
        if (target < arr[mid]) {
            int[] leftArr = Arrays.copyOf(arr, mid);
            result = binarySearch(leftArr, target);
        } else if (target > arr[mid]) {
            int[] rightArr = Arrays.copyOfRange(arr, mid + 1, arr.length);
            result = binarySearch(rightArr, target);
        } else {
            result = mid;
        }

        return result;
    }

    public static void main(String[] args) {
        // 입/출력 예시
        int output = binarySearch(new int[]{0, 1, 2, 3, 4, 5, 6}, 2);
        System.out.println(output); // 2 vs 1차 테스트 시 0이 나옴

        output = binarySearch(new int[]{4, 5, 6, 9}, 100);
        System.out.println(output); // -1

        // 테스트 케이스
        output = binarySearch(new int[]{3, 6, 7, 8, 9, 21, 31, 32}, 25);
        System.out.println(output); // -1

        output = binarySearch(new int[]{0, 1, 2, 3, 4, 5}, 1);
        System.out.println(output); // 1

        output = binarySearch(new int[]{4, 6, 8, 9, 10, 15}, 9);
        System.out.println(output); // 3

        output = binarySearch(new int[]{3, 6, 7, 8, 9, 21, 31, 32}, 31);
        System.out.println(output); // 6 vs 1차 테스트 시 1이 나옴
    }
}
