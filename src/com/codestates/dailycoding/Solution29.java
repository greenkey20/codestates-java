package com.codestates.dailycoding;

public class Solution29 {
    // 2022.10.24(월) 9h55
    public static int tiling(int num) {
		/* 타일을 가/세로 어느 방향으로 놓아도 상관없음
		타일링 문제를 해결하는 효율적인 알고리즘(O(N))이 존재함 -> 반드시 직접 문제 해결하면서 입력 크기에 따라 어떻게 달라지는지/반복되는지 관찰하기
		n = 1 ~ 6일 때 종이에 그림 그리며 경우의 수 생각해 보고 있는데, 손으로 그려서 중복 제외할 때 정확하게 하고 있는지 파악하기 힘들고(e.g. tiling(5) = 수기로 그려봤을 때 7 vs 코플릿 테스트케이스3에 따르면 8), 정확한 패턴 못 찾겠음 + 코드로 어떻게 구현해야 할지도 모르겠음
		tiling(1) = 1
		tiling(2) = tiling(1) + tiling(1) = tiling(1)에 대한 순열; 새로운 패턴
		tiling(3) = tiling(2) + tiling(1) 또는 tiling(1) + tiling(2) -> 단, 이 2가지 경우에 중복되는 것 있음
		tiling(4) = tiling(3) + tiling(1) 또는 tiling(1) + tiling(3) -> 단, 중복되는 것 있음
								또는 tiling(2) + tiling(2) = tiling(2)에 대한 순열
		tiling(5) = tiling(4) + tiling(1) 또는 tiling(1) + tiling(4)
								또는 tiling(3) + tiling(2) 또는 tiling(2) + tiling(3)..
		뭔가 재귀 + 이전에 구한 tiling() 값을 저장해두고 나중에는 조회만 해서 O(n) 성능 가지는 것 같은데..

		11h5 '알고리즘 타일링' 구글링 -> 동적 프로그래밍
		e.g. https://alalstjr.github.io/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98/2019/04/14/2-n-%ED%83%80%EC%9D%BC%EB%A7%81/
		https://return-value.tistory.com/22
		*/
        return 0;
    }

    public static void main(String[] args) {
        // 입/출력 예시
        int output = tiling(2);
        System.out.println(output); // 2

        output = tiling(4);
        System.out.println(output); // 5

        // 코플릿 test cases
        output = tiling(10);
        System.out.println(output); // 89

        output = tiling(5);
        System.out.println(output); // 8
    }
}
