package com.codestates.section1.unit6.string;

import java.util.StringTokenizer;

// 2022.9.11(일) 2h55
public class StringTokenizerExercise {
    public static void main(String[] args) {
        String str = "this is a string example using StringTokenizer";
        StringTokenizer tokenizer = new StringTokenizer(str);
        System.out.println(str); // this is a string example using StringTokenizer

        System.out.println("total tokens = " + tokenizer.countTokens()); // token = 지정한 구분자로 쪼개어진 문자열 -> total tokens = 7

        while(tokenizer.hasMoreTokens()) {
            System.out.println(tokenizer.nextToken());
        }

        System.out.println("total tokens = " + tokenizer.countTokens()); // total tokens = 0
    }
}
