package com.codestates.dailycoding;

public class Solution50 {
    // 2022.11.23(수) 10h25 -> 10h55 1차 제출 시 테스트케이스 9개 중 4개 통과하는데, 통과한 케이스는 왜 통과했는지 모르겠고, 내가 의도한대로 동작하지 않는 것 같고, 문제도 잘못 이해한 것 같음
    public static int LPS(String str) {
		/* Longest Prefix(접두어, 문자열의 첫 인덱스부터 시작하는 모든 부분 문자열) which is also Suffix(접미어, 문자열의 마지막 인덱스부터 시작하는 모든 부분 문자열) = 주어진 문자열 str(길이는 6만 이하, 알파벳 소문자로 구성)의 가장 긴 접두어이자 접미어
		+ non-overlapping(접두어와 접미어는 서로 겹치는 부분이 없어야 함, prefix와 suffix는 문자열의 동일한 인덱스에 위치한 문자를 요소로 가지면 안 됨)

		나의 첫번째 idea
		prefix에는 str.charAt(0)부터 하나씩 append vs suffix에는 str.charAt(str.length - 1)부터 하나씩 append
		-> prefix와 suffix가 달라질 때까지 while문 돌림
		-> while문 빠져나왔을 때 count 변수의 값이나 prefix/suffix의 length/size 반환
		*/
        StringBuilder prefix = new StringBuilder();
        StringBuilder suffix = new StringBuilder();

        int count = 0;

        prefix.append(str.charAt(count));
        suffix.append(str.charAt(str.length() - count - 1));

        while (prefix.toString().equals(suffix.toString()) && count != str.length() / 2) {
            count++;
            prefix.append(str.charAt(count));
            suffix.insert(0, str.charAt(str.length() - count - 1));

            System.out.println("접두어 = " + prefix + ", 접미어 = " + suffix);
        }

        return prefix.length() > 1 ? prefix.length() : 0;
    }

    public static void main(String[] args) {
        // 입/출력 예시
        int output = LPS("abbbcc");
        System.out.println(output); // 0

        output = LPS("aaaa");
        System.out.println(output); // 2
        // prefix: str.substring(0, 2)
        // suffix: str.substring(2)
        // non-overlapping 조건이 없는 경우 정답은 4

        output = LPS("aaaaa");
        System.out.println(output); // 2
        // prefix: str.substring(0, 2)
        // suffix: str.substring(3)
        // non-overlapping 조건이 없는 경우 정답은 5

        // 테스트케이스
        output = LPS("abbbcc");
        System.out.println(output); // 0

        output = LPS("aabcdaabc");
        System.out.println(output); // 4

        output = LPS("abcab");
        System.out.println(output); // 2

        output = LPS("codecodecode");
        System.out.println(output); // 4

        output = LPS("abcdabbb");
        System.out.println(output); // 0

        output = LPS("abcdefghijklm");
        System.out.println(output); // 0

        output = LPS("babbabbabb");
        System.out.println(output); // 4
    }
}
