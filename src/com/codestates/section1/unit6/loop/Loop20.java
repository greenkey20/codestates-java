package com.codestates.section1.unit6.loop;

// 2022.9.10(토) 23h20
public class Loop20 {
    public static void main(String[] args) {
        boolean output = hasRepeatedCharacter("abcdefg");
        System.out.println(output);

        output = hasRepeatedCharacter("codestates");
        System.out.println(output);

        output = hasRepeatedCharacter("y");
        System.out.println(output);

        output = hasRepeatedCharacter("");
        System.out.println(output);
    }

    public static boolean hasRepeatedCharacter(String str) {
        // 방법1) 내가 푼 방법
        boolean result = false;

        /*
        if (str.length() == 0 || str.length() == 1) {
            return result;
        } else {
            for (int i = 1; i < str.length(); i++) {
                for (int j = 0; j < i; j++) {
                    if (str.charAt(i) == str.charAt(j)) {
                        result = true;
                        return result;
                    }
                }
            }

            return result;
        }
        */

        /* 방법2) reference 코드 참고로 본 다음, 조금 더 간결하게 작성해 본 것
        빈 문자열 및 길이 1인 문자열 모두 아래 외부 for문으로 처리 가능
        굳이 result 변수 사용할 필요도 없긴 함
         */
        for (int i = 0; i < str.length() - 1; i++) {
            for (int j = i + 1; j < str.length(); j++) {
                if (str.charAt(j) == str.charAt(i)) {
                    result = true;
                    return result;
                }
            }
        }

        return result;
    }
}
