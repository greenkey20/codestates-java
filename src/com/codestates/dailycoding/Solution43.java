package com.codestates.dailycoding;

import java.util.Arrays;

public class Solution43 {
    // 2022.11.11(금) 11h15 -> 12h25 v1 실행 시 array index out of bounds -> 12h40 테스트케이스1 선언/초기화 line에 break point 걸고 디버깅해 보았으나, 아직 오류 파악 못함
    public static String spiralTraversal(Character[][] matrix) {
		/* Character 타입의 요소를 가진 2차원 M행(세로 길이 = matrix.length = M) x N열(가로 길이 = matrix[0].length = N) 배열을 나선형(spiral)으로 순회 -> 배열의 모든 요소를 순서대로 이어붙인 문자열을 리턴
		순회는 좌측 상단 (0,0)에서 시작

		종이에 배열의 나선형 순회를 그려보고, 움직임의 패턴 찾음
		*/
        int M = matrix.length;
        int N = matrix[0].length;

        StringBuilder sb = new StringBuilder(M * N);
//        int[][] flags = new int[M][N];
//        int productOfFlags = 0;
        int count = 0;
        int i = 0;
        int j = 0;

        while (M + N > 2) {
            switch (count % 4) {
                case 0:
                    for (; j < matrix[i].length; j++) {
                        sb.append(matrix[i][j]);
                    }

                    count++;
                    matrix = copyMatrix(matrix, i++, j);
                    System.out.println("count는 " + count + "이고, matrix는 " + Arrays.toString(matrix));
                    break;
                case 1:
                    for (; j < matrix.length; i++) {
                        sb.append(matrix[i][j]);
                    }

                    count++;
                    matrix = copyMatrix(matrix, i, j--);
                    System.out.println("count는 " + count + "이고, matrix는 " + Arrays.toString(matrix));
                    break;
                case 2:
                    for (; j >= 0; j--) {
                        sb.append(matrix[i][j]);
                    }

                    count++;
                    matrix = copyMatrix(matrix, i--, j);
                    System.out.println("count는 " + count + "이고, matrix는 " + Arrays.toString(matrix));
                    break;
                case 3:
                    for (; i >= 0; i--) {
                        sb.append(matrix[i][j]);
                    }

                    count++;
                    matrix = copyMatrix(matrix, i, j++);
                    System.out.println("count는 " + count + "이고, matrix는 " + Arrays.toString(matrix));
            }
        } // while문 영역 끝

        sb.append(matrix[0][0]);
        return sb.toString();
    }

    public static Character[][] copyMatrix(Character[][] matrix, int i, int j) {
        Character[][] result = new Character[i][j];
        for (int k = 0; k < result.length; k++) {
            System.arraycopy(matrix[k], 0, result[k], 0, matrix[k].length);
        }

        return result;
    }

    public static void main(String[] args) {
        Character[][] matrix = new Character[][]{
                {'A', 'B', 'C'},
                {'D', 'E', 'F'},
                {'G', 'H', 'I'},
        };
        String output = spiralTraversal(matrix);
        System.out.println(output); // ABCFIHGDE

        matrix = new Character[][]{
                {'T', 'y', 'r', 'i'},
                {'i', 's', 't', 'o'},
                {'n', 'r', 'e', 'n'},
                {'n', 'a', 'L', ' '},
        };
        output = spiralTraversal(matrix);
        System.out.println(output); // Tyrion Lannister
    }
}
