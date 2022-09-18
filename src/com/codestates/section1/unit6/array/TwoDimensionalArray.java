package com.codestates.section1.unit6.array;

import java.util.Arrays;

// 2022.9.18(일) 15h35
// 2차원 배열 = '(외부)배열의 요소 = 배열'
public class TwoDimensionalArray {
    public static void main(String[] args) {
        int[][] kcal = new int[31][3]; // 배열의 선언 및 초기화

        System.out.println(Arrays.toString(kcal)); // [[I@2c8d66b2,와 같은 주소 값이 31개 들어있는 배열]
        System.out.println(Arrays.toString(kcal[4])); // [0, 0, 0]

        // kcal 배열이 메모리 상에 어떻게 생성되어있는지 그림 그려보기
    }
}
