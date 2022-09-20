package com.codestates.dailycoding;

public class Solution2 {
    // 2022.9.20(화) 10h7
    public int computeWhenDouble(double interestRate) {
        // TODO:
        int year = 0;
        double balance = Math.pow(1 + interestRate / 100, year);

        while (balance < 2.0) {
            year++;
            balance = Math.pow(1 + interestRate / 100, year);
        }

        return year;
    }
}
