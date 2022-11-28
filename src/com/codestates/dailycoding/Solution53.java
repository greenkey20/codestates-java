package com.codestates.dailycoding;

import java.util.Arrays;

public class Solution53 {
    // 2022.11.28(월) 10h10 -> 10h35 v1 제출 시 통과
    public /*static*/ int[] rangeMinimum(int[] arr, int[][] ranges) {
		/* 입력 = 정수(-100,000 이상 100,000 이하)를 요소로 갖는 배열 arr(최대 길이는 500,000) + 특정 구간 ranges -> 해당 구간 내에서 최소 값을 return
        ranges에는 최대 10,000개의 구간이 주어질 수 있음 + ranges[i][0]은 i번째 구간의 시작 인덱스, ranges[i][1]은 i번째 구간의 끝 인덱스
        return하는 int[] 배열∂ result.length = ranges.length, result[i] = ranges[i] 구간의 최소 값

        나의 질문 = 이번 문제 메서드/프로그램은 왜 static 키워드가 붙어있지? 이번 문제 풀이(reference codes 등)에 특별히 필요한가?
        -> 나의 관찰 = static이 아니어도 코플릿 실행에는 이상 없으며, reference code에서도 static 아님

        tips/advanced
        1. 주어진 배열에서 특정 구간의 최소값을 구하는 단순한 알고리즘은 단순 순회(O(N)) vs 같은 배열에 대해서 다양한 구간에 대한 최소값을 구할 경우 + 구간의 개수도 N개라고 가정할 경우, 단순 순회는 O(N^2)
        vs 적절한 자료 구조(segment/구간 tree)를 통해 이와 같은 구간 조회에 대한 반복 작업을 효율적으로(O(N * logN)) 수행할 수 있음
        2. tree를 배열로 구현 vs 객체로 구현하는 것이 보다 직관적이기 때문에 객체로 먼저 도전하기
        3. 구간의 최대값 및 합도 동일한 로직으로 구현

        10h25 문제 및 입/출력 예시는 이해/파악 완료 -> 나는 단순 순회를 일단 구현해보고, 그 다음에 segment tree를 공부해보자
        -> 10h45 reference code 훑어봤는데, 어렵다.. 흐름이 어려워/복잡해보이는 재귀가 2개나 있고, 트리를 만든다..
        */
        int[] result = new int[ranges.length];

        for (int i = 0; i < ranges.length; i++) {
            int startIdx = ranges[i][0];
            int endIdx = ranges[i][1];
            int[] rangeArr = Arrays.copyOfRange(arr, startIdx, endIdx + 1);
            Arrays.sort(rangeArr);
            result[i] = rangeArr[0];
        }

        return result;
    }
}
