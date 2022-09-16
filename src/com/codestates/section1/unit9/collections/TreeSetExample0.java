package com.codestates.section1.unit9.collections;

import java.util.TreeSet;

// 2022.9.13(화) 학습 자료 제공
public class TreeSetExample0 {
    public static void main(String[] args) {
        TreeSet<Integer> treeSet = new TreeSet<>();

        for (int i = 1; treeSet.size() < 6; i++) {
            int num = (int) (Math.random() * 45) + 1;

            System.out.println(i + "번째 num = " + num);

            try { Thread.sleep(1000); } catch (Exception e) {}

            treeSet.add(num);
        }

        System.out.println("당첨 번호는 : " + treeSet);
    }
}
