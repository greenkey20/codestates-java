package com.codestates.dailycoding;

import java.util.Arrays;

public class Solution22 {
    // 2022.10.12(수) 10h45 -> 11h 2/6번 테스트 케이스 통과 못함 -> 2022.12.9(금) 10h20 수정 + 모든 테스트케이스 통과
    public static int[] bubbleSort(int[] arr) {
        // 정수(int)를 요소로 갖는 배열 arr(길이는 1000 이하)을 입력받음 -> 오름차순으로 정렬된 int들을 요소로 갖는 배열을 리턴
        // bubble sort 알고리즘 구현 + arr.sort 사용은 금지
        // 최선의 경우 수행 시간을 단축할 수 있음 <- 위에서 설명된 알고리즘 1~3의 과정 중 어떤 요소도 위치가 바뀌지 않은 경우 배열이 정렬된 상태라는 것을 알 수 있음

        // 반환할 int[] 배열 선언 및 초기화 -> 11h 문제 조건 보니 arr를 그대로 두어야 한다는 조건 없으므로, arr 요소들을 바로/직접 옮기며 정렬하기로 함 -> 그러면 이 부분 필요 없음
        // int[] sortedArr = arr.clone();

        // 요소의 위치가 바뀐 여부를 저장할 boolean[] 배열 선언 및 초기화 -> 2022.12.9(금) 10h25 reference code 보니, 이렇게 요소별 swap 여부 저장할 필요 없이, 그냥 int 변수 하나 0으로 초기화해두고 swap 발생 시 ++ vs swap 안 한 경우 그냥 놔두면 훨씬 간단하게 처리 가능
        int[] flags = new int[arr.length];

        // 최선의 경우 바깥for문의 조기 탈출을 위한 조건 검사용 변수 선언 및 초기화
        int product = 1;

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
                    // 2022.12.9(금) 10h25 reference code 보니, swap 함수를 별도로 만들어 활용할 수 있음
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                } else {
                    flags[j] = 1;
                    flags[j + 1] = 1;
                }
            }

            /* 2022.12.9(금) 10h5 코드 다시 읽어보니, 테스트케이스4 통과 못하는 이유가 100-100 비교하고 21 검사 못해서 그런 것 같아서, 왠지 이 flags 부분에 문제가 있을 것 같아 수정함
            -> 처음에는 product 값이 1인지 검사할 때 i 끝까지 다 돌았는지 확인해야 하나 생각했었는데,
            -> 바깥for문 돌 때마다 product가 1로 초기화되고 있음을 발견 vs 중간에 flags[j]가 하나라도 0이 있으면 탈출 못하게 해야 하는 바, product 값은 누적되어야 함
            -> 10h15 실행 시 의도한 대로 정렬은 됨 vs 바깥for문 i 순회할 때마다 아래 for문이 매번 검사할 필요 없는 것 같은데.. e.g. int = 0일 때만 실행해도 될 것 같은데..
             */
            if (i == 0) {
                for (int j = 0; j < flags.length; j++) {
                    product *= flags[j];
                }
                if (product == 1) {
                    break;
                }
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
