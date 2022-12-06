package com.codestates.section2.unit2.graph;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

// 2022.11.6(일) 23h55
public class Graph12Draft2 {
    public int connectedVertices(int[][] edges) {
        final int[] bigger = {0};

        // 최대 vertex 찾기
        Arrays.stream(edges).forEach(data -> {
            int currentBigger = Arrays.stream(data).boxed().max(Comparator.comparing(i -> i)).orElse(0);
            if (bigger[0] < currentBigger) bigger[0] = currentBigger;
        });

        // (최대 vertex + 1) 크기로 인접행렬 만들기
        int[][] adjArray = new int[bigger[0] + 1][bigger[0] + 1];

        // 2022.12.6(화) 10h30 이어서 학습
        // 간선이 있는 vertex끼리 인접행렬 상 연결
        for (int i = 0; i < edges.length; i++) {
            int from = edges[i][0];
            int to = edges[i][1];
            adjArray[from][to] = 1;
            adjArray[to][from] = 1;
        }

        boolean[] visited = new boolean[bigger[0] + 1];
        int count = 0;

        for (int vertex = 0; vertex < visited.length; vertex++) {
            if (!visited[vertex]) {
                count++;

                // 방법1) bfs
                visited = bfs_array(adjArray, vertex, visited);

                // 방법2) dfs
//                visited = dfs_array(adjArray, vertex, visited);
            }
        }

        return count;
    }

    public boolean[] bfs_array(int[][] adjArray, int vertex, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(vertex);
        visited[vertex] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            // 현재 선택된 정점에 1차로 연결된 모든 정점들을 queue에 담음
            for (int i = 0; i < adjArray[current].length; i++) {
                if (adjArray[current][i] == 1 && !visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }

        return visited;
    }

    public boolean[] dfs_array(int[][] adjArray, int vertex, boolean[] visited) {
        visited[vertex] = true;

        for (int i = 0; i < adjArray.length; i++) {
            if (adjArray[vertex][i] == 1 && !visited[i]) {
                // 현재 선택된 정점에서 1차로 연결된 정점에 대해, 그 정점이 1차로 연결된 정점을 찾아가고..(깊게 파고 들어감?)
                dfs_array(adjArray, i, visited);
            }
        }

        return visited;
    }
}
