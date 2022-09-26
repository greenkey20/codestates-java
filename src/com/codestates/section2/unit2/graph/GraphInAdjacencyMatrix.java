package com.codestates.section2.unit2.graph;

// 2022.9.26(월) 11h20
public class GraphInAdjacencyMatrix {
    private int[][] graph;

    // 그래프에 size만큼의 버텍스를 추가
    public void setGraph(int size) {
        graph = new int[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                graph[i][j] = 0;
            }
        }
    }

    // 인접 행렬 정보가 담긴 배열을 반환
    public int[][] getGraph() {
        return graph;
    }

    // fromVertex와 toVertex 사이의 간선을 추가
    public void addEdge(int from, int to) {
        if (from >= graph.length || to >= graph.length) return;
        graph[from][to] = 1;
    }

    // fromVertex와 toVertex 사이의 간선이 존재하는지 여부를 Boolean으로 반환
    public boolean hasEdge(int from, int to) {
        if (from >= graph.length || to >= graph.length) return false;
        else if (graph[from][to] == 1) return true;
        else return false;
    }

    // fromVertex와 toVertex 사이의 간선을 삭제
    public void removeEdge(int from, int to) {
        if (from >= graph.length || to >= graph.length) return;
        graph[from][to] = 0;
    }
}

