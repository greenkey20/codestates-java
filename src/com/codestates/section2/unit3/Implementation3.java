package com.codestates.section2.unit3;

public class Implementation3 {
    // 2022.10.28(금) 13h40 -> 14h 제출 시 '말이 보드를 이탈하게 되면 null을 반환해야 합니다' 테스트 외 모두 실패 + main()에서 int output1에 값 대입하는 line에서 null pointer exception 발생
    public static Integer boardGame(int[][] board, String operation) {
        /* N(2 ~ 1000) * N의 크기를 가진 보드판 = 2차원 int 타입 배열 board

        문자열 operation = 1줄에 띄어쓰기 없이 U(상), D(하), L(좌), R(우)만 나열
        1 <= operation.length <= board.length * 2 -> 나의 질문 = 이 조건의 특별한 의미가 있나?

        좌표 왼쪽 상단(0, 0)에서 시작 -> 한 번 움직일 때마다 한 칸씩 움직임 + 그 칸 안의 요소인 숫자(0 또는 1)를 획득, 방문한 곳을 또 방문해도 숫자를 획득할 수 있음

        보드 밖을 나간 말은 OUT 처리 = 말이 보드 밖으로 나갔다면 즉시 null 반환
        말이 해당 칸을 지나가면서 획득한 숫자의 합을 return
        */

        // 필요한 변수 선언 및 초기화
//        int[] currentPosition = {0, 0}; // 현재 위치 저장
        int x = 0; // 현재 위치의 가로 좌표 저장
        int y = 0; // 현재 위치의 세로 좌표 저장
        int sum = 0; // 획득한 숫자의 합 계산/저장

        // operation을 구성하는 영문자 하나하나를 순회하면서, 그 글자가
        for (int i = 0; i < operation.length(); i++) {
            char ch = operation.charAt(i);

            switch (ch) {
                case 'U': // U일 때
                    y++;
                    break;
                case 'D': // D일 때
                    y--;
                    break;
                case 'L': // L일 때
                    x--;
                    break;
                case 'R': // R일 때
                    x++;
            }

            if (x < 0 || y < 0 || x >= board.length || y >= board.length) {
                return null;
            } else {
                sum += board[y][x];
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        // 입/출력 예시
        int[][] board1 = new int[][]{
                {0, 0, 0, 1},
                {1, 1, 1, 0},
                {1, 1, 0, 0},
                {0, 0, 0, 0}
        };
        int output1 = boardGame(board1, "RRDLLD");
        System.out.println(output1); // 4


        int[][] board2 = new int[][]{
                {0, 0, 1},
                {1, 1, 1},
                {1, 0, 0}
        };
        int output2 = boardGame(board2, "UUUDD");
        System.out.println(output2); // null

        int[][] board3 = new int[][]{
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0},
                {0, 0, 0, 0, 0}
        };
        int output3 = boardGame(board3, "DDRRRUDUDUD");
        System.out.println(output3); // 0
    }
}
