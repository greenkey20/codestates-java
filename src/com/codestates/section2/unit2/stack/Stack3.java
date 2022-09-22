package com.codestates.section2.unit2.stack;

import java.util.ArrayList;
import java.util.Stack;

// 2022.9.22(목) 17h pair programming 시간에 각자 풀어보기
public class Stack3 {
    public static ArrayList<Stack> browserStack(String[] actions, String start) {
    /* 조건
    1. 새로운 페이지로 접속(알파벳 대문자)할 경우, 원래 있던 페이지를 prev 스택에 넣고 + next 스택을 비웁니다
     - 처음에 풀 때 문제 잘못 해석해서 아래와 같이 쓸데 없이 history 저장 공간 마련해서 쓰려고 했음
     // 방문한 페이지들(알파벳 대문자들)을 모아두는 집합(set)
        HashSet<String> history = new HashSet<>();
        history.add(start);

        if (!history.contains(actions[i])) { // 새로운 페이지로 접속한 경우
            history.add(actions[i]); // 방문한 페이지 이력 집합에 요소로 추가
    2. 뒤로 가기 버튼을 누를(-1) 경우, 원래 있던 페이지를 next 스택에 넣고 + prev 스택의 top에 있는 페이지로 이동한 뒤 prev 스택의 값을 pop
    3. 앞으로 가기 버튼을 누를(1) 경우, 원래 있던 페이지를 prev 스택에 넣고 + next 스택의 top에 있는 페이지로 이동한 뒤 next 스택의 값을 pop
    4. 브라우저에서 뒤/앞으로 가기 버튼이 비활성화일 경우(클릭이 되지 않을 경우), 스택(어떤 스택에? 이해 안 됨)에 push 하지 않습니다 -> actions 배열의 현재 탐색 중인 원소가 -1 또는 1인 경우 prev스택이나 next스택이 비어있지 않을 때만 해당 동작 실행하려고 조건문 썼는데, 아무리 해도 내 아이디어로는 비공개 테스트 4개 통과 안 되어서, 페어님 코드 참고
       (페어님 아이디어 = if (actions[i].equals("-1")) {
                         if (!prevStack.isEmpty()) {..)
       -> 내가 쓴 조건문대로 했을 때 별도로 처리했어야 하는 경우의 수들이 else로 다 빠져서 의도하는 대로 동작 안 함

    e.g. start = A, actions = {"B", "C", "-1", "D", "A", "-1", "1", "-1", "-1"}
    */
        Stack<String> prevStack = new Stack<>(); // A
        Stack<String> current = new Stack<>(); // B
        Stack<String> nextStack = new Stack<>(); // A D

        ArrayList<Stack> result = new ArrayList<>();

        // TODO:
        // 만약 start의 인자로 알파벳 대문자가 아닌 다른 데이터가 들어온다면 false를 리턴
        if (!(65 <= start.charAt(0) && start.charAt(0) <= 90 && start.length() == 1)) {
            return null; // 나의 질문 = 메서드 반환형이 ArrayList인데 false(Boolean 값) 반환 가능한가?
        }

        // 인자로 받은 start 페이지는 current 스택에 쌓고 시작하게 됨
        current.push(start);

        // 인자로 받은 actions 문자열 배열의 요소를 하나하나 순회하며,
        for (int i = 0; i < actions.length; i++) {
            if (actions[i].equals("-1") && !prevStack.isEmpty()) { // 뒤로 가기 버튼 누른 행동 + 뒤로 가기 버튼이 활성화되어 있는/prevStack이 비어있지 않은 경우에만
                nextStack.push(current.pop()); // 원래 있던 페이지를 next 스택에 넣고
                current.push(prevStack.pop()); // prev 스택의 top에 있는 페이지로 이동한 뒤 prev 스택의 값을 pop + prevStack이 비어있다면/뒤로 가기 버튼이 비활성화되어 있는 경우 Empty Stack Exception
            } else if (actions[i].equals("1") && nextStack.size() != 0) { // 앞으로 가기 버튼 누른 행동 + 앞으로 가기 버튼이 활성화되어 있는/nextStack이 비어있지 않은 경우에만
                prevStack.push(current.pop()); // 원래 있던 페이지를 prev 스택에 넣고
                current.push(nextStack.pop()); // next 스택의 top에 있는 페이지로 이동한 뒤 next 스택의 값을 pop + nextStack이 비어있다면/앞으로 가기 버튼이 비활성화되어 있는 경우 Empty Stack Exception
            } else if (actions[i].equals("-1") || actions[i].equals("1")) { // reference code 보고 else if 조건절 추가; 뒤/앞으로 가기 버튼 누르는 행동 나왔는데, prev/next스택이 비어있는 경우 -> 페어님 아이디어처럼 조건 처리하는 것이 더 깔끔한 것 같음
                // 아무 동작도 하지 않음
            } else { // 알파벳 대문자가 나온 경우 = 새로운 페이지로 접속하는 행동
                prevStack.push(current.pop()); // 원래 있던 페이지를 prev 스택에 넣음
                current.push(actions[i]); // 현재 페이지 = 지금 접속하고자 하는 페이지 = actions[i]
//                prevStack.push(current.pop()); // 원래 있던 페이지를 prev 스택에 넣음; version1을 IntelliJ에서 실행해보니 테스트 케이스와 비스무리한 형태의 결과는 나옴 -> 새로운 페이지 접속 정보 저장이 잘 안 되고 있는 것 같아서 이 조건문 재검토 -> 이 명령문을 아래줄에 써서 논리적 오류 발생
                nextStack.clear();
            }
        }

    // 출력값 ArrayList의 첫 번째 요소 prev 스택 + 두번째 요소 current 스택 + 세 번째 요소 next 스택
        result.add(prevStack);
        result.add(current);
        result.add(nextStack);

        return result;
}

    public static void main(String[] args) {
        String[] actions1 = new String[]{"B", "C", "-1", "D", "A", "-1", "1", "-1", "-1"};
        String start1 = "A";
        ArrayList<Stack> output = browserStack(actions1, start1);
        System.out.println(output); // [["A"], ["B"], ["A", "D"]]

        String[] actions2 = new String[]{"B", "-1", "B", "A", "C", "-1", "-1", "D", "-1", "1", "E", "-1", "-1", "1"};
        String start2 = "A";
        ArrayList<Stack> output2 = browserStack(actions2, start2);
        System.out.println(output2); // [["A", "B"], ["D"], ["E"]]
    }
}
