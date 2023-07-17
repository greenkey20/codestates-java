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
}
