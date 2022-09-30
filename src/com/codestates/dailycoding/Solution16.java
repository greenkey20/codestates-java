package com.codestates.dailycoding;

import java.util.HashMap;

public class Solution16 {
    // 2022.9.30(금) 10h30
    public boolean isIsogram(String str) {
        // 빈 문자열을 입력받은 경우 true를 리턴
        // 대소문자는 구별하지 않음
        String lowerStr = str.toLowerCase();

        // 2022.9.30(금) 10h55 reference code 보니, 내 코드는 2중 반복문을 사용해서 시간복잡도 비교적 나쁨 vs 시간복잡도를 낮출 수 있도록 적절한 자료구조를 활용하자
        for (int i = 0; i < lowerStr.length(); i++) {
            for (int j = i + 1; j < lowerStr.length(); j++) {
                if (lowerStr.charAt(i) == lowerStr.charAt(j)) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean isIsogramReference(String str) {
        //입력된 문자열이 공백일 경우 true를 리턴합니다.
        if (str.length() == 0) return true;

        //사용된 알파벳을 저장할 HashMap을 선언합니다.
        HashMap<Character, String> cache = new HashMap<Character, String>();

        //입력된 전체 문자열을 모두 소문자로 변환합니다.
        str = str.toLowerCase();

        //입력된 문자열을 순회하며
        for (int i = 0; i < str.length(); i++) {
            //HashMap에 이미 해당 알파벳이 저장되어 있다면
            if (cache.containsKey(str.charAt(i))) {
                //false를 리턴합니다.
                return false;
            }
            //HashMap에 해당 문자열이 저장되어 있지 않다면, 저장합니다.
            cache.put(str.charAt(i), "Exists");
        }
        //모든 문자열을 순회한다면 true를 리턴합니다.
        return true;
    }
}
