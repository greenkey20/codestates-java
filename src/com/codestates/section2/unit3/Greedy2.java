package com.codestates.section2.unit3;

// 2023.7.17(월) 23h
public class Greedy2 {
    public int partTimeJob(int k) {
        int count = 0;
        int[] coins = {500, 100, 50, 10, 5, 1};
        int idx = 0;

        while (k > 0) {
            int thisCoin = coins[idx];
            int num = k / coins[idx];
            count += num;
            k -= thisCoin * num;
            idx++;
        }

        return count;
    }

    public int partTimeJobReference(int k) {
        int result = 0;
        //동전의 종류를 배열에 넣어준 이후
        int[] wallet = new int[]{500, 100, 50, 10, 5, 1};
        //해당 동전의 종류만큼 배열을 순회합니다.
        for (int i = 0; i < wallet.length; i++) {
            //총 금액이 0보다 클때마다
            if (k > 0) {
                //총 금액을 현재 동전으로 나눈 수를 구합니다(해당 동전의 총 갯수)
                int sum = (int) Math.floor((double) k / wallet[i]);
                //해당 동전의 갯수를 결과에 더해준 이후
                result = result + sum;
                //총 금액을 사용한 동전의 금액만큼 차감합니다.
                k = k - (wallet[i] * sum);
            }
        }
        //결과를 반환합니다.
        return result;
    }
}
