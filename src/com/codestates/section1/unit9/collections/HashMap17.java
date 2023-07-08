package com.codestates.section1.unit9.collections;

import java.util.HashMap;
import java.util.Set;

// 2023.7.8(토) 21h50
public class HashMap17 {
    public int getSize(HashMap<Integer, Integer> hashMap) {
        Set<Integer> keySet = hashMap.keySet();
        return keySet.size();
    }
}
