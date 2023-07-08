package com.codestates.section1.unit10.stream;

import java.util.List;
import java.util.stream.Collectors;

public class Stream3 {
    public List<Integer> filterOddNumbers(List<Integer> list) {
        /*
        List<Integer> result = new ArrayList<>();
        list.stream().filter(i -> i % 2 == 0).포Each(i -> result.add(i));

        return result;
        */

        return list.stream().filter(i -> i % 2 == 0).collect(Collectors.toList());
    }

    public List<Integer> filterOddNumbersReference(List<Integer> list) {
        return list.stream()
                .filter(e -> e % 2 == 0) // 각 요소를 순회하며 짝수인지 검사합니다.
                .collect(Collectors.toList()); // 최종적으로 리스트의 형태로 만듭니다.
    }
}
