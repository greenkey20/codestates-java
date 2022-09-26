package com.codestates.dailycoding;

// 2022.9.26(월) 9h45
public class Solution8 {
    public static String convertDoubleSpaceToSingle(String str) {
        // 두 칸을 초과하는 공백은 존재하지 않는다고 가정
        return str.replace("  ", " ");
    }

    public static void main(String[] args) {

    }
}
