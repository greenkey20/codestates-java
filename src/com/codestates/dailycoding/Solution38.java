package com.codestates.dailycoding;

import java.util.Arrays;

public class Solution38 {
    // 2022.11.4(금) 11h10
    public static int[] mergeSort(int[] arr) {
		/* 오름차순으로 merge/합병/병합 정렬 구현 -> i < j일 때 arr[i] <= arr[j]

        길이 N인 배열 리스트 = 길이 1인 '부분 리스트'가 N개 모인 것
        -> 인접한 부분 리스트들을 정렬하여 2의 길이를 가진 부분 리스트로 병합
        -> 2의 길이를 가진 인접한 부분 리스트들을 4의 길이를 가진 부분 리스트로 병합
        -> 하나의 정렬된 리스트가 될 때까지 위 과정을 반복
        cf. N이 홀수인 경우 첫번째 병합 때 1의 길이를 가진 부분 리스트를 남김

        구현 방식1) 반복적 접근 = 아래 -> 위
        구현 방식2) 재귀적 접근 = 위 -> 아래

        knou 교과서 내용 다시 읽어봄 -> 코딩/구현 필요
        */
        // 재귀로 구현해 보기로 함 -> 문제 힌트 케이스 보면서, 종이에 재귀 구조 그려봄
        if (arr.length == 1) {
            return arr;
        }

        int[] left = new int[arr.length / 2];
        int[] right = new int[arr.length - left.length];

        left = mergeSort(Arrays.copyOfRange(arr, 0, arr.length / 2));
        right = mergeSort(Arrays.copyOfRange(arr, arr.length / 2, arr.length));

        return merge(left, right);
    }

    public static int[] merge(int[] left, int[] right) {

        int[] result = new int[left.length + right.length];
//        List<Integer> resultList = new ArrayList<>();
        System.arraycopy(left, 0, result, 0, left.length);

        // 이런 2중 for문으로 쓰면, 2중 loop를 돌며 resultList에 요소가 중복되어 들어갈 수 있음
        /*
        for (int i = 0; i < left.length; i++) {
            if (left.length != 1) {
                for (int j = 0; j < right.length; j++) {
                    if (left[i] < right[j]) {
                        resultList.add(left[i]);
                        resultList.add(right[j]);
                    } else {
                        resultList.add(right[j]);
                        resultList.add(left[i]);
                    }
                }
            } else {
//                if ()
            }
        }
         */

        // 16h35 수정해 보지만, 잘 모르겠음
        for (int i = 0; i < right.length; i++) {
            for (int j = 0; j < left.length; j++) {
                if (right[i] < left[0]) {
//                    resultList.add(right[i]);
                }
            }
        }

        // 16h20 아래 변환 문법들 왜 안 되는지 잘 모르겠음
//        int[] result = new int[left.length + right.length];
//        resultList.toArray(result);
//        int[] result = resultList.stream().map(i -> (int) i).toArray();

        return result;
    }

    public static void main(String[] args) {
        int[] output = mergeSort(new int[]{3, 1, 21});
        System.out.println(Arrays.toString(output));

        output = mergeSort(new int[]{5, 4, 3, 2, 1});
        System.out.println(Arrays.toString(output));

        output = mergeSort(new int[]{1, 2, 43, 100, 21, 43});
        System.out.println(Arrays.toString(output));

        output = mergeSort(new int[]{20, -10, -11, 2, 29});
        System.out.println(Arrays.toString(output));
    }
}
