package com.codestates.section1.unit6.loop;

// 2022.9.10(토) 18h10
public class Loop21 {
    public static void main(String[] args) {

    }

    public String makeMarginalString(String str) {
        StringBuilder result = new StringBuilder();
        String str2 = "";

        if (str.length() == 0) {
            return result.toString();
        } else {
            // 방법1) 2중 for문 = 주어진 문제 조건
            /*
            for (int i = 0; i < str.length(); i++) {
                for (int j = 0; j <= i; j++) {
                    result += str.charAt(j);
                }
            }
             */

            // 방법2) 페어님 idea = String 변수 1개 더 많들고, for문 1번만 돌리기
            for (int i = 0; i < str.length(); i++) {
                str2 += str.charAt(i);
                // result += str2;
                result.append(str2); // IntelliJ의 suggestion vs 한 번 생성된 String 클래스의 인스턴스는 여러 개의 문자열을 더할 때 매번 새로운 인스턴스를 생성, String 클래스는 인스턴스 생성 시 지정된 문자열 변경 불가
            }

            return result.toString();
        }
    }
}
