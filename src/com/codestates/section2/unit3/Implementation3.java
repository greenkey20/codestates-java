package com.codestates.section2.unit3;

import java.util.HashMap;

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

            // 2023.7.17(월) 23h10 문제 입/출력 예시 살펴보며 U/D 이동 방향이 잘못되었음을 감지 -> 맞았습니다
            switch (ch) {
                case 'U': // U일 때
                    y--;
                    break;
                case 'D': // D일 때
                    y++;
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
        Integer output1 = boardGame(board1, "RRDLLD"); // 2023.7.17(월) 23h15 Unboxing of '..' may produce 'NullPointerException' 해결
        System.out.println(output1); // 4


        int[][] board2 = new int[][]{
                {0, 0, 1},
                {1, 1, 1},
                {1, 0, 0}
        };
        Integer output2 = boardGame(board2, "UUUDD");
        System.out.println(output2); // null

        int[][] board3 = new int[][]{
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0},
                {0, 0, 0, 0, 0}
        };
        Integer output3 = boardGame(board3, "DDRRRUDUDUD");
        System.out.println(output3); // 0
    }

    public Integer boardGameReference(int[][] board, String operation) {
        //HashMap을 선언한 후, 입력되는 명령어에 따라 이동할 좌표를 넣어줍니다.
        HashMap<String, int[]> DIR = new HashMap<String, int[]>() {{
            put("U", new int[]{-1, 0});
            put("D", new int[]{1, 0});
            put("L", new int[]{0, -1});
            put("R", new int[]{0, 1});
        }};
        //보드의 길이를 선언합니다.
        int LEN = board.length;
        //시작 좌표와, 점수를 0으로 할당합니다.
        int Y = 0;
        int X = 0;
        int score = 0;

        //입력받은 operation을 char배열로 변환합니다.
        char[] chars = operation.toCharArray();

        //해당 배열만큼 반복합니다.
        for (int i = 0; i < chars.length; i++) {
            int dY = DIR.get(String.valueOf(chars[i]))[0];
            int dX = DIR.get(String.valueOf(chars[i]))[1];
            Y += dY;
            X += dX;
            //isValid 함수를 이용하여, 이동이 불가능한 경우 null을 반환합니다.
            if (!isValid(Y, X, LEN)) return null;
            //이동이 가능한 경우, 해당 보드의 값만큼 전체 점수에 더해줍니다.
            score += board[Y][X];
        }
        //전체 점수를 반환합니다.
        return score;
    }

    //이동이 가능한지 확인하여 boolean으로 결과를 반환하는 함수
    public boolean isValid(int y, int x, int LEN) {
        //최소값과, 최대값을 벗어나면 false, 가능하다면 true를 반환합니다.
        return 0 <= y && y < LEN && 0 <= x && x < LEN;
    }
}
