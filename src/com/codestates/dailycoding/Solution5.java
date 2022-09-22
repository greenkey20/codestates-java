package com.codestates.dailycoding;

// 2022.9.21(수) 10h25 시도 -> 2022.9.22(목) 10h5 IntelliJ에서 완성
public class Solution5 {
    public static String firstReverse(String str) {
        // 문제 요구 사항에 명시되어있지 않아서 '빈 문자열을 입력받은 경우, 빈 문자열을 리턴' 처리 별도로 안 했는데, 아래 방법1/2 모두 처리 가능
        // 방법1) hint = 문자열은 StringBuilder.reverse()를 통해 쉽게 뒤집을 수 있음
        /*
        StringBuilder sb = new StringBuilder();
        sb.append(str).reverse();

        return sb.toString();
         */

        // 방법2)
        String result = "";

        for (int i = str.length() - 1; i >= 0; i--) {
            result += str.charAt(i); // for문의 iterator 증감식을 i++로 잘못 작성 -> String index out of range: 17
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(firstReverse("I love codestates"));
    }
}
