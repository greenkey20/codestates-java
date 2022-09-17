package com.codestates.section1.unit6.loop;

// 2022.9.17(토) 19h40
public class Loop14 {
    public String characterAndNumber(String word) {
        String result = "";

        /* reference 코드 보고 로직 다시 생각해보니, 빈문자열을 입력받았을 경우 별도 처리 필요 없음
//        if (word.length() == 0) {
        if (word.isEmpty()) {
            return result;
        }
         */

        for (int i = 0; i < word.length(); i++) {
            result += Character.toString(word.charAt(i));
            result += i;
        }

        return result;
    }

    public static void main(String[] args) {

    }
}
