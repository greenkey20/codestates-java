package com.codestates.dailycoding;

// 2022.9.27(화) 10h30
public class Solution10 {
    public static String insertDash(String str) {
        // version1) 문제 조건에는 없었지만 빈 문자열을 입력받은 경우 null을 리턴해야 한다는 테스트 케이스 통과 못함 + str의 맨마지막에 있는 숫자를 안 붙여줌
        String result = "";

        for (int i = 0; i < str.length() - 1; i++) {
            if (((str.charAt(i) - '0') % 2) * ((str.charAt(i + 1) - '0') % 2) == 1) {
                result = result + str.charAt(i) + "-";
            } else {
                result += str.charAt(i);
            }
        }

        // version2)
        if (str.isEmpty()) {
            return null;
        }

        for (int i = 0; i < str.length() - 1; i++) {
            result += str.charAt(i);

            if (((str.charAt(i) - '0') % 2) * ((str.charAt(i + 1) - '0') % 2) == 1) {
                result += "-";
            }
        }

        result += str.charAt(str.length() - 1);

        return result;
    }

    public static String insertDashReference(String str) {
        if (str.length() == 0) {
            return null;
        }
        String result = "" + str.charAt(0);

        for (int i = 1; i < str.length(); i++) {
            int preNumber = Character.getNumericValue(str.charAt(i - 1)) % 2;
            int curNumber = Character.getNumericValue(str.charAt(i)) % 2;
            if (preNumber != 0 && curNumber != 0) {
                result = result + "-";
            }
            result = result + str.charAt(i);
        }
        return result;
    }
}
