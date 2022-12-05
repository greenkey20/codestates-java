package com.codestates.dailycoding;

import java.util.ArrayList;
import java.util.List;

public class Solution58 {
    // 2022.12.5(월) 9h50 ~ 10h15 ideation -> 10h25 reference 간단히 훑어봤는데, 내가 지금껏 못 푼 어떤 패턴인 것 같다.. 일단 내 수준에 맞는 문제를 풀러 가야겠다..
    public int jobAllocation(int[] jobs, int workersNum) {
        /* 전체 수리가 가장 빠르게 끝나는 시간 return = 배열의 원소 전체를 workersNum개 부분으로 나눈다? 이 때 각 부분의 합 중 최대 값 sum이 최대한 작아지도록 나눈다?
        자연수 배열 jobs를 workersNum개의 연속 구간으로 나눔 + 합이 가장 큰 구간의 합/구간의 합 중 최대 값을 sum이라고 할 때 sum이 가장 작아지는 분배에서의 sum을 return

        각 수리공들은 서로 연속해서 있는 부품만 수리 -> jobs 배열의 원소들의 순서 바꾸지 않음, 누락되는 원소 없음?
        jobs 배열의 원소들의 주어진 나열 순서 = 연속해서 있는 부품?
        jobs 배열의 각 원소 = 각 부품을 수리하는 데 걸리는 작업량? 제각각임(중복 숫자 없다는 의미인가? -> 입/출력 예시 보니 중복되는 숫자 입력 가능함)

        지금까지 데일리코딩 문제에 따라 reference codes 얼핏 본 것에 따르면 뭔가 dynamic programming인 것 같긴 한데.. 아닌가?
        */
        int[][] divisions = new int[workersNum][]; // 2차원에는 각 division에 들어갈 자연수들 목록이 될 수도 있고, 그냥 그 값들의 합을 넣어둘 수도 있고..
        List<Integer> sums = new ArrayList<>(); // 외부? for문 순회할 때마다 계산되는, 각 division의 합들 중 최대 값(sum)을 쌓아둠 -> 반복 마친 뒤 이 리스트에서 가장 작은 값 return

        // jobs 배열 {10, 2, 3, 4, 16, 10, 10}의 원소(총 원소 개수 = 7)를 하나씩 순회하면서
        for (int i = 0; i < jobs.length; i++) {
            // 각 division에 넣을 원소 개수 = 1 + 1 + 1 + 4일 때 각 division의 합들 중 최대 값(sum)을 저장해두기
            // 7을 4 부분으로 나누는 모든 경우의 수를 코딩 -> 아래 경우의 수들을 어떻게 패턴화시키지? + workersNum이 4가 아니라 다를 때에도 적용 가능해야 함
            // 부분1이 1일 때 -> 부분2는 1~4일 때 -> 부분3은 1~4일 때 -> 부분4는 4~1일 때..
            // 부분1이 2일 때 -> 부분2는 1~3일 때 -> 부분3은 1~3일 때 -> 부분4는 3~1일 때..
            // 부분1이 3일 때 -> 부분2는 1~2일 때 -> 부분3은 1~2일 때 -> 부분4는 2~1일 때..
            // 부분1이 4일 때 -> 부분2/3/4는 1
            // 1 + 1 + 2 + 3
            // 1 + 1 + 3 + 2
            // 1 + 1 + 4 + 1

            // 1 + 2 + 1 + 3
            // 1 + 2 + 2 + 2
            // 1 + 2 + 3 + 1

            // 1 + 3 + 1 + 2
            // 1 + 3 + 2 + 1

            // 1 + 4 + 1 + 1

            // 2 + 1 + 1 + 3
            // 2 + 1 + 2 + 2
        }

        int sum = 0;
        return sum;
    }

}
