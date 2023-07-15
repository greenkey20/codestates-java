package com.codestates.section2.unit2.graph;

import java.util.LinkedList;
import java.util.Queue;

// 2022.11.30(수) 11h30 코플릿 데일리코딩55 bfs 풀다가, 여기 학습 제대로 안 했기에 다시 옴
public class Graph12Draft3 {
    public int connectedVertices(int[][] edges) {
        // 인접행렬의 크기 구하기 = 코플릿 그래프10 함수 초반부 코드(2중 for문)와 같은 의미 = 최대 버텍스 찾기
//        final int[] bigger = {0};

        // 2023.7.15(토) 23h reference 강의(queue 방식, bfs) 본 뒤 내 방식대로 풀어보기
        int max = 0;

        // 최대 vertex 찾기
        for (int i = 0; i < edges.length; i++) {
            for (int j = 0; j < edges[i].length; j++) {
                int el = edges[i][j];
                if (el > 0) {
                    max = el;
                }
            }
        }
        System.out.println("max = " + max); // todo

        // 최대 버택스 + 1 = 인접행렬의 크기
        // (최대 vertex + 1) 크기로 인접행렬 만들기
        int[][] adjArray = new int[max + 1][max + 1];

        // 2022.12.6(화) 10h30 이어서 학습
        // edges 배열을 순회하며, 간선 연결 + edges의 간선들은 방향 없으므로(무향) 쌍방/왕복 가능 표시
        // 간선이 있는 vertex끼리 인접행렬 상 연결
        for (int i = 0; i < edges.length; i++) {
            int from = edges[i][0];
            int to = edges[i][1];

            adjArray[from][to] = 1;
            adjArray[to][from] = 1;
        }

        // 2022.12.11(일) 22h10 draft2 + 블로그 등 참고하며 복습 ㅠㅠ -> 내가 여전히 이 알고리즘을 직접 쓰기 어려워하는 건 내가 정확히/완벽히 이해하지 못했기 때문이겠지..?
        // 각 정점을 방문했었는지 체크해야 하는 바, 방문 여부 배열 생성
        boolean[] visited = new boolean[max + 1];
        int result = 0;

        for (int i = 0; i < visited.length; i++) {
            if (visited[i]) {
                result++;
            }
            visited = bfs_array(adjArray, i, visited);
        }

        return result;
    }

    public boolean[] bfs_array(int[][] adjArray, int i, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        int[] graph = adjArray[i];
        visited[i] = true;

        while (!queue.isEmpty()) {
            for (int j = 0; j < adjArray.length; j++) {
                int num = graph[j];

                if (num == 1) {
                    queue.add(num);
                }
            }
        }

        return visited;
    }
}
