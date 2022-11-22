package com.codestates.dailycoding;

import java.util.Arrays;

public class Solution48 {
    // 2022.10.21(월) 15h5
    public int subsetSum(int[] set, int bound) {
		/* 자연수 집합 set(자연수를 요소로 갖는 배열)의 요소를 최대 1번씩만 더해서 만든 + bound(300 이하의 자연수)를 넘지 않는, 가장 큰 수를 return
        단, 조건을 만족하는 조합이 없는 경우, return 0

        반환할 수 있는 최대의 수 = bound

        set의 요소들을 순회/검사하면서 result(검사한 요소들의 합)가 bound와 같거나 가장 가까워졌을 때(=그 다음 검사할 요소를 더했을 때 bound를 막 넘어가는 경우) result를 return
        */
        // set의 요소들을 오름차순으로 정렬한 뒤 시작
        Arrays.sort(set);

        int result = 0;
        return result;
    }
}
