package com.codestates.section2.unit1;

import java.util.Arrays;

// 2023.7.12(수) 9h45/12h55 ~ 13h20 = 40분 정도 고민했는데, 잘 모르겠어서 해설 영상 보기 -> 로직은 맞게 생각했는데, 재귀 호출 및 반환/실행 순서가 헷갈려 구현 못함 = 강사님처럼 재귀 호출의 재귀 호출..의 반환의 반환.. 코드 흐름을 일일이 써가며 이해해보자
public class Recursion12 {
    public int[] reverseArrV2(int[] arr) {
        if (arr.length == 0) {
            return new int[]{};
        }

        int[] tail = Arrays.copyOfRange(arr, arr.length - 1, arr.length);
        int[] afterRecursion = reverseArrV2(Arrays.copyOfRange(arr, 0, arr.length - 1));

        int[] dest = new int[tail.length + afterRecursion.length];

        return tail;
    }

    public int[] reverseArrV1(int[] arr) {
        if (arr.length == 0) {
            return arr;
        }

        /*
        ArrayList<Integer> result = new ArrayList<>();
        result.add(arr[arr.length - 1]);

        [1,2,3,4]
        */
        int[] result = new int[arr.length];
        result[0] = arr[arr.length - 1];

        System.arraycopy(reverseArrV1(Arrays.copyOfRange(arr, 0, arr.length - 1)), 0, result, 1, arr.length - 1);

        // return arr[맨마지막요소] + reverseArr(Arrays.copyOfRange(arr, 0, arr.length - 1));
        return result;
    }

    public int[] reverseArrReference(int[] arr) {
        //재귀 함수를 사용하여, 새로운 배열로 기존 입력된 arr 배열의 마지막 인덱스의 값부터 넣어줍니다.

        //base case : 문제를 더 이상 쪼갤 수 없는 경우
        if (arr.length == 0) { //입력된 배열이 빈 배열인 경우
            return new int[]{}; //빈 배열을 반환합니다.
        }

        //recursive Case : 그렇지 않은 경우
        //배열의 가장 마지막 요소만을 가지고 있는 head 배열을 선언, 할당합니다.
        int[] head = Arrays.copyOfRange(arr, arr.length - 1, arr.length);

        //남은 요소를 가지고 있는 tail 배열을 선언, 할당하고, 해당 배열의 요소가 모두 제거될 때까지 재귀함수를 호출합니다.
        int[] tail = reverseArrReference(Arrays.copyOfRange(arr, 0, arr.length - 1));

        //재귀함수가 모두 호출된 이후에, 할당된 head배열과 tail 배열을 합친 새로운 배열을 선언, 할당합니다.
        //새로운 배열을 선언합니다. 배열의 크기는 head.length와 tail.length를 합친 크기로 선언합니다.
        int[] dest = new int[head.length + tail.length];

        //System.arraycopy메서드를 사용하여, head, tail 두 배열의 요소를 모두 dest 배열에 복사합니다.
        System.arraycopy(head, 0, dest, 0, head.length);
        System.arraycopy(tail, 0, dest, head.length, tail.length);

        return dest;
    }
}
