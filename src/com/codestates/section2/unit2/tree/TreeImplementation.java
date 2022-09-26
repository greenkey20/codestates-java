package com.codestates.section2.unit2.tree;

import java.util.ArrayList;

public class TreeImplementation {
    private String value; // 입력 데이터 -> value는 어떠한 값도 들어갈 수 있지만, 현재 구현하는 Tree는 문자열로 제한
    private ArrayList<TreeImplementation> children; // 하위/자식 노드를 저장

    // 전달인자가 없을 경우의 생성자
    public TreeImplementation() {
        this.value = null;
        this.children = null;
    }

    // 전달인자가 존재할 경우의 생성자
    public TreeImplementation(String data) {
        this.value = data;
        this.children = null;
    }

    public void setValue(String data) {
        this.value = data;
    }

    // 현재 노드의 데이터를 반환
    public String getValue() {
        return value;
    }

    // 입력받은 value(?node를 입력받고 있는 것 아닌가?)를 Tree에 계층적으로 추가
    public void addChildNode(TreeImplementation node) {
//        if (node != null) children = new ArrayList<>(); // 나의 답안 if(children != null) children = new ArrayList<>(); // 테스트 케이스 대부분 통과 못함
        if (children == null) children = new ArrayList<>();
        children.add(node); // 이 line은 28행 if 조건과 상관 없이 실행되는 게 맞나?
    }

    // 입력받은 node를 Tree에서 삭제
    public void removeChildNode(TreeImplementation node) {
        String data = node.getValue();

        if (children != null) { // 이 행의 children 참조변수는 28행 것을 쓰고 있는 게 맞나?
            for (int i = 0; i < children.size(); i++) {
                if (children.get(i).getValue().equals(data)) {
                    children.remove(i);
                    return;
                }
                if (children.get(i).children != null) children.get(i).removeChildNode(node);
            }
        }
    }

    // 현재 트리에서 존재하는 children을 리턴
    public ArrayList<TreeImplementation> getChildrenNode() {
        return children;
    }

    // 트리에 포함된 데이터를 찾기 <- 재귀를 사용하여 값을 검색
    public boolean contains(String data) {
        if (value != null) {
            if (value.equals(data)) {
                return true;
            }
        }

        boolean check;

        if (children != null) {
            for (int i = 0; i < children.size(); i++) {
//                check = children.get(i).contains(data, false); // 이게 무슨 의미이지..? 코플릿에서도 문법 오류 발생
                check = children.get(i).contains(data);
                if (check) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "TreeImplementation{" +
                "value='" + value + '\'' +
                ", children=" + children +
                '}';
    }
}

class Run {
    public static void main(String[] args) {
        TreeImplementation rootNode = new TreeImplementation(null);
//        TreeImplementation rootNode = new TreeImplementation();

        for (int i = 0; i <= 4; i++) {
            rootNode.addChildNode(new TreeImplementation(Integer.toString(i)));
        }

        System.out.println(rootNode); // com.codestates.section2.unit2.tree.TreeImplementation@5a39699c
        System.out.println(rootNode.toString()); // {value: null, children: Solution(5)} -> 나의 질문 = 이렇게 출력하려면 toString()을 어떻게 오버라이딩해야 하지?
        System.out.println(rootNode.contains("5"));
        System.out.println(rootNode.contains("1"));
    }
}
