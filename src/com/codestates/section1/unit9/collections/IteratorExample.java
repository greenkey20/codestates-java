package com.codestates.section1.unit9.collections;

import java.util.ArrayList;
import java.util.Iterator;

// 2022.9.13(화) 학습 자료 제공
public class IteratorExample {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();

        for (int i = 1; i <= 10; i++) arrayList.add(i);

        System.out.println(arrayList);

        System.out.println("---------------------");

        Iterator<Integer> iterator = arrayList.iterator();

        while (iterator.hasNext()) {
            System.out.println("num = " + iterator.next());
            iterator.remove();
            System.out.println("arrayList = " + arrayList);
            System.out.println("--------------------------");
        }
    }
}

