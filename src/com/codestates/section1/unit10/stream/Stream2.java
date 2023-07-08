package com.codestates.section1.unit10.stream;

import java.util.List;

// 2023.7.9(일) 0h55
public class Stream2 {
    public double computeAverageOfNumbers(List<Integer> list) {
        return list.stream().mapToDouble(i -> i).average().orElse(0);
    }

    public double computeAverageOfNumbersRef1(List<Integer> list) {
        // list의 크기가 0인 경우 0을 리턴합니다.
        if (list.size() == 0) {
            return 0;
        }
        // 인자로 전달받은 list의 총합을 구합니다.
        double sum = list.stream()
                .mapToDouble(m -> m) // 평균이 소수점 이하 자리 값까지 구할 수 있도록 DoubleStream으로 변환합니다.
                .sum();
        // list의 크기로 나눕니다.
        return sum / list.size();
    }

    // 다른 풀이법
    public double computeAverageOfNumbersRef2(List<Integer> list) {
        return list.stream()
                .mapToDouble(d -> d)
                .average()
                .orElse(0.0);
    }
}
