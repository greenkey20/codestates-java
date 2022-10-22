package com.codestates.section2.unit2.tree;

import java.util.ArrayList;

// 2022.9.26(월) 11h
// 2022.10.18(화) 14h20 코플릿 daily coding 26번 문제 풀이를 위해 복습/참고 차 왔다가 생각 = 이 Tree 클래스를 tree 표현 뿐만 아니라 node 1개(하나의 꼭지점)만을 표현하는 데에도 쓰고 있는 게 맞나..?
// knou 이산수학 교재 p.272 정의11.1 tree = 사이클이 없는 연결 그래프
public class TreeImplementation {
    private String value; // 입력 데이터 -> value는 어떠한 값도 들어갈 수 있지만, 현재 구현하는 Tree는 문자열로 제한
    private ArrayList<TreeImplementation> children; // 하위/자식 노드를 저장
    /* 2022.10.18(화) 15h20
    나의 질문1 = 이 children list에는 루트 노드도 들어가나?
    나의 질문2 = 이 children list에는 직계 자손만 들어가나, 아니면 직계 자손의 자손(들)도 들어가나?
    나의 질문3 = 루트 노드의 자식들은 별도의 Tree 객체로 존재하는 것인가? 그러면 그 자식들/별도의 Tree 객체는 별도의 하위 노드를 갖는 것인가? 그렇다면 자손의 자손들은 메모리를 중복적으로 차지하고 있는 것인가?
    아니면, 내가 무엇을 잘못 이해하고 있는 것인가? 지금 생각해보니 특정 노드 객체는 직계 자손들만 인스턴스 변수/속성으로 갖게 되는 것 같은데, 맞나?
     */

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

    // 현재 노드의 데이터 입력/set -> 2022.10.18(화) 14h10 나의 질문 = 위 전달인자 1개 받아 생성자로 set하는 것과 이 메서드의 기능/역할 등 차이점이 무엇인가?
    public void setValue(String data) {
        this.value = data;
    }

    // 현재 노드의 데이터를 반환
    public String getValue() {
        return value;
    }

    // 현재 트리에서 존재하는 children을 리턴
    public ArrayList<TreeImplementation> getChildrenNode() {
        return children;
    }

    // 입력받은 value(?node를 입력받고 있는 것 아닌가?)를 Tree에 계층적으로 추가
    public void addChildNode(TreeImplementation node) {
//        if (node != null) children = new ArrayList<>(); // 나의 답안 if (children != null) // 테스트 케이스 대부분 통과 못함
        if (children == null)
            children = new ArrayList<>(); // 2022.10.18(화) 14h15 나의 질문 = 이 행의 children 참조변수의 정체가 정확히 이해 안 됨; 현재 이 객체의 인스턴스 변수 맞나?
        children.add(node); // 이 line은 바로 윗줄 if 조건과 상관 없이 실행되는 게 맞나?
    }

    // 입력받은 node를 Tree에서 삭제
    public void removeChildNode(TreeImplementation node) {
        String data = node.getValue();

        if (children != null) { // 이 행의 children 참조변수는 addChildNode() 메서드 if 조건문에 있는 것(과 같은 것, 즉 이 객체의 인스턴스 변수)을 쓰고 있는 게 맞나? 그렇다면 이 조건은 '트리가 비어있지 않은 경우'를 의미하는 게 맞나? 전달인자로 받은 node의 하위 노드가 있/없는지 확인하는 건 아니지..?
            for (int i = 0; i < children.size(); i++) {
                // 전달인자로 받은 node의 값이 현재 순회 중인 노드의 값과 같은 경우
                if (children.get(i).getValue().equals(data)) {
                    children.remove(i); // 해당 하위 노드를 Tree에서 삭제
                    return; // 이 메서드를 호출한 곳으로 돌아감, 이 메서드 종료
                }

                // 전달인자로 받은 node의 값이 현재 순회 중인 노드의 값과 다르고, 현재 순회 중인 노드가 하위 노드(들) 가지고 있는 경우 -> 현재 순회 중인 노드의 하위 노드에 대해 removeChildNode() 메소드 재귀 호출/실행?
                if (children.get(i).children != null) children.get(i).removeChildNode(node);
            }
        }
    }

    // 트리에 포함된 데이터를 찾기 <- 재귀를 사용하여 값을 검색
    public boolean contains(String data) {
        // 2022.10.18(화) 15h35 나의 생각 = 처음 구현 시, 왜 아래 코드를 'value가 null이 아닌 경우' 조건으로 감쌌지? >.< -> IntelliJ에서 코드 실행 시에는 value가 null인 경우가 있고, 그 때 null pointer exception이 발생하기 때문에 이렇게 써줬음
        // 단 코플릿 내용?은 수정하셨다고 함(출처: agora states https://github.com/codestates-seb/agora-states-be/discussions/368)
        if (value != null) {
            if (value.equals(data)) {
                return true;
            }
        }

        boolean check;

        if (children != null) {
            for (int i = 0; i < children.size(); i++) {
//                check = children.get(i).contains(data, false); // 이게 무슨 의미이지..? 코플릿에서도 문법 오류 발생 -> reference codes 보니 contains() 메서드를 오버로딩한 게 있음
                check = children.get(i).contains(data);
                if (check) {
                    return true;
                }
            }
        }
        return false;
    }

    // 2022.10.18(화) 15h30 reference codes 공부
    // 재귀를 사용하여 값을 검색
    public boolean containsReference(String data) {
        if (value.equals(data)) return true;

        boolean check;

        if (children != null) {
            for (int i = 0; i < children.size(); i++) {
                check = children.get(i).contains(data);
                if (check) return true;
            }
        }
        return false;
    }

    // 재귀를 사용하여 값을 검색하는 containsReference() 메서드 오버로딩
    public boolean containsReference(String data, boolean check) {
        if (value.equals(data)) return true;

        if (children != null) {
            for (int i = 0; i < children.size(); i++) {
                check = children.get(i).containsReference(data, check);
            }
        }
        return check;
    }

    // TreeImplementation 객체 출력 시 -> 일단 IntelliJ 자동완성으로 만든 메서드
    // e.g. TreeImplementation{value='0', children=[TreeImplementation{value='1', children=null}, TreeImplementation{value='2', children=null}, TreeImplementation{value='3', children=null}, TreeImplementation{value='4', children=null}, TreeImplementation{value='5', children=null}]}
    @Override
    public String toString() {
        return "TreeImplementation{" +
                "value='" + value + '\'' +
                ", children=" + children +
                '}';
    }
}

class RunTreeImplementation {
    public static void main(String[] args) {
        TreeImplementation rootNode = new TreeImplementation("0");
//        TreeImplementation rootNode = new TreeImplementation();

        for (int i = 1; i <= 5; i++) {
            rootNode.addChildNode(new TreeImplementation(Integer.toString(i)));
        }

        System.out.println(rootNode); // com.codestates.section2.unit2.tree.TreeImplementation@5a39699c
        System.out.println(rootNode.toString()); // {value: null, children: Solution(5)} -> 나의 질문 = 이렇게 출력하려면 toString()을 어떻게 오버라이딩해야 하지?
        System.out.println(rootNode.contains("6")); // false
        System.out.println(rootNode.contains("1")); // true
    }
}
