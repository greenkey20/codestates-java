package com.codestates.dailycoding;

public class Solution9 {
    // 2022.9.26(월) 9h45
    public static boolean ABCheck(String str) {
        // 대소문자를 구분하지 않습니다.
        // 공백도 한 글자로 취급합니다.
        // 'a'와 'b'는 중복해서 등장할 수 있습니다
        str = str.toLowerCase();
        String toCheck = "";

        for (int i = 0; i < str.length() - 4; i++) {
            toCheck = str.substring(i, i + 5);
            if (Character.toString(toCheck.charAt(0)).equals("a") && Character.toString(toCheck.charAt(4)).equals("b") || Character.toString(toCheck.charAt(0)).equals("b") && Character.toString(toCheck.charAt(4)).equals("a")) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {

    }

    public static boolean ABCheckReference(String str) {
        if (str.length() == 0) {
            return false;
        }
        str = str.toLowerCase();

        for (int i = 4; i < str.length(); i++) {
            if ((str.charAt(i) == 'a' && str.charAt(i - 4) == 'b') || (str.charAt(i) == 'b' && str.charAt(i - 4) == 'a')) {
                return true;
            }
        }

        return false;
    }
}
