package com.codestates.dailycoding;

import java.util.LinkedList;
import java.util.Queue;

public class Solution60 {
    // 2022.12.7(수) 10h30 블로그 하나(https://velog.io/@lifeisbeautiful/Java-백준-4963번-섬의-개수-with-자바) 참고해서 구현 시작
    // -> 11h 1차 제출 결과 = 빈 배열을 입력받은 경우(테스트케이스2) java.lang.ArrayIndexOutOfBoundsException + 나머지 테스트케이스 및 입/출력 예시 모두 0 returned
    static char[][] grid;
    static boolean[][] visited;
    static int dirX[] = {0, 0, -1, 1};
    static int dirY[] = {-1, 1, 0, 0};

    static int R, M, currentX, currentY;

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    // 2022.12.7(수) 10h
    public static int countIslands(char[][] grid) {
        /* grid.length = R = 영토의 세로 길이
        grid[i].length = M = 영토의 가로 길이
        grid[i][j] = 땅이면 '1' vs 물이면 '0'
        -> grid에 존재하는 섬(물로 둘러싸여있는 땅 + 가로 또는 세로로 땅이 연결되어 있는 경우 하나의 섬 + grid 범위 밖은 물로 둘러싸여있음)의 개수 return

        google "알고리즘 섬의 개수" -> 백준에 비슷한 문제 있음을 알게 되고(4963 silver2), 몇몇 블로그들 읽으며 접근법 + 풀이법 배움
        */
        R = grid.length;
        M = grid[0].length;

        grid = new char[R][M];
        visited = new boolean[R][M];

        int islandsCount = 0;

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j] && grid[i][j] == '1') { // 아직 방문하지 않은 땅인 경우
                    bfs(i, j);
                    islandsCount++;
                }
            }

        }

        return islandsCount;
    }

    public static void bfs(int x, int y) {
        Queue<Node> queue = new LinkedList<>();
        visited[x][y] = true;
        queue.add(new Node(x, y));

        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();

            for (int i = 0; i < 4; i++) {
                currentX = dirX[i] + currentNode.x;
                currentY = dirY[i] + currentNode.y;

                if (boundaryCheck() && !visited[currentX][currentY] && grid[currentX][currentY] == '1') {
                    visited[currentX][currentY] = true;
                    queue.add(new Node(currentX, currentY));
                }
            }
        }
    } // bfs() 메서드 종료

    public static boolean boundaryCheck() {
        return currentX >= 0 && currentY >= 0 && currentX < R && currentY < M;
    }

    public static void main(String[] args) {
        char[][] grid = new char[][]{
                {'0', '1', '1', '1'},
                {'0', '1', '1', '1'},
                {'1', '1', '0', '0'},
        };
        int result = countIslands(grid);
        System.out.println(result); // 1

        grid = new char[][]{
                {'0', '1', '1', '1', '0'},
                {'0', '1', '0', '0', '0'},
                {'0', '0', '0', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '1', '0'}
        };
        result = countIslands(grid);
        System.out.println(result); // 3
    }
}
