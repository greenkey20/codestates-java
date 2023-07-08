package com.codestates.section1.unit9.collections;

import java.util.HashMap;

public class HashMap23 {
    public HashMap<String, Integer> selectReference(String[] arr, HashMap<String, Integer> hashMap) {
        HashMap<String, Integer> newHashMap = new HashMap<>();
        for (String el : arr) {
            if (hashMap.containsKey(el)) {
                newHashMap.put(el, hashMap.get(el));
            }
        }
        return newHashMap;
    }
}
