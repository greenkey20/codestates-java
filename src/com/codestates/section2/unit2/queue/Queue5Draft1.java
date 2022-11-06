package com.codestates.section2.unit2.queue;

import java.util.LinkedList;
import java.util.Queue;

// 2022.9.23(금) 11h40
public class Queue5Draft1 {
    public static int queuePrinter(int bufferSize, int capacities, int[] documents) {
        /* 큐 size 조건? queue.size() < bufferSize &&
        문서 하나의 크기는 capacities를 초과하지 않음
        */

        /*
        for (int i = 0; i < documents.length; i++) {
          int sumQueue = queue.stream().mapToInt(i -> i).sum();

          if (sumQueue + documents[docIndex] <= capacities) {
            queue.add(documents[docIndex]);
            result++;
          }

          if (queue.size() == bufferSize) {
            queue.poll();
          } else if (queue.size() == 0 && sumQueue + documents[i] <= capacities) {
            queue.add(documents[i]);
          } else if (queue.size() == 1 && sumQueue + documents[i] > capacities) {

          } else if (queue.size() == 0 && sumQueue + documents[i] <= capacities) {

          } else { // if (queue.size() == 0 && sumQueue + documents[i] > capacities)

          }
        }
        */

        // 처음 생각 = bufferSize로 큐나 배열 만듦 vs bufferSize를 큐 생성 시 넣을/사용할 필요 없음
        Queue<Integer> queue = new LinkedList<>();
        int result = 0;
        /*
        queue.add(documents[0]);
        int result = bufferSize + 1;
        if (documents.length == 1) { // 인쇄할 문서의 개수(배열의 길이) = 1 이상 100 이하
            return result;
        }
         */

        // 2022.11.7(월) 1h40 나의 질문 = 아래와 같이 꼭 값 초기화 해줘야 하나? queue 생성 시 0으로 자동으로 안 채워지나? -> 테스트용 콘솔 출력해보니 bufferSize만큼 0 채워주는 작업 필요함
//        System.out.println(queue); // TODO 테스트용 콘솔 출력 -> []
        for (int i = 0; i < bufferSize; i++) {
            queue.add(0);
        }
//        System.out.println(queue); // TODO 테스트용 콘솔 출력 -> [0, 0]

        boolean flag = true;
        int docIndex = 0;

//        int sumQueue = queue.stream().mapToInt(i -> i).sum();

        while (flag) {
            result++; // result += 1과 같이 써도 결과는 동일하게 나옴
            queue.poll(); // 1초가 지나면 일단 queue의 맨 앞에 있는 작업은 처리해서 빠져나감 -> 2022.11.7(월) 1h15 드디어 테스트케이스 2건에 대한 무한루프는 탈출 + 단, 각각 4, 7이라는 결과가 나옴 -> 로직 수정 필요
            int sumQueue = queue.stream().mapToInt(i -> i).sum(); // queue에 남아있는 작업/문서들의 크기의 합 구하기

            // 2022.11.7(월) 1h10 오늘 읽어보니 아래 로직으로는 풀기 어려울 것 같다 + 아래 로직 필요 없는 것 같다
            // 이유1 = queue에 bufferSize만큼 0을 채워두고 시작하는 바, queue 크기를 조건으로 사용하는 것은 의미가 없음
            /*
            if (queue.size() < bufferSize && docIndex < documents.length - 1) {
                if (sumQueue + documents[docIndex] <= capacities) {
                    queue.add(documents[docIndex]);
                    if (docIndex != documents.length - 1) { // IntelliJ는 'docIndex < documents.length' 조건이 왜 항상 true라고 하는 거지?
                        docIndex += 1;
                    }
                }
            } else {
                queue.poll();
                sumQueue = queue.stream().mapToInt(i -> i).sum();

                if (sumQueue + documents[docIndex] <= capacities) {
                    queue.add(documents[docIndex]);
                    if (docIndex != documents.length - 1) {
                        docIndex++;
                    }
                }
//                else {
//                    queue.add(0);
//                }
            }
            */
            if (docIndex < documents.length - 1) { // 다음에 처리해야 할 문서가 마지막 문서가 아니라면
                if (sumQueue + documents[docIndex] <= capacities) { // '현재 queue에 있는 작업들의 크기 + 금번 처리해야 할 문서의 크기'가 프린터 용량보다 같거나 작은 경우
                    queue.add(documents[docIndex]); // 금번 처리할 문서를 queue로 받아들임
                    // docIndex += 1; // 다음 시간 단위에는 새로운 문서를 받아들일 수 있도록 docIndex를 1 증가시켜놓음

                    // 다음에 처리해야 할 문서가 마지막 문서가 아니라면
                    if (docIndex != documents.length - 1) { // IntelliJ는 'docIndex < documents.length' 조건이 왜 항상 true라고 하는 거지?
                        docIndex += 1;
                    }
                } else { // '현재 queue에 있는 작업들의 크기 + 금번 처리해야 할 문서의 크기'가 프린터 용량보다 큰 경우 = 새로운 문서를 queue에 받아들일 수 없음
                    queue.add(0);
                }
            }
            // 2022.11.7(월) while문 1번 돌 때마다 콘솔 출력한 결과 확인해보고, 1h55 수정 -> 다시 무한루프에 빠짐

            if (sumQueue == 0 && docIndex == documents.length - 1) {
                flag = false;
            }

            System.out.println(result + "초에 queue = " + queue); // TODO 테스트용 콘솔 출력
        }

        return result + 1;
    }

    public static void main(String[] args) {
        // test case1
        int bufferSize1 = 2;
        int capacities1 = 10;
        int[] documents1 = new int[]{7, 4, 5, 6};

        int output1 = queuePrinter(bufferSize1, capacities1, documents1);
        System.out.println(output1); // 8

        // test case2
        int bufferSize2 = 3;
        int capacities2 = 10;
        int[] documents2 = new int[]{7, 4, 5, 6, 2, 3};

        int output2 = queuePrinter(bufferSize2, capacities2, documents2);
        System.out.println(output2); // 14
    }
}
