package com.codestates.section2.unit2.graph;

import java.util.Arrays;
import java.util.Comparator;

// 2022.11.30(수) 11h30 코플릿 데일리코딩55 bfs 풀다가, 여기 학습 제대로 안 했기에 다시 옴
public class Graph12Draft3 {
    public int connectedVertices(int[][] edges) {
        // 인접행렬의 크기 구하기 = 코플릿 그래프10 함수 초반부 코드(2중 for문)와 같은 의미 = 최대 버텍스 찾기
        final int[] bigger = {0};

        Arrays.stream(edges).forEach(data -> {
            int currentBigger = Arrays.stream(data).boxed().max(Comparator.comparing(i -> i)).orElse(0);
            if (bigger[0] < currentBigger) bigger[0] = currentBigger;
        });

        // 최대 버택스 + 1 = 인접행렬의 크기
        int[][] adjArray = new int[bigger[0] + 1][bigger[0] + 1];

        // edges 배열을 순회하며, 간선 연결 + edges의 간선들은 방향 없으므로(무향) 쌍방/왕복 가능 표시
        for (int i = 0; i < edges.length; i++) {
            int from = edges[i][0];
            int to = edges[i][1];

            adjArray[from][to] = 1;
            adjArray[to][from] = 1;
        }



        return 0;
    }
}
