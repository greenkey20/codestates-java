package com.codestates.section1.unit10.stream;

import java.util.*;
import java.util.stream.Collectors;

public class Stream11 {
    public List<Integer> makeElementDouble(List<Integer> list) {
        //비어있는 리스트를 입력받은 경우, 비어있는 리스트를 리턴

        //Stream을 통해 List를 순회하며 각 요소에 동일한 연산(*2)을 반복 -> 새로운 List를 리턴
        //List return = new Arra
//        return list.stream().mapToInt(i -> i * 2).mapToObj(i -> i).collect(Collectors.toList());
        return list.stream().map(i -> i * 2).collect(Collectors.toList());
    }

    public List<Integer> makeElementDoubleReference(List<Integer> list) {
        return list.stream()
                .map(element -> element * 2) // map을 이용해서 각 요소의 값을 수정합니다.
                .collect(Collectors.toList()); // 리스트의 형태로 바꾼 후 리턴합니다.
    }
}
