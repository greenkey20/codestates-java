package com.codestates.section2.unit2.stack;

import java.util.ArrayList;

// 2022.9.22(목) 15h25
// Java의 ArrayList 자료형을 이용해서 내가 만든/구현한 stack 자료형
public class StackImplementation {
    // 멤버 변수
    private ArrayList<Integer> listStack = new ArrayList<>(); // Integer 데이터를 stack으로/처럼 쌓을/저장할 ArrayList -> 나의 질문 = 왜 하필 ArrayList를 사용하는가?
    /* 나의 생각 = ArrayList에는 순서가 있음, 값 중복 저장 가능, 배열처럼 물리적으로 인접한 메모리 사용, 값을 넣고 빼고 조회하는 등 자료 구조로써 자료를 다루는 데에 필요한 기능들이 구현되어 있음, 배열에 비해 size/크기 사용이 비교적 자유로움, 선형 자료구조, 어차피 자료 구조의 한 쪽 끝에서만 변경이 일어나므로 LinkedList에 비해 자료 수정이 어려운 점은 문제 안 됨..
    추가로 생각해볼 사항
    1. ArrayList로 Stack을 사용할 때 주의해야 할 사항 -> 아직 잘 모르겠음.. 자료가 들어오고 빠져나가는 index 관리?
    2. ArrayList로 Stack을 사용할 때 push, pop 이외에 필요한 메서드를 어떻게 구현할 수 있나? 아래와 같이 해봄
    3. Java의 배열로 Stack을 구현했을 때 어떤 단점이 존재할까? size의 유연성 부족 -> stack이 꽉 찬 경우, index out of bound 등 예외 처리..
     */


    // reference code에는 아래 int형 상수 있는데, 무슨 의미/용도이지?
    int FILL_ME_IT;

    // 멤버 메서드
    public void push(Integer data) {
        // FILL_ME_IN;
        listStack.add(data);
    }

    /**
     * 가장 나중에 추가된 데이터를 스택에서 삭제
     * @return 삭제한 데이터를 리턴
     */
    public Integer pop() {
        if (listStack.isEmpty()) { // reference code에서는 listStack.size() == 0로 조건 확인
            return null;
        } else {
            return listStack.remove(listStack.size() - 1);
        }
    }

    /**
     * @return 스택에 추가된 데이터의 크기를 리턴
     */
    public int size() {
        return listStack.size();
        // 내가 생각했던 구현 방식 = listStack.isEmpty() -> return 0 vs listStack 순회하며 count++하고 return count -> QueueImplementation에서 구현해봄
    }

    /**
     * @return 가장 나중에 추가된 데이터를 리턴
     */
    public Integer peek() {
        if (listStack.isEmpty()) {
            return null;
        } else {
            return listStack.get(listStack.size() - 1);
        }
    }

    /**
     * @return 현재 스택에 포함되어 있는 모든 데이터를 String 타입으로 변환하여 리턴
     */
    public String show() {
        return listStack.toString(); // 나의 질문 = ArrayList(-> AbstractCollection) 클래스의 toString() 메서드 정의 내용 보기
    }

    /**
     * 현재 스택에 포함되어 있는 모든 데이터 삭제
     */
    public void clear() {
        listStack.clear();
    }
}
