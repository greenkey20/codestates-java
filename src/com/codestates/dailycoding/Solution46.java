package com.codestates.dailycoding;

public class Solution46 {
    // 2022.11.17(목) 11h15 dynamic programming의 가장 기초적인 문제
    public int coinChange(int total, int[] coins) {
        /* coins의 원소들(20 이하의 양의 정수들이 다양하게 주어짐, 오름차순으로 정렬되어있음, coins.length <= 10000)을 필요한만큼 사용해서(각 동전의 개수는 무수히 많다고 가정)
        total을 만들 수 있는 모든 경우의 수(int)를 return
        나의 질문 = 아무리 조합해도 total을 만들 수 없는 경우도 있을 수 있나?

        coinChange(동전 교환)를 계산하는 효율적인 알고리즘(coin change algorithm, O(coins.length * total), O(M * N))이 존재함
        쉽지 않기 때문에 바로 레퍼런스 코드를 보고 이해하는 데 집중하기

        입/출력 예시2로 종이에 내가 쓴 loops(기본 틀, general idea) 돌리며 생각해 봤는데, i, i+1, i+2..번째 동전을 함께 사용하는 경우를 구현하지 못함 -> 11h45 일단 제출, 통과x
        */
        int result = 0;
        int sum = 0;

        for (int i = coins.length - 1; i >= 0; i--) {
            int coin = coins[i];
            int maxTimes = total / coin;
            for (int j = maxTimes; j >= 1; j--) {
                sum += coin * j;

                if (sum == total) {
                    result++;
                    continue;
                } else if (sum < total) {
                    // coins[i]보다 작은 단위의 동전(coins[i+1] ~ coins[0])들 각각에 대해 maxTimes 구해서 sum에 더해가며 total에 가까워지도록 만듦 -> sum == total이면 result++ vs sum > total이면 다음 회 loop로 넘어감
                }
            }
        }

        return result;
    }
}
