package com.codestates.section1.unit6.loop;

// 2022.9.18(일) 1h35
public class Loop5 {
    public static String makeDigits(int num) {
        String result = "";

        // 방법1) 문제 요구 조건대로 for문으로 작성 -> 1234567891011121314
        for (int i = 1; i <= num; i++) {
            result += i; // String 타입의 값과 int 타입의 값을 더해주는 경우, 자동으로 int 타입의 값은 String으로 변환되어 저장됨
        }

        // 방법2) while문으로 작성해보기 -> 1234567891011121314
        /*
        int i = 1;
        while (i <= num) {
            result += i;
            i++;
        }
         */

        return result;
    }

    public static void main(String[] args) {
        System.out.println(makeDigits(14));
    }
}
