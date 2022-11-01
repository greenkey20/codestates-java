package com.codestates.dailycoding;

import com.codestates.dailycoding.references.Solution34Reference;

public class Solution34 {
    // 2022.10.31(월) 10h30 -> 11h25 테스트케이스 6번 '배열을 시계방향으로 입력받은 횟수만큼 회전한 배열을 리턴해야 합니다' 통과 못하는데, IntelliJ 실행 시 입/출력 예시대로 나오는데, 왜인지, 해당 테스트케이스가 구체적으로 어떤 경우를 테스트하는 것인지 잘 모르겠음
    public static int[][] rotateMatrix(int[][] matrix, int K) {
		/* matrix = 2차원 n x n 배열, 원소들은 int 타입 데이터 -> 시계 방향으로 90도씩 K번 회전 -> 2차원 배열 return
		입/출력 예시를 k % 4 = 1 ~ 4인 경우 회전한 결과를 종이에 써보고(matrix의 index 값들을 기준으로)
		각 경우 새로운 행렬의 각 행과 열을 matrix의 index 값들을 기준으로 어떻게 만들 수 있을지 수의 패턴을 찾아봄

		k = 4일 때는 원래 matrix와 동일한 형태로 돌아옴 -> k = 5일 때는 k = 1일 때와 동일한 형태 등등
		*/
        // 11h25 1차 제출 시, 문제에는 명시되어 있지 않지만 테스트케이스 1번에 따라 '빈 배열을 입력받은 경우(matrix == null), 빈 배열(null)을 리턴'해야 함
        if (matrix == null) {
            return null;
        }

        // return할 새로운 2차원 배열 생성 및 초기화
        int n = matrix.length;
        int[][] rotatedMatrix = new int[n][n];

        int time = K % 4;

        if (time == 0) {
            return matrix;
        }

        // rotatedMatrix의 0~3번째 행을 각각 만들어나감 -> 각 행에서 0~3번째 열을 만들어나감
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                switch (time) {
                    /*
                    case 0: // 문제 풀 때도 얼핏 생각했지만, reference 코드 보니 이 경우는 굳이 반복문 돌릴 필요 없음 -> 바로 matrix 반환하면 됨
                        rotatedMatrix[i][j] = matrix[i][j];
                        break;
                     */
                    case 1:
                        rotatedMatrix[i][j] = matrix[n - 1 - j][i];
                        break;
                    case 2:
                        rotatedMatrix[i][j] = matrix[n - 1 - i][n - 1 - j];
                        break;
                    case 3:
                        rotatedMatrix[i][j] = matrix[j][n - 1 - i];
                }
            }
        }

        return rotatedMatrix;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        int K = 1;

        System.out.println(matrix[0][0]); // 1
        System.out.println(matrix[3][2]); // 15

        int[][] rotatedMatrix = rotateMatrix(matrix, K);
        System.out.println(rotatedMatrix[0][0]); // 13
        System.out.println(rotatedMatrix[3][2]); // 8

        rotatedMatrix = Solution34Reference.rotateMatrix(matrix, K);
        System.out.println(rotatedMatrix[0][0]); // 13
        System.out.println(rotatedMatrix[3][2]); // 8
    }
}
