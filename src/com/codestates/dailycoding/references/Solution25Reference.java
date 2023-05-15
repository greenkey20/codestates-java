package com.codestates.dailycoding.references;

// 2022.12.10(토) 20h10 참고 -> 로직/알고리즘 이해 안 됨 ㅠㅠ
public class Solution25Reference {
    public long power(int base, int exponent) {
        //재귀함수로 동작합니다.
        //exponent변수가 0이 될때까지 재귀를 돈 이후, 나머지 연산을 계산하고,
        //해당 결과값을 사용하여 홀수일 경우 다시 연산하여 리턴합니다.
        if (exponent == 0) return 1;

        int half = exponent / 2;
        long temp = power(base, half);
        long result = (temp * temp) % 94906249;

        if (exponent % 2 == 1) return (base * result) % 94906249;
        else return result;
    }
}
