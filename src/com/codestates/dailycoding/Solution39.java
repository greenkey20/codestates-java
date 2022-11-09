package com.codestates.dailycoding;

import java.util.Arrays;

public class Solution39 {
    // 2022.11.7(월) 10h15
    public static int[] heapSort(int[] arr) {
		/* 오름차순으로 최소(min) heap(정렬, root node = 최소 값) 구현 -> i < j일 때 arr[i] <= arr[j]
        arr의 요소들은 -1000 이상 1000 이하의 정수 + arr.length는 1000 이하
        Java에서는 쉽게 heap 사용 가능 <- PriorityQueue<Integer> heap = new PriorityQueue<Integer>()

        나의 질문 = heap(이진 탐색 트리의 일종?)에는 중복 요소 없는 게 맞나? -> (최소)heap은 완전 이진 트리로써, 각 노드의 값은 자신의 자식 노드의 값보다 작거나 같다

        2022.11.8(화) 23h45 knou 교과서 내용 다시 읽어봄 -> 코딩/구현 필요
        단계1) 초기 heap 구축
         - 방법1 = arr의 각 원소에 대한 heap에서의 삽입 과정 반복
         - 방법2 = arr를 우선 완전 이진 트리로 만듦 -> 값 비교를 통해 노드의 값을 서로 교환
        단계2) 모든 데이터를 처리할 때까지 '루트 노드에 존재하는 최소값 삭제(-> 리턴할 배열에 차곡차곡 담음) + heap으로 재구성' 반복
        */

        return arr;
    }

    public static void main(String[] args) {
        int[] output = heapSort(new int[]{5, 4, 3, 2, 1});
        System.out.println(Arrays.toString(output)); // [1, 2, 3, 4, 5]

        output = heapSort(new int[]{3, 1, 21});
        System.out.println(Arrays.toString(output)); // [1, 3, 21]

        output = heapSort(new int[]{4, 10, 3, 5, 1});
        System.out.println(Arrays.toString(output)); // [1, 3, 4, 5, 10]

        output = heapSort(new int[]{1, 2, 43, 100, 21});
        System.out.println(Arrays.toString(output)); // [1, 2, 21, 43, 100]

        output = heapSort(new int[]{20, -10, -11, 2, 29});
        System.out.println(Arrays.toString(output)); // [-11, -10, 2, 20, 29]
    }
}
