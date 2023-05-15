package com.codestates.dailycoding.references;

import java.util.Arrays;

// 2022.11.28(월) 10h40 참고
public class Solution53Reference {
    //createMinTree 메서드 활용을 위해 필드변수 선언
    static int[] tree;

    public int[] rangeMinimum(int[] arr, int[][] ranges) {
        // 트리 전체의 높이(루트 노트에서 가장 깊은 리프 노드까지의 거리)를 구하고
        // 전체 배열의 크기를 구한다.
        double log2 = Math.log(arr.length) / Math.log(2);
        double height = Math.ceil(log2);
        double size = Math.pow(2, height + 1) - 1;
        tree = new int[(int) size];
        Arrays.fill(tree, 0);
        createMinTree(arr, 0, arr.length - 1, tree, 0);
        return mins(ranges, arr);
    }

    public int findMin(int ts, int te, int rs, int re, int idx) {
        if (rs <= ts && te <= re) {
            return tree[idx];
        }

        if (te < rs || re < ts) {
            return Integer.MAX_VALUE;
        }

        int mid = (ts + te) / 2;
        return Math.min(
                findMin(ts, mid, rs, re, 2 * idx + 1),
                findMin(mid + 1, te, rs, re, 2 * idx + 2)
        );
    }

    public int[] mins(int[][] range, int[] arr) {
        int[] result = new int[range.length];
        for (int i = 0; i < range.length; i++) {
            int start = range[i][0];
            int end = range[i][1];
            result[i] = (findMin(0, arr.length - 1, start, end, 0)); // 10h45 나의 질문 = 우변 표현식은 왜 괄호로 감싸져있지?
        }
        return result;
    }

    public int createMinTree(int[] arr, int ts, int te, int[] tree, int idx) {
        if (ts == te) {
            tree[idx] = arr[ts];
            return arr[ts];
        }
        int mid = (ts + te) / 2;
        tree[idx] = Math.min(
                createMinTree(arr, ts, mid, tree, (idx * 2) + 1),
                createMinTree(arr, mid + 1, te, tree, (idx * 2) + 2)
        );
        return tree[idx];
    }
}
