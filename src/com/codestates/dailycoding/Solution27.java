package com.codestates.dailycoding;

import java.util.ArrayList;

public class Solution27 {
    // 2022.10.20(목) 11h
    public ArrayList<String> bfs(Tree node) {
        // 임의의 tree를 구성하는 노드 중 하나의 Node 객체를 입력받아,
        // 해당 노드를 시작으로 너비 우선 탐색(BFS, Breadth First Search)을 함 -> 탐색되는 순서대로 노드의 값이 저장된 배열을 리턴
        // 주어진 Tree 자료구조 클래스는 DFS 문제에서와 동일
        // 어떻게 구현할지 잘 모르겠어서 구글링, 알고리즘 책 등 공부
        return null;
    }

    // 아래 클래스의 내용은 수정하지 말아야 합니다.
    public static class Tree {
        private String value;
        private ArrayList<Tree> children;

        public Tree(String data) {
            this.value = data;
            this.children = null;
        }

        public String getValue() {      //현재 노드의 데이터를 반환
            return value;
        }

        public ArrayList<Tree> getChildrenNode() {
            return children;
        }

        public Tree addChildNode(Tree node) {
            if (children == null) children = new ArrayList<>();
            children.add(node);
            return children.get(children.size() - 1);
        }
    }
}
