package com.codestates.section1.unit9.collections;

import java.util.TreeSet;

// 2023.7.7(금) 16h35
public class TreeSetExample1 {
    public static void main(String[] args) {
        TreeSet<String> workers = new TreeSet<>();

        workers.add("LEE Java");
        workers.add("PARK Hacker");
        workers.add("KIM Coding");
        // 요소 추가 시 자동으로 사전 편찬 순 오름차순으로 정렬됨

        System.out.println("workers = " + workers);
        System.out.println("workers.first() = " + workers.first());
        System.out.println("workers.last() = " + workers.last());
        System.out.println("workers.higher(\"LEE\") = " + workers.higher("LEE"));
        System.out.println("workers.subSet(\"KIM\", \"QUEEN\") = " + workers.subSet("KIM", "QUEEN"));
    }
}
