package com.codestates.dailycoding;

public class Solution20 {
    // 2022.10.11(화) 9h45
    public String compressString(String str) {
        // 빈 문자열을 입력받은 경우, 빈 문자열을 리턴
        if (str.length() == 0) {
            return "";
        }

        // 문자열을 입력받아 3개 이상 연속되는 문자가 있을 경우, 연속 구간을 반복되는 수와 문자로 조합한 형태로 압축한 문자열을 리턴
        String result = "";

        int cnt = 1;
        char repeatedCh = ' ';

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (i != 0) {
                if (ch == str.charAt(i - 1)) {
                    cnt++;
                    repeatedCh = str.charAt(i);
                } else {
                    if (cnt >= 3) {
                        result = result + cnt + repeatedCh;
                    } else {
                        for (int j = 0; j < cnt; j++) {
                            result += str.charAt(i - 1);
                        }
                    }

                    cnt = 1;
                    repeatedCh = str.charAt(i);
                }
            } else { // i = 0일 때
                if (ch != str.charAt(1)) { // str의 첫번째 글자가 두번째 글자와 다른 경우
                    result += ch; // str의 첫번째 글자는 바로 result에 붙여줌
                }

                // str의 첫번째 글자가 두번째 글자와 같은 경우, 코드 계속 실행하면서 반복문 증감식 부분으로 감 -> i = 1부터 반복
            }
        }

        // ideation
        /*
        if (i != 0) {

        } else { // i = 0일 때
            if (ch != str.charAt(1)) { // str의 첫번째 글자가 두번째 글자와 다른 경우
                result += ch; // str의 첫번째 글자는 바로 result에 붙여줌
            }

            // str의 첫번째 글자가 두번째 글자와 같은 경우, 코드 계속 실행하면서 반복문 증감식 부분으로 감 -> i = 1부터 반복
        }
         */

        return result;
    }
}
