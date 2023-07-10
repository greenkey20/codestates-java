package com.codestates.section2.unit1;

import java.util.Arrays;

// 2022.9.21(수) 10h
public class Recursion9 {
    public int[] take1(int num, int[] arr) {
        // 더 이상 쪼갤 수 없는 경우
        if (num == 0) {
            return arr;
        }

        int[] result = new int[num];

        result[0] = arr[0];

        // 작은 단위로 쪼갤 수 있는 경우
        take1(num - 1, Arrays.copyOfRange(arr, 1, arr.length));

        return result;
    }

    public int[] take2(int num, int[] arr) {
        if (num == 0) {
            return new int[]{};
        }

        int[] head = Arrays.copyOfRange(arr, 0, 1);
        int[] tail = take2(num - 1, Arrays.copyOfRange(arr, 1, arr.length));

        System.arraycopy(tail, 0, head, head.length, 0);
        return head;
    }

    public static void main(String[] args) {
        Recursion9 recursion9 = new Recursion9();
        System.out.println(Arrays.toString(recursion9.take2(2, new int[]{3, -2, 4, 7})));
        System.out.println(Arrays.toString(recursion9.take2(5, new int[]{3, -2, 4, 7})));
    }

    public int[] takeReference1(int num, int[] arr) {
        //재귀 함수를 사용하여, 새로운 배열에 기존 입력된 arr 배열의 마지막 인덱스의 값부터 넣어줍니다.

        //base case : 문제를 더 이상 쪼갤 수 없는 경우
        if (arr.length == 0 || num == 0) { //입력된 배열이 빈 배열인 경우, 입력된 num이 0인 경우
            return new int[]{}; //빈 배열을 반환합니다.
        }

        //recursive Case : 그렇지 않은 경우
        //배열의 가장 첫번째 요소만을 가지고 있는 head 배열을 선언, 할당합니다.
        int[] head = Arrays.copyOfRange(arr, 0, 1);

        //남은 요소를 가지고 있는 tail 배열을 선언, 할당하고, 해당 배열의 요소가 모두 제거될 때까지 재귀함수를 호출합니다.
        //한번 호출될 때마다, num을 하나씩 줄여줍니다. head 배열에 현재 선택된 요소가 있기 때문에, 앞으로 선택할 요소를 나타내는 num을 1씩 줄여서 재귀함수가 실행되어야 합니다.
        int[] tail = takeReference1(num - 1, Arrays.copyOfRange(arr, 1, arr.length));

        //재귀함수가 모두 호출된 이후에, 할당된 head배열과 tail 배열을 합친 새로운 배열을 선언, 할당합니다.
        //새로운 배열을 선언합니다. 배열의 크기는 head.length와 tail.length를 합친 크기로 선언합니다.
        int[] dest = new int[head.length + tail.length];

        //System.arraycopy메서드를 사용하여, head, tail 두 배열의 요소를 모두 dest 배열에 복사합니다.
        System.arraycopy(head, 0, dest, 0, head.length);
        System.arraycopy(tail, 0, dest, head.length, tail.length);

        return dest;
    }

    public int[] takeReference2(int num, int[] arr) {
        //base Case : 더 이상 쪼개어 생각할 수 없는 경우
        //선택할 요소의 갯수(num)가 배열의 전체 요소의 갯수보다 많은 경우, 입력된 배열을 반환합니다.
        if (num >= arr.length) {
            return arr;
        }
        //선택할 요소의 갯수(num)가 0인 경우, 입력된 배열의 요소가 아무것도 없는 경우에는 빈 배열을 반환합니다.
        if (num == 0 || arr.length == 0) {
            return new int[]{};
        }

        //맨 뒷부분의 요소를 제외한 나머지 배열을 tail이라는 변수에 할당합니다.
        int[] tail = Arrays.copyOfRange(arr, 0, arr.length - 1);

        //제외한 배열을 포함하여 다시 재귀함수를 실행합니다.
        return takeReference2(num, tail);
    }
}