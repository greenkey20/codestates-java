package com.codestates.section2.unit2.queue;

// 2022.9.22(목) 16h30
public class ArrayListAsQueue {
    public static void main(String[] args) {
        QueueImplementation queue = new QueueImplementation();
        System.out.println(queue.show()); // []

        queue.add(1);
        System.out.println(queue.show()); // [1]

        queue.add(2);
        System.out.println(queue.show());

        queue.add(3);
        System.out.println(queue.show());

        queue.add(4);
        System.out.println(queue.show());

        queue.add(5);
        System.out.println(queue.show()); // [1, 2, 3, 4, 5]

        queue.poll();
        System.out.println(queue.show()); // [2, 3, 4, 5]

        System.out.println(queue.poll()); // 2
        System.out.println(queue.show()); // [3, 4, 5]

//        queue.clear(); // 큐에 들어있는 모든 데이터를 삭제
//        System.out.println(queue.show()); // []

        queue.poll();
        System.out.println(queue.show()); // [4, 5]

        queue.poll();
        System.out.println(queue.show()); // [5]

        queue.poll();
        System.out.println(queue.show()); // []

        queue.poll();
        System.out.println(queue.show()); // []
    }
}
