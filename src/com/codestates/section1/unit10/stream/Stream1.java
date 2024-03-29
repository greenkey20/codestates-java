package com.codestates.section1.unit10.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Stream1 {
    public static int computeSumOfAllElements1(List<Integer> list) {
        Stream<Integer> listStream = list.stream();
        return listStream.mapToInt(el -> el).sum();
    }

    public int computeSumOfAllElements2(List<Integer> list) {
        return list.stream().mapToInt(el -> el).sum();
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            list.add(i);
        }

        int result = computeSumOfAllElements1(list);
        System.out.println(result);

        List<Integer> list2 = new ArrayList<>();
        System.out.println(computeSumOfAllElements1(list2));


    }
}
