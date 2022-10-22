package com.codestates.section2.unit2.graph;

import java.util.Arrays;

// 2022.9.26(월) 11h20
/* graph 자료 구조를 인접행렬로 표현
단, 방향 + 비 가중치 graph, 배열의 인덱스 = 정점
인접행렬 그래프는 정점이 자주 삭제되는 경우에는 적합하지 않음(2022.10.22(토) 14h25 나의 질문 = 왜일까?) -> 정점을 지우는 메소드는 생략
 */
public class GraphInAdjacencyMatrix {
    private int[][] graph;

    // 그래프에 size만큼의 버텍스를 추가
    public void setGraph(int size) {
        graph = new int[size][size];

        // 2022.10.22(토) 14h20 나의 생각 = 아래와 같이 2중 반복문으로 초기화하지 않아도, 위 line에서 인접행렬 graph 생성 시 graph 배열 모든 원소의 값이 int 자료형의 기본 값인 0으로 초기화되지 않나?
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                graph[i][j] = 0;
            }
        }
    }

    // 인접행렬 정보가 담긴 배열을 반환
    public int[][] getGraph() {
        return graph;
    }

    // fromVertex와 toVertex 사이의 간선을 추가
    public void addEdge(int from, int to) {
        if (from >= graph.length || to >= graph.length) return;
        graph[from][to] = 1;
    }

    // fromVertex와 toVertex 사이의 간선이 존재하는지 여부를 boolean으로 반환
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
} // graph 자료 구조를 인접행렬로 구현한 클래스 영역 끝

class RunGraphInMatrix {
    public static void main(String[] args) {
        GraphInAdjacencyMatrix adjMatrix = new GraphInAdjacencyMatrix();

        // 정점/vertext가 총 3개인 그래프의 인접행렬 생성
        adjMatrix.setGraph(3);

        // 그래프의 인접행렬 정보 출력
        System.out.println(Arrays.deepToString(adjMatrix.getGraph()));
        /*
                            TO
                         0  1  2
                    0	[0, 0, 0],
            FROM 	1	[0, 0, 0],
                    2	[0, 0, 0]
        */

        // 특정 정점들 사이의 간선 추가
        adjMatrix.addEdge(0, 1);
        adjMatrix.addEdge(0, 2);
        adjMatrix.addEdge(1, 2);

        // 특정 정점 사이의 간선 존재 여부 확인
        boolean zeroToOneEdgeExists = adjMatrix.hasEdge(0, 1);
        System.out.println(zeroToOneEdgeExists); // true

        boolean zeroToTwoEdgeExists = adjMatrix.hasEdge(0, 2);
        System.out.println(zeroToTwoEdgeExists); // true

        boolean oneToZeroEdgeExists = adjMatrix.hasEdge(1, 0);
        System.out.println(oneToZeroEdgeExists); // false

        // 그래프의 현재 인접행렬 정보 출력
        System.out.println(Arrays.deepToString(adjMatrix.getGraph()));
        /*
                            TO
                         0  1  2
                    0	[0, 1, 1],
            FROM 	1	[0, 0, 1],
                    2	[0, 0, 0]
        */

        // 특정 정점들 사이의 간선 삭제
        adjMatrix.removeEdge(1, 2);
        adjMatrix.removeEdge(0, 2);

        // 특정 정점 사이의 간선 존재 여부 확인
        boolean oneToTwoEdgeExists = adjMatrix.hasEdge(1, 2);
        System.out.println(oneToTwoEdgeExists); // false

        zeroToTwoEdgeExists = adjMatrix.hasEdge(0, 2);
        System.out.println(zeroToTwoEdgeExists); // false

        // 그래프의 현재 인접행렬 정보 출력
        System.out.println(Arrays.deepToString(adjMatrix.getGraph()));
        /*
                            TO
                         0  1  2
                    0	[0, 1, 0],
            FROM 	1	[0, 0, 0],
                    2	[0, 0, 0]
        */
    }
}

