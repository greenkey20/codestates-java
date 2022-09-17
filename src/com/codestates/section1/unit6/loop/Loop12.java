package com.codestates.section1.unit6.loop;

// 2022.9.17(토) 20h10
public class Loop12 {
    public int getMaxNumberFromString(String str) {
        // 시도1) for문 안의 조건(if)문에서 현재 순회 중인 문자열의 i번째 문자의 ASCII 코드 값과 max를 비교하므로, str의 맨 마지막 문자/숫자가 max로 반환되는 문제가 있음
        /*
        int max = str.charAt(0) - '0';

        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) > max) {
                max = str.charAt(i) - '0';
            }
        }
         */

        /* 시도2)
        피드백1 = reference 코드 보니, max를 0으로 초기화하고 시작하면 로직 상 빈 문자열 입력받은 경우 별도 처리 필요 없음
        피드백2 = 자주 쓰는 식은 변수에 담아서 쓰자 -> 코드의 가독성 및 유지/보수성 향상
         */
        int max = 0;

        /*
        if (str.isEmpty()) {
            return max;
        }
         */

        // 인자로 주어진 문자열 str을 순회하며
        for (int i = 0; i < str.length(); i++) {
            // 문자 하나 가져오고, 비교를 위해 숫자로 바꿔줌
            /*if (str.charAt(i) - '0' > max) {
                max = str.charAt(i) - '0';
            }*/

            int checkNum = str.charAt(i) - '0';
            if (checkNum > max) {
                max = checkNum;
            }
        }

        return max;
    }
}
