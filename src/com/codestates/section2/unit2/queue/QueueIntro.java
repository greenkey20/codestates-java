package com.codestates.section2.unit2.queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

// 2022.9.22(목) 14h55
public class QueueIntro {
    public static void main(String[] args) {
        Queue<Character> queue = new LinkedList<>(); // 나의 질문 = 왜 linked list 자료형 사용?
        System.out.println(queue); // []

        queue.add('a');
        System.out.println(queue); // [a]

        queue.add('E');
        System.out.println(queue); // [a, E]

        queue.add('e');
        System.out.println(queue); // [a, E, e]

        queue.add('i');
        System.out.println(queue); // [a, E, e, i]

        queue.poll(); // retrieves and removes the head of this queue, or returns null if this queue is empty
        System.out.println(queue); // [E, e, i]

        queue.poll();
        System.out.println(queue); // [e, i]

        queue.poll();
        System.out.println(queue); // [i]

        queue.poll();
        System.out.println(queue); // [], queue에 들어왔던 모든 요소들을 꺼내어 빈? queue가 됨

        queue.poll();
        System.out.println(queue); // [] <- poll() 메서드는 queue가 비어있는 경우 null 반환
    }
}
