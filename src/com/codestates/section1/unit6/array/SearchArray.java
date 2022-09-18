package com.codestates.section1.unit6.array;

import java.util.Arrays;

// 2022.9.18(일) 14h
public class SearchArray {
    public static void main(String[] args) {
        int[] scores = {100, 90, 85, 95, 99};
        System.out.println(scores); // [I@2c8d66b2

        // 배열 순회
        // 방법1) for문
        int sum1 = 0;
        for (int i = 0; i < scores.length; i++) {
            sum1 += scores[i];
//            scores[i] = 1;
        }

        System.out.println("scores 배열에 담긴 점수들의 합 = " + sum1);
        System.out.println("for문 사용 -> " + Arrays.toString(scores)); // [1, 1, 1, 1, 1]

        // 방법2) while문
        int sum2 = 0;
        int k = 0;
        while (k < scores.length) {
//            sum += scores[k];
//            i++;

//            더 간단히 쓸 수 있는 코드
            sum2 += scores[k++];
//            scores[k++] = 2;
        }

        /*
        int j = scores.length - 1;
        while (scores.length > 0) {
            sum2 += scores[j--]; // Array Index Out Of Bounds Exception <- Index -1 out of bounds for length 5
        }
         */

        System.out.println("scores 배열에 담긴 점수들의 합 = " + sum2);
        System.out.println("while문 사용 -> " + Arrays.toString(scores)); // [2, 2, 2, 2, 2]

        // 방법3) 향상된 for문 -> 배열이나 컬렉션에 저장된 요소들을 읽어오는 용도로만 사용 가능, 요소들의 값 변경/수정 불가능
        int sum3 = 0;
        for (int score : scores) {
            sum3 += score;
//            score = 3;
        }

        System.out.println("scores 배열에 담긴 점수들의 합 = " + sum3);
        System.out.println("향상된 for문 사용 -> " + Arrays.toString(scores)); // [2, 2, 2, 2, 2]
    }
}
