package com.codestates.section1.unit10.stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// 2023.7.9(일) 0h30
public class Stream10 {
    public List<String> mergeTwoStreamReference(List<String> list1, List<String> list2) {
        Stream<String> stream1 = list1.stream(); // list1의 스트림을 생성합니다.
        Stream<String> stream2 = list2.stream(); // list2의 스트림을 생성합니다.

        Stream<String> stream3 = Stream.concat(stream1, stream2); // 두 개의 스트림을 합칩니다.
        return stream3.collect(Collectors.toList()); // 합쳐진 스트림을 List형태로 리턴합니다.
    }
}
