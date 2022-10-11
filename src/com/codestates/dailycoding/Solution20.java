package com.codestates.dailycoding;

public class Solution20 {
    // 2022.10.11(화) 9h45 -> 10h50 모든 테스트 케이스 통과
    public static String compressString(String str) {
        // 빈 문자열을 입력받은 경우, 빈 문자열을 리턴
        if (str.length() == 0) {
            return "";
        }

        // 문자열을 입력받아 3개 이상 연속되는 문자가 있을 경우, 연속 구간을 반복되는 수와 문자로 조합한 형태로 압축한 문자열을 리턴
        String result = "";

        int cnt = 1;
        char repeatedCh = ' ';

        for (int i = 1; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch == str.charAt(i - 1)) {
                cnt++;
                repeatedCh = str.charAt(i);
            } else {
                if (cnt >= 3) {
                    result = result + cnt + repeatedCh;
                } else if (cnt == 2) {
                    for (int j = 0; j < cnt; j++) {
                        result += str.charAt(i - 1);
                    }
                } else {
                    result += str.charAt(i - 1);
                }

                cnt = 1;
                repeatedCh = str.charAt(i);
            }
        }

        if (cnt == 1) {
            result += str.charAt(str.length() - 1);
        } else if (cnt == 2) {
            for (int j = 0; j < cnt; j++) {
                result += str.charAt(str.length() - 1);
            }
        } else {
            result = result + cnt + repeatedCh;
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

    public static void main(String[] args) {
        String output = compressString("abc");
        System.out.println(output); // "abc"

        output = compressString("wwwggoppopppp");
        System.out.println(output); // "3wggoppo4p"
    }

    /* 문제 풀이 과정 회고
    1. pseudo code 못 씀
    2. Eddie와 문제에 대해 이야기하다가 '특정 문자의 반복 조건을 빠져나오는 경우를 생각해보라'는 조언에 착안해서 코드 짜봄
    3. 테스트 케이스 2개 정도를 가지고 str의 문자 하나하나 반복문 돌려서 흐름 생각하며 한줄한줄 코드 짬
     */

    public String compressStringReference(String str) {
        if (str.length() == 0) return "";
        // 연속되는 문자를 기록하기 위한 변수를 선언하고
        // 첫 번째 문자로 초기화합니다.
        char before = str.charAt(0);
        // 동일한 문자의 반복 횟수를 저장할 변수를 선언, 초기값은 1로 할당합니다.
        int count = 1;
        // 정답으로 리턴할 문자열을 선언합니다. 초기값은 공백으로 할당합니다.
        String result = "";

        // 마지막 부분이 연속된 문자일 경우를 위해 dummy 문자 추가합니다.
        str = str + ' ';
        for (int i = 1; i < str.length(); i++) {
            // 동일한 문자가 반복될 경우
            if (before == str.charAt(i)) {
                //count를 1씩 더해줍니다.
                count++;
            } else {
                // 이전과 다른 문자일 경우,
                // 반복된 횟수가 3 이상일 경우에만 문자열을 압축합니다.
                if (count >= 3) {
                    result = result + count + before;
                } else {
                    //count의 수만큼 결과에 문자열을 저장합니다.
                    for (int j = 0; j < count; j++) {
                        result = result + before;
                    }
                    //자바 11에서 지원하는 String.repeat메소드를 활용하면 조금 더 간단하게 작성이 가능합니다.
                    //result = result + Character.toString(before).repeat(count);
                }
                before = str.charAt(i);
                count = 1;
            }
        }
        return result;
    }
}
