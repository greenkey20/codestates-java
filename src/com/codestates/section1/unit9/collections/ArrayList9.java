package com.codestates.section1.unit9.collections;

import java.util.ArrayList;

// 2022.9.14(수) 오전 pair activity -> 2022.9.26(월) 7h45 스스로 풀어보기
public class ArrayList9 {
    public static ArrayList<Integer> removeFromBackOfNew(ArrayList<Integer> arrayList) {
        if (arrayList.isEmpty()) {
            return null;
        }

        ArrayList<Integer> resultList = new ArrayList<>(arrayList.subList(0, arrayList.size() - 1));
        return resultList;
    }

    // reference code
    public static ArrayList<Integer> removeFromBackOfNewReference(ArrayList<Integer> arrayList) {
        int size = arrayList.size();
        if (size == 0) {
            return null;
        }

        ArrayList<Integer> newArrayList = new ArrayList<>(arrayList);

        newArrayList.remove(size - 1);

        return newArrayList;
    }

    public static void main(String[] args) {

    }
}
