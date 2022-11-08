package com.codestates.dailycoding.references;

// 2022.10.31(월) 11h35 제출 후, 테스트케이스 6번 통과 왜 못하는지 파악하기 위해 참고용으로 열람
public class Solution34Reference {
    public static int[][] rotateMatrix(int[][] matrix, int K) {
        //빈 배열일 경우
        if (matrix == null || matrix.length == 0) return matrix;

        int N = matrix.length;
        int M = matrix[0].length;

        int rotateNum = K % 4;

        // 회전하지 않는다.
        if (rotateNum == 0) return matrix;

        // 홀수번 회전 시 M x N, 짝수번 회전 시 N x M -> 나의 질문 = 모든 입력 matrix가 정방 행렬이 아닌 것인가?
        int[][] rotated = rotateNum % 2 == 1 ? new int[M][N] : new int[N][M];

        for (int row = 0; row < rotated.length; row++) {
            for (int col = 0; col < rotated[row].length; col++) {
                if (rotateNum == 1) {
                    rotated[row][col] = matrix[N - col - 1][row];
                } else if (rotateNum == 2) {
                    rotated[row][col] = matrix[N - row - 1][M - col - 1];
                } else {
                    rotated[row][col] = matrix[col][M - row - 1];
                }
            }
        }
        return rotated;
    }
}
