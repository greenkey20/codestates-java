package com.codestates.section1.unit9.collections;

import java.util.HashMap;

// 2023.7.8(토() 1h25
public class HashMap24 {
    public HashMap<Character, Integer> countAllCharacter(String str) {
        //TODO..
        // 1. str에 등장하는 문자(letter)의 리스트/목록을 만든다 e.g. {b, a, n}
        // 2. str에서 위 리스트의 각 원소/문자가 몇 번씩 등장하는지 count
        // 3. hashmap.put(str 등장 문자, count)
        // 4. return hashmap

        // 매개변수로 받은 str을 한 글자씩 돌면서 각 문자(letter)

        if (str.length() == 0) return null;

        HashMap<Character, Integer> map = new HashMap<>();
        // int count = 0;

        // banana
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (map.containsKey(ch)) {
                int value = map.get(ch) + 1;
                map.put(ch, value);
            } else {
                map.put(ch, 1);
            }
            // map.put(str.charAt(i), ); // {b=1} -> {b=1, a=1} -> {b=1, a=1, n=1} -> {b=1, a=1, n=1}
            System.out.println(map);
        }

        return map;
    }

    public static void main(String[] args) {
        HashMap24 hashMap24 = new HashMap24();
        hashMap24.countAllCharacter("banana");
    }

    public HashMap<Character, Integer> countAllCharacterReference(String str) {
        if (str.isEmpty()) {
            return null;
        }
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char curChar = str.charAt(i);
            if (hashMap.containsKey(curChar)) {
                int value = hashMap.get(curChar);
                hashMap.put(curChar, value + 1);
            } else {
                hashMap.put(curChar, 1);
            }
        }
        return hashMap;
    }
}
