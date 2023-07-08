package com.codestates.section1.unit9.collections;

import java.util.HashMap;
import java.util.List;

// 2023.7.8(토) 21h30
public class HashMap21 {
    public String getElementOfListEntry(HashMap<String, List<String>> hashMap, String key, int index) {
        if (hashMap.containsKey(key)) {
            if (index < hashMap.get(key).size()) {
                return hashMap.get(key).get(index);
            }
        }

        return null;
    }

    public String getElementOfListEntryReference(HashMap<String, List<String>> hashMap, String key, int index) {
        if (!hashMap.containsKey(key)) {
            return null;
        }
        List<String> valueList = hashMap.get(key);
        if (index < 0 || index >= valueList.size()) {
            return null;
        }
        return valueList.get(index);
    }
}
