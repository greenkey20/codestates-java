package com.codestates.dailycoding;

// 2022.9.21(수) 10h15
public class Solution4 {
    public static String firstCharacter(String str) {
        String result = "";

        // 빈 문자열을 입력받은 경우, 빈 문자열을 리턴
        if (str.isEmpty()) {
            return result;
        }

        // 주어진 문자열 str을 " " 기준으로 split
        String[] split = str.split(" ");

        // split 결과를 하나씩 순회하며
        for (String s : split) {
            // charAt(0)을 결과 문자열 result에 차례로 담기
            result += s.charAt(0);
        }

        // result를 반환
        return result;
    }

    public static void main(String[] args) {
        System.out.println(firstCharacter("The community at Code States might be the biggest asset")); // TcaCSmbtba
        System.out.println(firstCharacter(""));
    }
}
