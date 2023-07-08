package com.codestates.section1.unit10.stream;

import java.util.*;

public class Stream9 {
    public int findLongestLength(String[] strArr) {
        //빈 배열을 입력받은 경우 0을 리턴

        //요소의 길이를 기준으로 순회
        return Arrays.stream(strArr).mapToInt(s -> s.length()).max().getAsInt();
    }

    public int findLongestLengthReference(String[] strArr) {
        // 인자로 전달받은 배열의 길이가 0이면 0을 리턴합니다.
        if (strArr.length == 0) {
            return 0;
        }
        return Arrays.stream(strArr)
                .mapToInt(String::length) // 문자열 배열 각 요소의 길이를 구합니다.
                .max() // 문자열의 길이 중 가장 긴 길이를 구합니다.
                .getAsInt();
    }
}
