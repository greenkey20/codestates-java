package com.codestates.dailycoding;

import java.util.HashMap;

public class Solution19 {
    // 2022.10.6(목) 9h40 -> 10h20 모든 테스트 케이스 통과
    public String decryptCaesarCipher(String str, int secret) {
        String result = "";

        // 빈 문자열을 입력받은 경우, 빈 문자열을 리턴
        if (str.length() == 0) {
            return result;
        }

        // 암호화된 문자열과 암호화 키를 입력받아 복호화된 문자열을 리턴 = 내가 처음 풀이 시 놓친 것 -> 이 프로그램은 암(x)복(o)호화하는 기능을 함 -> str 각 문자에서 secret을 빼면 복호화됨
        // str(평문).charAt(i)를 secret(암호키)만큼 오른쪽으로 평행이동 = Caesar cipher
        // 공백은 그대로 두기
        // 입력된 문자열은 모두 소문자만 입력됨

        /* ideation
        원형 큐?
        나머지 연산을 통해 반복?
         */

        // ASCII 코드 값을 활용해서 소문자 알파벳의 나열을 만듦 -> reference code 보니, 이런 map 만들지 않고도 알파벳 원형 큐 사용할 수 있음
        HashMap<Integer, Character> alphabets = new HashMap<>();
        for (int i = 97; i <= 122; i++) {
            char ch = (char) i;
            alphabets.put(i % 26, ch);
        }
        System.out.println(alphabets);

        // str을 한 글자씩 확인하면서
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            System.out.println(ch);

            if (ch == ' ') { // str.charAt(i)가 공백인 경우, str.charAt[i]를 그대로 result에 더하기
                result += ch;
            } else { // str.charAt(i)가 공백이 아닌 경우, (해당 글자 - secret) % 26에 해당하는 알파벳 찾아서 result에 더하기
                result += alphabets.get((ch - secret) % 26);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution19 solution19 = new Solution19();

        String output = solution19.decryptCaesarCipher("khoor", 3);
        System.out.println(output); // hello vs 10h10 테스트 시 nkrru

        output = solution19.decryptCaesarCipher("zruog", 3);
        System.out.println(output); // world vs 10h10 테스트 시 cuxrj
    }

    public String decryptCaesarCipherReference(String str, int secret) {
        //알파벳을 모두 String으로 선언, 할당합니다.
        String alpha = "abcdefghijklmnopqrstuvwxyz";

        //결과를 담을 String을 선언합니다.
        String result = "";

        //입력된 str만큼 순회하며
        for (int i = 0; i < str.length(); i++) {
            //해당 문자열이 공백일 경우
            if (str.charAt(i) == ' ') {
                //결과에 공백을 그대로 추가합니다.
                result = result + str.charAt(i);
            } else {
                //이외의 경우, alpha에서 현재 문자열의 index를 찾아준 이후,
                int asis = alpha.indexOf(str.charAt(i));
                //복호화는 반대 방향으로 이루어기 때문에 seceret을 빼주게 됩니다.
                //전체 길이를 더하고, 나머지를 구하는 이유는 해당 문자열의 index를 벗어날 경우를 고려한 계산식입니다.
                int tobe = (asis - secret + alpha.length()) % alpha.length();
                //복호화한 문자열을 result에 추가합니다.
                result = result + alpha.charAt(tobe);
            }
        }
        //복호화된 문자열이 저장된 변수를 리턴합니다.
        return result;
    }
}
