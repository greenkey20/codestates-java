package com.codestates.section2.unit3;

import java.util.ArrayList;

// 2022.9.29(목) 오후 pair programming
public class Gcd {
    public static ArrayList<Integer[]> divideChocolateStick(int M, int N) {
        ArrayList<Integer[]> result = new ArrayList<>();

        int gcd = gcd(M, N);
        System.out.println(gcd);

        for (int i = 1; i <= gcd; i++) {
            if (gcd % i == 0) {
                result.add(fillList(i, M, N));
            }
        }

        System.out.println(result);

        return result;
    }

    public static Integer[] fillList(int gcd, int M, int N) { // [1, 4, 8], [2, 2, 4], [4, 1, 2]
        Integer[] result = new Integer[3];

        result[0] = gcd;
        result[1] = M / gcd;
        result[2] = N / gcd;

        return result;
    }

    public static int gcd(int M, int N) {
        if (N == 0) {
            return M; // M = 최대공약수
        }

        return gcd(N, M % N);
    }

    public static void main(String[] args) {
        int M = 4;
        int N = 8;
        ArrayList<Integer[]> output = divideChocolateStick(M, N);
        System.out.println(output); // [[1, 4, 8], [2, 2, 4], [4, 1, 2]]


    }
}
