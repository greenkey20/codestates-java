package com.codestates.dailycoding;

import java.util.Arrays;

public class Solution42 {
    // 2022.11.10(목) 10h15
    public int getItemFromTwoSortedArrays(int[] arr1, int[] arr2, int k) {
		/* 단순히 처음부터 끝까지 찾아보는 방법(O(K))(x) 다른 방법 탐구/이진 탐색 응용(O(logK))(o)해서 해결

		길이가 m, n이고 오름차순으로 정렬되어 있는 자연수 배열들(arr1.length = m, arr2.length = n)을 입력받아
		전체 요소(m + n <= 1,000,000) 중 k번째 요소를 리턴
		*/

        // arr1과 arr2를 길이 m + n인 1개의 배열로 합치고, 오름차순으로 정렬
        int[] arrCombined = new int[arr1.length + arr2.length];
        System.arraycopy(arr1, 0, arrCombined, 0, arr1.length); // 원본 배열을 다른 배열에 복사하면서 배열을 합치는 방법
        System.arraycopy(arr2, 0, arrCombined, arr1.length - 1, arr2.length);

        Arrays.sort(arrCombined);

        return 0;
    }
}
