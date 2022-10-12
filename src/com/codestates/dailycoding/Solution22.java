package com.codestates.dailycoding;

import java.util.Arrays;

public class Solution22 {
    // 2022.10.12(수) 10h45 -> 11h 2/6번 테스트 케이스 통과 못함
    public static int[] bubbleSort(int[] arr) {
        // 정수(int)를 요소로 갖는 배열 arr(길이는 1000 이하)을 입력받음 -> 오름차순으로 정렬된 int들을 요소로 갖는 배열을 리턴
        // bubble sort 알고리즘 구현 + arr.sort 사용은 금지
        // 최선의 경우 수행 시간을 단축할 수 있음 <- 위에서 설명된 알고리즘 1~3의 과정 중 어떤 요소도 위치가 바뀌지 않은 경우 배열이 정렬된 상태라는 것을 알 수 있음

        // 반환할 int[] 배열 선언 및 초기화 -> 11h 문제 조건 보니 arr를 그대로 두어야 한다는 조건 없으므로, arr 요소들을 바로/직접 옮기며 정렬하기로 함 -> 그러면 이 부분 필요 없음
        // int[] sortedArr = arr.clone();

        // 요소의 위치가 바뀐 여부를 저장할 boolean[] 배열 선언 및 초기화
        int[] flags = new int[arr.length];

        for (int i = 0; i < arr.length; i++) { // 단계7) 단계1~3을 총 n번(배열의 크기) 반복
            /* 단계1) 첫 번째 요소가 두 번째 요소보다 크면, 두 요소의 위치를 바꿈(swap)
            단계2) 두 번째 요소와 세 번째 요소보다 크면, 두 요소의 위치를 바꿈(swap)
            단계3) 단계1/2를 마지막까지 반복 -> 마지막에서 두 번째 요소와 마지막 요소를 비교

            단계4) 단계1~3을 1번 거치면, 가장 큰 요소가 배열의 마지막으로 밀려남
            단계5) 단계1~3을 첫 요소부터 다시 반복
            단계6) 단계5를 통해 2번째로 큰 요소가 배열의 마지막에서 두 번째로 밀려남

            거품이 밀려 올라가는 것 같은 모습의 bubble sort
             */
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                } else {
                    flags[j] = 1;
                    flags[j + 1] = 1;
                }
            }

            int product = 1;
            for (int j = 0; j < flags.length; j++) {
                product *= flags[j];
            }
            if (product == 1) {
                break;
            }
        }

        return arr;
    }

    public static void main(String[] args) {
        int[] output = bubbleSort(new int[]{2, 1, 3});
        System.out.println(Arrays.toString(output)); // [1, 2, 3]

        output = bubbleSort(new int[]{5, 4, 3, 2, 1});
        System.out.println(Arrays.toString(output)); // [1, 2, 3, 4, 5]

        output = bubbleSort(new int[]{6, 7, 7, 9, 9});
        System.out.println(Arrays.toString(output)); // [6, 7, 7, 9, 9]

        output = bubbleSort(new int[]{1, 2, 43, 100, 100, 21});
        System.out.println(Arrays.toString(output)); // 11h version 테스트 시 [1, 2, 43, 21, 100, 100]가 나오며 통과 못함

        output = bubbleSort(new int[]{20, -10, -11, 2, 4, 299});
        System.out.println(Arrays.toString(output)); // [-11, -10, 2, 4, 20, 299]
    }
}
