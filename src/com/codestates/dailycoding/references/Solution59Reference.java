package com.codestates.dailycoding.references;

// 2022.12.6(화) 10h 참고
public class Solution59Reference {
    public int longestPalindrome(String str) {
        if (str.length() < 2) return str.length();

        int LENGTH = str.length();
        boolean[][] isPalindrome = new boolean[LENGTH][];
        for (int i = 0; i < isPalindrome.length; i++) {
            isPalindrome[i] = new boolean[LENGTH];
        }

        int maxLen = 1;
        // 길이가 1인 회문
        for (int i = 0; i < LENGTH; i++) isPalindrome[i][i] = true;

        // 길이가 2인 회문
        for (int i = 0; i < LENGTH - 1; i++) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                isPalindrome[i][i + 1] = true;
                maxLen = 2;
            }
        }

        // 길이가 3 이상인 회문
        for (int len = 3; len <= LENGTH; len++) {
            for (int startIdx = 0; startIdx <= LENGTH - len; startIdx++) {
                int endIdx = startIdx + len - 1;
                if (
                        isPalindrome[startIdx + 1][endIdx - 1] &&
                                str.charAt(startIdx) == str.charAt(endIdx)
                ) {
                    isPalindrome[startIdx][endIdx] = true;
                    maxLen = len;
                }
            }
        }

        return maxLen;
    }
}