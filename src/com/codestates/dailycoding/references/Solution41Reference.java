package com.codestates.dailycoding.references;

// 2022.11.14(월) 8h15 참고
public class Solution41Reference {
    public int binarySearch(int[] arr, int target) {
        // 좌측 기준점
        int left = 0;

        // 우측 기준점
        int right = arr.length - 1;

        // 기준점이 서로에게 도달할 때까지 반복
        while (left <= right) {
            // 중앙 기준점
            int middle = (right + left) / 2;

            // 현재 기준이 타겟과 일치한다면 해당 값을 반환합니다.
            if (arr[middle] == target) return middle;

            // 기준점보다 크다면 우측을 줄이고
            if (target < arr[middle]) {
                right = middle - 1;
                //기준점보다 작다면 좌측을 줄입니다.
            } else {
                left = middle + 1;
            }
        }

        return -1;
    }
}
