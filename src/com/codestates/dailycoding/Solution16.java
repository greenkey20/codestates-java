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

    // reference code 공부 필요 -> 2022.10.6(목) 23h40 ok
    public boolean isIsogramReference(String str) {
        // 입력된 문자열이 공백일 경우 true를 리턴합니다.
        if (str.length() == 0) return true;

        // 사용된 알파벳을 저장할 HashMap을 선언
        HashMap<Character, String> cache = new HashMap<Character, String>();

        // 입력된 전체 문자열을 모두 소문자로 변환
        str = str.toLowerCase();

        for (int i = 0; i < str.length(); i++) { // 입력된 문자열을 순회하며
            if (cache.containsKey(str.charAt(i))) { // HashMap에 이미 해당 알파벳이 저장되어 있다면
                return false; // false를 리턴
            }

            cache.put(str.charAt(i), "Exists"); // HashMap에 해당 문자열이 저장되어 있지 않다면, 저장합니다 -> 2022.10.6(목) 23h40 나의 생각 = map의 value는 메서드에서 큰 의미/쓸모가 없는 것 같은데, 그러면 등장한 str.charAt(i)를 set에 담아둘 수 있지 않을까?
        }

        // 모든 문자열을 순회했다면 true를 리턴
        return true;
    }
}
