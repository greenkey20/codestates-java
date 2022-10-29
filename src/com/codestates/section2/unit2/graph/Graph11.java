package com.codestates.section2.unit2.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// 2022.9.26(월) 14h pair activity
public class Graph11 {
    // 주어진 인접행렬에서 한 정점으로부터 다른 정점으로 이어지는 길이 존재하는지 반환
    // 입력된 배열 matrix를 수정하지 말아야 함 <- agora states에 따르면, 코플릿에서 테스트 시 이 matrix를 사용함
    public static boolean getDirections(int[][] matrix, int from, int to) {
        /* idea drafts.. T.T
        if (from < to) {
            if (from == to - 1) {
                if (matrix[to - 1][to] == 1) {
                    return true;
                } else {
                    return false;
                }
            }

            return getDirections(, from, to - 1);
        }


        int check = 1;

        if (from < to) {
            if (matrix[from][to] == 1) {
                return true;
            } else {
                matrix[to - 1][to]
                for (int i = 1; i < from - to; i++) {
                    for ()
                        if (matrix[from][from + i] * matrix[from + i][])
                }
            }


            for (int i = from; i <= to; i++) {
                for (int j = i + 1; j <= to; j++) {
                    check *= matrix[i][j];
                }
            }

        } else {

        }
         */

        // version1
        /*
        int check = 1;

        if (from < to) {
            for (int i = from; i <= to; i++) {
                for (int j = i + 1; j <= to; j++) {
                    if (matrix[from][j] == 1) {
                        check *= matrix[from][j];
                    } else {
                        for (int k = j + 1; k <= to; k++) {
                            check *= matrix[j][k];
                        }
                    }
                }
            }

        }

        return false;
         */

        // 2022.10.23(일) 17h10 복습 시 아래와 같이 작성하다보니, 정확히 몇 번이나 반복문을 돌려야 하는지 알 수 없는 것 같다 -> 2022.10.29(토) 12h10 재귀로 작성해보기 + 16h10 코플릿 통과
        /*
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[from][i] == 1) {
                for (int j = 0; j < matrix.length; j++) {
                    if (matrix[i][j] == 1) {

                    }
                }
            }
        }
         */
        int[][] currentMatrix = new int[matrix.length][];
        for (int i = 0; i < currentMatrix.length; i++) {
            currentMatrix[i] = Arrays.copyOf(matrix[i], matrix[i].length);
        }

        if (from == to) return true;

        int[] fromAdjacencyList = currentMatrix[from];

        for (int i = 0; i < fromAdjacencyList.length; i++) {
            if (fromAdjacencyList[i] == 1) {
                fromAdjacencyList[i] = 0;
                if (getDirections(currentMatrix, i, to)) return true;
            }

        }

        return false;
    }

    public static void main(String[] args) {
        boolean result = getDirections(new int[][]
                {
                        {0, 1, 0, 0},
                        {0, 0, 1, 0},
                        {0, 0, 0, 1},
                        {0, 1, 0, 0}
                }, 0, 2);
        System.out.println(result); // true
        // 정점 0에서 2로 가는 길이 존재하는지 확인합니다.
        // 0 --> 1 로 가는 간선이 존재하고, 1 --> 2 로 가는 간선이 존재하기 때문에 true를 반환합니다.

        boolean result2 = getDirections(new int[][]
                {
                        {0, 1, 0, 0, 0},
                        {0, 0, 0, 1, 0},
                        {0, 1, 0, 0, 0},
                        {0, 1, 1, 0, 0},
                        {1, 1, 1, 1, 0}
                }, 1, 4);
        System.out.println(result); // false
        // 정점 1에서 4로 가는 길이 존재하는지 확인합니다.
        // 1 --> 3,
        // 3 --> 1 (정점 1을 다녀왔으니 다시 돌아가지 않습니다),
        // 3 --> 2,
        // 2 --> 1 (정점 1을 다녀왔으니 다시 돌아가지 않습니다)
        // ...으로, 4에 도달할 수 없습니다.
    }

    // 재귀를 사용한 풀이
    public boolean getDirectionsReference1(int[][] matrix, int from, int to) {
        int[][] currentMatrix = new int[matrix.length][]; // 2차원 배열 선언 및 초기화
        for (int i = 0; i < matrix.length; i++) currentMatrix[i] = Arrays.copyOf(matrix[i], matrix[i].length);

        // 입력된 출발점과 도착점이 같다면, true를 반환 = 재귀 함수의 도착 부분
        if (from == to) return true;

        // 입력된 출발 지점의 1차원 배열을 순회
        for (int i = 0; i < currentMatrix[from].length; i++) {
            if (currentMatrix[from][i] == 1) { // 길이 존재한다면
                currentMatrix[from][i] = 0; // 해당 루트를 순회했다고 표시 = 1 -> 0으로 변경
                // 표시된 행렬과, 출발 지점을 현재 지점인 i로 변경하여 재귀함수를 실행 -> 재귀 함수가 끝까지 도달했을 때 true를 반환한 경우 true 반환
                if (getDirections(currentMatrix, i, to)) return true;
            }
        }

        // 길을 찾을 수 없는 경우 false를 반환
        return false;
    }

    // queue를 사용한 풀이 -> queue = 방문할 곳
    public boolean getDirectionsReference2(int[][] matrix, int from, int to) {
        // 연결 리스트를 사용하여 큐를 선언 -> 2022.10.29(토) 17h 나의 질문 = 왜 LinkedList 클래스/자료형을 사용하는가?
        Queue<Integer> queue = new LinkedList<>();
        // 첫 시작점으로 from을 할당
        queue.add(from);

        // 방문했다는 것을 표시하기 위해 정점 수만큼의 크기/길이를 가지는 1차원 배열을 생성 -> 각 원소의 초기 값은 false로 생성됨
        boolean[] isVisited = new boolean[matrix.length];
        // 첫 정점 방문 여부 표시
        isVisited[from] = true;

        // queue의 사이즈가 0이 될 때까지 반복합니다.
        while (queue.size() > 0) {
            // queue에서 정점을 하나 빼서 now에 할당합니다.
            int now = queue.poll();

            // 목적지인지 검사하고, 목적지라면 true를 반환
            if (now == to) return true;

            // 해당 정점의 간선들을 확인
            for (int next = 0; next < matrix[now].length; next++) {
                if (matrix[now][next] == 1 && !isVisited[next]) { // 만약 간선이 있고 + 방문하지 않았다면
                    queue.add(next); // queue에 next를 넣음(다음 정점으로 가기 위해)
                    isVisited[next] = true; // 해당 정점을 방문했다는 것을 표시
                }
            }
        }

        // 길이 없다면 false를 반환
        return false;
    }
}
