package com.codestates.dailycoding;

public class Solution25 {
    // 2022.10.17(월) 13h55 -> 14h15 테스트케이스 1,3,4번 통과 못함
    public long power(int base, int exponent) {
		/* 두 수를 입력 받아 거듭제곱 계산해서(base^exponent) 리턴
		계산 결과가 컴퓨터로 나타낼 수 있는 수의 범위를 넘을 수 있기 때문에 실제 계산 결과를 94906249로 나눈 나머지를 long 타입으로 리턴 <- 연산 중간에도 이 범위를 넘을 수 있기 때문에 연산할 때마다 나머지를 구하고 그 결과에 연산을 이어가기

		Math.pow(거듭제곱 연산자) 사용 금지
		시간복잡도 O(logN)(e.g. 이진탐색)을 만족해야 함
		*/
        long result = 1;

        while (exponent > 0) {
            result *= base;

            if (result > 94906249) {
                result = result % 94906249;
                break;
            }

            exponent--;
        }

        return result;
    }

    public static void main(String[] args) {

    }
}
