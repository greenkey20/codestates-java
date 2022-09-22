package com.codestates.dailycoding;

public class Solution6 {
    // 2022.9.22(목) 10h30
    public static String letterCapitalize(String str) {
        // 시도1) 문제를 잘못 이해함
        /*
        // 주어진 문자열 str의 앞/뒤에 있는 공백 없애고 시작
        str = str.trim();

        String result = "";

        // 빈 문자(공백)으로만 이루어진 문자열을 입력받은 경우, 빈 문자열을 리턴
        if (str.length() == 0) {
            return result;
        }

        // 주어진 문자열 str 내부에 있는 연속된/모든 공백(whitespace character)을 " "(공백 1칸)으로 바꿈 <- 구글링해서 whitespace character를 나타내는 정규표현 찾음
        str = str.replaceAll("\\s", " ");
         */

        // 시도2)
        String strTemp = str.trim();

        if (strTemp.length() == 0) {
            return "";
        }

        String result = "";

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (i != 0) {
                if (('a' <= ch && ch <= 'z') && str.charAt(i - 1) == ' ') {
                    result += (char) (ch - 32);
                } else {
                    result += ch;
                }
            } else {
                result += (char) (ch - 32);
            }
        }

        return result;

        // 나의 질문 = String은 immutable해서 이렇게 str의 각 문자를 바꾸려고 해도 안 되는 것인가?
        /*
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (i != 0) {
                if (('a' <= ch && ch <= 'z') && str.charAt(i - 1) == ' ') {
                    ch = (char) (ch - 32);
                }
            } else {
                ch = (char) (ch - 32);
            }
        }

        return str; // "java  is good "
         */

        // reference1)
        /*
        if (str.length() == 0) return "";

        String[] words = str.split(" ");
        String result = "";

        for (int i = 0; i < words.length; i++) {
            if (words[i].isEmpty()) {
                words[i] = words[i];
            } else {
                words[i] = String.valueOf(words[i].charAt(0)).toUpperCase() + words[i].substring(1);
            }
        }

        result = String.join(" ", words);

        return result;
         */

        // reference2)
        /*
        if (str.length() == 0) return "";

        String[] words = str.split(" ");
        String result = "";

        for (int i = 0; i < words.length; i++) {
            words[i] = String.valueOf(words[i].charAt(0)).toUpperCase() + words[i].substring(1);
        }

        result = String.join(" ", words);
        return result;
         */
    }

    public static void main(String[] args) {
        System.out.println(letterCapitalize("java  is good ")); // "Java  Is Good "
    }
}
