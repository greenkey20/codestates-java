package com.codestates.section1.unit6.loop;

// 2022.9.11(일) 23h45
public class Loop18 {
    public static void main(String[] args) {

    }

    public static String listPrimes(int num) {
        String result = "";
        int count = 0;

        for (int i = 2; i <= num; i++) {
            for (int j = 2; j <= i; j ++) {
                if (num % j == 0) {

                }
            }
        }

        return result;
    }
}
