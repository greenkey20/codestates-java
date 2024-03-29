package com.codestates.section2.unit3;

import java.util.Arrays;

public class Greedy1 {
    // 2023.7.17(월) 8h40
    public int movingStuffV2(int[] stuff, int limit) {
        int boxCount = 0;
        int innerCount = 0;

        Arrays.sort(stuff);
        int[] stuffDesc = new int[stuff.length];

        for (int i = stuff.length - 1; i >= 0; i--) {
            stuffDesc[stuff.length - 1 - i] = stuff[i];
        }
        System.out.println("stuffDesc = " + Arrays.toString(stuffDesc)); // todo

        int freeSpace = 0;
        for (int i = 0; i < stuffDesc.length; i++) {
            int thisStuff = stuffDesc[i];

            if (freeSpace >= thisStuff) {
                if (innerCount == 1) { // 기존에 시작한 상자에 2번째 stuff를 추가로 넣을 수 있음
                    innerCount = 0;
                    continue;
                }
            }

            // 그 외의 경우에는 새로 상자를 시작해야 함
            boxCount++;
            innerCount = 1;

            freeSpace = limit - thisStuff;
        }

        return boxCount;
    }

    // 2022.9.28(수) 16h15
    public static int movingStuffV1(int[] stuff, int limit) {
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
        // version2) 2개의 짐을 담아야 하는 알고리즘 생각하기
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
        Greedy1 greedy1 = new Greedy1();
        int output1 = greedy1.movingStuffV2(new int[]{70, 50, 80, 50}, 100);
        System.out.println(output1); // 3

        int output2 = greedy1.movingStuffV2(new int[]{60, 80, 120, 90, 130}, 140);
        System.out.println(output2); // 4

        int output3 = greedy1.movingStuffV2(new int[]{167, 103, 73, 60, 42, 25}, 187);
        System.out.println(output3); // 4
    }

    public int movingStuffReference(int[] stuff, int limit) {
        int twoStuff = 0;

        // 짐을 무게순으로 오름차순 정렬
        Arrays.sort(stuff);
        // 가장 가벼운 짐의 인덱스
        int leftIdx = 0;
        // 가장 무거운 짐의 인덱스
        int rightIdx = stuff.length - 1;

        while (leftIdx < rightIdx) {
            // 가장 가벼운 짐과 무거운 짐의 합이 limit 보다 작거나 같으면 2개를 한번에 나를 수 있다
            if (stuff[leftIdx] + stuff[rightIdx] <= limit) {
                // 다음 짐을 확인하기 위해 가장 가벼운 짐과 무거운 짐을 가리키는 인덱스를 옮겨주고
                // 한번에 2개 옮길 수 있는 개수를 +1 해준다
                leftIdx++;
                rightIdx--;
                twoStuff++;
            } else {
                // 위 조건에 맞지 않는 경우는 한번에 한 개만 나를 수 있는 경우이기 때문에
                // 가장 무거운 짐의 인덱스만 옮겨준다
                rightIdx--;
            }
        }

        // 전체 짐의 개수에서 한번에 2개를 나를 수 있는 경우를 빼 주면 총 필요한 박스의 개수를 구할 수 있다
        return stuff.length - twoStuff;
    }
}
