package com.codestates.dailycoding;

import java.util.Arrays;

public class Solution41 {
    // 2022.11.9(수) 10h25 -> 10h40 1차 제출 = 테스트케이스4 및 5 통과 못함
    public static int binarySearchDraft(int[] arr, int target) {
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
            result = binarySearchDraft(leftArr, target);
        } else if (target > arr[mid]) {
            int[] rightArr = Arrays.copyOfRange(arr, mid + 1, arr.length);
            result = binarySearchDraft(rightArr, target);
        } else {
            result = mid;
        }

        return result;
    }

    // 2022.11.10(목) 10h35 knou 교과서 보면서 새로 작성해봄 -> binarySearch() 재귀 호출하고 반환 값을 어떻게 처리해야 할지 잘 모르겠음
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int mid = arr.length / 2;

        if (left > right) return -1; // 이 라인의 의미 아직 이해 못함 -> 10h45 나의 생각 = arr의 길이가 0/right의 값이 -1인 경우 재귀 호출 탈출?

        if (target == arr[mid]) {
            return mid;
        } else if (target < arr[mid]) {
            int[] leftArr = Arrays.copyOf(arr, mid);
            return binarySearch(leftArr, target);
        } else {
            int[] rightArr = Arrays.copyOfRange(arr, mid + 1, arr.length);
            return binarySearch(rightArr, target);
        }
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
        System.out.println(output); // 6 vs 1차 테스트 시 1이 나옴 -> 2022.11.14(월) 8h10 디버깅해보니 return mid 시 원본 배열 잘라서 재귀 호출 인자로 보낸 부분 배열의 인덱스가 반환되어서, 의도한대로 결과가 안 나오는 것 같은데, 어떻게 수정해야 할지 잘 모르겠음
    }
}
