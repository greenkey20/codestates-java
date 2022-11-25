package com.codestates.dailycoding;

import java.util.Arrays;

public class Solution51 {
    // 2022.11.24(목) 10h30
    public int LCS(String str1, String str2) {
		/* Longest Common Subsequence = 두 문자열에 공통으로 존재하는, 연속되지 않는 부분 문자열
        알파벳 소문자 및 숫자 총 50개 이하로 이루어진 str1(길이 M)-str2(길이 N) 비교 -> lcs가 존재하지 않으면 0 vs 존재하면 lcs의 길이 return

        tips/advanced)
        1. LCS를 계산하는 효율적인 알고리즘(O(M * N))이 존재함 + 쉽지 않기 때문에 바로 레퍼런스 코드를 보고 이해하는 데 집중하기
        2. LCS의 길이 대신, LCS 자체를 리턴하는 함수를 구현해보기
        3. LIS 및 LCS 변형 = 두 문자열이나 배열을 입력받아 LCIS(Longest Common Increasing Subsequence)의 길이, 또는 그 자체를 리턴하는 함수를 구현해보기

        10h55 데일리코딩 49번 레퍼런스 공부 완료 + 이 문제 입/출력 예시 살펴봄 -> 어떻게 풀어야 할지 잘 모르겠어서, 오늘은 레퍼런스 바로 공부해보기로 함
        */
        int M = str1.length();
        int N = str2.length();

        int[][] memo = new int[M + 1][N + 1]; // 2022.11.25(금) 11h5 나의 생각 = 왜 이런 식으로 memoization해야 하는 건지도 이해 안 됨
        for (int[] data : memo) Arrays.fill(data, -1);
        int left = 0;
        int right = 0;

        return compareOneByOne(left, right, 0, memo, str1, str2);
    }

    public int compareOneByOne(int left, int right, int len, int[][] memo, String str1, String str2) {
        if (memo[left][right] != -1) return memo[left][right];

        // lcs가 존재하지 않으면 0 반환
        if (left == str1.length() || right == str2.length()) return 0;

        // 2022.11.25(금) 11h 나의 생각 = wow, 내가 이 로직을 이해할 수 있을까..? -> 11h5 일단 오늘 문제 풀러 가자
        if (str1.charAt(left) == str2.charAt(right)) {
            memo[left][right] = 1 + compareOneByOne(left + 1, right + 1, len + 1, memo, str1, str2);
            return memo[left][right];
        }

        memo[left][right] = Math.max(
                compareOneByOne(left + 1, right, len, memo, str1, str2),
                compareOneByOne(left, right + 1, len, memo, str1, str2)
        );
        return memo[left][right];
    }
}
