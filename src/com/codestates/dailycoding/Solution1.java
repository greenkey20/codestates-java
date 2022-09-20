package com.codestates.dailycoding;

import java.util.HashMap;

public class Solution1 {
    // 2022.9.20(화) 10h
    public HashMap<String, String> transformFirstAndLast(String[] arr) {
        // TODO: 입력으로 받는 배열을 수정하지 말기
        HashMap<String, String> resultMap = new HashMap<>();

        // 빈 배열을 입력받은 경우, null을 리턴
        if (arr.length == 0) {
            // return resultMap; // {}
            return null;
        }

        // 주어진 String 배열 arr의 첫 요소 = 키
        String key = arr[0];

        // 주어진 String 배열 arr의 마지막 요소 = 값
        String value = arr[arr.length - 1];

        // resultMap을 리턴
        resultMap.put(key, value);
        return resultMap;
    }
}
