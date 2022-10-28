package com.codestates.dailycoding;

public class Solution33 {
    // 2022.10.28(금) 11h10
    public static int robotPath(int[][] room, int[] src, int[] dst) {
        /* src로부터 dst에 도달하는 데 걸리는 최소 시간 리턴 = 최단 거리 찾기?
        room[i][j]별로 상/하/좌/우 이동 가능한 지점들을 인접리스트 형태의 graph로 만들어야 하나?

        room = 세로와 가로의 길이가 각각 M, N인 방의 지도 -> room.length = M = 20 이하의 자연수, room[i].length = N = 20 이하의 자연수
        room[i][j]는 0(이동 가능한 통로) 또는 1(장애물)
        src[i] 및 dst[i]는 0 ~ 20 범위의 정수, room[src[0]][src[1]] 및 room[dst[0]][dst[1]]는 0 <- 항상 로봇이 지나갈 수 있는 통로
        src에서 dst로 가는 경로가 항상 존재 + 로봇은 지도 위를 1분에 1칸씩 상/하/좌/우로 이동 -> 나의 질문 = 대각선으로는 못 가는 게 맞는지?

        11h35 어떻게 풀어야 할까..? 막막하고, 이런 문제를 보면 (나는 아직ㅠㅠ)못 풀겠다는 부정적인 생각이 먼저 든다 ㅠㅠ 무엇을, 어떻게, 공부해야 이런 문제를 풀 수 있는 것이지..?
        room[src[0]][src[1]]
        */
        // 우선 입/출력 예시를 푼다고 가정하고 room의 원소별 상/하/좌/우 갈 수 있는 지점들의 정보(이동 가능하면 1 vs 불가능하면 0)를 담은 2차원 배열을 종이에 그려/써 봄
        int[][][] paths = new int[room.length][room[0].length][4];

        for (int i = 0; i < room.length; i++) {
            if (i == 0) {
                // 위로 이동 불가능 -> paths[][][] = 0
            }
        }

        int cnt = 0;
        return cnt;
    }

    public static void main(String[] args) {
        // 입/출력 예시
        int[][] room = new int[][]{
                {0, 0, 0, 0, 0, 0},
                {0, 1, 1, 0, 1, 0},
                {0, 1, 0, 0, 0, 0},
                {0, 0, 1, 1, 1, 0},
                {1, 0, 0, 0, 0, 0}
        };

        int[] src = new int[]{4, 2};
        int[] dst = new int[]{2, 2};
        int output = robotPath(room, src, dst);
        System.out.println(output); // 8
    }
}
