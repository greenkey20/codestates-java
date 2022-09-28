package com.codestates.section2.unit3;

import java.util.Arrays;

public class Greedy1 {
    // 2022.9.28(수) 16h15
    public static int movingStuff(int[] stuff, int limit) {
        /* 옮겨야 할 짐의 개수(stuff 배열의 원소의 개수)는 1개 이상 50,000개 이하
        limit(상자 1개의 무게 제한)는 40 이상 240 이하의 자연수
        박스의 무게 제한은 항상 짐의 무게 중 최대값보다 크게 주어지므로 짐을 나르지 못하는 경우는 없음
        */
        int count = 0;

        // stuff 배열의 원소들(짐의 무게)를 오름차순으로 정렬
        Arrays.sort(stuff);
        System.out.println(Arrays.toString(stuff));

        // 가장 가벼운 짐부터 박스 1개에 담아가며, 짐 1개 추가할 때마다 무게 sum <= limit인지 확인
        // 다음 박스로 넘어갈 때 count++
        // version1) 우연히 간단한 테스트 케이스(코플릿 입/출력 예시)는 통과하나 맞지 않은(absurd) 로직 + 게다가 나는 '박스는 너무 작아서 한번에 최대 2개의 짐 밖에 넣을 수 없다'는 조건 놓침
        int sum = 0;

        for (int i = 0; i < stuff.length; i++) {
            sum += stuff[i];

            if (sum >= limit) {
                i--;
                count++;
                sum = 0;
            }
        }

        // idea pieces/draft
        // stuff 배열의 마지막 인덱스 ~ 0번 인덱스까지 순회하며
        // if (stuff[i] <= limit),
        /* while (stuff.length != 0) {

        }

        while (sum <= limit) {
          for (int i = 0; i < stuff.length; i++) {
            sum += stuff[i];
          }
        }

        if (sum < limit) {
            continue;
        } else {
            stuff = Arrays.copyOfRange(stuff, i + 1, stuff.length);
            System.out.println(Arrays.toString(stuff));
            count++;
            sum = 0;
            i = 0;
        }ㄸ

        '백팩 알고리즘 탐욕' 검색해보기
        */

        return count;
    }

    public static void main(String[] args) {
        int output1 = movingStuff(new int[]{70, 50, 80, 50}, 100);
        System.out.println(output1); // 3

        int output2 = movingStuff(new int[]{60, 80, 120, 90, 130}, 140);
        System.out.println(output2); // 4
    }
}
