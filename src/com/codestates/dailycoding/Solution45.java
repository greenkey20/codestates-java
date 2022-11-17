package com.codestates.dailycoding;

public class Solution45 {
    // 2022.11.15(화) 10h15
    public int robotPath2(int[][] room, int[] src, int sDir, int[] dst, int dDir) {
		/* room = 세로와 가로의 길이가 각각 M, N인 방의 지도 -> room.length = M = 20 이하의 자연수, room[i].length = N = 20 이하의 자연수
        room[i][j]는 0(이동 가능한 통로) 또는 1(장애물)
        src[i] 및 dst[i]는 0 ~ 20 범위의 정수, room[src[0]][src[1]] 및 room[dst[0]][dst[1]]는 0 <- 항상 로봇이 지나갈 수 있는 통로
        src에서 dst로 가는 경로가 항상 존재
        로봇의 동작 1회 = 임의의 k칸 직진, 또는 90도 회전(위쪽 방향 1, 오른쪽 2, 아래쪽 3, 왼쪽 4) -> src/sDir으로부터 dst/dDir까지 도달하는 데 필요한 동작의 총 개수 return

        나의 질문
        1. 90도 회전 시 특정 방향으로 돌아야 한다는 규칙은 없는 거지?
        2. 데일리코딩 33번 robotPath1과의 유사점은 무엇인가?

        10h45 입/출력 예시1 보며 흐름 파악 -> 입/출력 예시2 흐름은 종이에 써 보며, 어떻게 코딩해야 할지 생각해보기 -> 어떤 정보들을 어떤 자료구조로 담아서 활용하며 탐색해 가야 할까?
        e.g. 현재 방향이 1인 경우, (0 ~ 현재 위치 i - 1)[j]의 값에 대해 모두 ++2 -> 이렇게 일반화 할 수 있지 않을 것 같다.. 지도 가운데에 있는 경우, 해당 위치에서 방향 바꾸면(이 때 필요한 동작 개수 다름) 장애물이 없는 어느 방향으로든 움직일 수는 있으니까
        */
        int result = 0;
        return result;
    }
}
