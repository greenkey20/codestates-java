package com.codestates.dailycoding;

public class Solution55 {
    // 2022.11.30(수) 10h25
    public int gossipProtocol(String[] village, int row, int col) {
		/* 특정 주민의 집(세로 위치 row, 가로 위치 col)으로부터 마을 전체로 소문 퍼지는 데 걸리는 일 수 return
		(row, col)로부터 하루에 상/하/좌/우 1칸 바로 옆에 있는 집으로 퍼짐
		row, col 모두 0 이상의 정수 + 항상 주민이 살고 있음

		village[i] = i번째 행의 열/columns 값들 = 0(주민 없음) 또는 1(주민 있음)이 총 N개인 String 자료형 -> N = village[i].length = 가로 길이, 열의 개수
		village.length = M = 세로 길이, 행의 개수

		모든 집은 연결되어 있음 = 한 집에서 다른 집으로 가는 경로가 항상 존재

		나의 질문 = 'village를 그래프로 구현하는 함수가 주어짐'이 무슨 뜻이지?

		10h35 나의 생각 = 전에도 이런 경로 찾기 문제 못 풀고 공부 안 했으니까, 레퍼런스 코드들 보면서 원리/알고리즘을 공부하자
		*/
        int result = 0;

        return result;
    }
}
