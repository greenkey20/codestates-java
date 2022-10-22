package com.codestates.section2.unit2.tree;

import java.util.ArrayList;

// 2022.9.26(월) 11h25
// 2진 탐색 트리
public class BinarySearchTreeImplementation {
    // 트리를 구성하는 노드 클래스; inner class로 정의
    public static class Node {
        // 멤버변수
        private int data; // 입력 데이터를 담음
        private Node left; // 왼쪽에 Node를 저장
        private Node right; // 오른쪽에 Node를 저장

        // 생성자
        public Node(int data) {
            this.setData(data);
            setLeft(null); // 2022.10.22(토) 18h20 나의 질문 = 왜 left 및 right 멤버변수에 대한 setters에는 this를 안 붙이지?
            setRight(null);
        }

        // g/setter
        public int getData() {
            return data;
        }

        public Node getLeft() {
            return left;
        }

        public Node getRight() {
            return right;
        }

        public void setData(int data) {
            this.data = data;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public void setRight(Node right) {
            this.right = right;
        }
    }

    // 이진 탐색 트리의 클래스; inner class로 정의
    public static class BinarySearchTree {
        // 멤버변수
        public Node root; // tree 구조를 이루는 Node 타입의 root

        // 생성자
        public BinarySearchTree() {
            root = null;
        }

        // tree에 value를 추가; 입력받은 value/data를 binary search에 맞게 tree에 계층적으로 추가 -> 2022.10.22(토) 21h 복습 시 간단한 예시 트리 그려서 동작 이해는 했지만, 나의 생각 = 이런 알고리즘은 어떻게 구상하고 구현할 수 있는 것일까?
        public void insert(int data) {
            Node newNode = new Node(data); // 왼/오른쪽 자식 노드가 null이며, data의 값이 저장된 새 노드 생성

            if (root == null) { // 루트 노드가 없을 때 = 트리가 비어있는 상태일 때
                root = newNode; // 이번에 새로 생성한 노드가 루트 노드가 됨
                return;
            }

            if (root.data == data) return; // 중복일 때 정지

            // 루트 노드가 있는 경우
            Node currentNode = root;
            Node parentNode = null;

            while (true) {
                parentNode = currentNode;

                if (data < currentNode.getData()) { // 해당 노드보다 작을 경우
                    currentNode = currentNode.getLeft();
                    if (currentNode == null) {
                        parentNode.setLeft(newNode);
                        return;
                    } else if (currentNode.data == newNode.data) return; // 2진 탐색 트리는 자료 중복 허용x
                } else { // 해당 노드보다 클 경우
                    currentNode = currentNode.getRight();
                    if (currentNode == null) {
                        parentNode.setRight(newNode);
                        return;
                    } else if (currentNode.data == newNode.data) return;
                }
            }
        }

        // tree에 포함된 value/data(값) 탐색/찾기
        // 어떤 동급생 분의 의견 = 메모리 주소 바꿔치기 같네요 -> 강사님 설명 = 그렇게 볼 수 있음, 탐색 기준이 자식 노드로 내려감, 정렬이 되어있는 바, 크기에 따라 조금 더 효율적으로 찾을 수 있을 것 -> 2022.10.22(토) 21h15 나의 질문 = pourquoi/comment? 정확히 이해 안 감..
        public boolean contains(int data) {
            Node currentNode = root;

            while (currentNode != null) {
                // 찾는 value/data 값이 노드의 value/data와 일치한다면 = tree에 포함하고 있다면
                if (currentNode.data == data) {
                    return true; // true를 리턴
                }

                // 찾는 value/data 값이 노드의 value/data 보다 작다면
                if (currentNode.data > data) { // 2022.10.22(토) 21h5 나의 질문 = 위 insert() 메서드에서 currentNode의 getter 이용해서 data 값 읽어오는 것 vs 이렇게 data 값 직접 접근 차이가 있나? -> 코플릿에서는 getter로 data 읽어오는 것으로 코드 수정해도 모든 테스트케이스는 통과함
                    currentNode = currentNode.left; // 현재 노드를 left로 변경 후 다시 반복
                } else { // 찾는 value/data 값이 노드의 value/data보다 크다면
                    currentNode = currentNode.right; // 현재 노드를 right로 변경 후 다시 반복
                }
            }

            return false;
        }

        /* 트리의 순회 구현 = 순회 + 함수를 매개변수로 받아 콜백 함수에 값을 적용시킨 것을 순회
        전위 순회를 통해 어떻게 탐색하는지 이해를 한다면, 중/후위 순회는 쉽게 다가올 것임
         */
        // 이진 탐색 트리를 전위 순회하는 메서드 = 전위 순회를 통해 트리의 모든 요소를 정렬하여 ArrayList 타입으로 반환
        public ArrayList<Integer> preorderTree(Node root, int depth, ArrayList<Integer> list) {
            if (root != null) {
                list.add(root.getData());
                preorderTree(root.getLeft(), depth + 1, list); // depth + 1 = 자식 노드가 하나씩 깊어짐
                preorderTree(root.getRight(), depth + 1, list);
            }

            return list;
        }

        // 중위 순회를 통해 트리의 모든 요소를 정렬하여 ArrayList 타입으로 반환 <- 전위 순회를 바탕으로 중위 순회를 구현
        public ArrayList<Integer> inorderTree(Node root, int depth, ArrayList<Integer> list) {
            if (root != null) {
                inorderTree(root.getLeft(), depth + 1, list);
                list.add(root.getData());
                inorderTree(root.getRight(), depth + 1, list);
            }

            return list;
        }

        // 후위 순회를 통해 트리의 모든 요소를 정렬하여 ArrayList 타입으로 반환, 데이터를 마지막에 <- 전위 순회를 바탕으로 후위 순회를 구현
        public ArrayList<Integer> postorderTree(Node root, int depth, ArrayList<Integer> list) {
            if (root != null) {
                postorderTree(root.getLeft(), depth + 1, list);
                postorderTree(root.getRight(), depth + 1, list);
                list.add(root.getData());
            }

            return list;
        }
    }
}

class RunBinarySearchTreeImplementation {
    public static void main(String[] args) {
        BinarySearchTreeImplementation.BinarySearchTree tree = new BinarySearchTreeImplementation.BinarySearchTree();
        tree.root = new BinarySearchTreeImplementation.Node(10);
        tree.insert(7);
        tree.insert(8);
        tree.insert(12);
        tree.insert(11);

        // 만들어진 tree 내용 확인
        System.out.println(tree.root.getLeft().getRight().getData()); // 8
        System.out.println(tree.root.getRight().getLeft().getData()); // 11

        ArrayList<Integer> preorderedTree = tree.preorderTree(tree.root, 0, new ArrayList<Integer>());
        System.out.println(tree.toString()); // [10, 7, 8, 12, 11]
        System.out.println(tree); // 2022.10.22(토) 21h50 나의 출력 결과 = com.codestates.section2.unit2.tree.BinarySearchTreeImplementation$BinarySearchTree@3cb5cdba
    }
}

