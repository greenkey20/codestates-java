package com.codestates.dailycoding;

public class Solution14 {
    // 2022.9.29(목) 10h20 -> 10h30 6번 테스트 케이스([-2123, 843, -733, 1156, -919]을(를) 입력받은 경우, false를 리턴해야 함) 통과 못함
    public boolean superIncreasing(int[] arr) {
        // 알고리즘 > pseudocode 개념 학습에서 나왔던 예시
        // 각 요소들이 그 이전의 요소들의 합보다 큰지 여부를 리턴
        int sum = 0;

        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                sum += arr[j];
            }

            if (sum >= arr[i]) {
                return false;
            }
        }

        return true;
    }
}
