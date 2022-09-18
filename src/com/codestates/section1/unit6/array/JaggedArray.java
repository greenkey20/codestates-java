package com.codestates.section1.unit6.array;

import java.util.Arrays;

// 2022.9.18(일) 15h25
public class JaggedArray {
    public static void main(String[] args) {
        int[][] ages = new int[5][]; // 마지막 차수에 해당하는 배열의 크기 지정/고정하지 않음
        System.out.println("ages 배열 출력 = " + Arrays.toString(ages)); // [null, null, null, null, null]

        // 외부 배열의 각 요소에 new int[] 사용해서 할당 = 내부 배열 생성
        ages[0] = new int[4];
        ages[1] = new int[6];
        ages[2] = new int[7];
        ages[3] = new int[8];
        ages[4] = new int[9];

        System.out.println("ages 배열 출력 = " + Arrays.toString(ages)); // [[I@71be98f5, [I@6fadae5d, [I@17f6480, [I@2d6e8792, [I@2812cbfa]

//        System.out.println("ages 배열의 1번째 내부 배열 출력 = " + Arrays.toString(ages[0]));
        for (int i = 0; i < ages.length; i++) {
            System.out.println("ages 배열의 " + (i + 1) + "번째 내부 배열 출력 = " + Arrays.toString(ages[i]));
        }

        // 가변 배열도 생성과 동시에 초기화 가능
        int[][] ages2 = {
                {30, 32, 39, 59},
                {31, 41, 52, 56, 72, 13},
                {45, 32, 84, 23, 13, 42, 55},
                {23, 41, 62, 64, 23, 51, 67, 98},
                {13, 14, 17, 84, 52, 37, 68, 66, 33}
        };

        for (int i = 0; i < ages2.length; i++) {
            System.out.println("ages2 배열의 " + (i + 1) + "번째 내부 배열 출력 = " + Arrays.toString(ages2[i]));
        }
    }
}
