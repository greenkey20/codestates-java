package com.codestates.dailycoding;

public class Solution17 {
    public String computeSquareRoot(int num) {
        /* 소수점 처리 <- java 표준 내장 객체인 String("java decimal places limit", "자바 소수점 자리수") 검색
        각 자리수(1, 0.1, 0.01, 0.001)마다 (목표값을 넘지 않는)근사값을 구하는 방식 있음
        바빌로니아 법(=제곱근 구하는 방법)의 점화식(recurrence formula) 활용
        */

        /* 2022.9.30(금) 11h ideation
        for문 i = 1, 2, 3.. i++
        for문이 1번 돌 때마다 1, 4, 9, 16..과 같은 제곱근 리스트 만들 수 있음
        -> num이 리스트의 몇 번째 원소보다 크고 작은지 확인하면, 제곱근이 어떤 자연수 사이에 있는지 알 수 있음(=제곱근의 범위 좁히기)
        -> 소수점을 (문제에서 주어진 소수점 셋째 자리까지) 내리며 근사값 찾아감(해당 근사값/내가 리턴할 값 * 해당 근사값/내가 리턴할 값 < num, num에 최대한 가깝게)
        */

        return null;
    }
}
