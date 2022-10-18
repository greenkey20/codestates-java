package com.codestates.dailycoding;

import java.util.ArrayList;

public class Solution26 {
    // 2022.10.18(화) 10h5
    public static ArrayList<String> dfs(Tree node) {
        // 임의의 tree를 구성하는 노드 중 하나의 node 객체를 입력받아,
        // 해당 노드를 시작으로 깊이 우선 탐색(DFS, Depth First Search)을 함 -> 이 때, 탐색되는 순서대로 노드의 값이 저장된 배열을 리턴
        // 어떻게 구현할지 잘 모르겠어서 구글링, 알고리즘 책 등 공부
        return null;
    }

    // 아래 inner 클래스의 내용은 수정하지 말아야 함
    public static class Tree {
        // 인스턴스 변수
        private String value;
        private ArrayList<Tree> children;

        // 생성자
        // 기본 생성자
        public Tree() {
            this.value = null;
            this.children = null;
        }

        // 전달 인자 1개 받는 생성자
        public Tree(String data) {
            this.value = data;
            this.children = null;
        }

        // 현재 노드의 데이터를 반환 -> 나의 생각 = getter 같은 것?
        public String getValue() {
            return value;
        }

        // 현재 노드의 자식/하위 노드(들) 반환 -> 나의 생각 = getter 같은 것?
        public ArrayList<Tree> getChildrenNode() {
            return children;
        }

        // 인스턴스 메서드
        public Tree addChildNode(Tree node) {
            if (children == null) children = new ArrayList<>();
            children.add(node);
            return children.get(children.size() - 1); // 나의 질문 = 이 반환은 어떤 의미이지?
        }
    }

    public static void main(String[] args) {
        Solution26.Tree root = new Solution26.Tree("1");
        Solution26.Tree rootChild1 = root.addChildNode(new Solution26.Tree("2"));
        Solution26.Tree rootChild2 = root.addChildNode(new Solution26.Tree("3"));
        Solution26.Tree leaf1 = rootChild1.addChildNode(new Solution26.Tree("4"));
        Solution26.Tree leaf2 = rootChild1.addChildNode(new Solution26.Tree("5"));

        ArrayList<String> output = dfs(root);
        System.out.println(output);
    }
}
