package com.codestates.section2.unit2.graph;

import java.util.ArrayList;

// 2022.9.26(월) 12h15
public class GraphInAdjacencyList {
    private ArrayList<ArrayList<Integer>> graph;

    // 매개변수 없는 생성자
    public GraphInAdjacencyList() {
        graph = new ArrayList<>();
    }

    // 그래프에 size만큼의 버텍스/정점을 추가 <- 넘겨받은 size만큼 빈 ArrayList를 값으로 할당합니다.
    public void setGraph(int size) {
        for (int i = 0; i < size; i++) {
            graph.add(new ArrayList<Integer>());
        }
    }

    // 그래프를 반환
    public ArrayList<ArrayList<Integer>> getGraph() {
        return graph;
    }

    // fromVertex와 toVertex 사이의 간선을 추가
    public void addEdge(int from, Integer to) {
        // from, to가 그래프의 크기보다 작거나(크거나 아닌가?) 음수일 경우 아무것도 추가하지 않음
        if (from < 0 || to < 0 || from >= graph.size() || to >= graph.size()) return;

        // from, to가 정확하게 입력되었을 경우
        graph.get(from).add(to); // from의 인접 리스트에 to를 추가
        graph.get(to).add(from); // to의 인접 리스트에 from를 추가
    }

    // fromVertex와 toVertex 사이의 간선이 존재하는지 여부를 Boolean으로 반환
    public boolean hasEdge(int from, int to) {
        // from, to가 그래프의 크기보다 작거나(크거나 아닌가?) 음수일 경우 아무것도 추가하지 않음
        if (from < 0 || to < 0 || from >= graph.size() || to >= graph.size()) return false;

        // ArrayList에서 제공하는 contains를 사용하여 boolean 타입의 값을 반환합니다.
        /*else*/
        return graph.get(from).contains(to);
    }

    // fromVertex와 toVertex 사이의 간선을 삭제
    public void removeEdge(int from, int to) {
        // from, to가 그래프의 크기보다 작거나(크거나 아닌가?) 음수일 경우 아무것도 제거하지 않습니다.
        if (from < 0 || to < 0 || from >= graph.size() || to >= graph.size()) return;

        // from의 인접 리스트가 to로 이어지는 간선이 존재하는 경우
        if (graph.get(from).contains(to)) {
            // from의 인접 리스트에서 to를 삭제
            graph.get(from).remove((Integer) to);
        }

        // to의 인접 리스트가 from으로 이어지는 간선이 존재하는 경우
        if (graph.get(to).contains(from)) {
            // to의 인접 리스트에서 from을 삭제합니다.
            graph.get(to).remove((Integer) from);
        }
    }
}
