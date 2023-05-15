package com.codestates.dailycoding.references;

// 2022.11.21(월) 15h45 참고
public class Solution30Reference {
    public int rotatedArraySearch(int[] rotated, int target) {
        int left = 0;
        int right = rotated.length - 1;

        while (left <= right) {
            int middle = (right + left) / 2;

            if (rotated[middle] == target) {
                return middle;
            }

            if (rotated[left] < rotated[middle]) {
                // 왼쪽 절반이 정렬되어 있는 상태
                if (target < rotated[middle] && rotated[left] <= target) {
                    right = middle - 1;
                } else {
                    left = middle + 1;
                }
            } else {
                // 오른쪽 절반이 정렬되어 있는 상태
                if (target <= rotated[right] && rotated[middle] < target) {
                    left = middle + 1;
                } else {
                    right = middle - 1;
                }
            }
        }

        return -1;
    }
}
