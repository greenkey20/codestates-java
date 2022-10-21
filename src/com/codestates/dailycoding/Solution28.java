package com.codestates.dailycoding;

import java.util.HashMap;
import java.util.Map;

public class Solution28 {
    // 2022.10.21(금) 10h45 -> 11h15 1차 제출 시 4개 테스트 통과 못함
    public static boolean balancedBrackets(String str) {
        /* 괄호가 포함된 문자열을 입력받아 -> 문자열 내의 모든 괄호의 짝이 맞는지 여부(boolean 값)를 리턴
        1. 닫힌 괄호 ), ], } 가 시작되면, 이후로 열린 괄호가 입력될 수 없음 = false 리턴
        2. 괄호는 먼저 열리고, 열린 만큼만 닫혀야 함

        basic = 괄호의 종류는 단 1가지 ( 및 )로 한정
        advanced = 괄호의 종류를 늘려 모든 종류의 괄호((, ), {, }, [, ])에도 작동하도록 + 괄호를 제외한 문자열이 포함된 경우에도 작동

        나의 질문 = 1가지 종류의 괄호가 str에 여러 번 등장하나? -> 테스트케이스를 보니 여러 번 등장할 수 있음
         */

        Map<Character, Integer> checkBrackets = new HashMap<>();

        // str의 글자 하나하나를 순회하면서, 그 글자가 (, ), {, }, [, ] 중 하나일 때 어떤 처리할지 생각해봄 -> 여러 가지 조건 만들어 구현
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[') {
                if (checkBrackets.containsKey(ch)) {
                    return false;
                } else {
                    checkBrackets.put(ch, 0);
                }
            } else if (ch == ')') {
                if (checkBrackets.containsKey('(')) {
                    checkBrackets.put('(', 1);
                } else {
                    return false;
                }
            } else if (ch == '}') {
                if (checkBrackets.containsKey('{')) {
                    checkBrackets.put('{', 1);
                } else {
                    return false;
                }
            } else if (ch == ']') {
                if (checkBrackets.containsKey('[')) {
                    checkBrackets.put('[', 1);
                } else {
                    return false;
                }
            }
        }

        int result = 1;

        for (Character ch : checkBrackets.keySet()) {
            int value = checkBrackets.get(ch);
            result *= value;
        }

        if (result == 1) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        boolean test1 = balancedBrackets("(((((((((())))))))))");
        System.out.println(test1); // v1에서는 false

        /* 테스트케이스 결과에 대해 반복문 사용해서 출력할 수 있을지 실험해 본 것
        for (int i = 1; i <= 8; i++) {
            String name = "test" + i;
            System.out.printf("%s = %b\n", name, name);
        }
         */

        boolean output1 = balancedBrackets("[](){}");
        System.out.println(output1); // true

        boolean output2 = balancedBrackets("[({})]");
        System.out.println(output2); // true

        boolean output3 = balancedBrackets("[(]{)}");
        System.out.println(output3); // false vs v1에서는 true

    }
}