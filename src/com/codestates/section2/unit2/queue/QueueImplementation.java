package com.codestates.section2.unit2.queue;

import java.util.ArrayList;

// 2022.9.22(목) 16h10
// Java의 ArrayList 자료형을 이용해서 내가 만든/구현한 queue 자료형
/* 추가로 생각해볼 사항
1. ArrayList로 Queue를 사용할 때 add, pull 이외에 필요한 메서드를 어떻게 구현할 수 있나? 아래와 같이 해봄 + 예외 발생시키도록 구현해보자
2. Java의 배열로 Queue를 구현했을때 어떤 단점이 존재할까? queue에 맨처음 들어온 요소부터 제거시켰을 때..(knou 자료구조 교과서 p.84 그림4-15처럼 queue에 원소가 없는데/queue가 채워지지 않았는데 더 이상의 원소 삽입이 불가능할 수 있음)
vs mod(ulus) 연산자 사용해서 원형 queue로 구현
 */
public class QueueImplementation {
    // 멤버 변수
    private ArrayList<Integer> listQueue = new ArrayList<>();

    // 멤버 메서드
    /**
     * 큐에 데이터를 추가
     */
    public void add(Integer data) {
        // FILL_ME_IN;
        listQueue.add(data);
    }

    /**
     * 가장 먼저 추가된 데이터를 큐에서 삭제
     * 삭제한 데이터를 리턴
     */
    public Integer poll() {
        if (listQueue.size() == 0) {
            return null;
        } else {
            return listQueue.remove(0);
        }
    }

    /**
     * 큐에 추가된 데이터의 크기를 리턴
     */
    public int size() {
        int count = 0;

        if (listQueue.isEmpty()) {
            return count;
        }

        for (int i = 0; i < listQueue.size(); i++) {
            count++;
        }

        return count;
        // return listQueue.size();
    }

    /**
     * 큐에 가장 먼저 추가된 데이터를 리턴
     */
    public Integer peek() {
        if (listQueue.size() == 0) {
            return null;
        } else {
            return listQueue.get(0);
        }
    }

    /**
     * 큐에 들어있는 모든 데이터를 String 타입으로 변환하여 리턴
     */
    public String show() {
        return listQueue.toString();
    }

    /**
     * 큐에 들어있는 모든 데이터를 삭제
     */
    public void clear() {
        listQueue.clear();
    }
}

// 2022.11.30(수) 11h10 코플릿 데일리코딩55 풀다가, 원형/순환/circular queue 찾아보다.. 여기 옴
class QueueExercise {
    public static void main(String[] args) {
        QueueImplementation queue = new QueueImplementation();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        System.out.println(queue.show()); // [1, 2, 3, 4, 5]

        queue.poll();
        queue.poll();
        System.out.println(queue.show()); // [3, 4, 5]
    }
}
