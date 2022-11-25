package com.codestates.dailycoding;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution52 {
    // 2022.11.25(금) 11h5
    public int uglyNumbers(int n) {
		/* ugly number = 2 또는 3 또는 5로만 나누어 떨어지는 수 + 단, 1은 1번째 ugly number -> 1 + 2, 3, 5의 곱셈 조합으로만 만들어지는 수들
        n(1 이상의 자연수)번째 ugly number(ugly numbers 배열의 n-1번 인덱스에 저장되어 있음)를 return

        O(N) 방법 탐구해보기(ugly number에 2 또는 3 또는 5를 곱한 수도 ugly number)(o) 단순히 처음부터 끝까지 모든 수에 대해서 나눗셈 연산, 나눗셈 연산을 매번 다시 하기(x)
        -> 이전에 만든? ugly number를 cache에 저장해두는 memoization?

        2022.11.25(금) 11h35 레퍼런스 참고하기로 함ㅠㅠ
        */
        int[] uglyNumsArr = new int[n];
        // ugly numbers 초기 값들 정의/세팅
        uglyNumsArr[0] = 1;
        uglyNumsArr[1] = 2;
        uglyNumsArr[2] = 3;
        uglyNumsArr[3] = 5;

        // ugly numbers 집합/배열 = uglyNumsArr[1]/[2]/[3]의 순서 상관 없는, 반복 가능한, 조합 -> 단, 몇 개를 뽑는지는 정해두지 않는데, 그럼 '조합'이라는 용어를 적용할 수 없나?

        Set<Integer> uglyNumsSet = new HashSet<>();

        while (uglyNumsSet.size() == n) {

        }

        // set에 담긴 숫자들을 uglyNumsArr에 담음

        Arrays.sort(uglyNumsArr);
        return uglyNumsArr[n - 1];
    }
}
