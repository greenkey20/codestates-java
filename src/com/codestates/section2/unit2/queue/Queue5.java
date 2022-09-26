package com.codestates.section2.unit2.queue;

import java.util.LinkedList;
import java.util.Queue;

// 2022.9.23(금) 11h40
public class Queue5 {
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

        for (int i = 0; i < bufferSize; i++) {
            queue.add(0);
        }

        boolean flag = true;
        int docIndex = 0;

//        int sumQueue = queue.stream().mapToInt(i -> i).sum();

        while (flag) {
            result++;
            int sumQueue = queue.stream().mapToInt(i -> i).sum();

            if (queue.size() < bufferSize && docIndex < documents.length - 1) {
                if (sumQueue + documents[docIndex] <= capacities) {
                    queue.add(documents[docIndex]);
                    if (docIndex != documents.length - 1) { // IntelliJ는 'docIndex < documents.length' 조건이 왜 항상 true라고 하는 거지?
                        docIndex += 1;
                    }
                }
//                else {
//                    queue.add(0);
//                }
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

            if (sumQueue == 0 && docIndex == documents.length - 1) {
                flag = false;
            }
        }

        return result;
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
