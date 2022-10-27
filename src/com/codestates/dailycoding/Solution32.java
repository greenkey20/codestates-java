package com.codestates.dailycoding;

import java.util.ArrayList;
import java.util.List;

public class Solution32 {
    // 2022.10.27(목) 10h30
    private List<int[]> result = new ArrayList<>();

    public int orderOfPresentation(int N, int[] K) {
        /* 발표자의 수 N(1 <= N <= 12인 조의 개수) 중 N개를 뽑아 순서 중요하게 + 중복 없이 나열시킴 = 순열(permutation)
        경우의 수 = N P N = N! / (N - N)! = N!
        재귀로 모든 경우의 수(length가 N인 int 타입 배열)를 하나씩 만들어 나가다가,
        이렇게 만들어진 배열의 내용물과 K(입력으로 주어진 int 타입 배열)의 내용물이 같으면(Arrays.equals()), 이 때의 cnt를 return
        */

        // teams 배열 생성 및 조 번호로 원소들 값 초기화
        int[] teams = new int[N];
        for (int i = 1; i <= N; i++) {
            teams[i - 1] = i;
        }

        permutation(N, 1, teams);


        return 0;
    }

    public void permutation(int N, int num, int[] teams) {
        int[] item = new int[N];

        if (num == N) {
            result.add(item);
        }

        for (int i = 0; i < item.length; i++) {
            item[i] = teams[0];
        }
    }
}
