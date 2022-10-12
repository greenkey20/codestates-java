package com.codestates.dailycoding;

import java.util.Arrays;

public class Solution21 {
    // 2022.10.12(수) 10h10 -> 10h35 모든 테스트 케이스 통과
    public int largestProductOfThree(int[] arr) {
        // 배열 arr의 요소 = 음수와 0을 포함하는 정수
        // 배열 arr의 길이는 3 이상 -> 3개의 요소를 곱해 나올 수 있는 최대값을 리턴
        // 순서 상관 없고, 중복 없이, arr.length개의 요소로부터 3개를 뽑는 조합(combination) -> 뽑는 요소 개수만큼의 중첩 반복문이나 재귀 함수로 구현
        int largestProduct = arr[0] * arr[1] * arr[2]; // 처음에 이 변수의 초기값을 1로 설정했는데, 음수만 3개 곱해야 하거나 0을 곱해야 하는 테스트 케이스 2개 통과 못함

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                for (int k = j + 1; k < arr.length; k++) {
                    int product = arr[i] * arr[j] * arr[k];
                    if (product > largestProduct) {
                        largestProduct = product;
                    }
                }
            }
        }

        return largestProduct;
    }

    // 문제에서 요구하는 숫자를 어떻게 구할지 조금 비틀어서? 생각해 볼 수 있음 -> 내 방식은 brute force이며 중첩 반복문으로 인해 시간 복잡도 크게 증가 vs sort() 함수의 도움을 받아 시간 복잡도 낮출 수 있음
    public int largestProductOfThreeReference(int[] arr) {
        // 배열을 오름차순으로 정리
        Arrays.sort(arr);

        int arrLength = arr.length;

        // 가장 큰 양수 3가지를 곱한 값
        int candidate1 = arr[arrLength - 1] * arr[arrLength - 2] * arr[arrLength - 3];

        // 가장 작은 음수 2가지와 가장 큰 양수를 곱한 값
        int candidate2 = arr[arrLength - 1] * arr[0] * arr[1];

        return Math.max(candidate1, candidate2);
    }
}
