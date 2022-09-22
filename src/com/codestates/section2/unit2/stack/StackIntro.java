package com.codestates.section2.unit2.stack;

import java.util.Stack;

// 2022.9.22(목) 14h25
public class StackIntro {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        System.out.println(stack); // []

        stack.push(1);
        System.out.println(stack); // [1]

        stack.push(2);
        System.out.println(stack); // [1, 2]

        stack.push(3);
        System.out.println(stack); // [1, 2, 3]

        stack.push(4);
        System.out.println(stack); // [1, 2, 3, 4]

        stack.pop(); // stack의 입구에 가장 가까운/stack에 가장 마지막에 들어온 4를 꺼냄
        System.out.println(stack); // [1, 2, 3]

        System.out.println(stack.pop()); // 3, 꺼낼 대상을 꺼내어 반환하며 stack으로부터 그 요소를 삭제/제거
        System.out.println(stack); // [1, 2]

        stack.pop();
        System.out.println(stack); // [1]

        stack.pop();
        System.out.println(stack); // [], stack에 들어왔던 모든 요소들을 꺼내어 빈 stack이 됨

        stack.pop();
        System.out.println(stack); // 빈 스택에서 pop하려고 했더니 Empty Stack Exception 발생
    }
}
