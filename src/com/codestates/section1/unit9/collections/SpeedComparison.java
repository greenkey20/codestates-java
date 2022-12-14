package com.codestates.section1.unit9.collections;

import java.util.ArrayList;
import java.util.LinkedList;

// 2022.9.13(화) 학습 자료 제공
public class SpeedComparison {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();

        double startTime;
        double endTime;

        // 순차적으로 추가
        System.out.println("---------------------------------------");
        startTime = System.nanoTime(); // returns the current value of the running Java Virtual Machine's high-resolution time source, in nanoseconds
        for (int i = 1; i <= 10000000; i++) arrayList.add(i);
        endTime = System.nanoTime();
        System.out.println("순차적인 추가 - ArrayList : " + Math.round((endTime - startTime) / 1000000 * 100) / 100.0 + "ms");

        startTime = System.nanoTime();
        for (int i = 1; i <= 10000000; i++) linkedList.add(i);
        endTime = System.nanoTime();
        System.out.println("순차적인 추가 - LinkedList : " + Math.round((endTime - startTime) / 1000000 * 100) / 100.0 + "ms");

        System.out.println("---------------------------------------");
        startTime = System.nanoTime();
        for (int i = 9999999; i > 5000000; i--) arrayList.remove(i);
        endTime = System.nanoTime();
        System.out.println("중간 데이터 삭제 - ArrayList : " + Math.round((endTime - startTime) / 1000000 * 100) / 100.0 + "ms");

        startTime = System.nanoTime();
        for (int i = 9999999; i > 5000000; i--) linkedList.remove(i);
        endTime = System.nanoTime();
        System.out.println("중간 데이터 삭제 - linkedList : " + Math.round((endTime - startTime) / 1000000 * 100) / 100.0 + "ms");
    }
}
